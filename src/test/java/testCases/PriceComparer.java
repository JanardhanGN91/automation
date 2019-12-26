package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AmazonLogin;
import pageObjects.AmazonSearchPage;
import pageObjects.FlipkartLogin;
import pageObjects.FlipkartSearchPage;
import resources.BaseClass;

public class PriceComparer extends BaseClass {
public WebDriver driver;
@BeforeTest
public void init() throws IOException {
	driver = openBrowser();
}
@Test
public void pricecompare() {
	driver.get("https://www.amazon.in/");
	AmazonLogin al = new AmazonLogin(driver);
	al.getSearchBox().sendKeys("iPhone XR 64GB Yellow");
	al.getSearchEnter().click();
	AmazonSearchPage asp = new AmazonSearchPage(driver);
	String priceInAmazon = asp.getPrice().getText();
	priceInAmazon = priceInAmazon.replace(",", "");
	System.out.println("Amazon price: "+priceInAmazon);
	driver.get("https://www.flipkart.com/");
	FlipkartLogin fl = new FlipkartLogin(driver);
	fl.getLoginClose().click();
	fl.getSearchBox().sendKeys("iPhone XR 64GB Yellow");
	fl.getSearchEnter().click();
	FlipkartSearchPage fsp = new FlipkartSearchPage(driver);
	String priceInFlipkart = fsp.getPrice().getText();
	priceInFlipkart = priceInFlipkart.replace(",", "");
	priceInFlipkart = priceInFlipkart.substring(1);
	System.out.println("Flipkart price: "+ priceInFlipkart);
	if(Integer.parseInt(priceInAmazon)>Integer.parseInt(priceInFlipkart)) {
		System.out.println("Pricer is cheaper in flipkart");
	}else {
		System.out.println("Price is cheaper in Amazon");
	}
}
@AfterTest
public void close() {
	driver.close();
}
}
