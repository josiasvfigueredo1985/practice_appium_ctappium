import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.appium.core.BasePage;
import com.appium.core.BaseTest;
import com.appium.pages.MenuPage;
import com.appium.pages.SwipePage;

public class SwipeTest extends BaseTest {

	MenuPage menu = new MenuPage();
	SwipePage swip = new SwipePage();
	BasePage base = new BasePage();

	@Test
	public void deveVerificarMensagensDoSwipe() {
		menu.scrollDownTelaMenu();
		menu.selecionaSwipe();
		assertTrue(base.validateDisplayedText("a esquerda"));

		// Swipe esquerda
		base.swipeLeft();
		assertTrue(base.validateDisplayedText("você consegue"));

		// Clicar bot�o
		swip.clicaBotaoDireita();
		assertTrue(base.validateDisplayedText("Chegar até o fim!"));

		// Swipe direita
		base.swipeRight();
		assertTrue(base.validateDisplayedText("você consegue"));

		// Swipe direita
		base.swipeRight();
		assertTrue(base.validateDisplayedText("a esquerda"));
	}
}
