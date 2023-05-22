package main;

public abstract class AbstractHandler {
    private long timeListStart;
    private long timeProcessStart;
    private long timeProcessEnd;
    private int elements;

    protected abstract void addElement(Person person);
    protected abstract void removeElement(int i);
    protected abstract void getElement(int currentSize);
    protected abstract String dataStructuresType();
    public abstract int currentSize();

    public void add(int amountElements) {
        timeListStart = System.currentTimeMillis();
        timeProcessStart = System.currentTimeMillis();
        StringBuilder personName = new StringBuilder();
        for (int i = 0; i < amountElements; i++) {
            personName.setLength(0);
            for (int j = 0; j < 5; j++) {
                personName.append(RandomUtils.randomChar());
            }
            addElement(new Person(personName.toString(), RandomUtils.randomNumber(80)));
        }
        elements = currentSize();
        timeProcessEnd = System.currentTimeMillis();
        System.out.println("time to add " + amountElements + " elements to " + dataStructuresType() + " = " + (timeProcessEnd - timeProcessStart));
    }

    public void remove(int amountElements) {
        timeProcessStart = System.currentTimeMillis();
        for (int i = 0; i < amountElements; i++) {
            removeElement(i);
        }

        timeProcessEnd = System.currentTimeMillis();
        System.out.println("time to remove " + amountElements + " elements from " + dataStructuresType() + " = " + (timeProcessEnd - timeProcessStart));
    }

    public void get(int amountElements) {
        timeProcessStart = System.currentTimeMillis();
        int currentSize = currentSize();
        for (int i = 0; i < amountElements; i++) {
            getElement(currentSize);
        }
        timeProcessEnd = System.currentTimeMillis();

        System.out.println("time to get " + amountElements + " elements from " + dataStructuresType() + " = " + (timeProcessEnd - timeProcessStart));
        System.out.println("total working time from " + dataStructuresType() + " = " + (timeProcessEnd - timeListStart));
    }
}
