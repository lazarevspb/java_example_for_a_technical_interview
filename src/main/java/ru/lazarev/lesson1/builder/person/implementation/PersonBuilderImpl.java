package ru.lazarev.lesson1.builder.person.implementation;

import ru.lazarev.lesson1.builder.person.Person;
import ru.lazarev.lesson1.builder.person.PersonBuilder;
import ru.lazarev.lesson1.builder.person.genderType.Gender;

public class PersonBuilderImpl implements PersonBuilder {

  private String middleName;
  private String firstName;
  private String lastName;
  private String country;
  private String address;
  private String phone;
  private Gender gender;
  private int age;


  public Person getResult() {
    return new Person(middleName, firstName, lastName, country, address, phone, gender, age);
  }


  @Override
  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  @Override
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Override
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public void setGender(Gender gender) {
    this.gender = gender;
  }

  @Override
  public void setAge(int age) {
    this.age = age;
  }
}
