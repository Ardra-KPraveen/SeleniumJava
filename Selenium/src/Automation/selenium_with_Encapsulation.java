package Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.sdk.metrics.data.Data;

public class selenium_with_Encapsulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create data object
		testData data=new testData();
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		assert actualTitle.equals(expectedTitle) : 
		       "Title does not match! Actual: " + actualTitle + ", Expected: " + expectedTitle;
		System.out.println("Actual title and expected title match: " + actualTitle);
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys(data.getFirstName());
		driver.findElement(By.name("lastName")).sendKeys(data.getLastName());
		driver.findElement(By.name("phone")).sendKeys(data.getPhone());
		driver.findElement(By.id("userName")).sendKeys(data.getEmail());
		driver.findElement(By.name("address1")).sendKeys(data.getAddress());
		driver.findElement(By.name("city")).sendKeys(data.getCity());
		driver.findElement(By.name("state")).sendKeys(data.getState());
		driver.findElement(By.name("postalCode")).sendKeys(data.getPostalcode());
		
		WebElement countryDropdown=driver.findElement(By.name("country"));
		countryDropdown.click();
		   
		Select dropdown=new Select(countryDropdown);
		dropdown.selectByVisibleText("INDIA");
		
		try {
		    // completely remove the popup from DOM if it exists
		    ((JavascriptExecutor) driver).executeScript(
		        "var el = document.querySelector('#cbox'); if (el) el.remove();"
		    );
		    System.out.println("Popup forcibly removed.");
		} catch (Exception e) {
		    System.out.println("No popup found to remove.");
		}
		driver.findElement(By.id("email")).sendKeys(data.getUserName());
		driver.findElement(By.name("password")).sendKeys(data.getPassword());
		driver.findElement(By.name("confirmPassword")).sendKeys(data.getPassword());
		
		driver.findElement(By.name("submit")).click();
		
        
	}
	

}
