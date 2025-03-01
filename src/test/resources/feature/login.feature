Feature: User Access to the HRMS application

 Background:
    ##Given user ability to access the HRMS application

   @common @Grp1
  Scenario: Valid User Login
    ##Given user ability to access the HRMS application
    When user enters a valid username and password
    And user clicks on the login button
    Then user should be able to access the application


     @common @Grp2
    Scenario: Invalid User Login
      When user enters an invalid username and password
      And user clicks on the login button
      Then user gets an error message "Invalid credentials"
