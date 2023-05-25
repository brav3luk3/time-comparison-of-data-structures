package main;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListHandler extends AbstractHandler {
    private List<Person> list;
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

    @Override
    protected String dataStructuresType() {
        if (isArrayList) {
            return "ArrayList";
        } else {
            return "LinkedList";
        }
    }

    @Override
    protected void addElement(Person person) {
        list.add(person);
    }

    @Override
    protected void removeElement(int i) {
        list.remove(RandomUtils.randomNumber(elements - i));
    }

    @Override
    public int currentSize() {
        return list.size();
    }

    @Override
    protected void getElement(int currentSize) {
        list.get(RandomUtils.randomNumber(currentSize));
    }

}
