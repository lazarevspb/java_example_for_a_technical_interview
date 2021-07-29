package ru.lazarev.lesson1.builder.person;

import ru.lazarev.lesson1.builder.person.genderType.Gender;

public interface PersonBuilder {

  public void setMiddleName(String middleName) ;
  public void setFirstName(String firstName);
  public void setLastName(String lastName);
  public void setCountry(String country);
  public void setAddress(String address);
  public void setGender(Gender gender);
  public void setPhone(String phone);
  public void setAge(int age);
}
