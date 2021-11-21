package org.sample;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.library.LibGlobal;

public class AdactinBooking {

	public static void main(String[] args) throws IOException, InterruptedException   {

		LibGlobal libglobal = new LibGlobal();
		libglobal.getDriver();
		libglobal.loadUrl("https://adactinhotelapp.com/");
		libglobal.maximize();
		String Name = libglobal.getData("Adactinbooking","Data",1,0);
		String Pass = libglobal.getData("Adactinbooking","Data",1,1);
		WebElement txtUserName = libglobal.locatorById("username");
		libglobal.textBox(txtUserName, Name);
		WebElement txtPassword = libglobal.locatorById("password");
		libglobal.textBox(txtPassword, Pass);
		WebElement btnLogin = libglobal.locatorById("login");
		libglobal.getScreenshot("Login");
		libglobal.click(btnLogin);
				
		WebElement location = libglobal.locatorById("location");
		libglobal.selectOptionById(location, 5);
		WebElement hotels = libglobal.locatorById("hotels");
		libglobal.selectOptionById(hotels, 3);
		WebElement roomType = libglobal.locatorById("room_type");
		libglobal.selectOptionById(roomType, 2);
		WebElement numOfRoom = libglobal.locatorById("room_nos");
		libglobal.selectOptionById(numOfRoom, 1);
		WebElement chkInDate = libglobal.locatorById("datepick_in");
		chkInDate.clear();
		String inDate = libglobal.getData("Adactinbooking","Data", 1, 7);
		libglobal.textBox(chkInDate, inDate);
		WebElement chkOutDate = libglobal.locatorById("datepick_out");
		chkOutDate.clear();
		String outDate = libglobal.getData("Adactinbooking","Data", 1, 8);
		libglobal.textBox(chkOutDate, outDate);
		
		WebElement adultPerRoom = libglobal.locatorById("adult_room");
		libglobal.selectOptionById(adultPerRoom, 2);
		WebElement childPerRoom = libglobal.locatorById("child_room");
		libglobal.selectOptionById(childPerRoom, 1);
		WebElement btnSearch = libglobal.locatorById("Submit");
		libglobal.getScreenshot("Search Hotel");
		libglobal.click(btnSearch);
				
		WebElement btnOpion = libglobal.locatorById("radiobutton_0");
		libglobal.click(btnOpion);
		WebElement btnContinue = libglobal.locatorById("continue");
		libglobal.getScreenshot("Continue");
		libglobal.click(btnContinue);
				
		String firstName = libglobal.getData("Adactinbooking","Data",1,2);
		String lastName = libglobal.getData("Adactinbooking","Data",1,3);
		String billAdd = libglobal.getData("Adactinbooking","Data",1,4);
		String cvvNum = libglobal.getData("Adactinbooking","Data",1,5);
		String cvvNumber = libglobal.getData("Adactinbooking","Data",1,6);
		WebElement txtfirstname = libglobal.locatorById("first_name");
		libglobal.textBox(txtfirstname, firstName);
		WebElement txtlastname = libglobal.locatorById("last_name");
		libglobal.textBox(txtlastname, lastName);
		WebElement txtBillAdd = libglobal.locatorById("address");
		libglobal.textBox(txtBillAdd, billAdd);
		WebElement txtccnum = libglobal.locatorById("cc_num");
		libglobal.textBox(txtccnum, cvvNum);
		WebElement creditCardType = libglobal.locatorById("cc_type");
		libglobal.selectOptionById(creditCardType, 1);
		WebElement expireMonth = libglobal.locatorById("cc_exp_month");
		libglobal.selectOptionById(expireMonth, 1);
		WebElement expireYear = libglobal.locatorById("cc_exp_year");
		libglobal.selectOptionById(expireYear, 10);
		WebElement txtCvv = libglobal.locatorById("cc_cvv");
		libglobal.textBox(txtCvv, cvvNumber);
		WebElement btnBookNow = libglobal.locatorById("book_now");
		libglobal.getScreenshot("Booking");
		libglobal.click(btnBookNow);
				
		Thread.sleep(5000);
		WebElement orderNO = libglobal.locatorById("order_no");
		libglobal.ScrollDown(orderNO);
		String data = libglobal.getAttribute(orderNO);
		libglobal.writeDataInCell("Adactinbooking", "Data", 1, 9, data);
		
		libglobal.getScreenshot("OrderNo");
	}

}
