package com.appium.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.appium.core.BasePage;
import com.appium.core.BaseTest;
import com.appium.pages.MenuPage;
import com.appium.pages.SwipeListPage;

public class SwipeListTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SwipeListPage swip = new SwipeListPage();
	private BasePage page = new BasePage();
	
	@Test
	public void deveVerificarAcoesSwipeList() {

		// swipe até o menu Swipe List
		menu.esperaExplicita("Formulário");
		menu.scrollDown();
		menu.selecionaSwipeList();

		// fazer um swipe para a esquerda na opção 1
		swip.swipeOpcao1();
		
		swip.clicarMais();
		
		page.esperaImplicita(2);
		assertTrue(menu.verificaTextoExibido("Opção 1 (+)"));
		
		swip.swipeResetOpcao1();
		
		assertTrue(menu.verificaTextoExibido("Opção 1"));
	}

}
