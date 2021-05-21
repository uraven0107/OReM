package core;

import object.Table;
import reflection.TableMapResolver;

import java.util.NoSuchElementException;

public class OReM {

    private static final TableMap tableMap;

    static {
        tableMap = new TableMap();
        TableMapResolver resolver = new TableMapResolver();
        resolver.run(tableMap);
    }

    public static Table getTable(String tableName) {
        return tableMap.getTable(tableName).orElseThrow(NoSuchElementException::new);
    }
}
