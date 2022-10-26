package com.appium.pages;

import com.appium.core.BasePage;

public class AlertaPage extends BasePage {

	public void clicaAlertaSimples() {
		clicaPorTexto("ALERTA SIMPLES");
	}

	public void clicaAlertaRestritivo() {
		clicaPorTexto("ALERTA RESTRITIVO");
	}

	public void clicaAlertaConfirm() {
		clicaPorTexto("ALERTA CONFIRM");
	}

	public void confirmarInfo() {
		clicaPorTexto("CONFIRMAR");
	}

	public void negarInfo() {
		clicaPorTexto("NEGAR");
	}

	public void sair() {
		clicaPorTexto("SAIR");
	}

	public String verificaInfoConfirma() {
		return retornaTexto("Confirma a operação?");
	}

	public String verificaInfoConfirmado() {
		return retornaTexto("Confirmado");
	}

	public String verificaInfoNegado() {
		return retornaTexto("Negado");
	}
	
	public void clicaForaDoAlertaSimples() {
		tapSimple(500,1500);
	}
	
	public boolean verificaAlertaFechado() {
		return verificaElementoPorTexto("Pode clicar no OK ou fora da caixa para sair");
	}
}
