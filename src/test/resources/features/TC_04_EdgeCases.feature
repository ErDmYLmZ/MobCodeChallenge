Feature: Various edge cases

  Scenario Outline: Invalid username
    Given user sets the "<endPoint>"
    When user searches for a "<username>"
    Then the status code is verified as 200
    And the Content type is verified as "application/json"
    Then user verifies the response body is empty

    Examples:
      | endPoint | username |
      | users    | Delphin  |

    Scenario Outline: Invalid endPoints
      Given user sets the "<endPoint>"
      When user searches for a "<username>"
      Then user verifies the status code is 404
      And the Content type is verified as "application/json"
      Examples:
        | endPoint | username |
        | usrs     | Delphine |
        | psts     | Delphine |
        | cmments  | Delphine |

  Scenario Outline:  Search for the wrong posts written by the user
    Given user sets the "<endPoint>"
    When user makes a search for the posts written by "<id>"
    Then the status code is verified as 200
    And the Content type is verified as "application/json"
    Then user verifies that is wrong "<title>"
    Examples:
      | endPoint | id | title                                              |
      | posts    | 9  | eum et est occaecati |