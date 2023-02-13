import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.appium.core.BasePage;
import com.appium.core.BaseTest;
import com.appium.pages.CliquesPage;
import com.appium.pages.MenuPage;

public class CliquesTest extends BaseTest {

	MenuPage page = new MenuPage();
	BasePage base = new BasePage();
	CliquesPage clic = new CliquesPage();

	@Test
	public void deveExecutarCliqueLongo() {
		page.selecionaCliques();

		clic.executaCliqueLongo();

		assertTrue(page.verificaElementoPorTexto("Clique Longo"));
	}

	@Test
	public void deveExecutarCliqueDuplo() {
		page.selecionaCliques();

		clic.executaCliqueDuplo();
		page.esperaImplicita(2);

		assertTrue(page.verificaElementoPorTexto("Duplo Clique"));
	}

	@Test
	public void deveExecutarCliqueDuploLento() {
		page.selecionaCliques();

		clic.executaCliqueDuploLento();

		assertTrue(page.verificaElementoPorTexto("Duplo Clique lento"));
	}

	@Test
	public void deveExecutarCliqueLimpar() {
		page.selecionaCliques();

		clic.executaCliqueLongo();
		clic.executaCliqueDuplo();
		clic.executaCliqueDuploLento();
		clic.executaCliqueLimparLento();

		assertTrue(clic.verificaCampoCliqueVazio());
	}
}
