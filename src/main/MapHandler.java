package main;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapHandler extends AbstractHandler {
    private Map<Integer, Person> map;
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
    @Override
    protected String dataStructuresType() {
        if (isHashMap) {
            return "HashMap";
        } else {
            return "TreeMap";
        }
    }

    @Override
    protected void addElement(Person person) {
        map.put(person.getId(), person);
    }

    @Override
    protected void removeElement(int i) {
        map.remove(RandomUtils.randomNumber(map.size()));
    }

    @Override
    public int currentSize() {
        return map.size();
    }

    @Override
    protected void getElement(int currentSize) {
        map.get(RandomUtils.randomNumber(countElements));
    }

}
