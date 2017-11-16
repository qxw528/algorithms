package com.algo.comparator;

import com.algo.vo.Person;

import java.util.*;

/**
 * Created by qiusir on 11/15/17.
 */
public class PersonIterator {

    public static void run() {
        List<Person> newList = new ArrayList<Person>();
        List<Person> oldList = new ArrayList<Person>();
        Map<Integer,Person> personMap = new HashMap<Integer, Person>();

        Person person = new Person(1,"tony");
        Person person1 = new Person(2,"tony1");
        Person person2 = new Person(3,"tony2");
        Person person3 = new Person(4,"tony3");

        Long start = System.nanoTime();
        newList.add(person);
        newList.add(person1);
        newList.add(person2);
        newList.add(person3);
        Long end = System.nanoTime();

        System.out.println(end-start);

/*        oldList.add(person);
        oldList.add(person1);
        oldList.add(person2);
        oldList.add(person3);*/

        Long start1 = System.nanoTime();
        personMap.put(1,person);
        personMap.put(2,person1);
        personMap.put(3,person2);
        personMap.put(4,person3);
        Long end1 = System.nanoTime();
        System.out.println(end1-start1);

        //runList(newList,oldList);
        //runIterator(newList,oldList);
    }

    private static void runIterator(List<Person> newList, List<Person> oldList) {
        //System.out.println(System.nanoTime());
        Long start = System.nanoTime();
        for (Person p:newList) {
            boolean bs = false;
            for (Person p1:oldList) {
                if (p.getId() == p1.getId()) {
                    bs = true;
                    break;
                }
            }

            if (bs) {
                System.out.println(p.getName());
            } else {
                System.out.println("======");
            }
        }
        Long end = System.nanoTime();
        System.out.println(end-start);
        //System.out.println(System.nanoTime());
    }

    private static void runList(List<Person> newList, List<Person> oldList) {
        //System.out.println(System.nanoTime());
        Long start = System.nanoTime();
        //List<Integer> listInt = new ArrayList<Integer>();
        Set<Integer> listInt = new HashSet<Integer>();
        for (Person p:newList) {
            listInt.add(p.getId());
        }
        for (Person p1:oldList) {
            if (listInt.contains(p1.getId())) {
                System.out.println(p1.getName());
            } else {
                System.out.println("======");
            }
        }
        Long end = System.nanoTime();
        //System.out.println(System.nanoTime());
        System.out.println(end-start);
    }

    public static void main(String[] args) {
        PersonIterator.run();
    }
}
