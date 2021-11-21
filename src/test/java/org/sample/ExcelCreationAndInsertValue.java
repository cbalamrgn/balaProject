package org.sample;

import java.io.IOException;

import com.library.BaseClass;

public class ExcelCreationAndInsertValue {

	public static void main(String[] args) throws IOException {
		BaseClass bc = new BaseClass();
		bc.writeData("Test", 0, 0, "Bala");
	}

}
