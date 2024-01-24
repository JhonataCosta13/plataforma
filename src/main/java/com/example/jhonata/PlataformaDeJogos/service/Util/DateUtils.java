package com.example.jhonata.PlataformaDeJogos.service.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String getCurrentTime(){
        Date time = new Date(System.currentTimeMillis());
        String formatted = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(time);
        return formatted;
    }
}
