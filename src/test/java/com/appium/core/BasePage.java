package com.appium.core;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import java.util.List;

// Deprecated -> import io.appium.java_client.TouchAction;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage extends DriverFactory {

	BaseTest baseTest = new BaseTest();

	// #region Utils
	public void writeText(By by, String texto) {
		try {
			getDriver().findElement(by).sendKeys(texto);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String getText(By by) {
		try {
			return getDriver().findElement(by).getText();
		} catch (Exception e) {
			return e.toString();
		}
	}

	public void click(By by) {
		try {
			getDriver().findElement(by).click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void clickByText(String texto) {
		try {
			click(By.xpath("//*[@text='" + texto + "']"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void selectCombo(By by, String value) {
		try {
			getDriver().findElement(by).click();
			clickByText(value);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean verifyIfIsChecked(By by) {
		boolean checked = false;
		try {
			checked = getDriver().findElement(by).getAttribute("checked").equals("true");
		} catch (Exception e) {
			System.out.println(e);
		}
		return checked;
	}

	public boolean verifyElementByText(String texto) {
		List<MobileElement> elementByText = null;
		try {
			elementByText = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
		} catch (Exception e) {
			System.out.println(e);
		}
		return elementByText.size() > 0;
	}

	public String getAlertTitle() {
		try {
			return getText(By.id("android:id/alertTitle"));
		} catch (Exception e) {
			System.out.println(e);
			return e.toString();
		}
	}

	public String getAlertText() {
		try {
			return getText(By.id("android:id/message"));
		} catch (Exception e) {
			System.out.println(e);
			return e.toString();
		}
	}
	// #endregion

	// region Waits
	public void explicitWaitXpath(String fullXpath) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(fullXpath)));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void explicitWaitByXpathText(String text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='" + text + "']")));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void implicitWaitInMilisecs(long milisec) {
		try {
			Thread.sleep(milisec);
		} catch (InterruptedException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public void waitForElementById(String id) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void implicitWaitInSecs(long sec) {
		try {
			driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean waitForElementBeNotVisible(String text) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='" + text + "']")));
	}

	// endregion

	// region Clicks
	public void clickElementByXpathText(String text) {
		// System.out.println("texto " + text);
		explicitWaitByXpathText(text);
		try {
			MobileElement el = driver.findElement(By.xpath("//*[@text='" + text + "']"));
			el.click();
		} catch (Exception e) {
			WebElement el = driver.findElement(By.xpath("//*[@text='" + text + "']"));
			el.click();
		}

	}

	public void clickByElementCoordinatesXpathText(String text) {
		MobileElement el = driver.findElement(By.xpath("//*[@text='" + text + "']"));
		int x = el.getCenter().x - (el.getSize().width / 2);
		int y = el.getCenter().y;
		tap(x, y);
	}

	public void clickByXpathContentDescId(String id) {
		driver.findElement(By.xpath("//*[@content-desc='" + id + "']")).click();
	}

	public void clickByXpathResourceId(String id) {
		driver.findElement(By.xpath("//*[@resource-id='" + id + "']")).click();
	}

	public void clickById(String id) {
		driver.findElement(By.id(id)).click();
	}

	public void clickByXpath(String fullXPath) {
		explicitWaitXpath(fullXPath);
		driver.findElement(By.xpath(fullXPath)).click();
	}

	public void longClickXpathText(String text) {
		MobileElement el = driver.findElementByXPath("//*[@text='" + text + "']");
		Point x = el.getCenter();
		AndroidTouchAction longClick = new AndroidTouchAction(driver);
		longClick.longPress(PointOption.point(x)).perform();
	}

	public void doubleClickXpathText(String text) {
		MobileElement el = driver.findElementByXPath("//*[@text='" + text + "']");
		AndroidTouchAction doubleClick = new AndroidTouchAction(driver);
		doubleClick.tap(tapOptions().withElement(ElementOption.element(el)).withTapsCount(2)).perform();
	}

	public void slowDoubleClick(String text) {
		MobileElement el = driver.findElementByXPath("//*[@text='" + text + "']");
		Point x = el.getCenter();
		AndroidTouchAction longDoubleClick = new AndroidTouchAction(driver);
		longDoubleClick.press(PointOption.point(x)).release().perform();
		implicitWaitInMilisecs(500);
		longDoubleClick.press(PointOption.point(x)).release().perform();
	}

	public void clickByXpathIndex(String index) {
		driver.findElement(By.xpath("//*[@index='" + index + "']")).click();
	}

	// endregion

	// region Taps
	public void tap(int x, int y) {
		// AndroidTouchAction tap = new AndroidTouchAction(driver);
		// tap.press(PointOption.point(x1, y1)).perform();

		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(PointOption.point(x, y)).perform();

	}

	// endregion

	// region Swipes

	public void swipe(double inicio, double fim) {

		org.openqa.selenium.Dimension size = driver.manage().window().getSize();

		int y = size.height / 2;

		int start_x = (int) (size.width * inicio);
		int end_x = (int) (size.width * fim);

		AndroidTouchAction swipe = new AndroidTouchAction(driver);
		swipe.longPress(PointOption.point(start_x, y)).moveTo(PointOption.point(end_x, y)).release().perform();
		// depreciado > new AndroidTouchAction(driver).press(PointOption.point(x,
		// start_y)).moveTo(PointOption.point(x, end_y)).release().perform();
	}

	public void swipeLeft() {
		swipe(0.9, 0.1);
	}

	public void swipeRight() {
		swipe(0.1, 0.9);
	}

	public void swipeList(String text, double inicio, double fim) {
		MobileElement opcao = driver.findElementByXPath("//*[starts-with(@text,'" + text + "')]");

		int start_x = (int) ((opcao.getCenter().x * 2) * inicio);
		// System.out.println(start_x);

		int end_x = (int) ((opcao.getCenter().x * 2) * fim);
		// System.out.println(end_x);

		int y = opcao.getCenter().y;
		// System.out.println(y);

		AndroidTouchAction swipeList = new AndroidTouchAction(driver);
		swipeList.longPress(PointOption.point(start_x, y)).moveTo(PointOption.point(end_x, y))
				.release().perform();
	}

	// endregion

	// region Inputs
	public void inputTextXpathResourceId(String resource_id, String text) {
		driver.findElement(By.xpath("//*[@resource-id='" + resource_id + "']")).sendKeys(text);
	}

	public void inputTextXpath(String fullXpath, String text) {
		driver.findElement(By.xpath(fullXpath)).sendKeys(text);
	}

	public void inputTextId(String id, String text) {
		driver.findElement(By.id(id)).sendKeys(text);
	}
	// endregion

	// region Returns
	public String getTextByXpathText(String text) {
		return driver.findElement(By.xpath("//*[@text='" + text + "']")).getText();
	}

	public String getTextByXpathContentDesc(String text) {
		return driver.findElement(By.xpath("//*[@content-desc='" + text + "']")).getText();
	}

	public String getTextByAttribute(String text) {
		return driver.findElement(By.xpath("//*[@text='" + text + "']")).getText();
		// Só é possível ler os atributos que contém o text esperado,
		// o elemento retorna um array vazio caso tentar ler dele diretamente.
	}

	public String getTextByXpathIndex(int ind) {
		return driver.findElement(By.xpath("//*[@index='" + ind + "']")).getText();
	}

	public String getTextByXpath(String fullPath) {
		return driver.findElement(By.xpath(fullPath)).getText();
	}

	public String getTextById(String id) {
		return driver.findElement(By.id(id)).getText();
	}

	public int[] getElementXYLocationXpath(String fullXPath) {
		explicitWaitXpath(fullXPath);
		MobileElement seek = driver.findElement(By.xpath(fullXPath));
		// First we get the element location
		// Element x position
		int x = seek.getLocation().x;
		// System.out.println("X-> " + x);
		// Element y position
		int y = seek.getLocation().y;
		// System.out.println("Y-> " + y);

		// Return and array with the respective positions
		int[] crdnts = { x, y };
		return crdnts;
	}

	public String[] getElementsListByClassName(String classe) {
		List<MobileElement> elements = driver.findElements(By.className(classe));

		String[] retorno = new String[elements.size()];
		for (int i = 0; i < elements.size(); i++) {
			retorno[i] = elements.get(i).getText();
			// System.out.print("\""+retorno[i]+"\",");
		}
		return retorno;
	}

	// endregion

	// region Clean Inputs
	public void cleanInputField(String id) {
		driver.findElementByXPath("//*[@resource-id='" + id + "']").clear();
	}
	// endregion

	// region Validations
	public boolean validateElementExistenceByText(String text) {
		List<MobileElement> elementos = driver.findElements(By.xpath("//*[@text='" + text + "']"));
		return elementos.size() > 0;
	}

	public boolean validateElementExistenceByText_2(String textName) {

		return driver.findElementByXPath("//*[@text='" + textName + "']").getAttribute("displayed").equals("true");
	}

	public boolean validateElementExistenceByXpath(String fullXPath) {

		return driver.findElementByXPath(fullXPath).getAttribute("displayed").equals("true");
	}

	public boolean validateElementExistenceById(String id) {

		return driver.findElementById(id).getAttribute("displayed").equals("true");
	}
	// endregion

	// region Seek Bars
	public void setSeekBarToZero(String fullXpathElement) {
		MobileElement el = driver.findElementByXPath((fullXpathElement));
		Point c = el.getCenter();
		int y = c.getY();
		tap(0, y);
	}

	public int returnSeekBarButtonDeltaPosition(String fullXpathSlideButton, String fullXpathSeekBar) {
		// Identify the element and click it to zero position
		setSeekBarToZero(fullXpathSeekBar);
		// Get the element through xpath
		// MobileElement btn = driver
		// .findElementByXPath(("//android.view.ViewGroup[@content-desc='slid']/android.view.ViewGroup[2]"));
		MobileElement btn = driver
				.findElementByXPath((fullXpathSlideButton));
		// Get the value from bounds attributes: [0,100][50,1000]
		String bounds = btn.getAttribute("bounds");
		// Convert the value to int
		int delta = Integer.parseInt(bounds.substring(8, 10));
		// System.out.println("Delta "+delta);
		return delta;
	}

	public void slideSeekBar(String fullXpathSeekBar, String fullXpathSlideButton, double pos) {
		MobileElement seek = driver.findElementByXPath(fullXpathSeekBar);
		int delta = returnSeekBarButtonDeltaPosition(fullXpathSlideButton, fullXpathSeekBar);// Delta is the measure
																								// identified as the
																								// zero
																								// point position for
																								// the Y axis
																								// cálculo médio da
																								// folga entre o limite
																								// do elemento slide e o
																								// slide de fato
		// System.out.println("Delta "+delta); // |< >-------------< >|
		int y = seek.getLocation().y + (seek.getSize().height / 2);
		// //System.out.println(y);

		int xinicial = seek.getLocation().x + delta;
		// xinicial = ponto x inicial do elemento = delta (delta é o ponto x + início do
		// elemento do slide de fato)
		// System.out.println(xinicial);
		int x = (int) (xinicial + ((seek.getSize().width - (delta * 2))) * pos);
		// x = x inicial + (largura do elelemento slide inteiro - delta * 2, j� que
		// devemos considerar a folga nos 2 lados) * posição desejada
		// System.out.println(x);

		tap(x, y);// método criado para executar o tap já depreciado
		// new AndroidTouchAction(driver).press(PointOption.point(x,
		// y)).release().perform();
	}

	// endregion

	// region Scrolls
	public void scroll(double inicio, double fim) {

		org.openqa.selenium.Dimension size = driver.manage().window().getSize();

		int x = size.width / 2;

		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);

		AndroidTouchAction scrol = new AndroidTouchAction(driver);
		scrol.longPress(PointOption.point(x, start_y)).moveTo(PointOption.point(x, end_y)).release().perform();
		// depreciado > new AndroidTouchAction(driver).press(PointOption.point(x,
		// start_y)).moveTo(PointOption.point(x, end_y)).release().perform();
	}

	public void scrollDown() {
		scroll(0.9, 0.1);
	}

	public void scrollUp() {
		scroll(0.1, 0.9);
	}
	// endregion

	// region Drang and Drops
	public void dragAndDrop(String origem, String destino) {
		MobileElement inicio = driver.findElement(By.xpath("//*[@text='" + origem + "']"));
		MobileElement fim = driver.findElement(By.xpath("//*[@text='" + destino + "']"));

		AndroidTouchAction dragDrop = new AndroidTouchAction(driver);
		dragDrop.longPress(element(inicio)).moveTo(element(fim)).release().perform();
	}

	// endregion

}
