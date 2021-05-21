package core;

import object.Table;

import java.io.InvalidObjectException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TableMap {

    public Map<String, Table> tableMap;

    public TableMap() {
        this.tableMap = new HashMap<>();
    }

    public void register(String tableName, Table table) {
        this.tableMap.put(tableName, table);
    }

    public Optional<Table> getTable(final String tableName) {
        if (this.tableMap.size() == 0 || !this.tableMap.containsKey(tableName)) {
            return Optional.empty();
        }
        return Optional.of(this.tableMap.get(tableName));
    }
}
