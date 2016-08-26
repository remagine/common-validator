package com.iropke.common.validator;

import java.util.regex.Pattern;

/**
 * @author Arthur
 */
public class ValidatorUtils {

    /**
     * String 최소값 validato, 띄어쓰기 제외
     */
    public static boolean length(String src, int min){
        if (src==null) return false;
        return src.trim().length() >= min;
    }

    /**
     *  String 최소값 최대값 validator, 띄어쓰기 제외
     */
    public static boolean length(String src, int min, int max){
        if (src==null) return false;
        return src.trim().length() >= min && src.trim().length() <= max;
    }

    /**
     * Email 형식 validator
     */
    public static boolean email(String src){
        if (src==null) return false;

        return Pattern.matches(
                "^[a-z0-9A-Z_-]*@[a-z0-9A-Z]*.[a-zA-Z.]*$",
                src);
    }

    /**
     * 일반전화 형식 validator
     */
    public static boolean phone(String src){
        if (src==null) return false;

        return Pattern.matches(
                "^\\d{2,3}\\d{3,4}\\d{4}$",
                src);
    }

    /**
     * 핸드폰 형식 validator
     */
    public static boolean mobile(String src){
        if (src==null) return false;

        return Pattern.matches(
                "^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$",
                src);
    }

    /**
     * 영문(대소문자) 형식 validator, , 띄어쓰기 제외
     */
    public static boolean alpha(String src){
        if (src==null) return false;

        return Pattern.matches(
                "^[a-zA-Z]*$",
                src.trim());
    }

    /**
     * 영문(소문자) 형식 validator, , 띄어쓰기 제외
     */
    public static boolean alphaLower(String src){
        if (src==null) return false;

        return Pattern.matches(
                "^[a-z]*$",
                src.trim());
    }

    /**
     * 영문(대문자) 형식 validator, , 띄어쓰기 제외
     */
    public static boolean alphaUpper(String src){
        if (src==null) return false;

        return Pattern.matches(
                "^[A-Z]*$",
                src.trim());
    }


    /**
     * 영문(대소문자) + 숫자 형식 validator, , 띄어쓰기 제외
     */
    public static boolean alphanum(String src){
        if (src==null) return false;

        return Pattern.matches(
                "^[0-9a-zA-Z]*$",
                src.trim());
    }

    /**
     * 영문(소문자) + 숫자 형식 validator, , 띄어쓰기 제외
     */
    public static boolean alphanumLower(String src){
        if (src==null) return false;

        return Pattern.matches(
                "^[0-9a-z]*$",
                src.trim());
    }

    /**
     * 영문(대문자) + 숫자 형식 validator, , 띄어쓰기 제외
     */
    public static boolean alphanumUpper(String src){
        if (src==null) return false;

        return Pattern.matches(
                "^[0-9A-Z]*$",
                src.trim());
    }

    /**
     *  ID 형식 validator, 영문(대소문자) + 숫자 + "_"
     */
    public static boolean identifier(String src){
        if (src==null) return false;

        return Pattern.matches(
                "^[0-9a-zA-Z_]*$",
                src);
    }

    /**
     *  ID 형식 validator, 영문(소문자) + 숫자 + "_"
     */
    public static boolean identifierLower(String src){
        if (src==null) return false;

        return Pattern.matches(
                "^[0-9a-z_]*$",
                src);
    }

    /**
     *  ID 형식 validator, 영문(대문자) + 숫자 + "_"
     */
    public static boolean identifierUpper(String src){
        if (src==null) return false;

        return Pattern.matches(
                "^[0-9A-Z_]*$",
                src);
    }

    /**
     *  CSS 형식 validator, 영문(대소문자) + 숫자 + "_" + "-"
     */
    public static boolean cssClassName(String src){
        if (src==null) return false;

        return Pattern.matches(
                "^[0-9A-Z_-]*$",
                src);
    }

    /**
     *  숫자 형식 validator, 앞에 0이 붙어도 상관없음(오직 양수만)
     */
    public static boolean number(String src){
        if (src==null) return false;

        return Pattern.matches(
                "^[0-9]*$",
                src);
    }

    /**
     *   정수 숫자 형식 validator, 음수 - 0 - 양수 (단 0으로 시작하는 2자리 이상 수는 false)
     */
    public static boolean integerNumber(String src){
        if (src==null) return false;

        return Pattern.matches(
                "^[-]?(0|[1-9][0-9]*)*$",
                src);
    }

    /**
     *   실수 숫자 형식 validator, 음수 - 0 - 양수 (단 0으로 시작하는 2자리 이상 수는 false, 숫자 자리수 제한 X)
     */
    public static boolean floatNumber(String src){
        if (src==null) return false;

        return Pattern.matches(
                "^[-]?(0|[1-9][0-9]*)(\\.[0-9]+)$",
                src);
    }


    /**
     *   실수 숫자 형식 validator, 음수 - 0 - 양수 (단 0으로 시작하는 2자리 이상 수는 false, 숫자 자리수 제한 있음)
     */
    public static boolean floatNumber(String src, int size){
        if (src==null) return false;
        if (src.length() > size) return false;

        return Pattern.matches(
                "^[-]?(0|[1-9][0-9]*)(\\.[0-9]+)$",
                src);
    }

    /**
     *   우편변호 형식 validator, ###-### 구우편번호 or 5자리 신우편번호
     */
    public static boolean zipcode(String src){
        if (src==null) return false;


        return Pattern.matches(
                "^\\d{3}-\\d{3}|\\d{5}$",
                src);
    }



}
