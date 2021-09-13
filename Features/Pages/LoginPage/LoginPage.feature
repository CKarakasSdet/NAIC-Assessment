Feature: Login

    Scenario: login with invalid credentials
        Given user launched the browser
        When user opens homepage
        And user enters email as "someemail@gmail.com" and password as "somepassword"
        And click on login
        Then page title should be "...."
        And user should see warning "Unable to login"