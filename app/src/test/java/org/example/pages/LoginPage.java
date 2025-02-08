package qtriptest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {
    WebDriver driver;
    String url = "https://crio-qkart-frontend-qa.vercel.app/login";
    public LoginPage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    @FindBy(xpath = "//div[@class='form css-ikzlcq']//h2")
    private WebElement loginformHeader;
    

    @FindBy(xpath = "//input[@id='username']")
    private WebElement loginemailTextBox;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//button[text()='Login to QKart']")
    private WebElement loginButton;
    @FindBy(xpath = "//p[@class='secondary-action']//a")
    private WebElement RegisterHere;


     /**
     * Navigate to the login page
     * TODO: Add validation to ensure the page has loaded correctly
     */
    public void navigateTologinpage(){
        driver.get(url);
      
    }

    /**
     * Perform a login with the given email and password
     * TODO: Add validation to ensure the login was successful
     * TODO: Consider using a more secure way to handle passwords
     */
    public void performLogin(String email, String password){
        System.out.println("Email Sending while login ----->" +  email);
        System.out.println("Password Sending while login ----->" +  password);
        loginemailTextBox.click();
        loginemailTextBox.sendKeys(email);
      

     
        passwordTextBox.sendKeys(password);

        loginButton.click();
    }

        
   

    
}
