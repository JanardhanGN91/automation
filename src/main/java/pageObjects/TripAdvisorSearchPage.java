package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TripAdvisorSearchPage {
WebDriver driver;
public TripAdvisorSearchPage(WebDriver driver) {
	this.driver = driver;
}
private By searchResult = By.xpath("//div[@class='result-title']/span");
public WebElement getSearchResult() {
	return driver.findElement(searchResult);
}
}
