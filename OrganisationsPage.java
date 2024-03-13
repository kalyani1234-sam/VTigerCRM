package objectRepository_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationsPage {

	//identify crete organisations..(+)
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement  createOrganisation;

	public WebElement getCreateOrganisation() {
		return createOrganisation;
	}
	
	public OrganisationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickPlusIcon()
	{
		createOrganisation.click();
	}
}
