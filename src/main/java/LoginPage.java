import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private DSL dsl;
	
	public LoginPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	
	public void setMatricula(String matricula) {
		dsl.setTexto("matricula", matricula);
	}
	
	public void setSenha(String senha) {
		dsl.setTexto("senha", senha);
	}	
	
	public void acessar() {
		dsl.clicaBotao(By.xpath("//input[@value='Acessar']"));
	}
	
	public String obterNomeUsuario() {
		return dsl.getTexto(By.id("nomeUsuario"));
	}
	
	public String obterMatriculaUsuario() {
		return dsl.getTexto(By.id("matriculaUsuario"));
	}
	
}
