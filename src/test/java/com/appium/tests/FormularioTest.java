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
		assertTrue(form.validateElementExistenceByText_2("Josias Valentim"));
		assertTrue(form.validateElementExistenceByText_2("PS4"));
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
		page.implicitWaitInSecs(5);
		form.clickOKCalendar();

		// Assertions
		assertTrue(page.validateElementExistenceByText_2("29/01/2000"));
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
		page.implicitWaitInSecs(5);
		form.clickElementByXpathText("OK");
		// Assertions
		assertTrue(page.validateElementExistenceByText_2("11:58"));
	}

	@Test
	public void deveArrastarSeekbar() {

		menu.selecionaFormulario();
		form.arrastaSeekBar1(0.15);
		page.implicitWaitInSecs(10);
		form.clicaSalvar();
		assertTrue(page.validateElementExistenceByText("Slider: 15"));

	}
}