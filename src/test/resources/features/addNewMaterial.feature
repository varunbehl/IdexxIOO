Feature: Create add new material scenario for Idexx IOO application

  Scenario: Create add new material scenario

    Given Navigate to Idexx Login page
    When Enter username and password
    And Click on submit button
    Then Verify ReOrder Option button
    When Hover on ReOrder Option button
    And Click on Schedule Orders link
    When Click on new Schedule Orders Button
    When Click on Schedule Orders edit link
    And Enter second new product
    Then Verify second Product Search field
    When Click on second search Icon
    Then Verify Search result pop up
    When Click on Add to cart button
    Then Verify next Button
    When Click on Next button
    Then Verify Submit order Button
    When Click on Submit order button
    Then Verify schedule Order number
    Then Verify schedule Thank you text
    Then Verify schedule Thank you confirmation
