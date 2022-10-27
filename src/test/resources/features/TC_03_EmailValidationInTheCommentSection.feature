Feature: Validate the emails in the comment section
  @SetUrl
  @MobCodeCh
  Scenario Template: Validation of the proper email format
    Given user sets the "<endPoint>"
    When user fetches the comments
    Then user validates the emails are in proper format

    Examples:
      | endPoint |
      | comments |