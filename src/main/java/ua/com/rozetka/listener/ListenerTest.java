package ua.com.rozetka.listener;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import util.WebDriverUtil;

public class ListenerTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult tr) {
        if (!tr.isSuccess()) {
            makeScreenshotOnFailure();
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] makeScreenshotOnFailure() {
        return ((TakesScreenshot) WebDriverUtil.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
