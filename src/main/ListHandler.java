package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListHandler {
    private List<Person> list;
    private Person person;
    private long timeListStart;
    private long timeProcessStart;
    private long timeProcessEnd;
    private int elements;
    private boolean isArrayList;


    public ListHandler(int elements, boolean isArrayList) {
        this.elements = elements;
        if (isArrayList) {
            list = new ArrayList<>();
        } else {
            list = new LinkedList<>();
        }
        this.isArrayList = isArrayList;
    }

    private static int randomNumber(int max) {
        return (int) (Math.random() * ++max);
    }

    private static char randomChar() {
        int rand = new Random().nextInt(52);
        char start = (rand < 26) ? 'A' : 'a';
        return (char) (start + rand % 26);
    }

    private String listType() {
        if (isArrayList) {
            return "ArrayList";
        } else {
            return "LinkedList";
        }
    }

    public void add() {
        timeListStart = System.currentTimeMillis();
        timeProcessStart = System.currentTimeMillis();
        StringBuilder personName = new StringBuilder();
        for (int i = 0; i < elements; i++) {
            personName.setLength(0);
            for (int j = 0; j < 5; j++) {
                personName.append(randomChar());
            }
            person = new Person(personName.toString(), randomNumber(80));
            list.add(person);
        }
        timeProcessEnd = System.currentTimeMillis();

        System.out.println("time to add " + elements + " elements to " + listType() + " = " + (timeProcessEnd - timeProcessStart));
    }

    public void remove(int amountElements) {
        timeProcessStart = System.currentTimeMillis();
        for (int i = 0; i < amountElements; i++) {
            list.remove(randomNumber(elements - i));
        }
        timeProcessEnd = System.currentTimeMillis();
        System.out.println("time to remove " + amountElements + " elements from " + listType() + " = " + (timeProcessEnd - timeProcessStart));
    }

    public void get(int amountElements) {
        timeProcessStart = System.currentTimeMillis();
        int currentSize = list.size();
        for (int i = 0; i < amountElements; i++) {
            list.get(randomNumber(currentSize));
        }
        timeProcessEnd = System.currentTimeMillis();

        System.out.println("time to get " + amountElements + " elements from " + listType() + " = " + (timeProcessEnd - timeProcessStart));
        System.out.println("total working time from " + listType() + " = " + (timeProcessEnd - timeListStart));
    }

}
