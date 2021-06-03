package jim.app.test.config;

import java.io.File;

import javax.annotation.PostConstruct;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeleniumConfiguration {

	@PostConstruct
	void postConstruct() {
		System.setProperty("webdriver.chrome.driver", new File("src/main/resources/chromedriver").getAbsolutePath());
	}

	@Bean
	public ChromeDriver driver() {
		final ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		co.addArguments("start-maximized");
		co.addArguments("disable-infobars");
		co.addArguments("--disable-extensions");
		co.addArguments("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.163 Safari/537.36");
		return new ChromeDriver(co);
	}	
}
