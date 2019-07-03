package com.crm.qe.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.crm.qe.base.BaseClass;

public class TestUtils extends BaseClass {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 30;
	public static String TEST_DATA_SHEET_PATH = System.getProperty("user.dir")+"/src/main/resource/CRMTestData.xlsx";

	public static void switchToFrame(String frameId) {
		driver.switchTo().frame(frameId);
	}

	public static void switchToFrame(WebElement frame) {
		driver.switchTo().frame(frame);
	}
	
	public static void takeScreenShot() throws IOException{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir"+"\\screenshot\\"+System.currentTimeMillis()+".png")));
	}
}
