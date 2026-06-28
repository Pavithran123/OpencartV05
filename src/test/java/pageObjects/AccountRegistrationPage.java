package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtFirstname;

@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtLastname;

@FindBy(xpath="//input[@id='input-email']")
WebElement txtEmail;

@FindBy(xpath="//input[@id='input-telephone']")
WebElement txtTelephone;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtPassword;

@FindBy(xpath="//input[@placeholder=\"Password Confirm\"]") 
WebElement txtconfirmpassword ;

@FindBy(xpath="//input[@name=\"agree\"]")
WebElement chkpolicy ;

@FindBy(xpath="//input[@type=\"submit\"]") 
WebElement btncontinue ;

@FindBy(xpath="//div//h1[text()='Your Account Has Been Created!']") 
WebElement msgconfirmation;

//Action methods

public void setFirstName(String fname) {
	txtFirstname.sendKeys(fname);
}

public void Enterlastname(String lname) {
	
	txtLastname.sendKeys(lname);
} 


public void Enteremail(String email) {

txtEmail.sendKeys(email);
} 


public void Entertelephone(String phone) {

txtTelephone.sendKeys(phone);
} 


public void Enterpassword(String psw) {

txtPassword.sendKeys(psw);
} 


public void Enterconfirmpassword(String psw) {

txtconfirmpassword.sendKeys(psw);
} 

public void checkpolicy() {
	//chkpolicy.click();
	
	WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
	mywait.until(ExpectedConditions.elementToBeClickable(chkpolicy)).click();
}

public void clickcontinue() {
	
	WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
	mywait.until(ExpectedConditions.elementToBeClickable(btncontinue)).click();
	//btncontinue.click();
}


public String getConfirmationMsg() {
	try {
	return (msgconfirmation.getText());
	} catch(Exception e ) {
		return (e.getMessage());
	}
	
}

}
