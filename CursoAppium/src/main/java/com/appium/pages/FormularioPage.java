package com.appium.pages;

import com.appium.core.BasePage;

import io.appium.java_client.MobileBy;

public class FormularioPage extends BasePage {

	public void escreveNome(String name) {
		getDriver().findElementByXPath("//*[@text='Nome']").sendKeys(name);
	}

	public void selecionaCombo(String Item) {
		getDriver().findElement(MobileBy.AccessibilityId("console")).click();
		getDriver().findElementByXPath("//*[@text='" + Item + "']").click();
	}

	public void clicaCheckBox() {
		getDriver().findElementByXPath("//*[@content-desc='check']").click();
	}

	public void clicaSwitch() {
		getDriver().findElementByXPath("//*[@content-desc='switch']").click();
	}

	public void clicaSalvar() {
		clickByXpathContentDescId("save");
	}

	public void clicaSalvarDemorado() {
		getDriver().findElementByXPath("//*[@text='SALVAR DEMORADO']").click();
	}

	public void abreTecladoCalendario() {
		clickByXpathResourceId("android:id/toggle_mode");
	}

	public void digitaMinutosCalendario(String minutos) {
		inputTextXpathResourceId("android:id/input_minute", minutos);
	}

	public void limpaMinutosCalendario() {
		cleanInputField("android:id/input_minute");
	}

	public boolean verificaCheckBox() {
		return getDriver().findElementByXPath("//*[@content-desc='check']").getAttribute("checked").equals("true");
	}

	public boolean verificaSwitch() {
		return getDriver().findElementByXPath("//*[@content-desc='switch']").getAttribute("checked").equals("true");
	}

	public boolean verificaBotaoSalvar() {
		return getDriver().findElementByXPath("//*[@text='SALVAR']").getAttribute("enabled").equals("true");
	}

	public void arrastaSeekBar1(double x) {
		slideSeekBar("//*[@content-desc='slid']",
				"//android.view.ViewGroup[@content-desc='slid']/android.view.ViewGroup[2]", x);
	}

	public void selectCalendar(String date) {
		clickElementByXpathText(date);
	}

	public void selectYear(String year) {
		clickByXpath("//*[@resource-id='android:id/text1' and @text='" + year + "']");
	}

	public void clickClock() {
		explicitWaitXpath("//*[@text='09:00']");
		clickByXpathIndex("7");
	}

	public void selectDayInCalendar(String day) {
		clickElementByXpathText(day);
	}

	public void clickOKCalendar() {
		clickElementByXpathText("OK");
	}

	public void clickYearSelection() {
		clickByXpath("//android.widget.TextView[@resource-id='android:id/date_picker_header_year']");
	}
}
