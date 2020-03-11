package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {
    public List<Integer> list;

    @Before
    public void helper() {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
    }

    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(5, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinct() {
        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(4);
        myList.add(5);

        ListAggregator aggregator = new ListAggregator(myList);
        int distinct = aggregator.distinct(new StubDatabase(myList), new ListDeduplicatorTest.StubSorted(myList));

        assertEquals(4, distinct);
    }

    @Test
    public void cornerCase() {
        List<Integer> myList = new ArrayList<>();
        myList.add(-1);
        myList.add(-4);
        myList.add(-5);

        ListAggregator aggregator = new ListAggregator(myList);

        int max = aggregator.max();

        assertEquals(-1, max);
    }

    class StubDatabase implements IListDeduplicator {
        private List<Integer> myList;

        StubDatabase(List<Integer> list) {
            this.myList = list;

        }

        public List<Integer> deduplicate(IListSorted listSorter)
        {
            /* List<Integer> myList = new ArrayList<>();
            myList.add(1);
            myList.add(2);
            myList.add(4); */
            // 1,2,4,2 -> 1, 2, 4

            return myList;
        }
    }

    @Test
    public void distinctCase() {
        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(4);

        ListAggregator aggregator = new ListAggregator(myList);

        IListDeduplicator deduplicator = Mockito.mock(IListDeduplicator.class);
        IListSorted listSorter = Mockito.mock(IListSorted.class);
        Mockito.when(listSorter.sort()).thenReturn(myList);
        Mockito.when(deduplicator.deduplicate(listSorter)).thenReturn(myList);

        // int distinct = aggregator.distinct(new StubDatabase(myList), new ListDeduplicatorTest.StubSorted(myList));
        int distinct = aggregator.distinct(deduplicator, listSorter);

        assertEquals(3, distinct);
    }

}