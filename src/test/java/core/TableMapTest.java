package core;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TableMapTest {

    @Test
    public void testRegister() {
        TableMap tableMap = new TableMap();
        tableMap.register("test", new TestTable());
        assertTrue(tableMap.getTable("test") instanceof TestTable);
    }
}
