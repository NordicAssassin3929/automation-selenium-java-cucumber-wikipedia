Feature: Test Wikipedia
  @Test_1
  Scenario: Test login with valid credentials
    Given Open firefox, and locate to log in page
    When I enter valid username and valid password
    Then User should be able to log in successfully
  @Test_2
  Scenario: Test search functionality
    Given Open firefox before searching functionality
    When I enter term in search
    Then User should get the page with term searched
  @Test_3
    Scenario: Change visual appearance of wikipedia
      Given Open firefox before changing visual appearance
      And Log in as user
      And Get to appearance
      When User clicks on new skin
      Then User should see UI changes
    @Test_4
    Scenario: Check if download as pdf works
      Given Open firefox before coming to download
      And Gets to download button
      When User clicks on download button
      Then pdf can be downloaded
      @Test_5
      Scenario: Create book
        Given Open firefox, and login
        And Create a book and start book creator
        And Search for keyword, add to book and show book
        When Set title, subtitle, click create chapter and set  chapter name
        Then Chapter is created successfully

