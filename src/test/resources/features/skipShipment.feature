Feature: Skip shipment scenario for Idexx IOO application

  Scenario: Skip Shipment scenario

    Given Navigate to Idexx Login page
    When Enter username and password
    And Click on submit button
    Then Verify ReOrder Option button
    When Hover on ReOrder Option button
    And Click on Schedule Orders link
    When Click on new Schedule Orders Button
    And Click on Skip Shipment link
    Then Verify skip shipment dialog box
    And Click on OK button
    Then Verify date before and date after