package main;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

public class SetHandler {
    private Set<Person> set;
    private Person person;
    private long timeSetStart;
    private long timeStart;
    private long timeEnd;
    private int countElements;
    private boolean isHashSet;

    public SetHandler(int elements, boolean isHashSet) {
        this.countElements = elements;
        if (isHashSet) {
            set = new HashSet<>();
        } else {
            set = new TreeSet<>();
        }
        this.isHashSet = isHashSet;
    }

    private static int rnd(int max) {
        return (int) (Math.random() * ++max);
    }

    private static char randomChar() {
        int rand = new Random().nextInt(52);
        char start = (rand < 26) ? 'A' : 'a';
        return (char) (start + rand % 26);
    }

    private String setStatus() {
        if (isHashSet) {
            return "HashSet";
        } else {
            return "TreeSet";
        }
    }

    public void add() {
        timeSetStart = System.currentTimeMillis();
        timeStart = System.currentTimeMillis();
        StringBuilder personName = new StringBuilder();
        for (int i = 0; i < countElements; i++) {
            personName.setLength(0);
            for (int j = 0; j < 5; j++) {
                personName.append(randomChar());
            }
            person = new Person(personName.toString(), rnd(80));
            set.add(person);
        }
        timeEnd = System.currentTimeMillis();

        System.out.println("time to add " + countElements + " elements to " + setStatus() + " = " + (timeEnd - timeStart));
    }

    public void remove(int DelElem) {
        timeStart = System.currentTimeMillis();
        List<Person> list = getRandomElements(DelElem);
        for (int i = 0; i < list.size(); i++) {
            set.remove(list.get(i));
        }
        timeEnd = System.currentTimeMillis();
        countElements = set.size();
        System.out.println("time to remove 500 elements from " + setStatus() + " = " + (timeEnd - timeStart));
    }

    public List<Person> getRandomElements(int amount) {
        List<Person> list = new ArrayList<>();
        Object[] objects = set.toArray();
        for (int i = 0; i < amount; i++) {
            list.add((Person) objects[rnd(countElements)]);
        }
        return list;
    }

    public void get(int getElem) {
        timeStart = System.currentTimeMillis();
        List<Person> list = getRandomElements(getElem);
        for (int i = 0; i < list.size(); i++) {
            set.contains(list.get(i));
        }
        timeEnd = System.currentTimeMillis();

        System.out.println("time to get 8000 elements from " + setStatus() + " = " + (timeEnd - timeStart));
        System.out.println("total working time from " + setStatus() + " = " + (timeEnd - timeSetStart));
    }
}
