package com.github.uraven0107.reflection;

import com.github.uraven0107.core.TableMap;
import com.github.uraven0107.core.TestTable;
import com.github.uraven0107.core.TestTable2;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    public void testNotCollectTableClassShouldReturnNull() {
        TableMap tableMap = new TableMap();
        TableMapResolver resolver = new TableMapResolver();
        resolver.run(tableMap);
        Optional<Test> empty = Optional.empty();
        assertEquals(empty, tableMap.getTable("dummy"));
    }
}