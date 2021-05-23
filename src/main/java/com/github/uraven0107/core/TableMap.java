package com.github.uraven0107.core;

import com.github.uraven0107.object.Table;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class TableMap {

    private final Map<String, Table> tableMap;

    public TableMap() {
        this.tableMap = new HashMap<>();
    }

    public void register(String tableName, Table table) {
        this.tableMap.put(tableName, table);
    }

    public Optional<Table> getTable(final String tableName) {
        return checkMap(map -> map.size() == 0
                || !map.containsKey(tableName)
                || Objects.isNull(tableMap.get(tableName)))
                ? Optional.empty()
                : Optional.of(tableMap.get(tableName));
    }

    private boolean checkMap(Predicate<Map<String, Table>> predicate) {
        return predicate.test(tableMap);
    }
}
