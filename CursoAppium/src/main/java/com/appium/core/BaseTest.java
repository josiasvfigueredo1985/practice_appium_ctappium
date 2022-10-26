package com.appium.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest extends DriverFactory {

	public BaseTest() {
		super();
	}

	@Rule
	public TestName testName = new TestName();

	@Before
	public void inicializaAppium() {
		DriverFactory.getDriver();
	}

	/*
	 * @AfterClass public static void finalizaClasse() { DriverFactory.killDriver();
	 * }
	 */
	@After
	public void finalizaAppium() {
		gerarScreenShot();
		DriverFactory.killDriver();
		// Usar para múltiplos testes
		// DriverFactory.getDriver().resetApp();
	}

	@After
	public void gerarScreenShot() {

		try {
			File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(imagem, new File("target/screenshots/" + testName.getMethodName() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}