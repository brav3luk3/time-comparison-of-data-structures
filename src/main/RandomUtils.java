package main;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class RandomUtils {
    private static Random random = new Random();

    public static int randomNumber(int max) {
        return random.nextInt(max);
    }

    public static char randomChar() {
        int rand = new Random().nextInt(52);
        char start;
        if (rand < 26) {
            start = 'A';
        } else {
            start = 'a';
        }
        return (char) (start + rand % 26);
    }

    public static List<Person> getRandomElements(int amountElements, Collection<Person> collection) {
        List<Person> list = new ArrayList<>();
        Object[] objects = collection.toArray();
        for (int i = 0; i < amountElements; i++) {
            list.add((Person) objects[randomNumber(objects.length)]);
        }
        return list;
    }
}
