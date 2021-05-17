package reflection;
import static org.junit.jupiter.api.Assertions.*;

import core.TestTable;
import object.Table;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class TestTableMapResolver {

    @Test
    public void testResolverRunning() {
        TableMapResolver tableMapResolver = new TableMapResolver();
        Map<String, Table> tableMap = tableMapResolver.run().getMap();
        assertTrue(tableMap.get("test") instanceof TestTable);
    }
}
