package com.zipcodewilmington.streams.conversions;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 */
public final class ArrayConverter extends PersonConversionAgent<Person[]> {
    public ArrayConverter(Person... people) {
        super(people);
    }

    public ArrayConverter(int collectionSize) {
        this(Stream
                .generate(new PersonFactory()::createRandomPerson)
                .limit(collectionSize)
                .toArray(Person[]::new));
    }

    //TODO
    public List<Person> toList() {
        List<Person> p = Arrays
                .stream(objectSequence)
                .collect(Collectors.toList());
        return p;
    }

    //TODO
    public Stream<Person> toStream() {
        Stream<Person> p = Arrays
                .stream(objectSequence);
        return p;
    }

    @Override
    public Person[] toArray() {
        return super.objectSequence;
    }
}
