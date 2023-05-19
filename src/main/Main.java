package main;

public class Main {

    public static void main(String[] args) {

        int elements = 1_000_000;

        System.out.println("\n////////////ArrayLIst////////////\n");

        ListHandler listHandler = new ListHandler(elements, true);
        listHandler.add();
        listHandler.remove(500);
        listHandler.get(8000);

        System.out.println("\n///////////LinkedList////////////\n");

        listHandler = new ListHandler(elements, false);
        listHandler.add();
        listHandler.remove(500);
        listHandler.get(8000);

        System.out.println("\n//////////////HashSet////////////\n");

        SetHandler setHandler = new SetHandler(elements, true);
        setHandler.add();
        setHandler.remove(500);
        setHandler.get(8000);

        System.out.println("\n/////////////TreeSet/////////////\n");

        setHandler = new SetHandler(elements, false);
        setHandler.add();
        setHandler.remove(500);
        setHandler.get(8000);

        System.out.println("\n/////////////HashMap//////////////\n");

        MapHandler mapHandler = new MapHandler(elements, true);
        mapHandler.add();
        mapHandler.remove(8000);
        mapHandler.get(8000);

        System.out.println("\n/////////////TreeMap//////////////\n");

        mapHandler = new MapHandler(elements, false);
        mapHandler.add();
        mapHandler.remove(8000);
        mapHandler.get(8000);
    }
}
