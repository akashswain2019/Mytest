Feature: Test the landing page of ANZ

Scenario: The user should be able to launch the landing page
Given The user is viewing landing page
When User enters 1 for living expenses and click on the work out how much i could borrow button
Then User validates the text
Then User enters values for other expenses and validate the values persists
Then User close the web driver instance