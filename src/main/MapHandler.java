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

    private static int rnd(int max) {
        return (int) (Math.random() * ++max);
    }

    private static char randomChar() {
        int rand = new Random().nextInt(52);
        char start = (rand < 26) ? 'A' : 'a';
        return (char) (start + rand % 26);
    }

    private String mapStatus() {
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
            person = new Person(personName.toString(), rnd(80));
            map.put(person.getId(), person);
        }
        timeEnd = System.currentTimeMillis();

        System.out.println("time to add " + countElements + " elements to " + mapStatus() + " = " + (timeEnd - timeStart));
    }

    public void remove(int DelElem) {
        timeStart = System.currentTimeMillis();
        List<Person> list = getRandomElements(DelElem);
        for (int i = 0; i < list.size(); i++) {
            map.remove(list.get(i).getId(), list.get(i));
        }
        timeEnd = System.currentTimeMillis();
        countElements = map.size();
        System.out.println("time to remove 500 elements from " + mapStatus() + " = " + (timeEnd - timeStart));
    }

    public List<Person> getRandomElements(int amount) {
        List<Person> list = new ArrayList<>();
        Object[] objects = map.values().toArray();
        for (int i = 0; i < amount; i++) {
            list.add((Person) objects[rnd(countElements)]);
        }
        return list;
    }

    public void get(int getElem) {
        timeStart = System.currentTimeMillis();
        List<Person> list = getRandomElements(getElem);
        for (int i = 0; i < getElem; i++) {
            map.get(list.get(i).getId());
        }
        timeEnd = System.currentTimeMillis();

        System.out.println("time to get 8000 elements from " + mapStatus() + " = " + (timeEnd - timeStart));
        System.out.println("total working time from " + mapStatus() + " = " + (timeEnd - timeMapStart));
    }
}
