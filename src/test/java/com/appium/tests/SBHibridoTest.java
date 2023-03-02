package com.appium.tests;
import static org.junit.Assert.assertEquals;
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
		// Digitar email
		sb.email("josiasvfigueredo@gmail.com");
		// Digitar Senha
		sb.senha("josias_2022");
		// Botão Entrar
		sb.entrar();
		assertEquals("Bem vindo, Josias Valentim!", sb.verificaTextoBoasVindas());

	}
}
