import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.appium.core.BaseTest;
import com.appium.pages.MenuPage;
import com.appium.pages.SplashPage;

public class SplashTest extends BaseTest {

	MenuPage menu = new MenuPage();
	SplashPage page = new SplashPage();

	@Test
	public void verificaSplash() {

		// acessar menu splash
		menu.selecionaSplash();

		// verificar se o splash est� sendo exibido
		page.isSplashVisivel();

		// aguardar sa�da do splash
		page.aguardarSplashSumir();

		// verificar que o formul�rio est� sendo exibido
		assertTrue(page.validateElementExistenceByText("Formulário"));
	}
}
