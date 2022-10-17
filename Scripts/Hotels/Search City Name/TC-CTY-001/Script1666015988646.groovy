import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement

WebUI.openBrowser('https://phptravels.net/')
WebUI.maximizeWindow()
WebUI.click(findTestObject('Object Repository/Menu/Hotels'))

WebUI.click(findTestObject('Object Repository/Search Hotel/City Name/Select_CityName'))

WebUI.setText(findTestObject('Object Repository/Search Hotel/City Name/Input_CityName'), input_CityName)

WebUI.click(findTestObject('Object Repository/Search Hotel/City Name/Option_CityName'))

WebUI.click(findTestObject('Object Repository/Search Hotel/Button/Button_Search'))

//Verify City Name
List<WebElement> verifyCityName = WebUI.findWebElements(findTestObject('Object Repository/Verify/Verify City Name/City_Name'), 10)
cityName = WebUI.getText(findTestObject('Object Repository/Verify/Verify City Name/City_Name'))

if (cityName.equals(input_CityName)) {
	KeywordUtil.markPassed(verifyCityName.size() + ', ' + cityName)
} else {
	KeywordUtil.markFailed('City Name not match')
}

WebUI.closeBrowser()