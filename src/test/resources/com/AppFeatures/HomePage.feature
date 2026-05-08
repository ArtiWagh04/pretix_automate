Feature: Home page feature

Background: 
Given user is already logged in to application
|username|password|
|artiwagh06@gmail.com|Artipretix@2026|

Scenario: check create a new event option
Given user is on home page
Then option title should be "Create a new event"

Scenario: check menu options
Given user is on home page
Then menu options should be
|Dashboard|
|Events|
|Organizers|
|Search|
|User settings|
|Reports|
|Shipping list|
And home page menu options count should be 7
