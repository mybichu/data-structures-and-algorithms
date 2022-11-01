package com.neoyu.datastructuresandalgorithms.dahuadatastructure.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class MyArrayListTest {

    @Test
    void testClear() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        Assertions.assertEquals(1, myArrayList.size());
        myArrayList.add(2);
        Assertions.assertEquals(2, myArrayList.size());
        myArrayList.clear();
        Assertions.assertEquals(0, myArrayList.size());
        Assertions.assertEquals(10, myArrayList.getCapacity());
    }

    @Test
    void testGet() {
    }

    @Test
    void testAdd() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>(1);
        myArrayList.add(1);
        Assertions.assertEquals(2, myArrayList.getCapacity());
        myArrayList.add(2);
        Assertions.assertEquals(3, myArrayList.getCapacity());
        myArrayList.add(3);
        Assertions.assertEquals(5, myArrayList.getCapacity());
    }

    @Test
    void testAddWithIndex() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(0,0);
        Assertions.assertEquals(6, myArrayList.size());
        Assertions.assertEquals(0, myArrayList.get(0));
        myArrayList.add(100, 2);
        Assertions.assertEquals(100, myArrayList.get(2));
        log.info(myArrayList.toString());
        Assertions.assertEquals(2, myArrayList.get(3));
    }

    @Test
    void testIndexOf() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(0);
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        Assertions.assertEquals(-1, myArrayList.indexOf(100));
        Assertions.assertEquals(-1, myArrayList.indexOf(null));
        Assertions.assertEquals(2, myArrayList.indexOf(2));
    }
}
