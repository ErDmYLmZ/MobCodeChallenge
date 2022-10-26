Feature: Make a search for the posts
@Url
  Scenario Outline:  Search for the posts written by the user
    Given user sets the "<endPoint>"
    When user makes a search for the posts written by "<id>"
    Then user verifies the "<title>"
    Examples:
      | endPoint | id | title                                              |
      | posts    | 9  | nesciunt iure omnis dolorem tempora et accusantium |