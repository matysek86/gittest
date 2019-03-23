package pl.mpas.advancedprogramming.Hashequales;

import java.util.Comparator;
import java.util.Objects;
//sortowanie z naturalnym porządkiem z porównaniem Person i Person

public class Person implements Comparable<Person> {
    String name;
    String surname;

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname);
    }

    // wszystkie kolekcje hasowalne są takie że w śordku znajdują się kubełki - has identyfikuje kubełek
    //każdy obiekt ma indywidualny haskod
    //inna osoba ma inny haskod
    //gdy zakomentujemy haskod to wstawia  do takiego samego kubełka
    //ale wtedy dodaje do teho samego kupełka
    //ale ponieważ ma to smao w kubełku to nie dodajemy tego do tego kubełka


    @Override
    public int hashCode() {
       return Objects.hash(name, surname);
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public int compareTo(Person o) {

        return name.compareTo(o.name);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
