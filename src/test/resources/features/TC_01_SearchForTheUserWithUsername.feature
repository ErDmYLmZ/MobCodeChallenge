Feature: Search with username
  @SetUrl
  @MobCodeCh
  Scenario Outline: Search with username Delphine
    Given user sets the "<endPoint>"
    When user searches for a "<username>"
    Then the status code is verified as 200
    And the Content type is verified as "<contentType>"
    Then the received information should contain "<id>","<name>","<username>"

    Examples:
      | endPoint | id | name            | username | contentType                     |
      | users    | 9  | Glenna Reichert | Delphine | application/json; charset=utf-8 |