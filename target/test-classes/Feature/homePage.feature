@Functionality
Feature: Test HomePage Functionality
# Please set correct username and password at line 7 and 8
  Background:
    Given Web Browser is open
    And User opens the url "family.qustodio.com/parents-app"
    And User set "navaleshweta@ymail.com" to the inputfield "username"
    And User set "qstudio22" to the inputfield "password"
    And User click on the element ".Login__button--container button"

  Scenario: Check Menu Options
    Given there is an element ".Header" on the page
    And User waits on element ".Header__title" for 10000ms to be visible
    And User expect that element ".Header__title" matches the text "Your Family"
    When User click on the element "#root > div > div > div > div.DesktopLayout__content-container > div.DesktopLayout__sidebar > div > div > ul > li:nth-child(2)"
    Then User expect that element "#root > div > div > div > div.DesktopLayout__content-container > div.DesktopLayout__content > div > div.Header__wrapper > div > div.Header__title" matches the text "Your devices"
    And User click on the element "#root > div > div > div > div.DesktopLayout__content-container > div.DesktopLayout__sidebar > div > div > ul > li:nth-child(3)"
    And User expect that element "#root > div > div > div > div.DesktopLayout__content-container > div.DesktopLayout__content > div > div.Header__wrapper > div > div.Header__title" matches the text "Your account"

  Scenario: Logout
    Given there is an element ".Header" on the page
    And User waits on element ".Header__title" for 10000ms to be visible
    When User click on the element "#root > div > div > div > div.DesktopLayout__content-container > div.DesktopLayout__sidebar > div > div > ul > li:nth-child(5)"
    Then User expect that element ".Login__header" matches the text "Welcome to Qustodio"

