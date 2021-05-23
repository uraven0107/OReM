package com.github.uraven0107;

import com.github.uraven0107.core.TableMap;
import com.github.uraven0107.object.Table;
import com.github.uraven0107.reflection.TableMapResolver;

import java.util.Optional;

public class OReM {
    private static final OReM oReM;
    private final TableMap tableMap;

    static {
        oReM = new OReM();
    }

    private OReM() {
        this.tableMap = new TableMap();
        TableMapResolver resolver = new TableMapResolver();
        resolver.run(tableMap);
    }

    public static Optional<Table> searchTable(String tableName) {
        return oReM.tableMap.getTable(tableName);
    }
}
