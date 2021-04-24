package prj5;

/**
 * Test class for the LinkedList class
 * 
 * @author benjaminhurt
 * @author ayermas
 * @author jaredo19
 * @version 04.23.2021
 *
 */
public class LinkedListTest extends student.TestCase {
    private LinkedList<String> emptyList;
    private LinkedList<String> list1; // Starts with one item
    private LinkedList<String> list2; // Starts with three items
    private String nullObject;

    /**
     * Sets up the test class
     */
    public void setUp() {
        emptyList = new LinkedList<String>();
        list1 = new LinkedList<String>();
        list2 = new LinkedList<String>();

        list1.add("red");

        list2.add("red");
        list2.add("orange");
        list2.add("yellow");

        nullObject = null;

    }


    /**
     * Tests the size method
     */
    public void testSize() {
        assertEquals(0, emptyList.size());
        assertEquals(1, list1.size());
        assertEquals(3, list2.size());
    }


    /**
     * Tests the add method with one parameter
     */
    public void testAddToEnd() {
        emptyList.add("red");
        assertEquals("red", emptyList.get(0));
        assertEquals(1, emptyList.size());

        list2.add("green");
        assertEquals("green", list2.get(3));
        assertEquals(4, list2.size());
    }


    /**
     * Tests the add method with a null exception and one parameter
     */
    public void testAddToEndNullException() {
        Exception exception = null;
        try {
            emptyList.add(nullObject);
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("Object is null",
            exception instanceof IllegalArgumentException);
    }


    /**
     * Tests the add method with an index and object parameter
     */
    public void testAddToIndex() {
        emptyList.add(0, "red");
        assertEquals("red", emptyList.get(0));
        emptyList.add(1, "orange");
        assertEquals("red\n, orange\n", emptyList.toString());
        emptyList.add(0, "blue");
        assertEquals("blue", emptyList.get(0));

        list1.add(0, "green");
        assertEquals("green\n, red\n", list1.toString());

        list2.add(0, "black");
        assertEquals("black\n, red\n, orange\n, yellow\n", list2.toString());
        list2.add(2, "white");
        assertEquals("black\n, red\n, white\n, orange\n, yellow\n", list2
            .toString());
        list2.add(5, "green");
        String temp;
        temp = "black\n, red\n, white\n, orange\n, yellow\n, green\n";
        assertEquals(temp, list2.toString());
    }


    /**
     * Tests the add method with a null exception and an index
     */
    public void testAddToIndexNullException() {
        Exception exception = null;
        try {
            emptyList.add(0, nullObject);
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("Object is null",
            exception instanceof IllegalArgumentException);
    }


    /**
     * Tests the add method with an out of bounds index
     */
    public void testAddToIndexOOBException() {
        Exception exception = null;
        try {
            list1.add(4, "black");
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("Index is out of bounds",
            exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests the add method with a negative index
     */
    public void testAddToIndexNegOOBException() {
        Exception exception = null;
        try {
            list1.add(-1, "black");
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("Index is out of bounds",
            exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests the isEmpty method
     */
    public void testIsEmpty() {
        assertTrue(emptyList.isEmpty());
        emptyList.add("red");
        assertFalse(emptyList.isEmpty());

        assertFalse(list1.isEmpty());
        list1.remove(0);
        assertTrue(list1.isEmpty());
    }


    /**
     * Tests the remove method on a specified object
     */
    public void testRemoveObject() {
        assertFalse(emptyList.remove("red"));
        assertEquals(0, emptyList.size());

        assertFalse(list1.remove("blue"));
        assertEquals(1, list1.size());
        assertTrue(list1.remove("red"));
        assertEquals(0, list1.size());
        assertFalse(list1.remove("red"));
        assertEquals(0, list1.size());

        assertFalse(list2.remove("white"));
        assertEquals(3, list2.size());
        assertTrue(list2.remove("orange"));
        assertEquals(2, list2.size());
        list2.add("red");
        list2.add("orange");
        assertTrue(list2.remove("orange"));
    }


    /**
     * Tests the remove method on an index
     */
    public void testRemoveIndex() {
        assertTrue(list1.remove(0));
        assertTrue(list1.isEmpty());

        list2.add("green");
        assertTrue(list2.remove(3));
        assertEquals("red\n, orange\n, yellow\n", list2.toString());
        assertTrue(list2.remove(0));
        assertEquals("orange\n, yellow\n", list2.toString());
    }


    /**
     * Tests the remove method with an out of bounds index
     */
    public void testRemoveIndexOOBException() {
        Exception exception = null;
        try {
            list1.remove(4);
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("Index is out of bounds",
            exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests the remove method with a negative index
     */
    public void testRemoveIndexNegativeOOBException() {
        Exception exception = null;
        try {
            list1.remove(-1);
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("Index is out of bounds",
            exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests the remove method with an index on an empty list
     */
    public void testRemoveIndexNullOOBException() {
        Exception exception = null;
        try {
            emptyList.remove(1);
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("Index is out of bounds",
            exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests the get method
     */
    public void testGet() {
        assertEquals("red", list1.get(0));
        list1.add("orange");
        assertEquals("red", list1.get(0));
        assertEquals("orange", list1.get(1));

        assertEquals("yellow", list2.get(2));
        list2.remove(2);
        assertEquals("orange", list2.get(1));
        list2.remove(1);
        assertEquals("red", list2.get(0));
    }


    /**
     * Tests the get method with an out of bounds exception
     */
    public void testGetException() {
        Exception exception = null;
        try {
            list1.get(10);
            fail("get() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("Index exceeds the size",
            exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests the contains method
     */
    public void testContains() {
        assertFalse(emptyList.contains("red"));
        assertFalse(emptyList.contains(nullObject));

        assertTrue(list1.contains("red"));
        assertFalse(list1.contains("green"));
        assertFalse(list1.contains(nullObject));

        assertTrue(list2.contains("yellow"));
    }


    /**
     * Tests the clear method
     */
    public void testClear() {
        emptyList.clear();
        assertTrue(emptyList.isEmpty());

        list1.clear();
        assertTrue(list1.isEmpty());

        list2.clear();
        assertTrue(list2.isEmpty());
    }


    /**
     * Tests the lastIndexOf method
     */
    public void testLastIndexOf() {
        assertEquals(-1, emptyList.lastIndexOf("red"));
        assertEquals(-1, emptyList.lastIndexOf(nullObject));

        assertEquals(0, list1.lastIndexOf("red"));
        assertEquals(-1, list1.lastIndexOf(nullObject));
        assertEquals(-1, list1.lastIndexOf("green"));
        list1.add("red");
        assertEquals(1, list1.lastIndexOf("red"));

        assertEquals(1, list2.lastIndexOf("orange"));
        list2.remove("orange");
        assertEquals(-1, list2.lastIndexOf("orange"));
    }


    /**
     * Tests the toString method
     */
    public void testToString() {
        assertEquals("", emptyList.toString());

        assertEquals("red\n", list1.toString());

        assertEquals("red\n, orange\n, yellow\n", list2.toString());
    }
}
