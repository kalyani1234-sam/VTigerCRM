package objectRepository_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.WebDriverUtils;

public class OrganisationsInformationPage  {

	WebDriverUtils wUtils= new WebDriverUtils();
	
	//identify mandatory field 
	@FindBy (css = "input[name='accountname']")
	private WebElement organisationName;
	
	public WebElement getOrganisationName() {
		return organisationName;
	}
	//identify group radio btn
	@FindBy(xpath = "(//input[@name='assigntype'])[2]")
	private WebElement assignType;

	public WebElement getAssignType() {
		return assignType;
	}
	
	//identify and select dropdown
	@FindBy(name = "assigned_group_id")
	private WebElement drpdwn;

	public WebElement getDrpdwn() {
		return drpdwn;
	}
	//idebtify save button
	@FindBy(xpath = "(//input[@class='crmbutton small save'])[1]")
	private WebElement saveBTN;

	public WebElement getSaveBTN() {
		return saveBTN;
	}
	//create parameterised constructor
	public OrganisationsInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//create a method
	public void organisationsInformation(String orgName, String supGRP)
	{
		//to enter organisation name
		organisationName.sendKeys(orgName);
		// click on grp radio btn
		assignType.click();
		//select "support group" in dropdown
		wUtils.handleDropdown(drpdwn, supGRP);
		
		//click on save button
		saveBTN.click();
		
	}
}
