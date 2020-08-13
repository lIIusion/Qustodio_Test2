@Functionality
Feature: Test Login Functionality

  Background:
    Given Web Browser is open
    And User opens the url "family.qustodio.com/parents-app"


  Scenario: Load login page and verify recover password link
    Given User waits on element ".Login__logo" for 10000ms to be visible
    And User expect that element "login" does exist on the page
    When User click on the element ".Login__passwordLink"
    And User waits on element ".c-btn c-btn--block c-btn--brand js-form-button" for 10000ms to be visible
    Then User expect that element ".c-btn c-btn--block c-btn--brand js-form-button" matches the text "Recover password"

#    Please enter correct username and password
  Scenario: Login with a valid user
    Given User expect that element "login" does exist on the page
    And User set "navaleshweta@ymail.com" to the inputfield "username"
    And User set "qstudio22" to the inputfield "password"
    When User click on the element ".Login__button--container button"
    And User waits on element ".Header__title" for 10000ms to be visible
    Then User expect that element ".Header__title" matches the text "Your Family"

  Scenario Outline: Login is <Successful/Unsuccessful> with <Valid/Invalid_ID> & <Valid/Invalid_Password>
    Given User set "<Username>" to the inputfield "username"
    And User set "<Password>" to the inputfield "password"
    When User click on the element ".Login__button--container button"
    Then User is  able to login "<Successfully/Unsuccessfully>"
    And User waits on element "<title>" for 10000ms to be visible
    And User expect that element "<title>" matches the text "<text>"

    Examples:
      |Successfully/Unsuccessfully |Username               |Password |Valid/Invalid_ID|Valid/Invalid_Password|   title         |    text              |
      |Successfully                |navaleshweta@ymail.com |qstudio22|Valid_Username  |Valid_Password        | .Header__title  |     Your Family      |
      |Unsuccessfully              |      invalid          | invalid |Invalid_Username|Invalid_Password      | .Login__header  | Welcome to Qustodio  |
      |Unsuccessfully              |        valid          |qstudio22|Invalid_Username|valid_Password        | .Login__header  | Welcome to Qustodio  |
      |Unsuccessfully              |softwareqaeng@gmail.com| invalid |Valid_Username  |Invalid_Password      | .Login__header  | Welcome to Qustodio  |
      |Unsuccessfully              |                       |         |   Empty        |   Empty              | .Login__header  | Welcome to Qustodio  |

  Scenario Outline: Login screen has username, password & Login fields present
    When User waits on element ".Login__logo" for 10000ms to be visible
    Then User has "<field>" visible

    Examples:
      |  field       |
      |  username    |
      |   password   |

  Scenario: Login screen has Login button present
    When User waits on element ".Login__logo" for 10000ms to be visible
    Then User expect that element "login" does exist on the page

