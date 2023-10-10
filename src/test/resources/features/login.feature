Feature: New Customer login/registration.
  Scenario: Existing customer validation
    Given customer already have an account
    When data is entered
    Then login should happen

