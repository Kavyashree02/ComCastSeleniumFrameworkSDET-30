package com.crm.CampaignTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CampaignInfoPage;
import com.crm.ObjectRepository.CampaignPage;
import com.crm.ObjectRepository.CreateCampaignPage;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ProductInfoPage;
import com.crm.ObjectRepository.ProductsPage;

@Listeners(com.crm.GenericLibrary.ListenerImplementationClass.class)
public class CreateCampaignProductTest extends BaseClass {
	
	@Test
	public void createCampaignProductTest() throws Throwable
	{
		
		String ProductName = eLib.readDataFromExcel("Campaign", 1, 2);
		String CampaignName = eLib.readDataFromExcel("Campaign", 1, 3)+"_"+jLib.getRandomNumber();
				
		
		
		/*step 4: navigate to products link & create a product*/
		HomePage hp= new HomePage(driver);
		hp.ClickOnProductLnk();
		
		
		ProductsPage pp= new ProductsPage(driver);
		pp.clickOnCreateProdImg();
		
		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.createNewProduct(ProductName);
		
		/* verification*/
		ProductInfoPage pip = new ProductInfoPage(driver);
		String actHeader = pip.ProductInfo();
		if(actHeader.contains(ProductName))
		{
			System.out.println(actHeader +"-----> Product created");
		}
		else
		{
			System.out.println("Product creation failed");
		}
        			
		
		/* step 6 : navigate to campaign*/
		hp.ClickOnMore();
		hp.ClickOnCampaignnLnk();
		
				
		/*step 7: create a campaign & choose the product*/
		CampaignPage cp = new CampaignPage(driver);
		cp.clickOnCreateCampImg();
		
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.createNewCamp(driver, CampaignName, ProductName);
	
		
		/* verification*/
		CampaignInfoPage cip = new CampaignInfoPage(driver);
		String actHeader1 = cip.CampaignInfo();
		if(actHeader1.contains(CampaignName))
		{
			System.out.println(actHeader1 +"-----> Campaign created");
		}
		else
		{
			System.out.println("Campaign creation failed");
		}
			
				
		
		}

}
