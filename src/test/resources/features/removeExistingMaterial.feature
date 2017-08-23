Feature: Remove Existing Material of order scenario for Idexx IOO application

  Scenario: Remove Existing Material of order scenario

    Given Navigate to Idexx Login page
    When Enter username and password
    And Click on submit button
    Then Verify ReOrder Option button
    When Hover on ReOrder Option button
    And Click on Schedule Orders link
    When Click on new Schedule Orders Button

    And Click on Schedule Orders edit link
    Then Verify second Product Search field
    When Enter second new product
    And Click on second search Icon
    Then Verify Search result pop up
    When Click on Add to cart button
    Then Verify next Button
    When Click on Next button
    Then Verify Submit order Button
    And Click on Submit order button
    When Hover on ReOrder Option button
    And Click on Schedule Orders link
    And Click on Schedule Orders edit link
    Then Verify Delete Icon
    And Click Delete Icon

    Then Verify next Button
    When Click on Next button
    Then Verify Submit order Button
    When Click on Submit order button




