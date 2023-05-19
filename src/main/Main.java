package main;

public class Main {

    public static void main(String[] args) {

        int elements = 1_000_000;

        System.out.println("\n////////////ArrayLIst////////////\n");

        ListHandler arr = new ListHandler(elements, true);
        arr.add();
        arr.remove(500);
        arr.get(8000);

        System.out.println("\n///////////LinkedList////////////\n");

        ListHandler lin = new ListHandler(elements, false);
        lin.add();
        lin.remove(500);
        lin.get(8000);

        System.out.println("\n//////////////HashSet////////////\n");

        SetHandler hash = new SetHandler(elements, true);
        hash.add();
        hash.remove(500);
        hash.get(8000);

        System.out.println("\n/////////////TreeSet/////////////\n");

        SetHandler treeSet = new SetHandler(elements, false);
        treeSet.add();
        treeSet.remove(500);
        treeSet.get(8000);

        System.out.println("\n/////////////HashMap//////////////\n");

        MapHandler map = new MapHandler(elements, true);
        map.add();
        map.remove(8000);
        map.get(8000);

        System.out.println("\n/////////////TreeMap//////////////\n");

        MapHandler treeMap = new MapHandler(elements, false);
        treeMap.add();
        treeMap.remove(8000);
        treeMap.get(8000);
    }
}
