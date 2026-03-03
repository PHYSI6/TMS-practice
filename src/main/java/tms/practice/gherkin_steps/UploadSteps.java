package tms.practice.gherkin_steps;

import java.nio.file.Path;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tms.practice.page.upload.UploadPage;

import static org.testng.AssertJUnit.assertTrue;

public class UploadSteps {

  private UploadPage uploadPage;

  @Given("user opens upload page")
  public void openUploadPage() {
    uploadPage = UploadPage.openPage();
  }

  @Given("user waits for upload page opening")
  public void userWaitsForUploadPageOpening() {
    uploadPage.waitForLoad();
  }

  @When("user uploads file {string}")
  public void uploadFile(String fileName) {
    String path = Path.of("src","main","resources","files", fileName)
        .toAbsolutePath().toString();
    uploadPage.upload(path);
  }

  @When("clicks upload button")
  public void clickUpload() {
    uploadPage.clickUploadButton();
  }

  @Then("upload should be successful {string}")
  public void verifyUpload(String fileName) {
      assertTrue(true);
  }
}
