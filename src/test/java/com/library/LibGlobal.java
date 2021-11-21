package com.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobal {
	protected static WebDriver driver;
	String cellValue;

	public static WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}	

	public static void loadUrl(String url) {
		driver.get(url);
	}

	public static void maximize() {
		driver.manage().window().maximize();
	}

	public void textBox(WebElement element,String data) {
		element.clear();
		element.sendKeys(data);
	}

	public void click(WebElement element) {
		element.click();
	}

	public void alertBtnOk() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void alertBtnCancel() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void alertTextBox(String data) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(data);
	}

	public String alertGetText() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		return text;
	}

	public String getData(WebElement element) {
		String text = element.getText();
		return text;
	}

	public String getData(String name,String data,int rowno,int cellno) throws IOException   {
		File f = new File("C:\\Users\\balam\\eclipse-workspace\\FrameworkMaven\\Excel Maintenance\\"+name+".xlsx");
		FileInputStream str = new  FileInputStream(f);
		Workbook book = new XSSFWorkbook(str);
		Sheet s = book.getSheet(data);
		Row r = s.getRow(rowno);
		Cell c = r.getCell(cellno);
		int type = c.getCellType();
		if (type==1) {
			cellValue = c.getStringCellValue();

		}
		if (type==0) {
			if(DateUtil.isCellDateFormatted(c)) {
				Date date = c.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("dd/MM/yyyy");
				cellValue = sim.format(date);
			}
			else {
				double d = c.getNumericCellValue();
				long l=(long)d;
				cellValue = String.valueOf(l);
			}
		}return cellValue;
	}


	public String getAttribute(WebElement element,String attributeName) {
		String data = element.getAttribute(attributeName);
		return data;
	}

	public String getAttribute(WebElement elemtent) {
		String data = elemtent.getAttribute("value");
		return data;
	}

	public static void allWindowClose() {
		driver.quit();
	}

	public static void currentWindowClose() {
		driver.close();
	}

	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public void selectOptionByText(WebElement element,String data) {
		Select select = new Select(element);
		select.selectByVisibleText(data);
	}

	public void selectOptionById(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectOptionByAttribute(WebElement element,String data) {
		Select select = new Select(element);
		select.selectByValue(data);
	}

	public void deselectOptionByText(WebElement element,String data) {
		Select select = new Select(element);
		select.deselectByVisibleText(data);
	}

	public void deselectOptionById(WebElement element,int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	public void deselectOptionByAttribute(WebElement element,String data) {
		Select select = new Select(element);
		select.deselectByValue(data);
	}

	public void deselectAllOption(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	public List<WebElement> getOptionsList(WebElement element) {
		Select select = new Select(element);
		List<WebElement> list = select.getOptions();
		return list;
	}

	public boolean selectMultipleOptions(WebElement element) {
		Select select = new Select(element);
		boolean options = select.isMultiple();
		return options;
	}

	public void textJs(WebElement element,String data) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].setAttribute('value','"+data+"')", element);
	}

	public void clickJs(WebElement element,String data) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
	}

	public void switchToChildWindow() {
		String parentWindowId = driver.getWindowHandle();
		Set<String> allWindowId = driver.getWindowHandles();
		for (String eachWindowId : allWindowId) 
		{
			if(!parentWindowId.equals(eachWindowId)) 
			{
				driver.switchTo().window(eachWindowId);
			}
		}
	}

	public void switchtoParentWindowId() {
		String parentWindowId = driver.getWindowHandle();
		driver.switchTo().window(parentWindowId);
	}

	public Set<String> getAllWindowId() {
		Set<String> allWindowId = driver.getWindowHandles();
		return allWindowId;
	}

	public void switchtoFrameById(int id) {
		driver.switchTo().frame(id);
	}

	public void switchtoFrameByElemnet(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void defaultFrame() {
		driver.switchTo().defaultContent();
	}

	public void switchtoFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	public int FrameCount(List<WebElement> element) {
		int count = element.size();
		return count;
	}

	public WebElement locatorById(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}

	public WebElement locatorByName(String text) {
		WebElement element = driver.findElement(By.name(text));
		return element;
	}

	public WebElement locatorByXpath(String text) {
		WebElement element = driver.findElement(By.xpath(text));
		return element;
	}

	public WebElement locatorByTagname(String text) {
		WebElement element = driver.findElement(By.tagName(text));
		return element;
	}

	public WebElement locatorByVisibleText(String text) {
		WebElement element = driver.findElement(By.linkText(text));
		return element;
	}

	public void waitOption(long millis) throws InterruptedException {
		Thread.sleep(millis);
	}

	public void getScreenshot(String name) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\balam\\eclipse-workspace\\FrameworkMaven\\Screenshot\\"+name+".png"));
	}

	public void getScreenshot(String name,WebElement element) throws IOException {
		File file = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\balam\\eclipse-workspace\\FrameworkMaven\\Screenshot\\"+name+".png"));
	}

	public void writeData(String fname,String sheetName,int rowno,int cellno,String data) throws IOException {
		File f = new File("C:\\Users\\balam\\eclipse-workspace\\FrameworkMaven\\Excel Maintenance\\"+fname+".xlsx");
		Workbook book = new XSSFWorkbook();
		Sheet s = book.createSheet(sheetName);
		Row r = s.createRow(rowno);
		Cell c = r.createCell(cellno);
		c.setCellValue(data);

		FileOutputStream out = new FileOutputStream(f);
		book.write(out);
	}

	public void writeDataInCell(String fname,String sheetName,int rowno,int cellno,String data) throws IOException {
		File f = new File("C:\\Users\\balam\\eclipse-workspace\\FrameworkMaven\\Excel Maintenance\\"+fname+".xlsx");
		FileInputStream str = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(str);
		Sheet s = book.getSheet(sheetName);
		Row r = s.getRow(rowno);
		Cell c = r.createCell(cellno);
		c.setCellValue(data);

		FileOutputStream out = new FileOutputStream(f);
		book.write(out);
	}

	public void updateData(String fname,String sheetName,int rowno,int cellno,String data) throws IOException {
		File f = new File("C:\\Users\\balam\\eclipse-workspace\\FrameworkMaven\\Excel Maintenance\\"+fname+".xlsx");
		FileInputStream str = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(str);
		Sheet s = book.getSheet(sheetName);
		Row r = s.getRow(rowno);
		Cell c = r.getCell(cellno);

		String string = c.getStringCellValue();
		if (!string.equals(data)) {
			c.setCellValue(data);
		}
		FileOutputStream out = new FileOutputStream(f);
		book.write(out);
	}

	public void ScrollDown(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public void ScrollUp(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	
}

