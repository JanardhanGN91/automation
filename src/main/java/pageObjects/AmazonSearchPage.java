package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonSearchPage {
WebDriver driver;
public AmazonSearchPage(WebDriver driver) {
	this.driver = driver;
}
private By price = By.xpath("//span[@class='a-price-whole']");
public WebElement getPrice() {
	return driver.findElement(price);
}
}
