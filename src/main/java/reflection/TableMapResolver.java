package reflection;

import object.Table;

import java.util.HashMap;
import java.util.Map;

public class TableMapResolver {
    public TableMapResolver run() {
        return this;
    }

    public Map<String, Table> getMap() {
        return new HashMap<>();
    }
}
