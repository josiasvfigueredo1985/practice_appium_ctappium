package com.appium.core;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage extends DriverFactory {

	BaseTest baseTest = new BaseTest();
	
	public void esperaExplicita(String xpathText) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='" + xpathText + "']")));
	
	}

	public void esperaNormal(long milisec) {
		try {
			Thread.sleep(milisec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean verificaTextoExibido(String textName) {

		return driver.findElementByXPath("//*[@text='" + textName + "']").getAttribute("displayed").equals("true");
	}

	public String retornaTexto(String texto) {
		return driver.findElement(By.xpath("//*[@text='" + texto + "']")).getText();
	}
	
	public String retornaTextoContentDesc(String texto) {
		return driver.findElement(By.xpath("//*[@content-desc='" + texto + "']")).getText();
	}

	public String retornaTextoAtributoElemento(String texto) {
		MobileElement el =  driver.findElement(MobileBy.AccessibilityId(texto));
		return el.getAttribute("content-desc");// Só é possível ler os atributos que contém o texto esperado, o elemento retorna um array vazio
		//caso tentar ler dele diretamente.
	}
	
	public String retornaTextoIndex(int ind) {
		return driver.findElement(By.xpath("//*[@index='" + ind + "']")).getText();
	}

	public void clicaPorTexto(String texto) {
		driver.findElement(By.xpath("//*[@text='" + texto + "']")).click();
	}

	public void clicaPorCoordenada(String texto) {
		MobileElement el = driver.findElement(By.xpath("//*[@text='" + texto + "']"));
		int x = el.getCenter().x - (el.getSize().width / 2);
		int y = el.getCenter().y;
		tap(x, y);
	}

	public void clicaPorAccessibilityId(String id) {
		driver.findElement(MobileBy.xpath("//*[@content-desc='" + id + "']")).click();
	}

	public void clicaPorResourceId(String id) {
		driver.findElement(MobileBy.xpath("//*[@resource-id='" + id + "']")).click();
	}

	public void digitaTexto(String resource_id, String texto) {
		driver.findElement(MobileBy.xpath("//*[@resource-id='" + resource_id + "']")).sendKeys(texto);
	}

	public void limpaTexto(String id) {
		driver.findElementByXPath("//*[@resource-id='" + id + "']").clear();
	}

	public boolean verificaElementoPorTexto(String texto) {
		List<MobileElement> elementos = driver.findElements(By.xpath("//*[@text='" + texto + "']"));
		return elementos.size() > 0;
	}

	// *[contains(@name,'text')]")
	// *[starts-swith(@name,'text')]")
	public boolean aguardaElementoSumir(String texto) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='" + texto + "']")));
	}

	public void tap(int x1, int y1) {
		new TouchAction(driver).press(PointOption.point(x1, y1)).release().perform();
	}

	public void tapSimple(int x1, int y1) {
		new TouchAction(driver).press(PointOption.point(x1, y1)).perform();
	}
	
	public void esperaImplicita(long sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	public void arrastaSeekBar(String content_desc, double pos) {

		MobileElement seek = driver.findElementByXPath("//*[@content-desc='" + content_desc + "']");

		int delta = 40;
		// cálculo médio da folga entre o limite do elemento slide e o slide de fato
		// |< >-------------< >|
		int y = seek.getLocation().y + (seek.getSize().height / 2);
		// //System.out.println(y);

		int xinicial = seek.getLocation().x + delta;
		// xinicial = ponto x inicial do elemento = delta (delta é o ponto x + início do
		// elemento do slide de fato)
		// System.out.println(xinicial);
		int x = (int) (xinicial + ((seek.getSize().width - (delta * 2))) * pos);
		// x = x inicial + (largura do elelemento slide inteiro - delta * 2, já que
		// devemos considerar a folga nos 2 lados) * posição desejada
		// System.out.println(x);

		tap(x, y);// método criado para executar o tap já depreciado
		// new TouchAction(driver).press(PointOption.point(x,
		// y)).release().perform();
	}

	public void cliqueLongo(String texto) {
		MobileElement el = driver.findElementByXPath("//*[@text='" + texto + "']");
		Point x = el.getCenter();
		new TouchAction(driver).longPress(PointOption.point(x)).perform();
	}

	public void cliqueDuplo(String texto) {
		MobileElement el = driver.findElementByXPath("//*[@text='" + texto + "']");

		TouchAction action = new TouchAction(driver);
		action.tap(tapOptions().withElement(ElementOption.element(el)).withTapsCount(2)).perform();
	}

	public void cliqueDuploLento(String texto) {
		MobileElement el = driver.findElementByXPath("//*[@text='" + texto + "']");
		Point x = el.getCenter();
		new TouchAction(driver).press(PointOption.point(x)).perform();
		esperaNormal(500);
		new TouchAction(driver).press(PointOption.point(x)).perform();
	}

	public void scroll(double inicio, double fim) {

		org.openqa.selenium.Dimension size = driver.manage().window().getSize();

		int x = size.width / 2;

		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);

		new TouchAction(driver).longPress(PointOption.point(x, start_y)).moveTo(PointOption.point(x, end_y))
				.release().perform();
		// depereciado > new TouchAction(driver).press(PointOption.point(x,
		// start_y)).moveTo(PointOption.point(x, end_y)).release().perform();
	}

	public void swipe(double inicio, double fim) {

		org.openqa.selenium.Dimension size = driver.manage().window().getSize();

		int y = size.height / 2;

		int start_x = (int) (size.width * inicio);
		int end_x = (int) (size.width * fim);

		new TouchAction(driver).longPress(PointOption.point(start_x, y)).moveTo(PointOption.point(end_x, y))
				.release().perform();
		// depereciado > new TouchAction(driver).press(PointOption.point(x,
		// start_y)).moveTo(PointOption.point(x, end_y)).release().perform();
	}

	public void swipeLeft() {
		// TODO Auto-generated method stub
		swipe(0.9, 0.1);
	}

	public void swipeRight() {
		// TODO Auto-generated method stub
		swipe(0.1, 0.9);
	}

	public void scrollDown() {
		scroll(0.9, 0.1);
	}

	public void scrollUp() {
		scroll(0.1, 0.9);
	}

//$x(“//input[starts-with(@name,’btnK’)]”) 
	public void swipeList(String texto, double inicio, double fim) {
		MobileElement opcao = driver.findElementByXPath("//*[starts-with(@text,'" + texto + "')]");

		int start_x = (int) ((opcao.getCenter().x * 2) * inicio);
		// System.out.println(start_x);

		int end_x = (int) ((opcao.getCenter().x * 2) * fim);
		// System.out.println(end_x);

		int y = opcao.getCenter().y;
		// System.out.println(y);

		new TouchAction(driver).longPress(PointOption.point(start_x, y)).moveTo(PointOption.point(end_x, y))
				.release().perform();
	}

	public String[] retornaListaElementosPorClasse(String classe) {
		List<MobileElement> elements = driver.findElements(By.className(classe));
		
		String[] retorno = new String[elements.size()];
		for (int i = 0; i < elements.size(); i++) {
			retorno[i] = elements.get(i).getText();
			//System.out.print("\""+retorno[i]+"\",");
		}
		return retorno;
	}
	
	public void arrastaSolta(String origem, String destino) {
		MobileElement inicio = driver.findElement(By.xpath("//*[@text='"+origem+"']"));
		MobileElement fim = driver.findElement(By.xpath("//*[@text='"+destino+"']"));
		
		TouchAction press = new TouchAction(driver)
				.longPress(element(inicio))
				.moveTo(element(fim))
				.release()
				.perform();
	}
}
