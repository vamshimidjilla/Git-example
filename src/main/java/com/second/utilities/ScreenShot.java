package com.second.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.second.base.BaseEngine;

import java.io.IOException;

public interface ScreenShot 
{
public static void screenshot(String tcName) throws IOException {
	
		TakesScreenshot takesScreenshot = (TakesScreenshot)BaseEngine.getWebDriver();
		File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(file, new File(BaseEngine.getUserDir()+"\\Screenshots\\+"tcName+".jpeg"));
		
		//FileUtils.copyFile(file, new File("C:\\Java_Practice\\Vam\\Screenshots\\+"tcName+".jpeg"));
		FileUtils.copyFile(file, new File("C:\\Java_Practice\\Vam\\Screenshots\\vamshi.jpeg"));
}
}

