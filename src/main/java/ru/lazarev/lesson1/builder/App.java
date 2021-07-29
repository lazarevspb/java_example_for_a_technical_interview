package ru.lazarev.lesson1.builder;

import ru.lazarev.lesson1.builder.person.Builder;
import ru.lazarev.lesson1.builder.person.OtherPerson;
import ru.lazarev.lesson1.builder.person.Person;
import ru.lazarev.lesson1.builder.person.implementation.OtherPersonBuilderImpl;
import ru.lazarev.lesson1.builder.person.implementation.PersonBuilderImpl;

public class App {

  public static void main(String[] args) {
    Builder builder = new Builder();

    PersonBuilderImpl personBuilder = new PersonBuilderImpl();
    builder.buildPerson(personBuilder);
    Person person = personBuilder.getResult();

    OtherPersonBuilderImpl otherPersonBuilder = new OtherPersonBuilderImpl();
    builder.buildOtherPerson (otherPersonBuilder);
    OtherPerson otherPerson = otherPersonBuilder.getResult();
  }
}
