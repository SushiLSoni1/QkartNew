package qtriptest.pages;

import java.util.UUID;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegisterPage {
    
    WebDriver driver;
    String url= "https://crio-qkart-frontend-qa.vercel.app/register";
    public String lastGeneratedUsername = "";

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

   

    @FindBy(xpath = "//h2[text()='Register']") 
    private WebElement registerformHeader;
    
    @FindBy(xpath = "//input[@id='username']")
    private WebElement emailTextBox;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmpasswordTextBox;

    @FindBy(xpath = "//button[text()='Register Now']")
    private WebElement registerNowButton;



    /**
     * Onboard a new user with the given email, password, and confirmation password
     * TODO: Add validation to ensure the registration was successful
     * TODO: Consider using a more secure way to handle passwords
     */
        
    public void onBoardNewUser(String email, String password, String confirmpassword, boolean isDynamicUserRequired) throws InterruptedException{
       
        String username;
        if(isDynamicUserRequired){
            username = email+UUID.randomUUID().toString();
        }
        else{
            username = email;
        }
      System.out.println("user name "+username);
        emailTextBox.sendKeys(username);
       lastGeneratedUsername = username;
        passwordTextBox.sendKeys(password);
      
        confirmpasswordTextBox.sendKeys(confirmpassword);

        registerNowButton.click();
        Thread.sleep(2000);
    }

     /**
     * Check if the register page is displayed
     * TODO: Add additional validation to ensure the page is fully loaded
     */
    public Boolean isRegisterPageisDisplayed(){
        return registerformHeader.isDisplayed();
    }

}
