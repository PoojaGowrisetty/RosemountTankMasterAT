
Feature: Verify functionalities in OverviewPage 

Background: 
 Given  User is SignedIn to RosemountTankMaster Page
      
    # the number and tab can be modified according to the page
    Scenario: Verify OverviewPage Tab contains all sections
        Given I am on the OverviewPage
        When I click on the "Overview" tab  
        Then I should see the 5 header tabs 
        Then I verify the alltanks are displayed
        Then I verify number of tanks are 20 
    
    Scenario: Verify user can navigate to all the tabs from Overview tab
            When I click on the "Movement" tab  
            Then I should navigate to movement page
            When I click on the "Watchlist" tab
            Then I should navigate to watchlist page
            When I click on the "Inventory" tab
            Then I should navigate to inventory page
            When I click on the "Reports" tab
            Then I should navigate to report page
      
    Scenario: Verify count of movement tanks matches in all tanks and movement page
            When I click on the "Overview" tab 
            Then I verify the number of movement tanks in AllTanks tab
            When I click on the "Movement" tab
            Then I verify the number of tanks in movement page
         @overviewpage
	Scenario:  Verify Tanks can be added to Watchlist   
	       Given I am on the OverviewPage
           When I click on the "Overview" tab
           When I click the star icon for "TK-110"
    	   When I click on the "WatchList" tab    	  
   	 	   Then "TK-110" should appear in my watchlist 
   	 	   When I click on the "Overview" tab
           When I click the star icon for "TK-102"
    	   When I click on the "WatchList" tab    	  
   	 	   Then "TK-102" should appear in my watchlist    
  
   	 Scenario: Verify user can go to Tank details page and navigate in tankdetails page
   	         Given I am on the OverviewPage
   	 		 When I click on the "Overview" tab
      		 When I click the "TK-103" container
      		 Then I verify tank container is expanded with details
      		 Then I verify details link is displayed
      		 Then I verify Note link is displayed
      		 When I click on the Details button
      		 Then I should navigate to tankdetails page
      		 When I click on "Inventory" button in tankdetails page
      		 Then I verify "Inventory" details displayed
      		 When I click on "Level" button in tankdetails page
      		 Then I verify "Level" details displayed
      		 When I click on "TemperaturePressure" button in tankdetails page
      		 Then I verify "TemperaturePressure" details displayed
      		 When I click on "AlarmLimits" button in tankdetails page
      		 Then I verify "AlarmLimits" details displayed
      		 
      		 
      Scenario: Verify the functionality of note in Tanks 
      		 Given I am on the OverviewPage
   	 		 When I click on the "Overview" tab
      		 When I click the "TK-111" container
      		 Then I verify tank container is expanded with details
      		 Then I verify Note link is displayed
      		 When I click on the Note button
      		 When I type "Updating Note in Tank details" in the Note 
      		 When I click on the "save" button in Note
      		 Then I verify note icon is displayed 
      		 When I click on the Note button
      		# Then I verify "Updating Note in Tank details" is displayed in the Note
      		 When I click on the "clearNote" button in Note
      		 And  I click on the "save" button in Note
      		 When I click on the Note button
      		 Then I verify "" is displayed in the Note
      		 When  I click on the "cancel" button in Note
      		 
       		 	   
      
 
      		 
      		 
      		
   	     
   	        
	      
            
  
            
    

        
     