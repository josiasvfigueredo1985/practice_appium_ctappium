import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.Test;

import com.appium.core.BasePage;
import com.appium.core.BaseTest;
import com.appium.pages.FormularioPage;
import com.appium.pages.MenuPage;

public class FormularioTest extends BaseTest {

	MenuPage menu = new MenuPage();
	FormularioPage form = new FormularioPage();
	BasePage page = new BasePage();

	@Test
	public void devePreencherFormulario() throws MalformedURLException {
		// Arrange
		menu.selecionaFormulario();

		// Actions
		form.escreveNome("Josias Valentim");
		form.selecionaCombo("PS4");
		form.clicaCheckBox();
		form.clicaSalvar();

		// Assertions
		assertTrue(form.verificaTextoExibido("Josias Valentim"));
		assertTrue(form.verificaTextoExibido("PS4"));
		assertTrue(form.verificaCheckBox());
		assertTrue(form.verificaSwitch());
		assertFalse(form.verificaBotaoSalvar());
	}

	@Test
	public void deveAlterarData() {
		// Arrange
		menu.selecionaFormulario();
		
		// Actions
		form.clicaPorTexto("01/01/2000");
		form.clicaPorResourceId("android:id/prev");
		form.clicaPorTexto("29");
		page.esperaImplicita(5);
		form.clicaPorTexto("OK");
		// Assertions
		assertTrue(page.verificaTextoExibido("29/1/2000"));
	}

	@Test
	public void deveAlterarHora() {
		// Arrange
		menu.selecionaFormulario();
		
		//Actions
		form.clicaPorTexto("06:00");
		form.clicaPorAccessibilityId("11");
		form.abreTecladoCalendario();
		form.limpaMinutosCalendario();
		form.digitaMinutosCalendario("58");
		page.esperaImplicita(5);
		form.clicaPorTexto("OK");
		// Assertions
		assertTrue(page.verificaTextoExibido("11:58"));
		System.out.println("Two...minutes to miiiiidniiiight....");

	}
	
	@Test
	public void deveArrastarSeekbar() {
		
		menu.selecionaFormulario();
				
		form.arrastaSeekBar1(0.15);
		
		page.esperaImplicita(10);
		form.clicaSalvar();
		assertTrue(page.verificaElementoPorTexto("Slider: 15"));
		
	}
}