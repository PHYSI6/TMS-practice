package tms.practice.element;


import java.io.File;

import com.codeborne.selenide.SelenideElement;

public class FileUploader {

  private final SelenideElement input;

  public FileUploader(SelenideElement input) {
    this.input = input;
  }

  public void upload(String path) {
    input.uploadFile(new File(path));
  }
}