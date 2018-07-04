package ru.stqa.pft.addressbook.model;

public class NewContactData {
  private final String firstName;
  private final String lastName;
  private final String homeTelephoneNumber;
  private final String email;
  private String group;

  public NewContactData(String firstName, String lastName, String homeTelephoneNumber, String email,String group) {
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

  public String getGroup() {
    return group;
  }
}
