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


//Menginputkan City Name
WebUI.click(findTestObject('Object Repository/Search Hotel/City Name/Select_CityName'))

WebUI.setText(findTestObject('Object Repository/Search Hotel/City Name/Input_CityName'), input_CityName)

WebUI.click(findTestObject('Object Repository/Search Hotel/City Name/Option_CityName'))

//Menginputkan data traveller
WebUI.click(findTestObject('Object Repository/Search Hotel/Travellers/Select_Travellers'))

//Menambah data adults dan child
WebUI.setText(findTestObject('Object Repository/Search Hotel/Travellers/Number_Adults'), '0')
WebUI.setText(findTestObject('Object Repository/Search Hotel/Travellers/Number_Childs'), '0')
for (int i = 0; i < 13; i++) {
	WebUI.click(findTestObject('Object Repository/Search Hotel/Travellers/Adults_Plus'))
	WebUI.click(findTestObject('Object Repository/Search Hotel/Travellers/Childs_Plus'))
}
WebUI.selectOptionByValue(findTestObject('Object Repository/Search Hotel/Travellers/Select_Nationality'), 'ID', false)

//Menghitung jumlah total child age
List<WebElement> childAge = WebUI.findWebElements(findTestObject('Object Repository/Verify/Verify Travellers/ChildAge_Total'), 10)
println childAge.size()

if (childAge.size() < 12) {
	WebUI.click(findTestObject('Object Repository/Search Hotel/Button/Button_Search'))
} else {
	KeywordUtil.markFailed('Child age lebih dari 12')
}

WebUI.closeBrowser()