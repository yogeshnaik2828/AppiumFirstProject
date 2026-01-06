package org;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class AppiumServerManager {

    private static AppiumDriverLocalService service;

    // ✅ Utility: Dynamically find Appium main.js path
    private static File getAppiumJSPath() {
        try {
            ProcessBuilder pb = new ProcessBuilder("which", "appium");
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String appiumPath = reader.readLine();
            process.waitFor();

            if (appiumPath != null) {
                // Example: /usr/local/bin/appium → convert to .../lib/node_modules/appium/build/lib/main.js
                File appiumMainJS = new File(appiumPath)
                        .getParentFile()               // bin
                        .getParentFile()               // local
                        .toPath()
                        .resolve("lib/node_modules/appium/build/lib/main.js")
                        .toFile();

                if (appiumMainJS.exists()) {
                    System.out.println("✅ Appium main.js found at: " + appiumMainJS.getAbsolutePath());
                    return appiumMainJS;
                } else {
                    System.err.println("❌ Could not locate Appium main.js automatically!");
                }
            } else {
                System.err.println("❌ 'which appium' returned null — Appium not found in PATH!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // ✅ Start Appium Server
    public static URI startServer() {
        File appiumMainJS = getAppiumJSPath();
        if (appiumMainJS == null || !appiumMainJS.exists()) {
            System.err.println("⚠️ Appium main.js not found — please check your Appium installation.");
            return null;
        }

        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withAppiumJS(appiumMainJS)
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info");

        service = AppiumDriverLocalService.buildService(builder);
        service.start();

        if (service.isRunning()) {
            try {
                System.out.println("🚀 Appium Server started at: " + service.getUrl());
                return service.getUrl().toURI();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("❌ Failed to start Appium Server!");
        }
        return null;
    }

    // ✅ Stop Appium Server
    public static void stopServer() {
        if (service != null && service.isRunning()) {
            service.stop();
            System.out.println("🛑 Appium Server stopped successfully.");
        } else {
            System.out.println("⚠️ Appium Server was not running.");
        }
    }
}
