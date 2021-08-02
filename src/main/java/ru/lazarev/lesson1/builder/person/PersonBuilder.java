package ru.lazarev.lesson1.builder.person;

import ru.lazarev.lesson1.builder.person.genderType.Gender;

public interface PersonBuilder {

  void setMiddleName(String middleName);

  void setFirstName(String firstName);

  void setLastName(String lastName);

  void setCountry(String country);

  void setAddress(String address);

  void setGender(Gender gender);

  void setPhone(String phone);

  void setAge(int age);
}
