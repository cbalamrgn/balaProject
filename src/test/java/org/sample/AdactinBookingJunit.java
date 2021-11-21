package org.sample;

import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.library.LibGlobal;


public class AdactinBookingJunit extends LibGlobal{

	@BeforeClass
	public static void beforeClass() {
		getDriver();
		loadUrl("https://adactinhotelapp.com/");
		maximize();
	}

	@AfterClass
	public static void afterClass() {
		allWindowClose();
	}

	@Before
	public void beforeMethod() {
		Date date = new Date();
		System.out.println(date);
	}

	@After
	public void afterMethod() {
		Date date = new Date();
		System.out.println(date);
	}

	@Test
	public void test1() throws IOException {

		String Name = getData("Adactinbooking","Data",1,0);
		String Pass = getData("Adactinbooking","Data",1,1);

		WebElement txtUserName = locatorById("username");
		textBox(txtUserName, Name);	
		String userName = getAttribute(txtUserName);
		Assert.assertEquals("Verify UserName",Name,userName);
		
		WebElement txtPassword = locatorById("password");
		textBox(txtPassword, Pass);
		String password = getAttribute(txtPassword);
		Assert.assertEquals("Verify Password",Pass,password);

		WebElement btnLogin = locatorById("login");
		getScreenshot("Login");
		click(btnLogin);
	}

	@Test
	public void test2() throws IOException {

		WebElement location = locatorById("location");
		selectOptionById(location, 5);
		WebElement hotels = locatorById("hotels");
		selectOptionById(hotels, 3);
		
		WebElement roomType = locatorById("room_type");
		selectOptionById(roomType, 2);
		WebElement numOfRoom = locatorById("room_nos");
		selectOptionById(numOfRoom, 1);

		WebElement chkInDate = locatorById("datepick_in");
		chkInDate.clear();
		String inDate = getData("Adactinbooking","Data", 1, 7);
		textBox(chkInDate, inDate);
		String chkindate = getAttribute(chkInDate);
		Assert.assertEquals("Verify ChkInDate",inDate,chkindate);

		WebElement chkOutDate = locatorById("datepick_out");
		chkOutDate.clear();
		String outDate = getData("Adactinbooking","Data", 1, 8);
		textBox(chkOutDate, outDate);
		String chkoutdate = getAttribute(chkOutDate);
		Assert.assertEquals("Verify ChkOutDate",outDate,chkoutdate);

		WebElement adultPerRoom = locatorById("adult_room");
		selectOptionById(adultPerRoom, 2);
		WebElement childPerRoom = locatorById("child_room");
		selectOptionById(childPerRoom, 1);
		
		WebElement btnSearch = locatorById("Submit");
		getScreenshot("Search Hotel");
		click(btnSearch);
	}

	@Test		
	public void test3() throws IOException {

		WebElement btnOpion = locatorById("radiobutton_0");
		click(btnOpion);
		WebElement btnContinue = locatorById("continue");
		getScreenshot("Continue");
		click(btnContinue);

	}

	@Test
	public void test4() throws IOException, InterruptedException {

		String firstName = getData("Adactinbooking","Data",1,2);
		String lastName = getData("Adactinbooking","Data",1,3);
		String billAdd = getData("Adactinbooking","Data",1,4);
		String cvvNum = getData("Adactinbooking","Data",1,5);
		String cvvNumber = getData("Adactinbooking","Data",1,6);

		WebElement txtfirstname = locatorById("first_name");
		textBox(txtfirstname, firstName);
		String fname = getAttribute(txtfirstname);
		Assert.assertEquals("Verify firstName",firstName,fname);

		WebElement txtlastname = locatorById("last_name");
		textBox(txtlastname, lastName);
		String lname = getAttribute(txtlastname);
		Assert.assertEquals("Verify lastName",lastName,lname);


		WebElement txtBillAdd = locatorById("address");
		textBox(txtBillAdd, billAdd);
		String billAddress = getAttribute(txtBillAdd);
		Assert.assertEquals("Verify BillAdd",billAdd,billAddress);

		WebElement txtccnum = locatorById("cc_num");
		textBox(txtccnum, cvvNum);
		WebElement creditCardType = locatorById("cc_type");
		selectOptionById(creditCardType, 1);

		WebElement expireMonth = locatorById("cc_exp_month");
		selectOptionById(expireMonth, 1);
		WebElement expireYear = locatorById("cc_exp_year");
		selectOptionById(expireYear, 10);

		WebElement txtCvv = locatorById("cc_cvv");
		textBox(txtCvv, cvvNumber);
		WebElement btnBookNow = locatorById("book_now");
		getScreenshot("Booking");
		click(btnBookNow);

		Thread.sleep(5000);
	}

	@Test
	public void test5() throws  IOException {

		WebElement orderNO = locatorById("order_no");
		ScrollDown(orderNO);
		String data = getAttribute(orderNO);
		writeDataInCell("Adactinbooking", "Data", 1, 9, data);

		getScreenshot("OrderNo");

	}

}
