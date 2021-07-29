package ru.lazarev.lesson1.builder.person;

import ru.lazarev.lesson1.builder.person.genderType.Gender;

public class Builder {

  public void buildPerson(PersonBuilder personBuilder) {
    personBuilder.setMiddleName("Middle Name");
    personBuilder.setFirstName("First Name");
    personBuilder.setLastName("Last Name");
    personBuilder.setCountry("Person Country");
    personBuilder.setAddress("Person address");
    personBuilder.setGender(Gender.MALE);
    personBuilder.setPhone("555-55-55");
  }

  public void buildOtherPerson(PersonBuilder personBuilder) {
    personBuilder.setMiddleName("Middle Other Name");
    personBuilder.setFirstName("First Other Name");
    personBuilder.setLastName("Last Other Name");
    personBuilder.setCountry("Person Other Country");
    personBuilder.setAddress("Person Other address");
    personBuilder.setGender(Gender.FEMALE);
    personBuilder.setPhone("2-12-85-06");
  }

}
