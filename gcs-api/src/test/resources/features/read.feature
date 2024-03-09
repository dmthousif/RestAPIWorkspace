Feature: User Authentication

  Background:
    Given the user is on the login page
    And the user has entered valid credentials

  Scenario: Successful login
    When the user submits the login form
    Then the user should be redirected to the dashboard

  Scenario Outline: Invalid login attempts
    When the user submits the login form with "<username>" and "<password>"
    Then the login should fail and an error message "<error_message>" should be displayed

    Examples:
      | username | password | error_message         |
      | user1    | pass123  | Incorrect credentials |
      | user2    | pass456  | Account locked        |


  Scenario: Parameterize login
    When User enters the following details:
      | Field        | Value          |
      | First Name   | John           |
      | Last Name    | Doe            |
      | Email        | john@example.com |
      | Password     | pass123        |

  @Before
  Scenario: Reset user data before login
    Given the user data is reset

  @After
  Scenario: Clean up after login
    Then clear user session
