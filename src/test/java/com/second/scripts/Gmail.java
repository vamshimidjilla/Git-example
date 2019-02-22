package com.second.scripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.second.base.BaseEngine;

public class Gmail extends BaseEngine
{
	public String userDir;
	@Test
	public void username() throws Exception 
	{
		
		getWebDriver().get("https://www.gmail.com");
		getWebDriver().findElement(By.id("identifierId")).sendKeys("vamshimidjilla");
		getWebDriver().findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		Thread.sleep(3000);
		getWebDriver().findElement(By.xpath("//input[@type='password']")).sendKeys("jxjkj");
		
	}

}
