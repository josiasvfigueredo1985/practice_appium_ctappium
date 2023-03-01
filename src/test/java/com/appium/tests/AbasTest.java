package com.appium.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.appium.core.BaseTest;
import com.appium.pages.AbasPage;
import com.appium.pages.MenuPage;

public class AbasTest extends BaseTest {

	AbasPage aba = new AbasPage();
	MenuPage page = new MenuPage();

	@Test
	public void verificaAbas1e2() {
		// Arrange
		page.selecionaAbas();
		// Actions
		aba.clicarAba1();
		// Assertions
		assertTrue(aba.verificaTextoAba1());
		// Actions
		aba.clicarAba2();
		// Assertions
		assertTrue(aba.verificaTextoAba2());
	}
}
