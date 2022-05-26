package appium;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.PropertyLoader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseAppium {

    // public static AppiumDriverLocalService service;
      private static AndroidDriver driver;
    // public static AppiumDriver appiumDriver;
/*
    public static WebDriver driver;
@Before("@appium")

    public void init() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel XL API 31");
        //  clientCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\apolo\\Desktop\\appiumMobileApkAmazon\\src\\test\\resources\\AmazonShopping.apk");
        cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "//src//test//resources//Shein.apk");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // clientCapabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
        // clientCapabilities.setCapability("appActivity", "com.amazon.mShop.android.home.HomeActivity");

    }
    @After
    public void tearDown(){
    driver.quit();
    }
    public static WebDriver getDriver(){
    return driver;
    }
}
*/
/*
   public void init() throws MalformedURLException {
        if (driver == null) {

            PropertyLoader loadproperty = new PropertyLoader();
            String device = loadproperty.loadProperties().getProperty("device");

            DesiredCapabilities clientCapabilities = new DesiredCapabilities();
            clientCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            clientCapabilities.setCapability(MobileCapabilityType.UDID, device);
            clientCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
            clientCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel XL API 31");
            clientCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\apolo\\Desktop\\appiumMobileApkAmazon\\src\\test\\resources\\AmazonShopping.apk");
           // clientCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "//src//test//resources//Shein.apk");
            // clientCapabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
            // clientCapabilities.setCapability("appActivity", "com.amazon.mShop.android.home.HomeActivity");


            try {
                driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), clientCapabilities);
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                System.out.println("Create instance of Android Driver");

            } catch (MalformedURLException e) {
                e.printStackTrace();
                System.out.println("Instance of Android Driver is not created");
            }
          ///  driver.findElement(By.id("btn_go_shopping")).click();
        }
    }


}
*/

        // Carga del fichero de propiedades
        PropertyLoader loadproperty = new PropertyLoader();
        // Recuperación del fichero de propiedades de la ruta y nombre de la aplicación móvil

       // String appiumON = "appiumON";
       // String appiumON = System.getProperty("appiumON");
        String appiumON = loadproperty.loadProperties().getProperty("appiumON");
       // String device = System.getProperty("device");
        String device = loadproperty.loadProperties().getProperty("device");

        // Generación de las capabilites a nivel del servicio de Appium
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);

        // Generación de las capabilites a nivel de driver
        DesiredCapabilities clientCapabilities = new DesiredCapabilities();
        clientCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        clientCapabilities.setCapability(MobileCapabilityType.UDID, device);
        clientCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
        clientCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel XL API 31");
        clientCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\apolo\\Desktop\\appiumMobileApkAmazon\\src\\test\\resources\\AmazonShopping.apk");
        try {
            if (appiumON.equals("S")) {
                URL url_appium = new URL("http://" + loadproperty.loadProperties().getProperty("AppiumServerIP") + ":" +
                        loadproperty.loadProperties().getProperty("AppiumServerPort") + "/wd/hub");
                driver = new AndroidDriver(url_appium, clientCapabilities);
            } else {
                File app = new File(loadproperty.loadProperties().getProperty("apkDir"), loadproperty.loadProperties().getProperty("apkName"));
                desiredCapabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
                // Appium service
                AppiumServiceBuilder builder = new AppiumServiceBuilder().withCapabilities(desiredCapabilities)
                        .withIPAddress(loadproperty.loadProperties().getProperty("AppiumServerIP"))
                        .usingPort(Integer.valueOf(loadproperty.loadProperties().getProperty("AppiumServerPort")).intValue());
                service = builder.build();
                service.start();
                driver = new AndroidDriver(service.getUrl(), clientCapabilities);
            }
        } catch (Exception e) {
            throw new Exception ("Error connecting to Appium service : " + e.getMessage());
        }
    }

    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}

