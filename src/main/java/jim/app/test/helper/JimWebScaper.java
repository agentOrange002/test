package jim.app.test.helper;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.remote.http.W3CHttpCommandCodec;
import org.openqa.selenium.remote.http.W3CHttpResponseCodec;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JimWebScaper {

	// private static final String URL = "https://relatedwords.org/relatedto/car";
	private static final String SEARCH = "https://www.zillow.com/homes/recently_sold/Pleasanton-CA/house_type/47164_rid/globalrelevanceex_sort/37.739092,-121.750317,37.583086,-122.028408_rect/11_zm/";
	private final ChromeDriver driver;

	@PostConstruct
	void postConstruct() {
		scrape();
	}

	// @Scheduled(fixedDelay = 5000)
	public void scrape() {
		// driver.get(SEARCH);
		// final WebElement words = driver.findElementByClassName("words");
		// final WebElement words =
		// driver.findElementByClassName("result-list-container");
		// final List<WebElement> wordList = words.findElements(By.tagName("a"));
		// wordList.forEach(word -> System.out.println(word.getText()));
		
		HttpCommandExecutor executor = (HttpCommandExecutor) driver.getCommandExecutor();
		URL url = executor.getAddressOfRemoteServer();
		SessionId session_id = driver.getSessionId();
		RemoteWebDriver driver2 = createDriverFromSession(session_id, url);
		
		try {		
			driver2.get(SEARCH);
			Thread.sleep(150000);			
			WebElement element = driver.findElement(By.tagName("div"));		
			//List<WebElement> wordList = element.findElements(By.xpath(".//*"));		
			List<WebElement> wordList = element.findElements(By.tagName("address"));
			AtomicInteger runCount = new AtomicInteger(1);
			wordList.forEach(word -> System.out.println(runCount.getAndIncrement()+" :"+word.getText()));			
		} catch (Exception error) {

		}
		finally {
			driver2.quit();
		}
		
	}

	public static RemoteWebDriver createDriverFromSession(final SessionId sessionId, URL command_executor) {
		CommandExecutor executor = new HttpCommandExecutor(command_executor) {

			@Override
			public Response execute(Command command) throws IOException {
				Response response = null;
				if (command.getName() == "newSession") {
					response = new Response();
					response.setSessionId(sessionId.toString());
					response.setStatus(0);
					response.setValue(Collections.<String, String>emptyMap());

					try {
						Field commandCodec = null;
						commandCodec = this.getClass().getSuperclass().getDeclaredField("commandCodec");
						commandCodec.setAccessible(true);
						commandCodec.set(this, new W3CHttpCommandCodec());

						Field responseCodec = null;
						responseCodec = this.getClass().getSuperclass().getDeclaredField("responseCodec");
						responseCodec.setAccessible(true);
						responseCodec.set(this, new W3CHttpResponseCodec());
					} catch (NoSuchFieldException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}

				} else {
					response = super.execute(command);
				}
				return response;
			}
		};

		return new RemoteWebDriver(executor, new DesiredCapabilities());
	}

}
