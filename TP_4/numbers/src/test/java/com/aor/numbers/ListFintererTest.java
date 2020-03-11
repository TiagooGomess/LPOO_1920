package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListFintererTest {
    public List<Integer> list;
    ListFilterer listFilterer;

    @Before
    public void helper() {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(-4);
        list.add(-2);
        list.add(5);
        list.add(8);
        listFilterer = new ListFilterer(this.list);
    }

    @Test
    public void positiveFilterTest() {
        PositiveFilter positiveFilter = new PositiveFilter();

        List<Integer> listOfPositives = this.listFilterer.filter(positiveFilter);

        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(5);
        myList.add(8);

        assertEquals(myList, listOfPositives);
    }

    @Test
    public void divisibleByTest() {
        DivisibleByFilter divisibleByFilter = new DivisibleByFilter(2);

        List<Integer> listOfDivisibleBy2 = this.listFilterer.filter(divisibleByFilter);

        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(-4);
        myList.add(-2);
        myList.add(8);

        assertEquals(myList, listOfDivisibleBy2);
    }

}

