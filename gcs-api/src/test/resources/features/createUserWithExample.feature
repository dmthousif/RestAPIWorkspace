Feature: user creation

  Scenario Outline: verify user created successfully using examples
    When user makes post call
    Then verify service response code <statusCode>

    Examples:
      | JsonPath | job                               | statusCode |
      | name     | Thousif                           | 201        |
      | Job      | Software Test Automation Engineer | 201        |

