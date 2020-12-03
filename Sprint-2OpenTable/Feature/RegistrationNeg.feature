
Feature: Registration unsuccessful
  
  Scenario Outline: Unsuccessful creation of Registration
    Given User is in Home page
    When User clicks on Sign up button
    And User enters invalid first name <firstname>
    And User enters invalid last name <lastname>
    And User enters invalid email <email>
    And User enters invalid password <password>
    And User enters invalid Confirm password <confirmpassword>
    And User enters invalid primary dining location <pdl>
    And User check the checkboxes 
    And User click on Create Account button
    Then Registration is unsuccessful
    
    Examples: 
      | firstname  | lastname | email  | password  | confirmpassword  | pdl  |
      |            |          | medhasv@gmail.com | abcd@321 | abcd@321 | Queensland |
     	|    Medha    | abc      | medhasv@gmail | abcd@321 | abcd@321 | Queensland |
     	|    Medha    | abc      | medhasv@gmail.com | abcd | abccd | Queensland |
     	|    Medha   | abc     | medhasv@gmail.com | abcd@321 | abcd@321 |   |
     