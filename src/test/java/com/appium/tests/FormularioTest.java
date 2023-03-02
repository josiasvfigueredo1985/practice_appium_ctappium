package com.appium.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.Test;

import com.appium.core.BasePage;
import com.appium.core.BaseTest;
import com.appium.pages.FormularioPage;
import com.appium.pages.MenuPage;

public class FormularioTest extends BaseTest {

	MenuPage menu = new MenuPage();
	FormularioPage form = new FormularioPage();
	BasePage page = new BasePage();

	@Test
	public void devePreencherFormulario() throws MalformedURLException {
		// Arrange
		menu.selecionaFormulario();

		// Actions
		form.escreveNome("Josias Valentim");
		form.selecionaCombo("PS4");
		form.clicaCheckBox();
		form.clicaSalvar();

		// Assertions
		assertTrue(form.checkIfElementIsDisplayedByText("Josias Valentim"));
		assertTrue(form.checkIfElementIsDisplayedByText("PS4"));
		assertTrue(form.verificaCheckBox());
		assertTrue(form.verificaSwitch());
		assertFalse(form.verificaBotaoSalvar());
	}

	@Test
	public void deveAlterarData() {
		// Arrange
		menu.selecionaFormulario();

		// Actions
		form.selectCalendar("01/01/2000");
		form.clickYearSelection();
		form.selectYear("2000");
		form.selectDayInCalendar("29");
		form.clickOKCalendar();

		// Assertions
		assertTrue(page.checkIfElementIsDisplayedByText("29/01/2000"));
	}

	@Test
	public void deveAlterarHora() {
		// Arrange
		menu.selecionaFormulario();

		// Actions
		form.clickClock();
		form.clickByXpathContentDescId("11");
		form.abreTecladoCalendario();
		form.limpaMinutosCalendario();
		form.digitaMinutosCalendario("58");
		page.implicitWaitInSec(5);
		form.clickByText("OK");
		// Assertions
		assertTrue(page.checkIfElementIsDisplayedByText("11:58"));
	}

	@Test
	public void deveArrastarSeekbar() {

		menu.selecionaFormulario();
		form.arrastaSeekBar1(0.15);
		form.clicaSalvar();
		assertTrue(page.checkIfElementExistsByText("Slider: 15"));

	}
}