package org.test.co;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class A {

	@Test
	private void rest() {
		RestAssured.baseURI = "https://reqres.in";

		Response res = RestAssured.given().header("content-type", "application/json").queryParam("page", "2").when()
				.get("/api/users");

		int code = res.getStatusCode();
		System.out.println(code);

		String body = res.getBody().asString();
		System.out.println(body);
	}

	@Test(enabled = false)
	private void test1() {
		System.out.println("test1");

	}
	
	@Test(enabled = false)
	private void test15() {
		System.out.println("test1");

	}

	@Test(enabled = false)
	private void test16() {
		System.out.println("test1");

	}@Test(enabled = false)
	private void test18() {
		System.out.println("test1");

	}
	@Test(enabled = false)
	private void test19() {
		System.out.println("test1");

	}@Test
	private void test13() {
		System.out.println("test1");

	}


	@Test(enabled = false)
	private void test() {
		Assert.assertTrue(false);
	}

	@Test(enabled = false)
	private void test3() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		List<WebElement> allLinkWebElement = driver.findElements(By.tagName("a"));
		System.out.println(allLinkWebElement.size());

		for (int i = 0; i < allLinkWebElement.size(); i++) {
			WebElement currentlink = allLinkWebElement.get(i);
			String link = currentlink.getAttribute("href");
			if (link != null) {
				if (link.contains("http")) {
					URL url = new URL(link);
					URLConnection openConnection = url.openConnection();
					HttpURLConnection con = (HttpURLConnection) openConnection;
					int resp = con.getResponseCode();
					if (resp == 200) {
						System.out.println("success=" + link);
					} else {
						System.out.println("broken=" + link);

					}

				}
			}

		}
	}
}
