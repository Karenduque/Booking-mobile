@Android @MediaCenter
Feature: Search
  The purpose of this feature is to cover all the possible scenarios related to the search without Login.

  Scenario Outline: 01. Book a hotel in  "<destinationName>" from the date "<initialDate>" until  "<finalDate>" with rooms  and guests  "<rooms>" , "<adults>" , "<children>"
    Given I am an user searching with the characteristics "<destinationName>", "<initialDate>", "<finalDate>", "<rooms>", "<adults>", "<children>"
    When I click on Search
    Then the results are showed
    And I can to do the book
    And I choose the options: hotel and room
    Then I can see the fill in your information page
    And I fill my booking details
    And I verify the booking details
    And select last step
    Then the book is successfully


    Examples:
      | destinationName |  initialDate |  finalDate |  rooms  | adults | children |
      |Cuzco            |mar, 14 feb   |mar, 28 feb |1        |2       |1         |
      |Cali             |mar, 14 feb   |mar, 28 feb |1        |3       |1         |

