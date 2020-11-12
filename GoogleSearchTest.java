package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		//carga el driver
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		//Ahora creamos el objeto WebDriver
		driver = new ChromeDriver();
		//Abrimos una instancia del navegador
		driver.manage().window().maximize();
		//dirección url que queremos abrir
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void testGooglePage() {
		//obtiene la caja de búsqueda de google
		WebElement searchbox=driver.findElement(By.name("q"));
		//Se limpia la caja de búsqueda
		searchbox.clear();
		//Contenido que se desea buscar
		searchbox.sendKeys("quality-stream Introduccion a la automatizacion de pruebas");
		//Se envía el texto
		searchbox.submit();
		//tiempo de carga de los resultados de búsqueda
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//el contenido de búsqueda debe ser igual al título de la página de  resultado
		assertEquals("quality-stream Introduccion a la automatizacion de pruebas - Google Search",driver.getTitle());
	}
	
	@After
	public void tearDown() {
		
		//Se cierra el navegador una ve que se completa la prueba
		driver.quit();
	}
}
