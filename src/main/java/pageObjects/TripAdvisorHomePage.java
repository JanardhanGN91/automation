package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TripAdvisorHomePage {
WebDriver driver;
public TripAdvisorHomePage(WebDriver driver) {
	this.driver = driver;
}
private By searchBox = By.xpath("//*[@title='Search']");
private By enterSearch = By.xpath("//*[@id='mainSearch']");
private By enterSearchDiff = By.xpath("//*[@id='component_4']/div/div/form/input[1]");
private By searchButton = By.xpath("//*[@id='SEARCH_BUTTON_CONTENT']");
private By searchDiff = By.xpath("//*[@id='component_4']/div/div/form/input[1]");
public WebElement getSearchBox() {
	return driver.findElement(searchBox);
}
public WebElement getEnterSearch() {
	return driver.findElement(enterSearch);
}
public WebElement getSearchButton() {
	return driver.findElement(searchButton);
}
public int getEnterSearchDiffCount() {
	return driver.findElements(enterSearchDiff).size();
}
public WebElement getEnterSearchDiff() {
	return driver.findElement(searchDiff);
}
}
