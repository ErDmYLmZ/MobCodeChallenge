Feature: Various edge cases
  @SetUrl
  Scenario Outline: Invalid username
    Given user sets the "<endPoint>"
    When user searches for invalid "<invalidUsername>"
    Then user verifies the response body is empty

    Examples:
      | endPoint | invalidUsername |
      | users    | Delphin         |

  Scenario Outline: Invalid endPoints
      Given user sets the invalid "<invalidEndPoint>"
      When user searches for an "<id>"
      Then user verifies the status code is 404

      Examples:
        | invalidEndPoint | id |
        | usrs            | 9  |
        | psts            | 9  |
        | cmments         | 9  |

  Scenario Outline:  Search for the wrong posts written by the user
    Given user sets the "<endPoint>"
    When user makes a search for the posts written by "<id>"
#    Then the status code is verified as 200
#    And the Content type is verified as "application/json; charset=utf-8"
    Then user verifies that is wrong "<title>"
    Examples:
      | endPoint | id | title                                              |
      | posts    | 9  | eum et est occaecati |