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

WebUI.openBrowser('https://phptravels.net/')
WebUI.maximizeWindow()
WebUI.click(findTestObject('Object Repository/Menu/Hotels'))


//Menginputkan City Name
WebUI.click(findTestObject('Object Repository/Search Hotel/City Name/Select_CityName'))

WebUI.setText(findTestObject('Object Repository/Search Hotel/City Name/Input_CityName'), input_CityName)

WebUI.click(findTestObject('Object Repository/Search Hotel/City Name/Option_CityName'))

//Menginputkan Checkin Checkout
WebUI.click(findTestObject('Object Repository/Search Hotel/CheckinCheckout/Select_Checkin'))
WebUI.click(findTestObject('Object Repository/Search Hotel/CheckinCheckout/Date/Checkin/td_29'))

WebUI.click(findTestObject('Object Repository/Search Hotel/CheckinCheckout/Date/Checkout/td_30'))

//Mengambil tanggal dari inputan tanggal checkin dan checkout
checkinDate = WebUI.getAttribute(findTestObject('Object Repository/Search Hotel/CheckinCheckout/Select_Checkin'), 'value')
checkoutDate = WebUI.getAttribute(findTestObject('Object Repository/Search Hotel/CheckinCheckout/Select_Checkout'), 'value')

WebUI.click(findTestObject('Object Repository/Search Hotel/Button/Button_Search'))

//Verifikasi tanggal hasil pencarian dengan tanggal inputan
verifyDate = WebUI.getText(findTestObject('Object Repository/Verify/Verify Date/Checkin_Checkout'))

if (verifyDate.contains(checkinDate) && verifyDate.contains(checkoutDate)) {
	KeywordUtil.markPassed('Tanggal pencarian sudah tepat')
}

WebUI.closeBrowser()