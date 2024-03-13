package contactsPOM1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInformationPage {

	@FindBy(name="firstname")
	private WebElement firstName;
	
	public WebElement getFirstName() {
		return firstName;
	}

	
	@FindBy(name ="lastname")
	private WebElement lastName;
	
	public WebElement getLastName() {
		return lastName;
	}

	@FindBy(xpath = "(//img[@title='Select'])[1]")//+icon
	private WebElement addORG;
	
	@FindBy(id = "search_txt")
	private WebElement searchTF;
	
	@FindBy(css = "input[name='search']")
	private WebElement searchBTN;
	
	@FindBy(xpath = "(//a[text()='Infosys415'])[1]")
	private WebElement orgName;
	
	public WebElement getAddORG() {
		return addORG;
	}

	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getSearchBTN() {
		return searchBTN;
	}

	public WebElement getOrgName() {
		return orgName;
	}


	@FindBy(xpath = "(//input[@name='assigntype'])[2]")
	private WebElement groupRBTN;
	
	public WebElement getGroupRBTN() {
		return groupRBTN;
	}

	
	@FindBy(name="assigned_group_id")
	private WebElement drdown;
	
	public WebElement getDrdown() {
		return drdown;
	}

	
	@FindBy (css = "input[class='crmButton small save']")
	private WebElement saveBTN;

	public WebElement getSaveBTN() {
		return saveBTN;
	}
	
	public ContactsInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
