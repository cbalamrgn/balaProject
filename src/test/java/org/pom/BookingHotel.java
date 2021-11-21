package org.pom;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.library.LibGlobal;

public class BookingHotel extends  LibGlobal{
	
	@BeforeClass
	public static void browserSetup() {
		getDriver();
		loadUrl("https://adactinhotelapp.com/");
		maximize();		
	}
	
	@Test
	public void SearchHotel() throws IOException, InterruptedException {
		
		String userName = getData("AdactinhotelappDetails", "Data", 1, 0);
		String password = getData("AdactinhotelappDetails", "Data", 1, 1);	
		String location = getData("AdactinhotelappDetails", "Data", 1, 12);
		String hotels = getData("AdactinhotelappDetails", "Data", 1, 13);
		String roomType = getData("AdactinhotelappDetails", "Data", 1, 14);
		String numberOfRooms = getData("AdactinhotelappDetails", "Data", 1, 15);
		String checkInDate = getData("AdactinhotelappDetails", "Data", 1, 16);
		String checkOutDate = getData("AdactinhotelappDetails", "Data", 1, 17);
		String AdultsPerRoom = getData("AdactinhotelappDetails", "Data", 1, 18);
		String ChildrenPerRoom = getData("AdactinhotelappDetails", "Data", 1, 19);
		String firstName = getData("AdactinhotelappDetails", "Data", 1, 3);
		String lastName = getData("AdactinhotelappDetails", "Data", 1, 4);
		String billingAddress = getData("AdactinhotelappDetails", "Data", 1, 5);
		String creditCardNo = getData("AdactinhotelappDetails", "Data", 1, 7);
		String creditCardType = getData("AdactinhotelappDetails", "Data", 1, 8);
		String ccExpMonth = getData("AdactinhotelappDetails", "Data", 1, 9);
		String ccExpYear = getData("AdactinhotelappDetails", "Data", 1, 10);
		String cvvNumber = getData("AdactinhotelappDetails", "Data", 1, 11);
		
		LoginPage loginPage = new LoginPage();
		loginPage.login(userName, password);
		
		SearchHotelPage searchHotelPage = new SearchHotelPage();
		searchHotelPage.SearchHotel(location, hotels, roomType, numberOfRooms, checkInDate, checkOutDate, AdultsPerRoom, ChildrenPerRoom);
		
		SelectHotelPage selectHotelPage = new SelectHotelPage();
		selectHotelPage.SelectHotel();
		
		BookHotelPage bookHotelPage = new BookHotelPage();
		bookHotelPage.BookHotel(firstName, lastName, billingAddress, creditCardNo, creditCardType, ccExpMonth, ccExpYear, cvvNumber);
		
		Thread.sleep(5000);
		
		BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
		bookingConfirmationPage.BookingConfirmation();
	}
	
	@AfterClass
	public static void browserClose() {
		allWindowClose();
	}
	
}
