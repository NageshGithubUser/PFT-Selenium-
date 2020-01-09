package com.qa.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LibraryPage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProdDBPage;
import com.qa.pages.ScreenerInboxpage;
import com.qa.pages.ScreenerOutboxPage;
import com.qa.pages.ScreenerPublisherPage;
import com.qa.util.TestUtil;

public class ExternalUserScreenerTest extends TestBase {
	
	LoginPage loginpage;	
	HomePage HomePage;
	LibraryPage libraryPage;
	ScreenerPublisherPage ScreenerPublisherPage;
	ScreenerInboxpage ScreenerInboxpage;
	ScreenerOutboxPage ScreenerOutboxPage;
	ProdDBPage ProdDBPage;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@Test(priority =1)
	public void SanityStart1()
	{
		System.out.println("================EXTERNAL USER SANITY REPORT START =================");
	}	
	
	@Test(priority = 2)
	public void ExternalUser_LaunchURL() {
		intilization();
		//TestUtil.Log.info("External URL has been launched");
		loginpage = new LoginPage();	
	}
	@Test(priority = 3)
	public void ExternalUser_Login()   {	
		try {
			ScreenerInboxpage= loginpage.Ext_login(prop.getProperty("External_Username"), prop.getProperty("External_Pwd"));
			//TestUtil.Log.info("External User has logeed-In");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//TestUtil.Log.debug("External User has not able to login , Please check the Creditial or xpath");
		}	
	}
//	@Test(priority=4)
//	public void CancelRequest()
//	{
//		try {
//			TestUtil.Wait();
//			ScreenerInboxpage.ClcikonSearchicon();
//			ScreenerInboxpage.SearchtheOrder(prop.getProperty("ScreenerTitleExternal"));
//			TestUtil.Wait();
//			ScreenerInboxpage.RequestExtenion(prop.getProperty("RequestExternsionComment"));
//			ScreenerInboxpage.CancelRequest();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//		}
//
//	}

	@Test(priority = 5)
	public void Validate_Metadata_Icon()
	{
		try {
			TestUtil.Wait();
			ScreenerInboxpage.ClcikonSearchicon();
			ScreenerInboxpage.SearchtheOrder(prop.getProperty("ScreenerTitleExternal"));
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			TestUtil.Wait();
			ScreenerInboxpage.VerifyMetadataIconsDisplay();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test(priority = 6)
	public void Validate_Download_Icon()
	{
		try {
			TestUtil.Wait();
			ScreenerInboxpage.ClcikonSearchicon();
			ScreenerInboxpage.SearchtheOrder(prop.getProperty("ScreenerTitleExternal"));
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			TestUtil.Wait();
			ScreenerInboxpage.VerifyDownloadIconsDisplay();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test(priority = 7)
	public void Validate_Play_Icon()
	{
		try {
			TestUtil.Wait();
			ScreenerInboxpage.ClcikonSearchicon();
			ScreenerInboxpage.SearchtheOrder(prop.getProperty("ScreenerTitleExternal"));
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			TestUtil.Wait();
			ScreenerInboxpage.VerifyPlayIconsDisplay();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
//	@Test(priority=8)
//	public void ShareOredr()
//	{
//		ScreenerInboxpage.shareorder(prop.getProperty("Share_Recipient_Id"));
//	}
//	@Test(priority=9)
//	public void ValidateRefreshBtn()
//	{
//		ScreenerInboxpage.ValidateRefresh();
//	}
//	
	@AfterSuite
	public void Endsanity() throws InterruptedException
	{
		TestUtil.Wait();
		System.out.println("================SANITY REPORT END =================");
		//driver.quit();
	}

}
