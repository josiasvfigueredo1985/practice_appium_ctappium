package com.appium.pages;

import org.openqa.selenium.By;

import com.appium.core.BasePage;

public class SplashPage extends BasePage {

	public void mensagemSplash() {
		getDriver().findElement(By.xpath("//*[@text='Splash']"));
	}

	public boolean isSplashVisivel() {
		return verificaElementoPorTexto("Splash!");
	}
	public void aguardarSplashSumir() {
		aguardaElementoSumir("Splash!");
	}
	
	
}
