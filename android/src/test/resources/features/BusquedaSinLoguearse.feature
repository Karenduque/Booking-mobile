@Android @MediaCenter
Feature: Search
  The purpose of this feature is to cover all the possible scenarios related to the search without Login.

  Scenario Outline: 01. Open the Stays "<destinationName>" from the date "<initialDate>" until  "<finalDate>" with rooms  and guests  "<rooms>" , "<adults>" , "<children>"
    Given I am an user searching with the characteristics "<destinationName>" "<initialDate>" "<finalDate>" <rooms>" "<adults>" "<children>"
    When I click on Search
    Then the results are showed

    Examples:
      | destinationName |  initialDate |  finalDate |  rooms  | adults | children |
      |Cuzco            |mar, 14 feb   |mar, 28 feb |1        |2       |1         |
      |Cali             |mar, 14 feb   |mar, 28 feb |1        |3       |1         |