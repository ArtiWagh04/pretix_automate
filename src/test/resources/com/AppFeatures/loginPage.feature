Feature: login page feature

Scenario:
Given user is on login page
When user gets the title of the page 
Then page title should be "pretix.eu"

Scenario:
Given user is on login page
Then forgot your password link should be displayed 

Scenario:login with correct credentials
Given user is on login page
When user enters username "artiwagh06@gmail.com"
And user enters password "Artipretix@2026"
When user clicks on login button
Then user gets the title of the page
And page title should be "Dashboard pretix.eu"