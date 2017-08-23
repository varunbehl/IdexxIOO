Feature: Change Arrival Date scenario for Idexx IOO application

  Scenario: Change Arrival date of order scenario

    Given Navigate to Idexx Login page
    When Enter username and password
    And Click on submit button
    Then Verify ReOrder Option button
    When Hover on ReOrder Option button
    And Click on Schedule Orders link
    When Click on new Schedule Orders Button

   And Click on Schedule Orders edit link
   Then Verify Arrival day dropdown
   Then Verify next Button
   When Click on Next button
   Then Verify Submit order Button
   And Click on Submit order button