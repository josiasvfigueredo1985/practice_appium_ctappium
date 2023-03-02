package com.appium.pages;

import org.openqa.selenium.By;

import com.appium.core.BasePage;

public class SBHibridoPage extends BasePage {

	public void email(String email) {
		waitForPresenceOfElement("//*[@resource-id='email']");
		inputTextXpathResourceId("email", email);
	}

	public void senha(String senha) {
		waitForPresenceOfElement("//*[@resource-id='senha']");
		inputTextXpathResourceId("senha", senha);
	}

	public void entrar() {
		click(By.xpath("//*[@text='Entrar']"));
		implicitWaitInMilisec(500);
	}

	public String verificaTextoBoasVindas() {
		String txt = "Bem vindo, Josias Valentim!";
		waitForPresenceOfElement("//*[@text='" + txt + "']");
		return getTextByAttribute(txt);
	}

}
