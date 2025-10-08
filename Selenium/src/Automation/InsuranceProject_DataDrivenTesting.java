package Automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsuranceProject_DataDrivenTesting {

	public static void main(String[] args) throws IOException {
	
// Initialize WebDriver
WebDriver driver=new ChromeDriver();

// To Open the website
driver.get("https://demo.guru99.com/test/newtours/");
driver.findElement(By.linkText("Insurance Project")).click();
driver.findElement(By.xpath("/html/body/div[3]/a")).click();


WebElement honorifics=driver.findElement(By.id("user_title"));
honorifics.click();
Select dropdown=new Select(honorifics);
dropdown.selectByVisibleText("Mrs");

//To Load Excel file
String excelFilePath=".\\datafiles\\inputs.xlsx";
FileInputStream fip=new FileInputStream(excelFilePath);
XSSFWorkbook wb=new XSSFWorkbook(fip);
XSSFSheet sheet=wb.getSheet("Sheet1");

//personal details
String firstName=sheet.getRow(0).getCell(1).getStringCellValue();
driver.findElement(By.id("user_firstname")).sendKeys(firstName);
String surname=sheet.getRow(1).getCell(1).getStringCellValue();
driver.findElement(By.id("user_surname")).sendKeys(surname);
/*In Excel, your phone number cell is stored as a numeric value, not text.
So when you call getStringCellValue(), Apache POI can’t read it properly — it doesn’t throw an error, but returns nothing usable.*/

DataFormatter formatter = new DataFormatter();
String phone = formatter.formatCellValue(sheet.getRow(2).getCell(1));
driver.findElement(By.id("user_phone")).sendKeys(phone);

WebElement year=driver.findElement(By.id("user_dateofbirth_1i"));
year.click();
Select dropdown2=new Select(year);
dropdown2.selectByVisibleText("1995");

WebElement month=driver.findElement(By.id("user_dateofbirth_2i"));
month.click();
Select dropdown3=new Select(month);
dropdown3.selectByVisibleText("August");

WebElement date=driver.findElement(By.id("user_dateofbirth_3i"));
date.click();
Select dropdown4=new Select(date);
dropdown4.selectByVisibleText("15");

driver.findElement(By.id("licencetype_f")).click();

//License & Occupation
WebElement LicensePeriod=driver.findElement(By.xpath("//*[@id=\"user_licenceperiod\"]"));
LicensePeriod.click();
Select dropdown5=new Select(LicensePeriod);
dropdown5.selectByVisibleText("4");

WebElement Occupation=driver.findElement(By.xpath("//*[@id=\"user_occupation_id\"]"));
Occupation.click();
Select dropdown6=new Select(Occupation);
dropdown6.selectByVisibleText("Engineer");

//Address
String Address=sheet.getRow(3).getCell(1).getStringCellValue();
driver.findElement(By.xpath("//*[@id=\"user_address_attributes_street\"]")).sendKeys(Address);
String city=sheet.getRow(4).getCell(1).getStringCellValue();
driver.findElement(By.xpath("//*[@id=\"user_address_attributes_city\"]")).sendKeys(city);
String country=sheet.getRow(5).getCell(1).getStringCellValue();
driver.findElement(By.xpath("//*[@id=\"user_address_attributes_county\"]")).sendKeys(country);

DataFormatter format = new DataFormatter();
String postalCode = format.formatCellValue(sheet.getRow(6).getCell(1));
driver.findElement(By.xpath("//*[@id=\"user_address_attributes_postcode\"]")).sendKeys(postalCode);

//Credentials and Form Submission
String email=sheet.getRow(7).getCell(1).getStringCellValue();
driver.findElement(By.xpath("//*[@id=\"user_user_detail_attributes_email\"]")).sendKeys(email);
String password=sheet.getRow(8).getCell(1).getStringCellValue();
driver.findElement(By.xpath("//*[@id=\"user_user_detail_attributes_password\"]")).sendKeys(password);
driver.findElement(By.xpath("//*[@id=\"user_user_detail_attributes_password_confirmation\"]")).sendKeys(password);
driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[5]/input[2]")).click();

wb.close();
driver.quit();

System.out.println("Form submitted successfully!");

}}
