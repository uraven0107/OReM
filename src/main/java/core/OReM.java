package core;

import object.Table;
import reflection.TableMapResolver;

import java.util.NoSuchElementException;

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

    public static Table getTable(String tableName) {
        return oReM.tableMap.getTable(tableName).orElseThrow(NoSuchElementException::new);
    }

    public static void ignoreClasses(String[] classNames) {
    }
}
