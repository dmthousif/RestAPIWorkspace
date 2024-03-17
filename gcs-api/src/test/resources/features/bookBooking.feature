Feature: book a hotel

  Scenario Outline: verify user is able to book hotel successfully - ReadJSONfromPathDDT
    When Create the Json from the file <fileName>
    And Override the field <fieldName> with value <value>
    When user makes post call
    Then verify service response <responseCode>
    Then verify service response body <responseBody>

    Examples:
      | fileName         | fieldName  | value | responseCode | responseBody             |
      | bookBooking.json | totalprice | 777   | 200          | bookBookingResponse.json |
      | bookBooking.json | totalprice | test  | 400          | bookBookingResponse.json |
      | bookBooking.json | totalprice |       | 400          | bookBookingResponse.json |


  Scenario Outline: verify user is able to book hotel successfully - CreateJSONusingPOJO
    When Create the Json using Pojo
    And Override the field <fieldName> with value <value>
    When user makes post call
    Then verify service response <responseCode>
    Then verify service response body <responseBody>

    Examples:
      | fieldName  | value | responseCode | responseBody             |
      | totalprice | 777   | 200          | bookBookingResponse.json |
      | totalprice | test  | 400          | bookBookingResponse.json |
      | totalprice |       | 400          | bookBookingResponse.json |
