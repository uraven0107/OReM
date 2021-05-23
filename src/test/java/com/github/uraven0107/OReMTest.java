package com.github.uraven0107;

import com.github.uraven0107.core.TestTable;
import com.github.uraven0107.core.TestTable2;
import com.github.uraven0107.object.Table;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class OReMTest {

    @Test
    public void testSelect() {
        Table testTable = OReM.searchTable("test").get();
        assertEquals(1, testTable.select("id").where("id = 1").get("id"));
    }

    @Test
    public void testIsInstanceOfCollectInstanceOfTable() {
        Table testTable = OReM.searchTable("test").get();
        Table testTable2 = OReM.searchTable("test2").get();
        assertTrue(testTable instanceof TestTable);
        assertTrue(testTable2 instanceof TestTable2);
    }

    @Test
    public void testAutoRegister() {
        assertNotEquals(null, OReM.searchTable("test"));
    }

    @Test
    public void testNotExistTableShouldReturnEmptyOptional() {
        Optional<Table> empty = Optional.empty();
        assertEquals(empty, OReM.searchTable("notExist"));
    }

    @Test
    public void testNotCollectTableClassShouldReturnEmptyOptional() {
        Optional<Table> empty = Optional.empty();
        assertEquals(empty, OReM.searchTable("dummy"));
    }
}
