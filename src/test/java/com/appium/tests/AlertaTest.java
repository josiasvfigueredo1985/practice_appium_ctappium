package com.appium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.appium.core.BaseTest;
import com.appium.pages.AlertaPage;
import com.appium.pages.MenuPage;

public class AlertaTest extends BaseTest {

	AlertaPage al = new AlertaPage();
	MenuPage page = new MenuPage();

	@Test
	public void verificaPopUpAlerta() {

		page.selecionaAlerta();

		al.clicaAlertaConfirm();
		assertEquals("Confirma a operação?", al.verificaInfoConfirma());

		al.confirmarInfo();
		assertEquals("Confirmado", al.verificaInfoConfirmado());

		al.sair();
	}

	@Test
	public void deveClicarForaDoAlerta() {

		page.selecionaAlerta();

		al.clicaAlertaSimples();

		assertTrue(al.verificaAlertaFechado());

		al.clicaForaDoAlertaSimples();

		assertFalse(al.verificaAlertaFechado());
	}

}
