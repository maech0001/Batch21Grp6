Feature: API Testing

Background:
  Given a request token is generated

  @validAPI
  Scenario: API User Creation
   Given a request token is generated
    When a request payload is prepared for user creation
    When a Post call is made against the request
    Then status code int is expected to be returned
    And the response message returned should be string


  @existingEmail @invalid
  Scenario: User Creation with an existing email address
    When a request payload is prepared for user creation using an existing email address
    When a Post call is made against the request
    Then status code int is expected to be returned
    And the response message returned should be string


  @invalidEmailFormat @invalid
  Scenario: User Creation using an invalid email format
    When a request payload is prepared for user creation using an invalid email format
    When a Post call is made against the request
    Then status code int is expected to be returned
    And the response message returned should be string

  @emptyPasswordField @invalid
  Scenario: User Creation using an empty password field
    When a request payload is prepared for user creation using an empty password field
    When a Post call is made against the request
    Then status code int is expected to be returned
    And the response message returned should be string


  @emptyUsernameField @invalid
  Scenario: User Creation using an empty username
    When a request payload is prepared for user creation using an empty username field
    When a Post call is made against the request
    Then status code int is expected to be returned
    And the response message returned should be string






