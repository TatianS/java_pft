package ru.stqa.pft.addressbook.model;

import java.util.Objects;

  public class NewContactData {
  private int id = Integer.MAX_VALUE;
  private String firstName;
  private String lastName;
  private String homeTelephoneNumber;
  private String email;
  private String group;

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

  public NewContactData withId(int id) {
    this.id = id;
    return this;
    }

    public NewContactData withFirstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public NewContactData withLastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public NewContactData withHomeTelephoneNumber(String homeTelephoneNumber) {
      this.homeTelephoneNumber = homeTelephoneNumber;
      return this;
    }

    public NewContactData withEmail(String email) {
      this.email = email;
      return this;
    }

    public NewContactData withGroup(String group) {
      this.group = group;
      return this;
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
      return Objects.equals(firstName, that.firstName) &&
              Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
      return Objects.hash(firstName, lastName);
    }
  }
