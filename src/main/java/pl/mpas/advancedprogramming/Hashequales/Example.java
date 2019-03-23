package pl.mpas.advancedprogramming.Hashequales;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Example {

    public static void main(String[] args) {


    Person me = new Person("Maciej", "O");
    Person me2 = new Person("Maciej", "O");
    Person me3 = new Person("Maciej", "O");

    HashSet<Person> persons = new HashSet<>();
    persons.add(me);
    persons.add(me2);
    persons.add(me3);


         // equale porównuje
        // po co są hasCode
        // uniklny
        // == czy te same refenrecje wsakują na ten sam obiekt w pamięci

        System.out.println("me.equals(me2)= " + me.equals(me2));
        System.out.println("me.equals(me3)= " + me.equals(me3));
        System.out.println("person.siz = " + persons.size());

        // te w komentarzach tworza komarator dla osoby czyli sortują po inieminiu a potem po nazwisku
        //Comparator.comparing(Person::getName).thenComparing(Person::getSurname);

        Set<Person> sorttedSet = new TreeSet<>(Comparator.comparing(Person::getName).thenComparing(Person::getSurname));
        sorttedSet.add(me);
        sorttedSet.add(me2);
        sorttedSet.add(new Person("Olek", "W" ));

            for (Person p: sorttedSet) {
                System.out.println( "Person" + p );
        }

    }
}
