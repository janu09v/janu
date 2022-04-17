package test_login;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import base_layer.url_page;

public class data extends url_page {
	@Test(dataProvider = "Credentials1")
	public void loginTest(String username,String password) {
	driver.findElement(By.id("txtUsername")).sendKeys(username);
	driver.findElement(By.id("txtPassword")).sendKeys(password);
	driver.findElement(By.id("btnLogin")).click();
	String actualURL=driver.getCurrentUrl();
	String expectedURL="https://opensource-demo.orangehrmlive.com/index.php/dashboard"; AssertJUnit.assertEquals(actualURL,expectedURL);
	}
}
