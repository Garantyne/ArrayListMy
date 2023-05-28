package org.example;

import org.example.exceptions.NotFindException;
import org.example.exceptions.NotIndexException;
import org.example.myList.MyList;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NotIndexException, NotFindException {
        MyList list = new MyList("asdf");
        List<String> list2 = new ArrayList<>(List.of("asdf"));
        System.out.println(list.add("ggggg"));
        System.out.println(list.add("ggggg"));
        list.add("ggggg");
        list.add("ggggg");
        list.add("qwert");
        System.out.println(list.equals(list));
        list.remove("qwert");

        list.toString1();
        System.out.println(list.getCapacity());
    }
}