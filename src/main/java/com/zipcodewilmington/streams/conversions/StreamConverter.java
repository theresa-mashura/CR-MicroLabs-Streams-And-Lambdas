package com.zipcodewilmington.streams.conversions;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 */
public final class StreamConverter extends PersonConversionAgent<Stream<Person>> {
    private final List<Person> personList;
    public StreamConverter(Stream<Person> people) {
        super(people);
        this.personList = super.objectSequence.collect(Collectors.toList());
    }

    public StreamConverter(int collectionSize) {
        this(Stream
                .generate(new PersonFactory()::createRandomPerson)
                .limit(collectionSize));
    }

    // TODO
    public List<Person> toList() {
        List<Person> p = personList;
        return p;
    }

    // TODO
    public Stream<Person> toStream() {
        Stream<Person> p = personList.stream();
        return p;
    }

    // TODO
    public Person[] toArray() {
        Person[] p = personList
                .stream()
                .toArray(Person[]::new);
        return p;
    }
}
