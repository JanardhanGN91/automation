package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonLogin {
WebDriver driver;
public AmazonLogin(WebDriver driver) {
	this.driver = driver;
}
private By searchBox = By.id("twotabsearchtextbox");
private By searchEnter = By.xpath("//input[@value='Go']");
public WebElement getSearchBox() {
	return driver.findElement(searchBox);
}
public WebElement getSearchEnter() {
	return driver.findElement(searchEnter);
}
}
