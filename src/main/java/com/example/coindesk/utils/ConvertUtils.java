package com.example.coindesk.utils;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ConvertUtils {

    public static String convertUtcToTaiwanTime(String utcString) {
        // 輸入字串格式：例如 "Sep 2, 2024 07:07:20 UTC"
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy HH:mm:ss z", Locale.ENGLISH);

        // 解析 UTC 字串
        ZonedDateTime utcTime = ZonedDateTime.parse(utcString, inputFormatter);

        // 轉換成 Asia/Taipei 時區
        ZonedDateTime taiwanTime = utcTime.withZoneSameInstant(ZoneId.of("Asia/Taipei"));

        // 輸出格式
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        // 回傳格式化字串
        return taiwanTime.format(outputFormatter);
    }


}
