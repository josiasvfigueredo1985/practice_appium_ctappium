import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.appium.core.BasePage;
import com.appium.core.BaseTest;
import com.appium.pages.MenuPage;
import com.appium.pages.OpcaoPage;

public class OpcaoTest extends BaseTest {

	MenuPage menu = new MenuPage();
	BasePage page = new BasePage();
	OpcaoPage op = new OpcaoPage();
	
	@Test
	public void deveClicarOpcaoEscondida() {
		
		op.scrollDownTelaMenu();
		menu.selecionaOpcaoEscondida();
		
		assertTrue(page.verificaElementoPorTexto("Voc� achou essa op��o"));
		
		//page.clicaPorTexto("OK");
	}
}
