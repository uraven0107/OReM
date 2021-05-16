import static org.junit.jupiter.api.Assertions.*;

import core.OReM;
import object.Table;
import org.junit.jupiter.api.Test;

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
}
