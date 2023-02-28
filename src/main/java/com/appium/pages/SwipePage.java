package com.appium.pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;

import com.appium.core.BasePage;
import com.appium.core.DriverFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SwipePage extends BasePage {

	public void clicaBotaoDireita() {
		clickElementByXpathText("›");
	}

	public void clicaBotaoEsquerda() {
		clickElementByXpathText("‹");
	}
}
