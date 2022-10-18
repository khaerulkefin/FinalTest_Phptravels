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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement

WebUI.openBrowser('https://phptravels.net/')
WebUI.maximizeWindow()
WebUI.click(findTestObject('Object Repository/Menu/Hotels'))

WebUI.scrollToElement(findTestObject('Object Repository/Featured Hotels/Headline_Featured Hotels'), 10)

//Mengambil element card
List<WebElement> cardHotel = WebUI.findWebElements(findTestObject('Object Repository/Featured Hotels/card_Hotels'), 10)
List<WebElement> cardList = new ArrayList()

for (dataCard in cardHotel) {
	cardList.add(dataCard.getText())
}

for (int i = 0; i < cardList.size(); i++) {
	if (cardList.get(i).equals('Hyatt Regency Perth')) {
		cardHotel[i].click()
	}
}

//verifikasi apakah card yang dipilih benar

WebUI.closeBrowser()