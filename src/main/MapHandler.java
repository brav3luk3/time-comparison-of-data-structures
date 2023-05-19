package main;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

public class MapHandler {
    private Map<Integer, Person> map;
    private Person person;
    private long timeMapStart;
    private long timeStart;
    private long timeEnd;
    private int countElements;
    private boolean isHashMap;

    public MapHandler(int countElements, boolean isHashMap) {
        this.countElements = countElements;
        if (isHashMap) {
            map = new HashMap<>();
        } else {
            map = new TreeMap<>();
        }
        this.isHashMap = isHashMap;
    }

    private static int randomNumber(int max) {
        return (int) (Math.random() * ++max);
    }

    private static char randomChar() {
        int rand = new Random().nextInt(52);
        char start = (rand < 26) ? 'A' : 'a';
        return (char) (start + rand % 26);
    }

    private String mapType() {
        if (isHashMap) {
            return "HashMap";
        } else {
            return "TreeMap";
        }
    }

    public void add() {
        timeMapStart = System.currentTimeMillis();
        timeStart = System.currentTimeMillis();
        StringBuilder personName = new StringBuilder();
        for (int i = 0; i < countElements; i++) {
            personName.setLength(0);
            for (int j = 0; j < 5; j++) {
                personName.append(randomChar());
            }
            person = new Person(personName.toString(), randomNumber(80));
            map.put(person.getId(), person);
        }
        timeEnd = System.currentTimeMillis();

        System.out.println("time to add " + countElements + " elements to " + mapType() + " = " + (timeEnd - timeStart));
    }

    public void remove(int amountElements) {
        timeStart = System.currentTimeMillis();
        List<Person> list = getRandomElements(amountElements);
        for (int i = 0; i < list.size(); i++) {
            map.remove(list.get(i).getId(), list.get(i));
        }
        timeEnd = System.currentTimeMillis();
        countElements = map.size();
        System.out.println("time to remove 500 elements from " + mapType() + " = " + (timeEnd - timeStart));
    }

    public List<Person> getRandomElements(int amountElements) {
        List<Person> list = new ArrayList<>();
        Object[] objects = map.values().toArray();
        for (int i = 0; i < amountElements; i++) {
            list.add((Person) objects[randomNumber(countElements)]);
        }
        return list;
    }

    public void get(int amountElements) {
        timeStart = System.currentTimeMillis();
        List<Person> list = getRandomElements(amountElements);
        for (int i = 0; i < amountElements; i++) {
            map.get(list.get(i).getId());
        }
        timeEnd = System.currentTimeMillis();

        System.out.println("time to get 8000 elements from " + mapType() + " = " + (timeEnd - timeStart));
        System.out.println("total working time from " + mapType() + " = " + (timeEnd - timeMapStart));
    }
}
