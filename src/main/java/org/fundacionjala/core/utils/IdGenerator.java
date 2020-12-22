package org.fundacionjala.core.utils;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class IdGenerator {

    static DateFormat hora;
    static Date date ;

    private IdGenerator() {
    }

    /**
     * Utility method that generates an unique id.
     * @return UniqueId
     */
    public static String getUniqueId() {
        hora = new SimpleDateFormat("HHmmss");
        date = new Date();
        return hora.format(date);
    }
}
