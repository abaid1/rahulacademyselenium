package Rahulacademy;


import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class RegistrationTest {
	@Test
	@Parameters ({"URL"})
	public void studentRegis(String dusraURL) throws InterruptedException, IOException
	
	{
		
	BrowserLaunchPage launch = new BrowserLaunchPage();
	
	launch.fnBrowserLaunch(dusraURL);
	launch.fnRegistration();
	Thread.sleep(3000);
	launch.fnRegistrationError();
	Thread.sleep(3000);
	launch.fnBrowserQuit();
	}
		
}
