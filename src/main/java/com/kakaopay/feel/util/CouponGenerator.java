package com.kakaopay.feel.util;

public class CouponGenerator {

    private static final String couponNum[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };

    public static String execute(String sha) {
        String tmp;
        StringBuffer sb = new StringBuffer();
        String coupon;
        int hex = 0;

        for (int i = 0; i <= sha.length() - 1; ) {
            tmp = sha.substring(i, i + 4);
            hex = Integer.valueOf(tmp, 16);
            hex = hex % 62;
            sb.append(couponNum[hex]);
            i = i + 4;
        }

        coupon = sb.toString();
        return coupon;
    }


}
