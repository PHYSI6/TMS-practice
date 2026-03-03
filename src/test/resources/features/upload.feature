Feature: Upload file

  @regression
  Scenario Outline: Successful upload
    Given user opens upload page
    And user waits for upload page opening
    When user uploads file "<fileName>"
    And clicks upload button
    Then upload should be successful "<expectedText>"

    Examples:
      | fileName          | expectedText      |
      | base_schema.xml   | base_schema.xml   |
      | base_schema_1.xml | base_schema_1.xml |

  @smoke
  Scenario Outline: Successful upload
    Given user opens upload page
    And user waits for upload page opening
    When user uploads file "<fileName>"
    And clicks upload button
    Then upload should be successful "<expectedText>"

    Examples:
      | fileName          | expectedText      |
      | base_schema.xml   | base_schema.xml   |
      | base_schema_1.xml | base_schema_1.xml |
