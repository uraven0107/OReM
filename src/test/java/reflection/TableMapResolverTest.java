package reflection;

import core.TableMap;
import core.TestTable;
import core.TestTable2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TableMapResolverTest {

    @Test
    public void testInitializeTableMap() {
        TableMap tableMap = new TableMap();
        TableMapResolver resolver = new TableMapResolver();
        resolver.run(tableMap);
        assertTrue(tableMap.getTable("test").get() instanceof TestTable);
        assertTrue(tableMap.getTable("test2").get() instanceof TestTable2);
    }
}