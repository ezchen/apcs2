public class Test_MyLinkedList // -*-Java-*-
{

    public static void main(String[] args)
    {
	testall();
    }

    public static void testall()
    {
	test_MyLinkedList();
	test_length();
	test_get();
	test_set();
	test_find();
	test_add();
	test_remove();
    }

    public static <T> void printw(int tabs, T input)
    //Print with tabs.
    {
	String output = "";
	while (tabs-- > 0)
	    {
		output += "\t";
	    }
	output += input;
	System.out.println(output);
	//I may implement a version that allows newlines at the end as well.  Woo!
    }

    public static MyLinkedList<String> make()
    //Makes a MyLinkedList for testing.
    //Relies on constructor, add()
    {
	MyLinkedList<String> thing = new MyLinkedList<String>();
	for (int count = 9; count >= 0; count--)
	    {
		thing.add(Integer.toString(count * 10));
	    }
	return thing;
    }

    public static void test_MyLinkedList()
    //Relies on constructor, add()
    {
	printw(0, "TESTING CONSTRUCTOR + add (FRONT)...");
	MyLinkedList<String> thing = make();
	printw(1, "SHOULD BE 0 - 90 INCR 10");
	printw(1, thing);
	printw(0, "TESTING COMPLETE!\n");
    }

    public static void test_length()
    {
	printw(0, "TESTING length...");
	MyLinkedList<String> thing = make();
	printw(1, thing);
	printw(1, "IDK COUNT THEM OR SOMETHING");
	printw(1, thing.length());
	printw(0, "TESTING COMPLETE!\n");
    }

    public static void test_get()
    //Relies on length
    {
	printw(0, "TESTING get...");
	MyLinkedList<String> thing = make();
	printw(1, thing);

	printw(1, "GET -1: ");
	try 
	    {
		thing.get(-1);
	    }
	catch (IndexOutOfBoundsException e)
	    {
		printw(1, "exception thrown");
	    }

	printw(1, "GET 0: ");
	printw(1, thing.get(0));
	printw(1, "GET 4: ");
	printw(1, thing.get(4));
	printw(1, "GET LAST: ");
	printw(1, thing.get(thing.length() - 1));

	printw(1, "GET 99: ");
	try 
	    {
		thing.get(99);
	    }
	catch (IndexOutOfBoundsException e)
	    {
		printw(1, "exception thrown");
	    }

	printw(0, "TESTING COMPLETE!\n");
    }

    public static void test_set()
    //Relies on length
    {
	printw(0, "TESTING set...");
	MyLinkedList<String> thing = make();
	printw(1, thing);

	printw(1, "SET -1 = TOO SMALL");
	try 
	    {
		thing.set(-1, "TOO SMALL");
	    }
	catch (IndexOutOfBoundsException e)
	    {
		printw(1, "exception thrown");
	    }

	printw(1, "SET 0 = ZERO");
	thing.set(0, "ZERO");
	printw(1, thing);

	printw(1, "SET 4 = FOUR");
	thing.set(4, "FOUR");
	printw(1, thing);

	printw(1, "SET LAST = LAST");
	thing.set(thing.length() - 1, "LAST");
	printw(1, thing);

	printw(1, "SET 525600 = TOO BIG");
	try
	    {
		thing.set(525600, "TOO BIG");
	    }
	catch (IndexOutOfBoundsException e)
	    {
		printw(1, "exception thrown");
	    }

	printw(0, "TESTING COMPLETE!\n");
    }

    public static void test_find()
    //Relies on length and get
    {
	printw(0, "TESTING find...");

	MyLinkedList<String> thing = make();
	printw(0, thing);

	printw(1, "FIND 0");
	printw(1, thing.find("0"));

	printw(1, "FIND 20");
	printw(1, thing.find("20"));

	printw(1, "FIND " + thing.get(thing.length() - 1));
	printw(1, thing.find(thing.get(thing.length() - 1)));

	printw(1, "FIND haha");
	printw(1, thing.find("haha"));

	printw(0, "TESTING COMPLETE!\n");
    }

    public static void test_add()
    //relies on length
    {
	printw(0, "TESTING add (POSITIONAL)...");
	MyLinkedList<String> thing = make();
	printw(1, thing);

	printw(1, "ADDING TOO SMALL AT -1...");
	try 
	    {
		thing.add("TOO SMALL", -1);
	    }
	catch (IndexOutOfBoundsException e)
	    {
		printw(1, "exception thrown");
	    }

	printw(1, "ADDING ZERO AT 0...");
	thing.add("ZERO", 0);
	printw(1, thing);

	printw(1, "ADDING THREE AT 3...");
	thing.add("THREE", 3);
	printw(1, thing);

	printw(1, "ADDING LAST AT END...");
	thing.add("LAST", thing.length());
	printw(1, thing);

	printw(1, "ADDING TOO BIG AT 525600");
	try
	    {
		thing.add("TOO BIG", 525600);
	    }
	catch (IndexOutOfBoundsException e)
	    {
		printw(1, "exception thrown");
	    }

	printw(0, "TESTING COMPLETE!\n");
    }

    public static void test_remove()
    //Relies on length
    {
	printw(0, "TESTING remove...");

	MyLinkedList<String> thing = make();
	printw(1, thing);

	printw(1, "REMOVE -1");
	try
	    {
		thing.remove(-1);
	    }
	catch (IndexOutOfBoundsException e)
	    {
		printw(1, "exception thrown");
	    }

	printw(1, "REMOVE 0");
	thing.remove(0);
	printw(1, thing);

	printw(1, "REMOVE 3");
	thing.remove(3);
	printw(1, thing);

	printw(1, "REMOVE LAST");
	thing.remove(thing.length() - 1);
	printw(1, thing);

	printw(1, "REMOVE 99");
	try
	    {
		thing.remove(99);
	    }
	catch (IndexOutOfBoundsException e)
	    {
		printw(1, "exception thrown");
	    }

	printw(0, "TESTING COMPLETE!\n");
    }

}
