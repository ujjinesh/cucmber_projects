

Feature: Yahoo user registration

  Scenario: Check the user should be registered by filling all the required fields.
    Given launch application
    When Enter all Required Fields 
    And Click on the Continue button
    Then I Navigate the Yahoo Secure your account page.
    When I Enter the In-Valid Mobile Number Click On Send code button
    Then  I see the Error message
    When I clear textbox and enter valid Mobile Number and click on send code
    Then i see the Verify your mobile number Page
    And I Navigate the Yahoo account Registration Page
    When I click Terms Link
    Then I see the Yahoo Terms of Service page 
    And I Navigate the Yahoo account Registration Page
    And I switch the Yahoo account Registration Page
  
