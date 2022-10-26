Feature: Make a search for the posts

  Scenario Outline:  Search for the posts written by the user
    Given user sets the "<endPoint>"
    When user makes a search for the posts written by "<id>"
    Then the status code is verified as 200
    And the Content type is verified as "application/json"
    Then user verifies the "<title>"
    Examples:
      | endPoint | id | title                                              |
      | posts    | 9  | nesciunt iure omnis dolorem tempora et accusantium |