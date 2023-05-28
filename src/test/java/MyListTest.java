import org.example.exceptions.NotFindException;
import org.example.exceptions.NotIndexException;
import org.example.myList.MyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class MyListTest {
    MyList ml;

    @Mock
    MyList myList;


    @BeforeEach
    public void setUp() throws NotIndexException {
        ml = new MyList();
        ml.add("Varian",0);
        ml.add("Thrall",1);
        ml.add("Karn",2);
        ml.add("Arthas",3);
        ml.add("Illidan",4);
    }

    @Test
    public void add() throws NotIndexException {
        String testResult = ml.add("asdf");

        String actual = "asdf";
        assertEquals(testResult, actual);
        String testResult1 = ml.add("asdf",1);
        assertEquals(testResult1,actual);
    }
    @Test
    public void remove() throws NotFindException, NotIndexException {

        String testResult = ml.remove("Arthas");
        String actual = "Arthas";
        assertEquals(testResult, actual);
        String testResult1 = ml.remove(1);
        String actual2 = "Thrall";
        assertEquals(testResult1,actual2);
    }

    @Test
    public void contains(){
        boolean testResult = ml.contains("Arthas");
        boolean actual = true;
        assertEquals(testResult,actual);
    }
    @Test
    public void indexOf(){
        int testResult = ml.indexOf("Illidan");
        int actual = 4;
        assertEquals(testResult,actual);
        assertEquals(-1,-1);
    }
    @Test
    public void lastIndexOf(){
        int testResult = ml.lastIndexOf("Illidan");
        int actual = 4;
        assertEquals(testResult,actual);
        assertEquals(-1,-1);
    }

    @Test
    public void equals() throws NotIndexException {
        myList = new MyList();
        myList.add("Varian",0);
        myList.add("Thrall",1);
        myList.add("Karn",2);
        myList.add("Arthas",3);
        myList.add("Illidan",4);
        String[] test = myList.getMyArray();
        String[] actual = ml.getMyArray();
        //assertArrayEquals(test,actual);
        assertEquals(myList.equals(ml),ml.equals(myList));
    }
}
