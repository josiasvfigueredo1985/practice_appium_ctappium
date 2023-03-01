package com.appium.tests;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.appium.core.BaseTest;
import com.appium.pages.AccordionPage;
import com.appium.pages.MenuPage;

public class AccordionTest extends BaseTest {

	MenuPage menu = new MenuPage();
	AccordionPage acc = new AccordionPage();

	@Test

	public void verificaMenusAccordion() {
		// Arrange
		menu.selecionaAccordion();
		
		// Actions'
		acc.selecionaOpcao1();
		
		// Assertions
		assertTrue(acc.verificaTextoOpcao1());
		
		// Actions
		acc.selecionaOpcao2();
		
		// Assertions
		assertTrue(acc.verificaTextoOpcao2());
		
		// Actions
		acc.selecionaOpcao3();
		
		// Assertions
		assertTrue(acc.verificaTextoOpcao3());
		
		// Actions
		acc.selecionaOpcao4();
		
		// Assertions
		assertTrue(acc.verificaTextoOpcao4());
		
		// Actions
		acc.selecionaOpcao5();
		
		// Assertions
		assertTrue(acc.verificaTextoOpcao5());
		
		// Actions
		acc.selecionaOpcao6();
		
		// Assertions
		assertTrue(acc.verificaTextoOpcao6());
	}
}
