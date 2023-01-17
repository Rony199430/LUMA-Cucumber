

Feature: LUMA checkout 
I want to buy a yoga pant from LUMA website


  Scenario: Placing an order for blue yoga pant
    Given I open the browser 
    And I navigate to LUMA website
    When I search Yoga Pants
    And I add Product from listing 
    And I go to checkout 
    And I put my details
    Then  I confirm placing the order 


  
