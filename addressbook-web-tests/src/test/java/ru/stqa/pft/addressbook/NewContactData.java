package ru.stqa.pft.addressbook;

public class NewContactData {
  private final String firstName;
  private final String lastName;
  private final String homeTelephoneNumber;
  private final String email;

  public NewContactData(String firstName, String lastName, String homeTelephoneNumber, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.homeTelephoneNumber = homeTelephoneNumber;
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getHomeTelephoneNumber() {
    return homeTelephoneNumber;
  }

  public String getEmail() {
    return email;
  }
}
