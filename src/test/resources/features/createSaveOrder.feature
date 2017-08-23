Feature: Create Save order scenario for Idexx IOO application

  Scenario: Create a simple create Save order scenario
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