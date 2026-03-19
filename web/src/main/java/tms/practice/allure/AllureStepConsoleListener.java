package tms.practice.allure;

import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.StepResult;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AllureStepConsoleListener implements StepLifecycleListener {

  @Override
  public void beforeStepStart(StepResult result) {
    log.info(result.getName());
  }
}
