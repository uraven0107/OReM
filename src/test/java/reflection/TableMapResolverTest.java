package reflection;

import core.TableMap;
import core.TestTable;
import object.Table;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableMapResolverTest {

    @Test
    public void testInitializeTableMap() {
        TableMap tableMap = new TableMap();
        TableMapResolver resolver = new TableMapResolver();
        resolver.run(tableMap);
        assertTrue(tableMap.getTable("test") instanceof TestTable);
    }

}