package Rahulacademy;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserLaunchPage {
	WebDriver Cdriver=new ChromeDriver();
	String uName ;
	String uemail; 
	String upassword; 
	
	
	public  BrowserLaunchPage() 
	{
	
	}
	
	public static String fnGetCellData(int rownum, int colnum) throws IOException 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\akash\\eclipse-workspace_Demo\\Rahulacademy\\testdata\\SeleniumTestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet datasheet = workbook.getSheet("rahulacademy");
		try {
			XSSFCell cell = datasheet.getRow(rownum).getCell(colnum);
			String cellData = cell.getStringCellValue();
			workbook.close();
			fis.close();
			return cellData;
			} 
		catch (Exception e) {
				throw (e);
			}
		
	}
	
	public  void fnBrowserLaunch(String teesraURL) throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
	Cdriver.manage().deleteAllCookies();
	Cdriver.manage().window().maximize();
	Cdriver.get(teesraURL);
	Thread.sleep(3000);
	}
	
	
	public void fnRegistration() throws IOException
	
	{
		String Rname = fnGetCellData(1, 1);
		String Remail = fnGetCellData(1, 2);
		String Rpwd = fnGetCellData(1, 3);
		String Rcpwd = fnGetCellData(1, 4);
		
		WebElement lnkRegister = Cdriver.findElement(By.xpath("//a[@href='http://qaclickacademy.usefedora.com/sign_up']"));
		lnkRegister.click();
		WebElement txtUsername = Cdriver.findElement(By.xpath("//input[@id='user_name']"));
		txtUsername.sendKeys(Rname);
		WebElement txtUseremail = Cdriver.findElement(By.xpath("//input[@id='user_email']"));
		txtUseremail.sendKeys(Remail);
		WebElement txtPassword = Cdriver.findElement(By.xpath("//input[@id='user_password']"));
		txtPassword.sendKeys(Rpwd);
		WebElement txtConfPassword = Cdriver.findElement(By.xpath("//input[@id='user_password_confirmation']"));
		txtConfPassword.sendKeys(Rcpwd);
		WebElement chkEmail = Cdriver.findElement(By.xpath("//input[@id='user_unsubscribe_from_marketing_emails']"));
		chkEmail.click();
		WebElement chkTerm = Cdriver.findElement(By.xpath("//input[@id='user_agreed_to_terms']"));
		chkTerm.click();
		WebElement btnSignup = Cdriver.findElement(By.xpath("//input[@value='Sign Up']"));
		btnSignup.click();
	}
	
	public void fnRegistrationError() throws InterruptedException, IOException
	{
		
		String Lemail = fnGetCellData(1, 2);
		String Lpwd = fnGetCellData(1, 3);
		
		System.out.println("Inside error function");
		WebElement txtusrexisterror = Cdriver.findElement(By.xpath("//a[contains(text(), 'Please')]"));
		WebDriverWait w = new WebDriverWait(Cdriver, 5);
		w.until(ExpectedConditions.visibilityOf(txtusrexisterror));
		WebElement lnkHome = Cdriver.findElement(By.xpath("//img[@alt='Rahul Shetty Academy']"));
		
		if (txtusrexisterror.isDisplayed())
		{
			lnkHome.click();
			WebElement btnLogin = Cdriver.findElement(By.xpath("//a[contains(text(), 'Login')]"));
			btnLogin.click();
			Thread.sleep(35000);
			WebElement txtEmail = Cdriver.findElement(By.xpath("//input[@type='email']"));
			txtEmail.sendKeys(Lemail);
			WebElement txtPasskey = Cdriver.findElement(By.xpath("//input[@type='password']"));
			txtPasskey.sendKeys(Lpwd);
			WebElement btnLoginP = Cdriver.findElement(By.xpath("//input[@value='Log In']"));
			btnLoginP.click();
			WebElement txtUserName = Cdriver.findElement(By.xpath("//span[contains(text(), 'Agatha Christief')]"));
			Assert.assertEquals(true, txtUserName.isDisplayed());
		}
		
		else
		{
			System.out.println("no errorpiece");
		}
		
		}
	
	public void fnBrowserQuit() {
		Cdriver.quit();
	}
	
	}
	
	

