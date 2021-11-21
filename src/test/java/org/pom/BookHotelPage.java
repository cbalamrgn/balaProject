package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.library.LibGlobal;

public class BookHotelPage extends LibGlobal {
	
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="first_name")
	private WebElement txtFirstName;

	@FindBy(id="last_name")
	private WebElement txtLastName;
	
	@FindBy(id="address")
	private WebElement txtBillingAddress;
	
	@FindBy(id="cc_num")
	private WebElement txtCreditCardNo;
	
	@FindBy(id="cc_type")
	private WebElement dDnCreditCardType;
	
	@FindBy(id="cc_exp_month")
	private WebElement dDnCcExpMonth;
	
	@FindBy(id="cc_exp_year")
	private WebElement dDnCcExpYear;
	
	@FindBy(id="cc_cvv")
	private WebElement txtCvvNumber;
	
	@FindBy(id="book_now")
	private WebElement btnBookNow;

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtBillingAddress() {
		return txtBillingAddress;
	}

	public WebElement getTxtCreditCardNo() {
		return txtCreditCardNo;
	}

	public WebElement getdDnCreditCardType() {
		return dDnCreditCardType;
	}

	public WebElement getdDnCcExpMonth() {
		return dDnCcExpMonth;
	}

	public WebElement getdDnCcExpYear() {
		return dDnCcExpYear;
	}

	public WebElement getTxtCvvNumber() {
		return txtCvvNumber;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

	public void BookHotel(String firstName,String lastName,String billingAddress,String creditCardNo,String creditCardType,
			String ccExpMonth,String ccExpYear,String cvvNumber) throws InterruptedException {
		
		textBox(txtFirstName, firstName);
		textBox(txtLastName, lastName);
		textBox(txtBillingAddress, billingAddress);
		textBox(txtCreditCardNo, creditCardNo);
		selectOptionByText(dDnCreditCardType, creditCardType);
		selectOptionByText(dDnCcExpMonth, ccExpMonth);
		selectOptionByText(dDnCcExpYear, ccExpYear);
		textBox(txtCvvNumber, cvvNumber);
		click(btnBookNow);
		Thread.sleep(5000);
	}

	
}
