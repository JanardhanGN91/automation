package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipkartLogin {
WebDriver driver;
public FlipkartLogin(WebDriver driver) {
	this.driver = driver;
}
private By searchBox = By.xpath("//input[@name='q']");
private By searchEnter = By.xpath("//button[@type='submit']");
private By loginClose = By.xpath("/html/body/div[2]/div/div/button");
public WebElement getSearchBox() {
	return driver.findElement(searchBox);
}
public WebElement getSearchEnter() {
	return driver.findElement(searchEnter);
}
public WebElement getLoginClose() {
	return driver.findElement(loginClose);
}
}
