package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() 
	{
		logger.info("******************Strating TC001_AccountRegistrationTest***************");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		
		hp.clickRegister();
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("***************Providing customer details***************");
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.Enterlastname(randomeString().toUpperCase());
		regpage.Enteremail(randomeString()+"@gmail.com");
		regpage.Entertelephone(randomeNumber());
		
		String password = randomeAlphaNumberic();
		
		regpage.Enterpassword(password);
		regpage.Enterconfirmpassword(password);
		regpage.checkpolicy();
		regpage.clickcontinue();
		
		logger.info("***********Validating expected Message****************");
		
		String confmsg = regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		
		else
		{
			logger.error("Test failed");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
		
		//Assert.assertEquals(cnfmsge, "Your Account Has Been Created!");
		}
		
		catch(Exception e)
		{
			
			Assert.fail();
		}
		
		logger.info("*********************Finished TC001_AccountRegistrationTest*********************");
	}
}
