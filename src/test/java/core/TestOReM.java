package core;

import static org.junit.jupiter.api.Assertions.*;

import object.Table;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class TestOReM {

    @Test
    public void testSelect() {
        Table testTable = OReM.getTable("test");
        assertEquals(1, testTable.select("id").where("id = 1").get("id"));
    }

    @Test
    public void testIsInstanceOfTestTable() {
        Table testTable = OReM.getTable("test");
        assertTrue(testTable instanceof TestTable);
    }

    @Test
    public void testAutoRegisterTable() {
        assertNotEquals(null, OReM.getTable("test"));
    }

    @Test
    public void notExistTableShouldThrowNoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> OReM.getTable("NotExist"));
    }
}
