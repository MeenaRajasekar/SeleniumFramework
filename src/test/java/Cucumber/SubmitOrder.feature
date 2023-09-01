
@tag
Feature: purchase the order om Ecommerce Website
  I want to use this template for my feature file

Background:
Given landed on Ecommerce Page


  @tag2
  Scenario Outline: Positive test of submitting order
    Given Logged in with username <username> and password <password>
    When I add product <productName> to the cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | username                   |   password        |      productName
      | rahulshetty@gmail.com      |    Rakshan@2018   |     ZARA COAT 3
      |                            |                   | 
