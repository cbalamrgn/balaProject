package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.library.LibGlobal;

public class SelectHotelPage extends LibGlobal{
	
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="radiobutton_0")
	private WebElement btnSelect;

	@FindBy(id="continue")
	private WebElement btnContinue;

	public WebElement getBtnSelect() {
		return btnSelect;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}
	
	public void SelectHotel() {
		click(btnSelect);
		click(btnContinue);
	}
}
