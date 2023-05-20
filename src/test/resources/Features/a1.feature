Feature: Validate OrangeHRM Functionality

  Scenario: Validate user creation functionality
    Given User is on OrangeHRM login page
    When User enters username and password
      | username | password |
      | Admin    | admin123 |
    And User clicks on the login button
    Then User should able to login and navigate to the landing page
    When User clicks on add user's button under admin tab
    And User create new user with given data
      | User Role | Employee Name   | status  | username | password  | confPassword |
      | ESS       | Chenzira  Chuki | Enabled | abbbbbbb | abcdabcd1 | abcdabcd1    |
    Then Verify that created user with given username is present in the page
      | UserName |
      | abbbbbbb |
    When User delete the above created user
      | Username |
      | abbbbbbb |
    Then Verify that user should able to delete the user entry
      | username |
      | abbbbbbb |