package reflection;

import core.TableMap;
import core.TestTable;
import object.Table;
import org.junit.jupiter.api.Test;

import java.io.InvalidObjectException;

import static org.junit.jupiter.api.Assertions.*;

class TableMapResolverTest {

    @Test
    public void testInitializeTableMap() throws InvalidObjectException {
        TableMap tableMap = new TableMap();
        TableMapResolver resolver = new TableMapResolver();
        resolver.run(tableMap);
        assertTrue(tableMap.getTable("test").get() instanceof TestTable);
    }

}