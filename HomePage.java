package objectRepository_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.WebDriverUtils;

//page is compulsory suffix for pom 
public class HomePage extends WebDriverUtils  {

		//identify organisation tab
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement organisation;
	
	//identify contacts tab
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contacts;
	
	//identify leads tab
	@FindBy(xpath="(//a[text()='Leads'])[1]")
	private WebElement leads;
	
	
	//identify sign out image
	@FindBy(css = "img[src='themes/softed/images/user.PNG']")
	private WebElement simag;
	
	
	
	//identify sign out text to click
	
	@FindBy(linkText ="Sign Out")
	private WebElement signout;



	public WebElement getOrganisation() {
		return organisation;
	}



	public WebElement getContacts() {
		return contacts;
	}



	public WebElement getLeads() {
		return leads;
	}



	public WebElement getSimag() {
		return simag;
	}



	public WebElement getSignout() {
		return signout;
	}
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void home()
	{
		organisation.click();;
	}
	public void home(WebDriver driver)
	{
		//to mousehover on admin image for sign out image
		mouseHover(driver, simag);
		//to click on sign out
		signout.click();
	}
}
