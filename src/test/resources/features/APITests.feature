@apitests
Feature: Verify the response of Rosemount TankMaster Demo WebApplication 

  Scenario: Verify the response of TankMaster API
    Given the TankMaster API endpoint is "https://tankmastermobiledemo.rosemount.com/"
    When I send a GET request to the TankMaster API
    Then the response status code should be 403 
    
    ##Authentication  Error
 