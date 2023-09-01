
@tag
Feature: Validating the Error message
  I want to use this template for my feature file


  @tag2
  Scenario Outline: Title of your scenario outline
    Given landed on Ecommerce Page
    When  Logged in with username <username> and password <password>
    Then "Incorrect email or password." message displayed

   Examples: 
      | username                   |   password        |     
      | rahulshetty@gmail.com      |    Rakshan@2018   |    
      |                            |                   | 