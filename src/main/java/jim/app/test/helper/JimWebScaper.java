package jim.app.test.helper;

import java.util.List;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JimWebScaper {

	private static final String URL = "https://relatedwords.org/relatedto/";
	private final ChromeDriver driver;
	
	@PostConstruct
	void postConstruct() {
		scrape("car");
	}

	//@Scheduled(fixedDelay = 5000)
	public void scrape(String value) {
		driver.get(URL+value);
		final WebElement words = driver.findElementByClassName("words");
		final List<WebElement> wordList = words.findElements(By.tagName("a"));
		wordList.forEach(word -> System.out.println(word.getText()));
		driver.quit();
	}

	

}
