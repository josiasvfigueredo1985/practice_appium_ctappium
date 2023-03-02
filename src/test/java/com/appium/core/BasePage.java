package com.appium.core;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import java.util.List;

// Deprecated -> import io.appium.java_client.TouchAction;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
	/*
	 * ------------------ Attention ------------------
	 * All the methods implemented here are adjusted to the tested application,
	 * so be careful to not implement the wrong logic in your test
	 */

	// #region Utils
	public void writeText(By by, String text) {
		try {
			getDriver().findElement(by).sendKeys(text);
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
			waitBy(by);
			getDriver().findElement(by).click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void waitBy(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
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

	public boolean verifyIfIsEnabled(By by) {
		boolean enabled = false;
		try {
			enabled = getDriver().findElement(by).getAttribute("enabled").equals("true");
		} catch (Exception e) {
			System.out.println(e);
		}
		return enabled;
	}

	// #endregion

	// region Waits
	public void waitForPresenceOfElement(String fullXpath) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(fullXpath)));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean waitForElementBeNotVisible(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}

	public void implicitWaitInMilisec(long milisec) {
		try {
			Thread.sleep(milisec);
		} catch (InterruptedException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public void implicitWaitInSec(long sec) {
		try {
			driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	// endregion

	// region Clicks
	public void clickByText(String text) {
		try {
			waitForPresenceOfElement("//*[@text='" + text + "']");
			MobileElement el = driver.findElement(By.xpath("//*[@text='" + text + "']"));
			el.click();
		} catch (Exception e) {
			WebElement el = driver.findElement(By.xpath("//*[@text='" + text + "']"));
			el.click();
		}
	}

	public void clickCoordinatesByText(String text) {
		waitForPresenceOfElement("//*[@text='" + text + "']");
		MobileElement el = driver.findElement(By.xpath("//*[@text='" + text + "']"));
		int x = el.getCenter().x - (el.getSize().width / 2);
		int y = el.getCenter().y;
		tap(x, y);
		implicitWaitInMilisec(200);
	}

	public void clickByXpathContentDescId(String id) {
		waitForPresenceOfElement("//*[@content-desc='" + id + "']");
		driver.findElement(By.xpath("//*[@content-desc='" + id + "']")).click();
	}

	public void clickByXpathResourceId(String id) {
		driver.findElement(By.xpath("//*[@resource-id='" + id + "']")).click();
	}

	public void clickByXpath(String fullXPath) {
		waitForPresenceOfElement(fullXPath);
		driver.findElement(By.xpath(fullXPath)).click();
	}

	public void longClickXpathText(String text) {
		waitForPresenceOfElement("//*[@text='" + text + "']");
		MobileElement el = driver.findElementByXPath("//*[@text='" + text + "']");
		Point x = el.getCenter();
		AndroidTouchAction longClick = new AndroidTouchAction(driver);
		longClick.longPress(PointOption.point(x)).perform();
	}

	public void doubleClickXpathText(String text) {
		waitForPresenceOfElement("//*[@text='" + text + "']");
		MobileElement el = driver.findElementByXPath("//*[@text='" + text + "']");
		AndroidTouchAction doubleClick = new AndroidTouchAction(driver);
		doubleClick.tap(tapOptions().withElement(ElementOption.element(el)).withTapsCount(2)).perform();
	}

	public void slowDoubleClick(String text) {
		waitForPresenceOfElement("//*[@text='" + text + "']");
		MobileElement el = driver.findElementByXPath("//*[@text='" + text + "']");
		Point x = el.getCenter();
		AndroidTouchAction longDoubleClick = new AndroidTouchAction(driver);
		longDoubleClick.press(PointOption.point(x)).release().perform();
		implicitWaitInMilisec(500);
		longDoubleClick.press(PointOption.point(x)).release().perform();
	}

	public void clickByXpathIndex(String index) {
		WebDriverWait w = new WebDriverWait(driver, 3);
		w.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@index='" + index + "']")))
				.click();
	}

	// endregion

	// region Taps
	public void tap(int x, int y) {
		TouchAction action = new TouchAction(driver);
		action.tap(PointOption.point(x, y)).perform();
	}

	// endregion

	// region Swipes

	public void swipe(double inicio, double fim) {

		Dimension size = driver.manage().window().getSize();

		int y = size.height / 2;

		int start_x = (int) (size.width * inicio);
		int end_x = (int) (size.width * fim);

		AndroidTouchAction swipe = new AndroidTouchAction(driver);
		swipe.longPress(PointOption.point(start_x, y)).moveTo(PointOption.point(end_x, y)).release().perform();
		implicitWaitInMilisec(200);
		// Deprecated -> new AndroidTouchAction(driver).press(PointOption.point(x,
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
		int end_x = (int) ((opcao.getCenter().x * 2) * fim);
		int y = opcao.getCenter().y;
		AndroidTouchAction swipeList = new AndroidTouchAction(driver);
		swipeList.longPress(PointOption.point(start_x, y)).moveTo(PointOption.point(end_x, y))
				.release().perform();
		implicitWaitInMilisec(200);
	}

	// endregion

	// region Inputs
	public void inputTextXpathResourceId(String resource_id, String text) {
		driver.findElement(By.xpath("//*[@resource-id='" + resource_id + "']")).sendKeys(text);
	}

	public void writeTextXpath(String xpath, String text) {
		try {
			waitForPresenceOfElement(xpath);
			getDriver().findElement(By.xpath(xpath)).sendKeys(text);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	// endregion

	// region Returns
	public String getTextByXpathText(String text) {
		return driver.findElement(By.xpath("//*[@text='" + text + "']")).getText();
	}

	public String getTextByAttribute(String text) {
		return driver.findElement(By.xpath("//*[@text='" + text + "']")).getText();
		// Só é possível ler os atributos que contém o text esperado,
		// o elemento retorna um array vazio caso tentar ler dele diretamente.
	}

	public String getTextByXpathIndex(int ind) {
		return driver.findElement(By.xpath("//*[@index='" + ind + "']")).getText();
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
	public boolean checkIfElementExistsByText(String text) {
		List<MobileElement> elementos = driver.findElements(By.xpath("//*[@text='" + text + "']"));
		return elementos.size() > 0;
	}

	public boolean checkIfElementIsDisplayedByText(String textName) {
		waitForPresenceOfElement("//*[@text='" + textName + "']");
		return driver.findElementByXPath("//*[@text='" + textName + "']").getAttribute("displayed").equals("true");
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
		MobileElement btn = driver
				.findElementByXPath((fullXpathSlideButton));
		// Get the value from bounds attributes, e.g: [0,100][50,1000]
		String bounds = btn.getAttribute("bounds");
		// Convert the value to int
		int delta = Integer.parseInt(bounds.substring(8, 10));
		// System.out.println("Delta "+delta);
		return delta;
	}

	public void slideSeekBar(String fullXpathSeekBar, String fullXpathSlideButton, double pos) {
		MobileElement seek = driver.findElementByXPath(fullXpathSeekBar);
		// Delta is the measure identified as the zero point position forthe Y axis
		// |< >-------------< >|
		int delta = returnSeekBarButtonDeltaPosition(fullXpathSlideButton, fullXpathSeekBar);
		int y = seek.getLocation().y + (seek.getSize().height / 2);
		int xInitial = seek.getLocation().x + delta;
		// xInitial = point x of element = delta (delta is the point x + begin of the
		// slide element)
		int x = (int) (xInitial + ((seek.getSize().width - (delta * 2))) * pos);
		// x = x initial + (element slide wide - delta * 2, the gap in the two sides
		// must be considered
		tap(x, y);
	}

	// endregion

	// region Scrolls
	public void scroll(double start, double end) {
		Dimension size = driver.manage().window().getSize();
		int x = size.width / 2;
		int start_y = (int) (size.height * start);
		int end_y = (int) (size.height * end);
		AndroidTouchAction scrol = new AndroidTouchAction(driver);
		scrol.longPress(PointOption.point(x, start_y)).moveTo(PointOption.point(x, end_y)).release().perform();
	}

	public void scrollDown() {
		scroll(0.9, 0.1);
	}

	public void scrollUp() {
		scroll(0.1, 0.9);
	}
	// endregion

	// region Drang and Drops
	public void dragAndDrop(String from, String to) {
		MobileElement start = driver.findElement(By.xpath("//*[@text='" + from + "']"));
		MobileElement end = driver.findElement(By.xpath("//*[@text='" + to + "']"));
		AndroidTouchAction dragDrop = new AndroidTouchAction(driver);
		dragDrop.longPress(element(start)).moveTo(element(end)).release().perform();
		implicitWaitInMilisec(500);
	}

	// endregion

}
