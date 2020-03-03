package imagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ImageClass {
	@Test
	public void verifyImageAppearance() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ford.com/");
		Thread.sleep(3000);

		// Thread.sleep(3000);
		driver.manage().window().maximize();

		Thread.sleep(3000);

		WebElement COOKIES_DELETE = driver
				.findElement(By.xpath("//a[@aria-label='Close Banner Button' and @ tabindex='0']"));
		COOKIES_DELETE.click();

		WebElement IMAGE_ELEMENT = driver.findElement(By.xpath(
				"//img[@src='//ford-h.assetsadobe.com/is/image/content/dam/brand_ford/en_us/brand/suvs-crossovers/mache/dm/21_FRD_MCH_48103.tif?croppathe=1_21x9&wid=1440']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", IMAGE_ELEMENT);

		boolean bool = IMAGE_ELEMENT.isDisplayed();
		Assert.assertEquals(true, bool);

//		
//		boolean isDisplayed = IMAGE_ELEMENT.isDisplayed();
//		if (isDisplayed) {
//			System.out.println("Image is there");
//		} 
//		else {
//			System.out.println("Verification Failed");
//		}
		// driver.close();
		// driver.quit();

	}

}
