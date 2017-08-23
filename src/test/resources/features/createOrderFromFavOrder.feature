Feature: Create order from Favorite order scenario for Idexx IOO application

  Scenario: Create order from Favorite order scenario
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
    Then Verify Home Button
    When Click on Home button
    Then Verify Order Now Button
    When Click on Order Now Button
    When Click on View Order Button
    Then Verify Purchase Order Number field
    When Enter Purchase Order No order
    And Click on Add to Favorite Order button
    And Enter Order Name
    And Click on OK button
    Then Verify ReOrder Option button
    When Hover on ReOrder Option button
    When Click on favorite Orders link
    Then Verify Order Now Link
    And Click on Order Now link
    Then Verify next Button
    When Click on Next button
    Then Verify Submit order Button
    When Click on Submit order button

