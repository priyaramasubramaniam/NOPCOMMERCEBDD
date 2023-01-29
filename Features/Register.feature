Feature: User Registration
  Scenario: Register user with all fields
    Given User launches chrome browser
    When User enters URL "https://demo.nopcommerce.com/"
    Then User clicks on Register link
    And User enters following details
    | Gender | Firstname | Lastname | Day | Month | Year | Email | Company name | Password | Confirm Password |
    | Female | Priya | SP | 05 | November | 1994 | priya@gmail.com | Priya construction | 123456 | 123456 |
    And User Clicks on Submit button
    Then User should verify the message "Your registration completed"
    Then User closes the browser

  Scenario: Register user with Mandatory fields
    Given User launches chrome browser
    When User enters URL "https://demo.nopcommerce.com/"
    Then User clicks on Register link
    And User enters following mandatory details
      | Firstname | Lastname | Email | Password | Confirm Password |
      | Priya | SP | priya@gmail.com | 123456 | 123456 |
    And User Clicks on Submit button
    Then User should verify the message "Your registration completed"
    Then User closes the browser

  Scenario : Register user without entering into mandatory fields
    Given User launches chrome browser
    When User enters URL "https://demo.nopcommerce.com/"
    Then User clicks on Register link
    And User Clicks on Submit button
    Then User should verify the following messages
      | First name is required. |
      | Last name is required.  |
      | Email is required.      |
      | Password is required.   |
    Then User closes the browser



