Feature: Test Wikipedia
  @Test_1
  Scenario: Test login with valid credentials
    Given Allocate to log in page
    When Entering credentials
    Then User should be able to log in successfully
  @Test_2
  Scenario: Test search functionality
    Given I enter term in search
    Then User should get the page with term searched
  @Test_3
    Scenario: Change visual appearance of wikipedia
      Given Log in as user
      And Get to appearance
      When User clicks on new skin
      Then User should see UI changes
    @Test_4
    Scenario: Check if download as pdf works
      Given Log in
      And Gets to download button
      When User clicks on download button
      Then pdf can be downloaded
      @Test_5
      Scenario: Create book
        Given Log in wiki
        And Create a book and start book creator
        And Search for keyword, add to book and show book
        When Set title, subtitle, click create chapter and set  chapter name
        Then Chapter is created successfully

