@logintest
Feature: Verify the login functionality of the Rosemount Tank Master application

  Background:
    Given the Rosemount Tank Master application is running
    And the user is on the login page

  Scenario: Successful login with valid credentials
   When the user enters a valid username and password
   When clicks the login button
   Then the user should be redirected to the overview page


  