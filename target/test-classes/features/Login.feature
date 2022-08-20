Feature: Login into application

Scenario Outline: Positive test validationg login using chrome browser
Given Initialize the browser with chrome
And Navigate to the "http://qaclickacademy.com" site
And Click on Login link in home page to land on secure sing in page
When User enters <username> and <password> and logs in 
Then Verify that user is successfully logged in
And Close browsers

Examples:

|username 				 |password 		|
|test99@gmail.com		 |123456		|
|test11@gmail.com		 |111111		|
