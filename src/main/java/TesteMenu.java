import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteMenu {
	
	private WebDriver driver;
	private LoginPage pageLogin;
	private InitialPage page;
	
	@Before
	public void before() {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		pageLogin = new LoginPage(driver);
		driver.get("https://uol.unifor.br/acesso/app/autenticacao");
		
		pageLogin.setMatricula("730548787");
		pageLogin.setSenha("20042000");
		pageLogin.acessar();
		
		page = new InitialPage(driver);
		
	}
	
	@After
	public void after(){
		
		driver.quit();
		
	}
	

	@Test
	public void acessarOrganograma() {
		
		page.selecionaMenuCampus();
		page.selecionaSubmenuOrganograma();
		page.selecionaOpcaoOrganograma();
		
		Assert.assertEquals("Organograma", page.obterTituloTelaOrganograma());
		
	}
	
}
