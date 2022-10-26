Feature: Search with username
@Url
  Scenario Outline: Search with username Delphine
    Given user sets the "<endPoint>"
    When user searches for a "<username>"
    Then the status code is verified as 200
    And the Content type is verified as "<ContentType>"
    Then the received information should contain "<id>","<name>","<username>"

    Examples:
      | endPoint | id | name            | username | ContentType                     |
      | users    | 9  | Glenna Reichert | Delphine | application/json; charset=utf-8 |