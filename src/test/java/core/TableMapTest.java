package core;
import static org.junit.jupiter.api.Assertions.*;

import object.Table;
import org.junit.jupiter.api.Test;

import java.io.InvalidObjectException;
import java.util.Optional;

public class TableMapTest {

    @Test
    public void testRegister() throws InvalidObjectException {
        TableMap tableMap = new TableMap();
        tableMap.register("test", new TestTable());
        assertTrue(tableMap.getTable("test").get() instanceof TestTable);
    }

    @Test
    public void testEmptyMapReturnEmptyOptional() {
        TableMap tableMap = new TableMap();
        assertEquals(tableMap.getTable("test"), Optional.empty());
    }

    @Test
    public void testNotExistTableNameReturnEmptyOptional() {
        TableMap tableMap = new TableMap();
        tableMap.register("test", new TestTable());
        assertEquals(tableMap.getTable("notExist"), Optional.empty());
    }
}
