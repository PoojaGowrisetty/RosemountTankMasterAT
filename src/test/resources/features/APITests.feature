@apitests
Feature: Verify the overview page response API

  Scenario: Verify API returns tank details for a valid tank ID
    Given the TankMaster API endpoint is "https://tankmastermobiledemo.rosemount.com/"
    When I send a GET request to the TankMaster API
    Then the response status code should be 403 
    
    ##Authentication  Error
 