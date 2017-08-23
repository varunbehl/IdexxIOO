Feature: Create Favorite order scenario for Idexx IOO application

  Scenario: Create Favorite order scenario

    Given Navigate to Idexx Login page
    When Enter username and password
    And Click on submit button
    Then Verify ReOrder Option button
    When Hover on ReOrder Option button
    And Click on favorite Orders link
    Then Verify Saved Order number
    And Click on new favorite Orders link
    Then Verify Fav order name field
    And Enter Favorite order
    Then Verify Product Search field
    When Enter Product Description
    Then Verify search Icon
    When Click on search icon
    Then Verify Search result pop up
    When Click on Add to cart button
    Then Verify save favorite button
    And Click on save favorite button
    Then Verify Favorite order confirmation
    Then Verify Favorite order text