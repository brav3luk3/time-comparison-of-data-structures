package main;

public class Main {

    public static void main(String[] args) {

        int elements = 1_000_000;
        int amountElementsToRemove = 8000;
        int amountElementsToGet = 8000;

        System.out.println("\n////////////ArrayLIst////////////\n");

        ListHandler listHandler = new ListHandler(elements, true);
        listHandler.add(elements);
        listHandler.remove(amountElementsToRemove);
        listHandler.get(amountElementsToGet);

        System.out.println("\n///////////LinkedList////////////\n");

        listHandler = new ListHandler(elements, false);
        listHandler.add(elements);
        listHandler.remove(amountElementsToRemove);
        listHandler.get(amountElementsToGet);

        System.out.println("\n//////////////HashSet////////////\n");

        SetHandler setHandler = new SetHandler(elements, true);
        setHandler.add();
        setHandler.remove(amountElementsToRemove);
        setHandler.get(amountElementsToGet);

        System.out.println("\n/////////////TreeSet/////////////\n");

        setHandler = new SetHandler(elements, false);
        setHandler.add();
        setHandler.remove(amountElementsToRemove);
        setHandler.get(amountElementsToGet);

        System.out.println("\n/////////////HashMap//////////////\n");

        MapHandler mapHandler = new MapHandler(elements, true);
        mapHandler.add(elements);
        mapHandler.remove(amountElementsToRemove);
        mapHandler.get(amountElementsToGet);

        System.out.println("\n/////////////TreeMap//////////////\n");

        mapHandler = new MapHandler(elements, false);
        mapHandler.add(elements);
        mapHandler.remove(amountElementsToRemove);
        mapHandler.get(amountElementsToGet);
    }
}
