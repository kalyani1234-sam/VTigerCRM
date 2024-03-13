package basicPOM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import commonUtils.ExcelUtils;
import commonUtils.JavaUtils;
import commonUtils.PropertyFileUtils;
import commonUtils.WebDriverUtils;
import contactsPOM1.ContactsInformationPage;
import contactsPOM1.ContactsPage;
import objectRepository_POM.HomePage;
import objectRepository_POM.LoginPage;

public class ContactsBasePage {

	public static WebDriver driver;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		JavaUtils javaUtils = new JavaUtils();
		WebDriverUtils wUtils=new WebDriverUtils();
		
		//to read data from excel file 
		ExcelUtils exUtils = new ExcelUtils();
		String fName = exUtils.getDataFRomExcelVTIGER("Contacts", 0, 1);
		String lName = exUtils.getDataFRomExcelVTIGER("Contacts", 1, 1);
		// read data for dropdown called team selling
		String assingTo = exUtils.getDataFRomExcelVTIGER("Contacts", 2, 1);
		
		//select organisation name in child window as infosys415
		String orgName = exUtils.getDataFRomExcelVTIGER("Contacts", 3, 1);
		
		
		PropertyFileUtils pUtils = new PropertyFileUtils();
		//to read data from property file (vtigerproperty.properties)
		String browser = pUtils.getDataFrmPropertyFile1("Browser");
		String userNam = pUtils.getDataFrmPropertyFile1("username");
		String pwd = pUtils.getDataFrmPropertyFile1("password");
		String url = pUtils.getDataFrmPropertyFile1("url");
		
		if (browser.equals("Chrome")) {
			driver= new ChromeDriver();
		}
		else if (browser.equals("Edge")) {
			driver= new EdgeDriver();
		}
		else
		{
			driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		wUtils.impliciteWaits(driver);
		driver.get(url);
		
		/*WebDriver driver = new ChromeDriver();
		
		*/
		//create object of LoginPage and HomePage 
		
		LoginPage lp = new LoginPage(driver);
		
		//PageFactory.initElements(driver, lp);//to initialise webelemnts we call this class 
		lp.getUserNameTF().sendKeys(userNam);
		//driver.navigate().refresh();
		//lp.getUserNameTF().sendKeys("user"); //after pom it is not giving sateElementReferenceException
		
		lp.getPasswordTF().sendKeys(pwd);
		lp.getLoginBTN().click();
		
		HomePage hp = new HomePage(driver);
		//PageFactory.initElements(driver, hp);
		
		hp.getContacts().click();//to click on contacts mahor tab in home page
		
		ContactsPage cp = new ContactsPage(driver);
		//PageFactory.initElements(driver, cp);
		cp.getCreateContact().click(); //to click on + icon to create contacts
		
		
		ContactsInformationPage cip = new ContactsInformationPage(driver); //inside data is in this page 
		
		cip.getFirstName().sendKeys(fName);  //add first name though excel file
		cip.getLastName().sendKeys(lName); //add last name though excel file
		cip.getAddORG().click();//to click on + icon to add organisation nmame
		String cURL="http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=";
		wUtils.switchWindow(driver, cURL);  //to handle child window while clicking on add org name
		
		
		cip.getSearchTF().sendKeys(orgName); // to pass org name in search text field
		cip.getSearchBTN().click();  //to click on search btn
		cip.getOrgName().click(); //to click on specific org name
		
		//to come back on parent window
		String parentUrl = "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
		wUtils.switchWindow(driver, parentUrl);
		
		
		cip.getGroupRBTN().click();   //to select group radio btn
		wUtils.handleDropdown(cip.getDrdown(),assingTo ); //to handle dropdown
		
		cip.getSaveBTN().click(); //to save 
		
		
		wUtils.mouseHover(driver, hp.getSimag()); //to mouse hover on  admin image in right corner
				//to click on sign out
		hp.getSignout().click();
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
