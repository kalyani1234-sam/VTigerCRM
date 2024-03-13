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
import objectRepository_POM.HomePage;
import objectRepository_POM.LoginPage;
import objectRepository_POM.OrganisationsInformationPage;
import objectRepository_POM.OrganisationsPage;

public class OrganisationsBasePage {

	public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		JavaUtils javaUtils = new JavaUtils();
	
		PropertyFileUtils pUtils = new PropertyFileUtils();
		//to read data from property file (vtigerproperty.properties)
		String browser = pUtils.getDataFrmPropertyFile1("Browser");
		String userNam = pUtils.getDataFrmPropertyFile1("username");
		String pwd = pUtils.getDataFrmPropertyFile1("password");
		String url = pUtils.getDataFrmPropertyFile1("url");
		
		//to read data from excel sheet/file
		ExcelUtils excelUtils= new ExcelUtils();
		String orgName = excelUtils.getDataFRomExcelVTIGER("Organisations", 0, 1);
		String supGRP = excelUtils.getDataFRomExcelVTIGER("Organisations", 1, 1);
		
		WebDriverUtils wUtils = new WebDriverUtils();
		
		//to launch the browser
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
		driver.get(url);
		
		/*WebDriver driver = new ChromeDriver();
		
		*/
		//create object of LoginPage and HomePage 
		
		LoginPage lp = new LoginPage(driver);
		lp.login(userNam, pwd);
		/*PageFactory.initElements(driver, lp);//to initialise webelemnts we call this class 
		lp.getUserNameTF().sendKeys(userNam);
		driver.navigate().refresh();
		lp.getUserNameTF().sendKeys("user"); //after pom it is not giving sateElementReferenceException
		
		lp.getPasswordTF().sendKeys(pwd);
		lp.getLoginBTN().click();*/
		
		//in homepage organisation clicking
		HomePage hp = new HomePage(driver);
		
		//click on orgnisation in homepage
		hp.home();    //hp.getOrganisation().click();
		
		//create object of organisationsPage to click on (+) icon 
		OrganisationsPage op = new OrganisationsPage(driver);
		
		//click on organisatuon ...(+)
		op.clickPlusIcon();
		//op.getCreateOrganisation().click();
		
		//create object of OrganisationsInformationPage 
		OrganisationsInformationPage oip = new OrganisationsInformationPage(driver);
		
		
		oip.organisationsInformation(orgName+javaUtils.getRandomNumber(),supGRP);
		
		
	/*	oip.getOrganisationName().sendKeys(orgName+javaUtils.getRandomNumber());
		// click on grp radio btn
		oip.getAssignType().click();
		//select "support group" in dropdown
		wUtils.handleDropdown(oip.getDrpdwn(), supGRP);
		
		//click on save button
		oip.getSaveBTN().click();*/
		
		Thread.sleep(2000);
		//to mousehover on admin image for sign out
		/*wUtils.mouseHover(driver, hp.getSimag());
		//to click on sign out
		hp.getSignout().click();*/
		hp.home(driver);
		
		
		
	}

}
