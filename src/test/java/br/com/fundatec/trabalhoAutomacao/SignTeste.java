package br.com.fundatec.trabalhoAutomacao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignTeste {

	@Test
	public void deveFazerLogin() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\tecnico\\eclipse-workspace\\trabalhoAutomacao\\drivers\\chromedriver.exe");
		
		WebDriver navegador = new ChromeDriver();
		
		navegador.get("http://demo.cs-cart.com");
		
		navegador.findElement(By.linkText("VIDEO GAMES")).click();
		navegador.findElement(By.linkText("PlayStation 3")).click();
		navegador.findElement(By.linkText("Lord of the Rings: War in the North(PS3)")).click();
		navegador.findElement(By.name("dispatch[checkout.add..88]")).click();
		Thread.sleep(5000);
		
		String carrinho = navegador.findElement(By.xpath("/html/body/div[2]/div[4]/div[2]/div/div[1]/div[3]/div/div[2]/div/div/div[1]/a/span/span[2]")).getText();
		assertEquals("1 item(s) for $39.99", carrinho);
		Thread.sleep(3000);
		
		navegador.findElement(By.xpath("/html/body/div[2]/div[4]/div[2]/div/div[2]/div/div/ul/li[7]/a[2]")).click();
		navegador.findElement(By.linkText("X-Box One")).click();
		navegador.findElement(By.linkText("Batman: Arkham City (X360)")).click();
		navegador.findElement(By.name("dispatch[checkout.add..94]")).click();
		Thread.sleep(5000);
		
		String carrinhoFinal = navegador.findElement(By.xpath("/html/body/div[2]/div[4]/div[2]/div/div[1]/div[3]/div/div[2]/div/div/div[1]/a/span/span[2]")).getText();
		assertEquals("2 item(s) for $99.98", carrinhoFinal);
	}
}
