package Qkart.Tests;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class testPage {
  
    String Lastusername = "";
    static WebDriver driver;
   

    public static void logStatus(String type, String message, String status) {

        System.out.println(String.format("%s | %s | %s | %s", String.valueOf(java.time.LocalDateTime.now()), type, message, status));
        
    }

    @BeforeClass(enabled = true)
    public static void assignDriver() throws MalformedURLException {
        logStatus("driver","initalizing Browser","started");
        driver = new ChromeDriver();
        logStatus("driver","initalizing Browser", "success");
        
    }

    @AfterClass(enabled = true)
    public static void closeDriver() {
        logStatus("driver","closing Browser","started");
        driver.close();
        driver.quit();
        logStatus("driver","closing Browser", "success");
    }

    @Test(enabled = true, groups = "Login Flow", priority = 1, description = "Verify user registration and login functionality")
    public void TestCase01(String UserName, String Password) throws InterruptedException, IOException {
     
     try{ 
      
     HomePage  homepage = new HomePage(driver);
       //1. Navigate to Home Page of QTrip
       homepage.navigateTohomepage();
       // sleep time to laod 
       Thread.sleep(4000);
       //2. Click on the Register Page
       homepage.navigateToregisterpage();
       
     RegisterPage  registerpage = new RegisterPage(driver);

       //4. Enter email , Password & Confirm Password , Click on Register Now
       registerpage.onBoardNewUser(UserName, Password, Password, true);
         // save the register details
       Lastusername = registerpage.lastGeneratedUsername;
    
       
     LoginPage loginpage = new LoginPage(driver);
       //5.  navigate to login page
       loginpage.navigateTologinpage();

       //7. Enter the created user credentials and click on Login
       loginpage.performLogin(Lastusername, Password);

       homepage.performlogout();

     
        
       }

      catch(Exception e){
       System.out.println(e);
      }
     
      
       
   }
        
    

}
