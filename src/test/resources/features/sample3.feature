Feature: Create Order Scenario for IDEXX IOO for sample 3

  Scenario: Create Order scenario for US
    Given go to url
    | https://qaorder.idexx.com|
    When Enter credentials
      | https://qaorder.idexx.com|
    And Click on submit button
      | https://qaorder.idexx.com|

    When Click on Order Now Button
      | https://qaorder.idexx.com|
    Then Verify Product Search field
    When Enter 3 Product
      | https://qaorder.idexx.com|
      |99-0001174|
      | VetTest General Health Profile (2)|
      | VetTest General Health Profile (2)|

    Then Verify next Button
      | https://qaorder.idexx.com|
    When Click on Next button
      | https://qaorder.idexx.com|
    Then Verify Submit order Button
      | https://qaorder.idexx.com|
    When Click on Submit order button
      | https://qaorder.idexx.com|


  Scenario:  Create Order scenario for France

    Given go to url
    | https://qacommande.idexx.fr|
    When Enter credentials
    | https://qacommande.idexx.fr|
    And Click on submit button
    | https://qacommande.idexx.fr|
    Then Verify the following button
    | https://qacommande.idexx.fr|
    When Click on the following button
      | https://qacommande.idexx.fr|
    When Verify the New Order Link
      | https://qacommande.idexx.fr|
    When Click on the New Order Link
      | https://qacommande.idexx.fr|

    When Enter 3 Product
      | https://qacommande.idexx.fr|
      | 99-0001174|
      | 98-24000-US|
      | 99-0001174|
  Then Verify next Button
    | https://qacommande.idexx.fr|
  When Click on Next button
    | https://qacommande.idexx.fr|
  Then Verify Submit order Button
    | https://qacommande.idexx.fr|
    And Check the submit order checkbox
      | https://qacommande.idexx.fr|
  When Click on Submit order button
    | https://qacommande.idexx.fr|

