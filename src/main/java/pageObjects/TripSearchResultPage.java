package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TripSearchResultPage {
WebDriver driver;
public TripSearchResultPage(WebDriver driver) {
	this.driver = driver;
}
private By writeReview = By.linkText("Write a review");
private By rating = By.xpath("//*[@id='bubble_rating']");
private By reviewTitle = By.id("ReviewTitle");
private By reviewText = By.id("ReviewText");
private By hotelRatingsCheck = By.name("reviewTagIDs");
private By serviceRating = By.id("qid12_bubbles");
private By locationRating = By.id("qid47_bubbles");
private By cleanlinessRating = By.id("qid14_bubbles");
private By valueRating = By.id("qid13_bubbles");
private By submitCheckbox = By.id("noFraud");
private By verifyHighlight = By.className("ui_bubble_rating fl bubble_10");
public WebElement getWriteReview() {
	return driver.findElement(writeReview);
}
public WebElement getRating() {
	return driver.findElement(rating);
}
public WebElement getReviewTitle() {
	return driver.findElement(reviewTitle);
}
public WebElement getReviewText() {
	return driver.findElement(reviewText);
}
public int getHotelRatingsCheck() {
	return driver.findElements(hotelRatingsCheck).size();
}
public WebElement getServiceRating() {
	return driver.findElement(serviceRating);
}
public WebElement getLocationRating() {
	return driver.findElement(locationRating);
}
public WebElement getCleanlinessRating() {
	return driver.findElement(cleanlinessRating);
}
public WebElement getSubmitCheckBox() {
	return driver.findElement(submitCheckbox);
}
public WebElement getValueRating() {
	return driver.findElement(valueRating);
}
public int getValueRatingCount() {
	return driver.findElements(valueRating).size();
}
public int getLocationRatingCount() {
	return driver.findElements(locationRating).size();
}
public int getVerifyHighlightCount() {
	return driver.findElements(verifyHighlight).size();
}
}
