import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAcessar {
	
	private WebDriver driver;
	private LoginPage page;
	
	@Before
	public void before() {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		page = new LoginPage(driver);
		driver.get("https://uol.unifor.br/acesso/app/autenticacao");
		
	}
	
	@After
	public void after(){
		
		driver.quit();
		
	}
	

	@Test
	public void acessarEValidarAcesso() {
		
		page.setMatricula("730548787");
		page.setSenha("20042000");
		
		page.acessar();
		
		Assert.assertEquals("LARISSA", page.obterNomeUsuario());
		Assert.assertEquals("730-548787", page.obterMatriculaUsuario());
		
	}
	
}
