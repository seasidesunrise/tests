import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class Num36Util {

    public static void main(String[] argas) throws Exception {
        String a = "0ab";
        String b = "xy0";

        a = "10";
        b = "a0";
        if (a == null || b == null) {
            return;
        }
        int maxLength = Math.max(a.length(), b.length());
        ArrayList<Character> list = new ArrayList<Character>();
        int addTemp = 0;
        for (int i = maxLength - 1; i >= 0; i--) {
            int temp1 = 0, temp2 = 0;
            if (a.length() > i) {
                temp1 = a.charAt(i);
            }
            if (isInt(temp1)) {
                temp1 = temp1 - 48;
            }
            if (isAlphabit(temp1)) {
                temp1 = temp1 - 97 + 10;
            }

            if (b.length() > i) {
                temp2 = b.charAt(i);
            }
            if (isInt(temp2)) {
                temp2 = temp2 - 48;
            }
            if (isAlphabit(temp2)) {
                temp2 = temp2 - 97 + 10;
            }

            int temp = temp1 + temp2 + addTemp;
            if (temp > 35) {
                temp = temp - 35;
                addTemp = 1;
            } else {
                addTemp = 0;
            }
            list.add((char) temp);
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            int value = list.get(i);
            if (value >= 10) {
                value = value + 97 - 10;
            } else {
                value = value + 48;
            }
            System.out.print((char) (value));
        }

    }

//    public static String add36(String a, String b) {
//        if (a == null ) {
//            a = "";
//        }
//        if (b == null) {
//            b = "";
//        }
//
//
//    }

    private static boolean isInt(int value) {
        return value <= 57 && value >= 48;
    }

    private static boolean isAlphabit(int value) {
        return value <= 122 && value >= 97;
    }


}
