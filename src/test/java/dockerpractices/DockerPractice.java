package dockerpractices;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DockerPractice {

	public static void main (String args[]) {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");		
		dc.setCapability(ChromeOptions.CAPABILITY, options);
		URL url;
		try {
			url = new URL("http://localhost:4444/wd/hub");
			RemoteWebDriver driver = new RemoteWebDriver(url,dc);
			driver.get("https://opensource-demo.orangehrmlive.com/");
			System.out.println(driver.getTitle());
			driver.quit();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int a=0;
		switch(a) {
		
		case 0 : 
			System.out.println(0);
		default :
			System.out.println(1);
			break;
		case 3 :
			System.out.println(2);
		}
	
	}
}
