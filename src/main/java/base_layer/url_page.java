package base_layer;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class url_page {
	public WebDriver driver;
	excell_library obj= new excell_library("D:\\java fit material\\automation testing\\user1.xlsx");
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}
	@DataProvider(name ="Credentials1")
	public Object[][] getExcelData() {
	//Totals rows count
	int rows=obj.getRowCount("Data");
	//Total Columns
	int column=obj.getColumnCount("Data");
	int actRows=rows-1;
	Object[][] data= new Object[actRows][column];
	for(int i=0;i<actRows;i++) {
	for(int j=0; j<column;j++) {
	data[i][j]=obj.getCellData("Data", j, i+2);
	}
	}
	return data;
	}	
	}
	
