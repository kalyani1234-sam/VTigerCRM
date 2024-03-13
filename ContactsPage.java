package contactsPOM1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	@FindBy(css = "img[title='Create Contact...']")
	private WebElement createContact;

	public WebElement getCreateContact() {
		return createContact;
	}
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
