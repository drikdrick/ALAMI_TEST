package org.example.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='mobilePhone']")
    private WebElement mobilePhoneField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement passwordConfirmationField;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='cityAndProvince']")
    private WebElement cityAndProvinceField;

    @FindBy(xpath = "//button[@data-button-name='register-new']")
    private WebElement registerBtn;

    public RegisterPage(WebDriver newDriver) {
        PageFactory.initElements(newDriver, this);
    }

    public void setEmailField(String email) {
        if (email.equals("random")) {
            email = "test" + System.currentTimeMillis() + "@mailinator.com";
        }
        emailField.sendKeys(email);
    }

    public void setMobilePhoneField(String mobilePhone) {
        if (mobilePhone.equals("random")) {
            mobilePhone = "082223456789";
        }
        mobilePhoneField.sendKeys(mobilePhone);
    }

    public void setPasswordField(String password) {
        if (password.equals("random")) {
            password = "12345678aaAA";
        }
        passwordField.sendKeys(password);
    }

    public void setPasswordConfirmationField(String passwordConfirmation) {
        if (passwordConfirmation.equals("random")) {
            passwordConfirmation = "12345678aaAA";
        }
        passwordConfirmationField.sendKeys(passwordConfirmation);
    }

    public void setFirstNameField(String firstName) {
        if (firstName.equals("random")) {
            firstName = "Test";
        }
        firstNameField.sendKeys(firstName);
    }

    public void setLastNameField(String lastName) {
        if (lastName.equals("random")) {
            lastName = "User";
        }
        lastNameField.sendKeys(lastName);
    }

    public void setCityAndProvinceField(String cityAndProvince) throws InterruptedException {
        if (cityAndProvince.equals("random")) {
            cityAndProvince = "Jakarta";
        }
        cityAndProvinceField.sendKeys(cityAndProvince);
        Thread.sleep(2000);
        cityAndProvinceField.sendKeys(Keys.RETURN);
    }

    public void setFieldWithValue(String field, String value) throws InterruptedException {
        switch (field) {
            case "email":
                setEmailField(value);
                break;
            case "mobilePhone":
                setMobilePhoneField(value);
                break;
            case "password":
                setPasswordField(value);
                break;
            case "passwordConfirmation":
                setPasswordConfirmationField(value);
                break;
            case "firstName":
                setFirstNameField(value);
                break;
            case "lastName":
                setLastNameField(value);
                break;
            case "cityAndProvince":
                setCityAndProvinceField(value);
                break;
            default:
                throw new RuntimeException("Field not found");
        }
    }

    public void clickRegisterBtn() {
        registerBtn.click();
    }
}
