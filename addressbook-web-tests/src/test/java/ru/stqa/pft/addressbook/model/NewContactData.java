package ru.stqa.pft.addressbook.model;

import java.util.Objects;

  public class NewContactData {
  private int id;
  private final String firstName;
  private final String lastName;
  private final String homeTelephoneNumber;
  private final String email;
  private String group;

  public NewContactData(int id, String firstName, String lastName, String homeTelephoneNumber, String email, String group) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.homeTelephoneNumber = homeTelephoneNumber;
    this.email = email;
  }

    public NewContactData(String firstName, String lastName, String homeTelephoneNumber, String email, String group) {
      this.id = 0;
      this.firstName = firstName;
      this.lastName = lastName;
      this.homeTelephoneNumber = homeTelephoneNumber;
      this.email = email;
    }

  public int getId() {
    return id;
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

    public void setId(int id) {
      this.id = id;
    }

    @Override
  public String toString() {
    return "NewContactData{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    NewContactData that = (NewContactData) o;
    return  Objects.equals(id, that.id) &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName);
  }
}
