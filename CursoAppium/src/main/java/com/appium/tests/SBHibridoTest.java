package com.appium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.appium.core.BaseTest;
import com.appium.pages.MenuPage;
import com.appium.pages.SBHibridoPage;

public class SBHibridoTest extends BaseTest {

	MenuPage menu = new MenuPage();
	SBHibridoPage sb = new SBHibridoPage();

	@Test
	public void deveCadastrarNovousuario() {

		menu.selecionaSeuBarrigaHibrido();
		sb.esperaImplicita(2);
		// Digitar email
		sb.email("josiasvfigueredo@gmail.com");
		// Digitar Senha
		sb.senha("josias_2022");
		// Bot�o Entrar
		sb.entrar();
		sb.esperaImplicita(1);
		assertEquals("Bem vindo, Josias Valentim!", sb.verificaTextoBoasVindas());

	}
}
