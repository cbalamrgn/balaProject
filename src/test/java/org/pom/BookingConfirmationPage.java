package org.pom;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.library.LibGlobal;

public class BookingConfirmationPage extends LibGlobal {

	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="order_no")
	private WebElement txtOrderNo;

	public WebElement getTxtOrderNo() {
		return txtOrderNo;
	}

	public void BookingConfirmation() throws IOException {
		String data = getAttribute(txtOrderNo);
		writeDataInCell("AdactinhotelappDetails", "Data", 1, 20, data);
	}
}
