package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public WebDriver driver;
public Properties prop;
public WebDriver openBrowser() throws IOException {
	prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	String browserName = prop.getProperty("browser");
	if(browserName.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	}
	else if(browserName.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	else {
		WebDriverManager.edgedriver().setup();
		driver = new InternetExplorerDriver();
	}
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	return driver;
}
}
