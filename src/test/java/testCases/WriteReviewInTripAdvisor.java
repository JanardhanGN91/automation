package testCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.TripAdvisorHomePage;
import pageObjects.TripAdvisorSearchPage;
import pageObjects.TripSearchResultPage;
import resources.BaseClass;

public class WriteReviewInTripAdvisor extends BaseClass {
	WebDriver driver;

	@BeforeTest
	public void init() throws IOException {
		driver = openBrowser();
	}

	@Test
	public void WriteReview() throws InterruptedException {
		driver.get("https://www.tripadvisor.in/");
		TripAdvisorHomePage tripPage = new TripAdvisorHomePage(driver);
		tripPage.getSearchBox().click();
		// Two kinds of search boxes appear dynamically so to deal with it if else is
		// used
		if (tripPage.getEnterSearchDiffCount() > 0) {
			tripPage.getEnterSearchDiff().sendKeys("Club Mahindra");
			tripPage.getEnterSearchDiff().sendKeys(Keys.ENTER);
		} else {
			tripPage.getEnterSearch().sendKeys("Club Mahindra");
			tripPage.getSearchButton().click();

		}
		TripAdvisorSearchPage searchPage = new TripAdvisorSearchPage(driver);
		searchPage.getSearchResult().click();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		itr.next();
		driver.switchTo().window(itr.next());
		TripSearchResultPage resultPage = new TripSearchResultPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(resultPage.getWriteReview()));
		resultPage.getWriteReview().click();
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> i = handle.iterator();
		i.next();
		i.next();
		driver.switchTo().window(i.next());
		WebElement rating = resultPage.getRating();
		Actions actions = new Actions(driver);
		actions.moveToElement(rating, -70, 0).perform();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String script = "return document.getElementsByClassName(\"ui_bubble_rating fl bubble_10\").length;";
		long highLight = (long) jse.executeScript(script);
		// This will check whether the star rating is highlighted
		Assert.assertEquals(1L, highLight);
		Thread.sleep(5000);
		actions.moveToElement(rating, -30, 0).perform();
		Thread.sleep(5000);
		actions.moveToElement(rating, 0, 0).perform();
		Thread.sleep(5000);
		actions.moveToElement(rating, 70, 0).clickAndHold().release().perform();
		resultPage.getReviewTitle().sendKeys("Good stay, great location");
		resultPage.getReviewText().sendKeys(
				"Good hotel. Hospitality was great and crew were very friendly. Location is near by to all tourist destinations.");
		if (resultPage.getHotelRatingsCheck() > 0) {
			WebElement service = resultPage.getServiceRating();
			System.out.println("Size of service" + service.getSize());
			Actions action = new Actions(driver);
			action.moveToElement(service, -50, 0).perform();

			Thread.sleep(5000);
			action.moveToElement(service, -10, 0).perform();
			Thread.sleep(5000);
			action.moveToElement(service, 50, 0).click().build().perform();
		}
		resultPage.getSubmitCheckBox().click();
	}

	@AfterTest
	public void close() {
		driver.quit();
	}
}
