package com.example.fmgordillo.clases.resources;

/**
 * Created by famargor on 10/11/16.
 * <p>
 * COMMENT:
 * I will use the most well-known errors from SQLite for our app
 */

public enum DBErrors {
    SQLITE_OK(0, "Successful result"),
    SQLITE_ERROR(1, "SQL error or missing database"),
    SQLITE_INTERNAL(2, "Internal logic error in SQLite"),
    SQLITE_PERM(3, "Access permission denied"),
    SQLITE_ABORT(4, "Callback routine requested an abort"),
    SQLITE_FULL(13, "Insertion failed because database is full"),
    SQLITE_EMPTY(16, "Database is empty"),
    SQLITE_MISMATCH(20, "Data type mismatch"),

    USUARIOS_CODIGO_VACIO(100, "Empty values are not allowed in CODE");

    private final long number;
    private final String result;

    DBErrors(long number, String result) {
        this.number = number;
        this.result = result;
    }

    public static String getResultTxyByNumber(long number) {
        String finalResult = "Undefined error";
        for (DBErrors err : DBErrors.values()) {
            if (err.getResultNumber() == number) {
                finalResult = err.getResultTxt();
            }
        }
        return finalResult;
    }

    public String getResultTxt() {
        return result;
    }

    public long getResultNumber() {
        return number;
    }
}
