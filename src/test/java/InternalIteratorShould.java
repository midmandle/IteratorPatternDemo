import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class InternalIteratorShould {
    private ListAggregate listItems;
    private List<String> expectedItems;
    private List<String> iteratedItems;

    @Before
    public void setUp() {
        listItems = new ListAggregate(asList("Item1", "Item2", "Item3"));
        expectedItems = asList("Hello, Item1", "Hello, Item2", "Hello, Item3");
        iteratedItems = new ArrayList<>();
    }

    @Test
    public void return_each_item_in_the_order_they_were_added() {
        DemoInternalIterator iterator = listItems.getInternalIterator();

        printStatusBefore();

        printRunningStatus();

        ListAggregate processedItems = iterator.iterate(this::appendHello);
        iteratedItems = processedItems.toList();

        printStatusAfter();

        assertEquals(expectedItems, iteratedItems);
    }

    private String appendHello(String itemString) {
        return "Hello, " + itemString;
    }

    private void printStatusAfter() {
        System.out.println("AFTER:");
        System.out.println("EXPECTED: \t" + expectedItems);
        System.out.println("ACTUAL: \t" + iteratedItems);
    }

    private void printRunningStatus() {
        System.out.println();
        System.out.println("_____ RUN INTERNAL ITERATOR _____");
        System.out.println();
    }

    private void printStatusBefore() {
        System.out.println();
        System.out.println("BEFORE:");
        System.out.println("EXPECTED: \t" + expectedItems);
        System.out.println("ACTUAL: \t" + listItems);
    }
}
