import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSL {
	
	private WebDriver driver;
	
	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	/*             TEXTO              */
	
	public void setTexto(String id, String texto) {
		driver.findElement(By.id(id)).clear();
		driver.findElement(By.id(id)).sendKeys(texto);
	}
	
	public String getValue(String id) {
		return driver.findElement(By.id(id)).getAttribute("value");
	}
	
	public String getTexto(By by) {
		return driver.findElement(by).getText();
	}
	
	public String getTexto(String id) {
		return getTexto(By.id(id));
	}
	
	/*             RADIO              */
	
	public void selecionaRadio(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public boolean isRadioSelecionado(String id) {
		return driver.findElement(By.id(id)).isSelected();
	}
	
	/*             CHECKBOX              */
	
	public void selecionaCheckBox(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public boolean isCheckBoxSelecionado(String id) {
		return driver.findElement(By.id(id)).isSelected();
	}
	
	/*             COMBO              */
	
	public List<String> getOpcoesCombo(String id){
		List<WebElement> opcoes = new Select(driver.findElement(By.id(id))).getOptions();
		List<String> strings = new ArrayList<String>();
		for(WebElement e : opcoes){
		    strings.add(e.getText());
		}
		
		return strings;
	}
	
	public void selecionaCombo(String id, String texto) {
		new Select(driver.findElement(By.id(id))).selectByVisibleText(texto);
	}
	
	public void desselecionaCombo(String id, String texto) {
		new Select(driver.findElement(By.id(id))).deselectByVisibleText(texto);
	}
	
	public String getPrimeiroSelecionadoCombo(String id) {
		return new Select(driver.findElement(By.id(id))).getFirstSelectedOption().getText();
	}
	
	public List<WebElement> getSelecionadosCombo(String id) {
		return new Select(driver.findElement(By.id(id))).getAllSelectedOptions();
	}
	
	/*             BOTÃO              */
	
	//public void clicaBotao(String id) {
		//driver.findElement(By.id(id)).click();
	//}
	
	public void clicaBotao(By by) {
		driver.findElement(by).click();
	}
	
	/*             LINK              */
	
	public void clicaLink(String link) {
		driver.findElement(By.linkText(link)).click();
	}
	
	/*  QUALQUER ELEMENTO COM ESPERA  */
	
	public WebElement buscaElementoComEspera(By by, int time) {
		return new WebDriverWait(driver, Duration.ofSeconds(time)).until(driver -> driver.findElement(by));
	}
	
	/*        LINK COM ESPERA        */
	
	public void clicaLinkComEspera(By by, int time) {
		buscaElementoComEspera(by, time).click();
	}
	
	/*       TEXTO COM ESPERA       */
	
	public String getTextoComEspera(By by, int time) {
		return buscaElementoComEspera(by, time).getText();
	}
	
	public String getValueComEspera(By by, int time) {
		return buscaElementoComEspera(by, time).getAttribute("value");
	}
	
	/*             ALERT              */
	
	public String alertaObterTexto() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public void alertaEscreverEAceitar(String texto) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(texto);
		alert.accept();
	}
	
	public String alertaObterTextoEAceitar() {
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		alert.accept();
		return texto;
	}
	
	public String alertaObterTextoENegar() {
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		alert.dismiss();
		return texto;
	}
	
}
