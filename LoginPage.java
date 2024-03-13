package objectRepository_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//page is compulsory suffix for pom 
public class LoginPage {

	//identify username tf
	@FindBy(name="user_name")
	private WebElement userNameTF;
	
	//identify password tf
	@FindBy(name="user_password")
	private WebElement passwordTF;
	
	//identify login button
		@FindBy(id="submitButton")
		private WebElement loginBTN;
	
	public WebElement getUserNameTF() {
		return userNameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginBTN() {
		return loginBTN;
	}
	//create parameterised constructor to initialised webElemnets
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this); //this keyword return reference of loginpage class
	}
	
	public void login(String UNdata, String pwdData)
	{
		userNameTF.sendKeys(UNdata);
		passwordTF.sendKeys(pwdData);
		loginBTN.click();
	}
}
/*webelements
username
password
login button*/