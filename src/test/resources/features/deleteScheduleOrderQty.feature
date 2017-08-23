Feature: Delete Schedule order Quantity scenario for Idexx IOO application

  Scenario: Delete Schedule order Quantity scenario

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
    Then Verify Delete schedule order Button
    When Click on Delete schedule order Button
    And Click on OK button
