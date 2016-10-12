package com.example.fmgordillo.clases.resources;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by famargor on 10/11/16.
 * <p>
 * COMMENT:
 * I will use the most well-known errors from SQLite for our app
 */

public enum DBErrors {
    SQLITE_OK(0L, "Successful result"),
    SQLITE_ERROR(1L, "SQL error or missing database"),
    SQLITE_INTERNAL(2L, "Internal logic error in SQLite"),
    SQLITE_PERM(3L, "Access permission denied"),
    SQLITE_ABORT(4L, "Callback routine requested an abort"),
    SQLITE_FULL(13L, "Insertion failed because database is full"),
    SQLITE_EMPTY(16L, "Database is empty"),
    SQLITE_MISMATCH(20L, "Data type mismatch"),
    USUARIOS_CODIGO_VACIO(100L, "Empty values are not allowed in CODE");

    private final Long number;
    private final String result;

    DBErrors(Long number, String result) {
        this.number = number;
        this.result = result;
    }

    public static String getResultTxyByNumber(Long number) {
        String finalResult = "Undefined error";
        Long correct = 0L;
        Map<Long, String> hi = new HashMap();
        for (DBErrors err : DBErrors.values()) {
            hi.put(err.getResultNumber(), err.getResultTxt());
        }
        if (!(number == correct)) {
            return hi.get(number);
        } else {
            return finalResult;
        }

    }

    public String getResultTxt() {
        return result;
    }

    public long getResultNumber() {
        return number;
    }
}
