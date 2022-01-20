import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InitialPage {
	
	private DSL dsl;
	
	public InitialPage(WebDriver driver) {
		
		dsl = new DSL(driver);
		
	}
	
	/*public void selecionaMenuCampus() {
		dsl.clicaLink("//a[@id='BGFEWQQS']");
	}*/
	
	public void selecionaMenuCampus() {
		dsl.clicaLinkComEspera(By.id("BGFEWQQS"), 3);
	}
	
	public void selecionaSubmenuOrganograma() {
		//dsl.clicaBotao(By.id("6D344CABA8E11"));
		dsl.clicaLinkComEspera(By.id("6D344CABA8E11"), 3);
	}

	public void selecionaOpcaoOrganograma() {
		//dsl.clicaLink("//a[@id='ORG_001']");
		dsl.clicaLinkComEspera(By.id("ORG_001"), 3);
	}

	public String obterTituloTelaOrganograma() {
		return dsl.getTextoComEspera(By.xpath("//*[@class='titulo-azul']/h4"), 10);
	}
		
	
	
}
