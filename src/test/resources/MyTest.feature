Feature: My First Cucumber feature

  Scenario: User can login with correct username/password
    Given user navigates to 'https://www.google.com'
    Then user sees page title 'Google'

    Given user navigates to 'https://www.lu.lv'
    Then user sees page title 'Latvijas Universitāte'

