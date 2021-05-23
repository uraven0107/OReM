package com.github.uraven0107.core;
import com.github.uraven0107.testObjects.TestTable;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TableMapTest {

    @Test
    public void testRegister() {
        TableMap tableMap = new TableMap();
        tableMap.register("test", new TestTable());
        assertNotEquals(Optional.empty(), tableMap.getTable("test"));
    }

    @Test
    public void testEmptyMapReturnEmptyOptional() {
        TableMap tableMap = new TableMap();
        assertEquals(tableMap.getTable("notExist"), Optional.empty());
    }

    @Test
    public void testNotExistTableNameReturnEmptyOptional() {
        TableMap tableMap = new TableMap();
        String notExistTableName = "notExist";
        tableMap.register("exist", new TestTable());
        assertEquals(Optional.empty(), tableMap.getTable(notExistTableName));
    }

    @Test
    public void nullTableShouldReturnEmptyOptional() {
        TableMap tableMap = new TableMap();
        String nullTableName = "nullTable";
        tableMap.register(nullTableName,null);
        assertEquals(Optional.empty(), tableMap.getTable(nullTableName));
    }
}
