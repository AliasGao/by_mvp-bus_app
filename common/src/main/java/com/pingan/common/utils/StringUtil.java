package com.pingan.common.utils;

public class StringUtil {

    private StringUtil(){}

    public static int getCharCount(String s, char c) {
        int count = 0;
        int i = s.indexOf(c);
        if (i != -1) {
            while (i < s.length()) {
                if (s.charAt(i) == c)
                    count++;
                i++;
            }
        }
        return count;
    }
}
