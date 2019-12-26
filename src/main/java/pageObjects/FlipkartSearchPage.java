package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipkartSearchPage {
	WebDriver driver;
public FlipkartSearchPage(WebDriver driver) {
	this.driver= driver;
}
private By price = By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/div[2]/div[2]/div/div/div/a/div[2]/div[2]/div/div/div[1]");
public WebElement getPrice() {
	return driver.findElement(price);
}
}
