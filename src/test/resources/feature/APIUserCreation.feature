Feature: API Testing



Background:
  Given a request token is generated

  @validAPI
  Scenario: API User Creation
   Given a request token is generated
    When a request payload is prepared for user creation
    When a Post call is made against the request
    Then status code 201 is expected to be returned
    And the response "Message" returned is "User Created"


  @existingEmail @invalid
  Scenario: User Creation with an existing email address
    When a request payload is prepared for user creation using an existing email address
    When a Post call is made against the request
    Then status code 200 is expected to be returned
    And an error response "Message" returned is "The email address you have entered is already registered"


  @invalidEmailFormat @invalid
  Scenario: User Creation using an invalid email format
    When a request payload is prepared for user creation using an invalid email format
    When a Post call is made against the request
    Then status code 400 is expected to be returned
    And an error response "data" returned is "Invalid Email"

  @emptyPasswordField @invalid
  Scenario: User Creation using an empty password field
    When a request payload is prepared for user creation using an empty password field
    When a Post call is made against the request
    Then status code 400 is expected to be returned
    And an error response "data" returned is "Please fill all inputs"


  @emptyUsernameField @invalid
  Scenario: User Creation using an empty username
    When a request payload is prepared for user creation using an empty username field
    When a Post call is made against the request
    Then status code 400 is expected to be returned
    And an error response "data" returned is "Please fill all inputs"






