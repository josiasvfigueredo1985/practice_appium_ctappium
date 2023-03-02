package com.appium.pages;

import org.openqa.selenium.By;

import com.appium.core.BasePage;

import io.appium.java_client.MobileBy;

public class FormularioPage extends BasePage {

	public void escreveNome(String name) {
		writeTextXpath("//*[@text='Nome']", name);
	}

	public void selecionaCombo(String Item) {
		click(MobileBy.AccessibilityId("console"));
		click(By.xpath("//*[@text='" + Item + "']"));
		implicitWaitInMilisec(500);
	}

	public void clicaCheckBox() {
		click(By.xpath("//*[@content-desc='check']"));
		implicitWaitInMilisec(500);
	}

	public void clicaSwitch() {
		click(By.xpath("//*[@content-desc='switch']"));
		implicitWaitInMilisec(500);
	}

	public void clicaSalvar() {
		clickByXpathContentDescId("save");
		implicitWaitInMilisec(500);
	}

	public void clicaSalvarDemorado() {
		click(By.xpath("//*[@text='SALVAR DEMORADO']"));
		implicitWaitInMilisec(500);
	}

	public void abreTecladoCalendario() {
		clickByXpathResourceId("android:id/toggle_mode");
		implicitWaitInMilisec(500);
	}

	public void digitaMinutosCalendario(String minutos) {
		inputTextXpathResourceId("android:id/input_minute", minutos);
	}

	public void limpaMinutosCalendario() {
		cleanInputField("android:id/input_minute");
	}

	public boolean verificaCheckBox() {
		// return
		// getDriver().findElementByXPath("//*[@content-desc='check']").getAttribute("checked").equals("true");
		return verifyIfIsChecked(By.xpath("//*[@content-desc='check']"));
	}

	public boolean verificaSwitch() {
		return verifyIfIsChecked(By.xpath("//*[@content-desc='switch']"));
	}

	public boolean verificaBotaoSalvar() {
		return verifyIfIsEnabled(By.xpath("//*[@text='SALVAR']"));
	}

	public void arrastaSeekBar1(double x) {
		waitForPresenceOfElement("//android.view.ViewGroup[@content-desc='slid']/android.view.ViewGroup[2]");
		slideSeekBar("//android.view.ViewGroup[@content-desc='slid']/android.view.ViewGroup[1]",
				"//android.view.ViewGroup[@content-desc='slid']/android.view.ViewGroup[2]", x);
	}

	public void selectCalendar(String date) {
		clickByText(date);
	}

	public void selectYear(String year) {
		click(By.xpath("//*[@resource-id='android:id/text1' and @text='" + year + "']"));
	}

	public void clickClock() {
		implicitWaitInMilisec(500);
		clickByXpathIndex("7");
	}

	public void selectDayInCalendar(String day) {
		clickByText(day);
	}

	public void clickOKCalendar() {
		clickByText("OK");
	}

	public void clickYearSelection() {
		click(By.xpath("//android.widget.TextView[@resource-id='android:id/date_picker_header_year']"));
	}
}
