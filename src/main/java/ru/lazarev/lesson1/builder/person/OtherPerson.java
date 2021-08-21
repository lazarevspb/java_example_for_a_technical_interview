package ru.lazarev.lesson1.builder.person;

import ru.lazarev.lesson1.builder.person.genderType.Gender;

public class OtherPerson {

  private final String middleName;
  private final String firstName;
  private final String lastName;
  private final String country;
  private final String address;
  private final String phone;
  private final Gender gender;
  private final int age;

  public OtherPerson(String middleName, String firstName, String lastName, String country,
      String address, String phone, Gender gender, int age) {
    this.middleName = middleName;
    this.firstName = firstName;
    this.lastName = lastName;
    this.country = country;
    this.address = address;
    this.phone = phone;
    this.gender = gender;
    this.age = age;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getCountry() {
    return country;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }

  public Gender getGender() {
    return gender;
  }

  public int getAge() {
    return age;
  }
}
