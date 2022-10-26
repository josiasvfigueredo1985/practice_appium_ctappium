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
		clicaPorAccessibilityId("save");
	}

	public void clicaSalvarDemorado() {
		getDriver().findElementByXPath("//*[@text='SALVAR DEMORADO']").click();
	}

	public void abreTecladoCalendario() {
		clicaPorResourceId("android:id/toggle_mode");
	}

	public void digitaMinutosCalendario(String minutos) {
		digitaTexto("android:id/input_minute", minutos);
	}

	public void limpaMinutosCalendario() {
		limpaTexto("android:id/input_minute");
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
		arrastaSeekBar("slid", x);

	}

}
