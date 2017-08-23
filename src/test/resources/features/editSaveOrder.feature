Feature: Edit save order scenario for Idexx IOO application

  Scenario: Edit save order scenario
    Given Navigate to Idexx Login page
    When Enter username and password
    And Click on submit button
    When Click on Order Now Button
    Then Verify Product Search field
    When Enter Product Description
    Then Verify Product Search field
    And Click on search icon
    Then Verify Search result pop up
    And Click on Add to cart button
    Then Verify the Save for Later button
    When Click on Save For Later button
    Then Verify Order Name Dialogue Box
    When Enter Order Name
    When Click on OK button
    Then Verify My orders button
    When Hover on My Orders button
    When Click on Saved Orders link
    Then Verify Saved Order number
    When Click on Saved Orders edit link
    Then Verify View Saved Order text
    And Click on Edit button
    Then Verify Edit Saved Order text
    Then Verify qty field
    When Save Order Quantity
    Then Verify Save Button
    When Click on Save button
    Then Verify Saved Order - Confirmation text
    Then Verify Quantity field edited
    When Click on Close button