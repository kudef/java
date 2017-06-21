package ru.otus.oksana;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> myArrayList = new MyArrayList<String>();

        List<String> defList = new ArrayList<String>();

        Collections.addAll(myArrayList, "a", "s", "d", "f");
        printListContents(myArrayList, "myArrayList");
        assertListEquals(myArrayList, "a", "s", "d", "f");

        padToSize(defList, myArrayList.size());
        Collections.copy(defList, myArrayList);
        printListContents(defList, "defList copied from myArrayList");
        assertListEquals(defList, "a", "s", "d", "f");

        defList.set(0, "q");
        defList.add("w");

        padToSize(myArrayList, defList.size());
        Collections.copy(myArrayList, defList);
        printListContents(myArrayList, "myArrayList copied from defList");
        assertListEquals(myArrayList, "q", "s", "d", "f", "w");

        Collections.sort(myArrayList);
        printListContents(myArrayList, "myArrayList sorted");
        assertListEquals(myArrayList, "d", "f", "q", "s", "w");

    }

    private static void assertListEquals(List<String> list, String... expectedElements) {
        Object[] elements = list.toArray();
        assert(elements.equals(expectedElements));
    }

    private static void printListContents(List<String> list, String listName) {
        System.out.println("listName = [" + listName + "], size = [" + list.size() + "]");
        Object[] elements = list.toArray();
        for (Object element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    private static void padToSize(List<String> list, int targetSize) {
        int sizeDiff = targetSize - list.size();
        if (sizeDiff > 0) {
            for (int i = 0; i < sizeDiff; i++) {
                list.add(null);
            }
        }
    }

}
