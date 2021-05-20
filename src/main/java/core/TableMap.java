package core;

import object.Table;

import java.util.HashMap;
import java.util.Map;

public class TableMap {

    public Map<String, Table> tableMap;

    public TableMap() {
        this.tableMap = new HashMap<>();
    }

    public void register(String tableName, Table table) {
        this.tableMap.put(tableName, table);
    }

    public Table getTable(final String tableName) {
        return this.tableMap.get(tableName);
    }
}
