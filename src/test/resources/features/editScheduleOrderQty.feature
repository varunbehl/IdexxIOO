Feature: Edit Schedule order Quantity scenario for Idexx IOO application

  Scenario: Edit Schedule order Quantity

    Given Navigate to Idexx Login page
    When Enter username and password
    And Click on submit button
    Then Verify ReOrder Option button
    When Hover on ReOrder Option button
    And Click on Schedule Orders link
    When Click on new Schedule Orders Button
    And Click on Schedule Orders edit link
    Then Verify qty field
    When Enter qty value
    Then Verify next Button
  When Click on Next button
  Then Verify second Submit order button
  And Click on second Submit order button