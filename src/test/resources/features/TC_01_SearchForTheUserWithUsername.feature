Feature: Search with username

  Scenario Outline: Search with username Delphine
    Given user sets the "<endPoint>"
    When user searches for a "<username>"
    Then the status code is verified as 200
    And the Content type is verified as "application/json"
    Then the received information should contain "<id>","<name>","<username>"

    Examples:
      | endPoint | id | name            | username |
      | users    | 9  | Glenna Reichert | Delphine |