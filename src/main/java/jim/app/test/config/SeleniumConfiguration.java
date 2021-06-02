package jim.app.test.config;

import java.io.File;

import javax.annotation.PostConstruct;

import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeleniumConfiguration {

	@PostConstruct
	void postConstruct() {
		System.setProperty("webdriver.chrome.driver", new File("src/main/resources/chromedriver").getAbsolutePath());
		//System.setProperty("webdriver.chrome.driver","/home/agentorange002/Desktop/datalabs/test/src/main/resources/chromedriver");
	}

	@Bean
	public ChromeDriver driver() {
		return new ChromeDriver();
	}

	
}
