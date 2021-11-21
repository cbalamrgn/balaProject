package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.library.LibGlobal;

public class SearchHotelPage extends LibGlobal {
	
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="location")
	private WebElement dDnLocation;

	@FindBy(id="hotels")
	private WebElement dDnHotels;

	@FindBy(id="room_type")
	private WebElement dDnRoomType;

	@FindBy(id="room_nos")
	private WebElement dDnNoOfRoom;

	@FindBy(id="datepick_in")
	private WebElement txtCheckInDate;

	@FindBy(id="datepick_out")
	private WebElement txtCheckOutDate;

	@FindBy(id="adult_room")
	private WebElement dDnAdultsPerRoom;

	@FindBy(id="child_room")
	private WebElement dDnChildrenPerRoom;

	@FindBy(id="Submit")
	private WebElement btnSubmit;

	public WebElement getdDnLocation() {
		return dDnLocation;
	}

	public WebElement getdDnHotels() {
		return dDnHotels;
	}

	public WebElement getdDnRoomType() {
		return dDnRoomType;
	}

	public WebElement getdDnNoOfRoom() {
		return dDnNoOfRoom;
	}

	public WebElement getTxtCheckInDate() {
		return txtCheckInDate;
	}

	public WebElement getTxtCheckOutDate() {
		return txtCheckOutDate;
	}

	public WebElement getdDnAdultsPerRoom() {
		return dDnAdultsPerRoom;
	}

	public WebElement getdDnChildrenPerRoom() {
		return dDnChildrenPerRoom;

	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public void SearchHotel(String location,String hotels,String roomType,String numberOfRooms,String checkInDate,
			String checkOutDate,String AdultsPerRoom,String ChildrenPerRoom) {

		selectOptionByText(dDnLocation, location);
		selectOptionByText(dDnHotels, hotels);
		selectOptionByText(dDnRoomType, roomType);
		selectOptionByText(dDnNoOfRoom,numberOfRooms);
		textBox(txtCheckInDate, checkInDate);
		textBox(txtCheckOutDate, checkOutDate);
		selectOptionByText(dDnAdultsPerRoom, AdultsPerRoom);
		selectOptionByText(dDnChildrenPerRoom, ChildrenPerRoom);
		click(getBtnSubmit());
	}

}