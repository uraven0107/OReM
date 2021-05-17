package core;

import object.Table;

import java.util.HashMap;
import java.util.Map;

public class OReM {

    private static final Map<String, Table> tableMap = new HashMap<>();

    static {
        // TODO リフレクションでテーブルを取得できるようにする。
        tableMap.put("test", new Table());
    }

    public static Table getTable(String tableName) {
        return tableMap.get(tableName);
    }
}
