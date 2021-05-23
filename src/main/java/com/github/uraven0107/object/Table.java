package com.github.uraven0107.object;

public class Table {

    public Table select(String columnName) {
        return this;
    }

    public Table where(String condition) {
        return this;
    }

    public int get(String columnName) {
        return 1;
    }
}
