# selenium.saucelabs
Quickstart project to setup a selenium test using the power of Sauce Labs for Automated testing 


This project is a really great way for experimenting with Selenium and the Testing capabilities of Sauce Labs.

The test is extremely simple, the intent of the test is to hit any webpage and check the Title to make sure that the page loaded correctly.

To get started you will need an account with Sauce Labs.

After an account has been created you will need the username and api token key given by Sauce Labs for the client tunnel application needed to authenticate the test session.

This project assumes that you have the values available in your maven settings.xml file.

Ex.
In my properties section of my settings.xml I have:

	<sauce.client.repo.url>ARTIFACT-REPO-URL-PATH-TO-SAUCE-CLIENT-FOR-YOUR-OS</sauce.client.repo.url>
      
	<sauce.labs.user>USERNAME</sauce.labs.user>
	
	<sauce.labs.api.key>API-KEY</sauce.labs.api.key>
	
	<sauce.grid.url>https://USERNAME:API-KEY@ondemand.saucelabs.com:443/wd/hub/</sauce.grid.url>
      



After your settings.xml file has been setup running the test is as simple as running the maven command:
"mvn clean install -P $BROWSER -Dbase.url=URL -Dpage.title=EXPECTED-TITLE

Notice that 3 parameters are being passed into the maven process, the Profile, and 2 VM arguments

The profile will activate the test against a specific browser, possible values are listed below
Profile values:
ie
chrome
firefox
safari


Now to test a specific page a value needs to be passed into the VM using the property base.url, any webpage URL will work.
ex.    -Dbase.url=www.google.com

Now to validate the test we check the page title, we do this by passing in a page.title property.
ex.    -Dpage.title=Google

That's it, Happy Testing!!!
