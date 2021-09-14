Feature: Login

    Scenario: login with invalid credentials
        Given user launched the browser
        When user opens homepage
        And user navigates to login page
        And user enters email as "someemail@gmail.com" and password as "somepassword"
        And click on login
        Then user should see warning "Login failed, please try again."