package qtriptest.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class HomePage {
    WebDriver driver;
    String url = "https://crio-qkart-frontend-qa.vercel.app/";
    
    public HomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);

    }

    @FindBy(xpath = "//button[text()='Logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//button[text()='Register']")
    private WebElement registerbutton;

    @FindBy(xpath = "//div[@class='MuiFormControl-root MuiTextField-root search-desktop css-i44wyl']//input[@name='search']")
    private WebElement SearchBox;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginbutton;

    
    @FindBy(xpath = "//div[@class='loading MuiBox-root css-0']//h4")
    private WebElement NoMatchFound;
    
    /**
     * Navigate to the home page
     * TODO: Add validation to ensure the page has loaded correctly
     */
    public void navigateTohomepage() throws InterruptedException{ 
        driver.get("https://crio-qkart-frontend-qa.vercel.app/");
        String str=driver.getCurrentUrl();
        if(!str.equals(url)){
            driver.get(url);
        }
    }
        // Search the city 
    public void searchProduct(String ProductName){
        searchbox.clear();
        searchbox.sendKeys(ProductName);
    }
       
        

    // public Boolean isnavigatedToLoginpage(){
    //     return driver.getCurrentUrl().contains("login");
    // }

        public void navigateToLoginpage() throws InterruptedException{
            loginbutton.click();
            Thread.sleep(2000);
        }
     
     //TODO: Navigate to the register page
    
    public void navigateToregisterpage() throws InterruptedException{
        registerbutton.click();
        Thread.sleep(2000);
    }

    //TODO: Check if the logout button is visible
    // public Boolean islogoutButtonisVisible(){
   
    //     return logoutButton.isDisplayed();
       
    // }

    /**
     * Check if the login page navigation was successful
     * TODO: Improve the logic to check for successful navigation
     */
    // public Boolean isloginpagNavigationesucceded(){
    //     return logoutButton.isDisplayed();
    // }

    /**
     * Perform a logout
     * TODO: Add validation to ensure the logout was successful
     */
    public void performlogout(){
        logoutButton.click();
    }

    public void SearchProduct(){

        SearchBox.sendKeys("Shoes");
    }
    

    

}
