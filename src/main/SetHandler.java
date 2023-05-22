package main;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetHandler {
    private Set<Person> set;
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

    private String setType() {
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
                personName.append(RandomUtils.randomChar());
            }
            set.add(new Person(personName.toString(), RandomUtils.randomNumber(80)));
        }
        timeEnd = System.currentTimeMillis();

        System.out.println("time to add " + countElements + " elements to " + setType() + " = " + (timeEnd - timeStart));
    }

    public void remove(int amountElements) {
        timeStart = System.currentTimeMillis();
        List<Person> list = RandomUtils.getRandomElements(amountElements, set);
        for (int i = 0; i < list.size(); i++) {
            set.remove(list.get(i));
        }
        timeEnd = System.currentTimeMillis();
        countElements = set.size();
        System.out.println("time to remove 500 elements from " + setType() + " = " + (timeEnd - timeStart));
    }

    public void get(int amountElements) {
        timeStart = System.currentTimeMillis();
        List<Person> list = RandomUtils.getRandomElements(amountElements, set);
        for (int i = 0; i < list.size(); i++) {
            set.contains(list.get(i));
        }
        timeEnd = System.currentTimeMillis();

        System.out.println("time to get 8000 elements from " + setType() + " = " + (timeEnd - timeStart));
        System.out.println("total working time from " + setType() + " = " + (timeEnd - timeSetStart));
    }
}
