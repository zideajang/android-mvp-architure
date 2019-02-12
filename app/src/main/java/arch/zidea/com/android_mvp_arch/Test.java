package arch.zidea.com.android_mvp_arch;

import java.util.regex.Pattern;

public class Test {

    //[-+]?\d+\.\d+
    public static void main(String[] args) {
        String strOne = "0.01";
        String strTwo = "1.25";
        String strThree = "-1.25";
        String strFive = "null";

        System.out.println(isFloat(strOne));
        System.out.println(isFloat(strTwo));
        System.out.println(isFloat(strThree));
        System.out.println(isFloat(strFive));
    }

    public static boolean isFloat(String str){
        Pattern pattern = Pattern.compile("[-+]?\\d+\\.\\d+");

        return pattern.matcher(str).matches();
    }
}
