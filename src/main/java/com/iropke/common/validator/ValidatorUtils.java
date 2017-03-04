package com.iropke.common.validator;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Arthur
 */
public class ValidatorUtils {

    /**
     * String 최소값 validator, 앞뒤공백 제거(src.trim())
     */
    public static boolean length(String src, int min) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }
        return src.trim().length() >= min;
    }

    /**
     * String 최소값 최대값 validator, 앞뒤공백 제거(src.trim())
     */
    public static boolean length(String src, int min, int max) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }
        return src.trim().length() >= min && src.trim().length() <= max;
    }

    /**
     * Email 형식 validator
     */
    public static boolean email(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }

        return Pattern.matches("[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+", src);
    }

    /**
     * 일반전화 형식 validator, 0#(#)-###(#)-#### , -포함
     */
    public static boolean phone(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }

        return Pattern.matches("^0\\d{1,2}-\\d{3,4}-\\d{4}$", src);
    }

    /**
     * 핸드폰 형식 validator, 01#-####-#### , -포함
     */
    public static boolean mobile(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }

        return Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", src);
    }

    /**
     * 영문(대소문자) 형식 validator, 공백문자불가 , 앞뒤공백 제거(src.trim())
     */
    public static boolean alpha(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }

        return Pattern.matches("^[a-zA-Z]+$", src.trim());
    }

    /**
     * 영문(소문자) 형식 validator, 공백문자불가 , 앞뒤공백 제거(src.trim())
     */
    public static boolean alphaLower(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }

        return Pattern.matches("^[a-z]+$", src.trim());
    }

    /**
     * 영문(대문자) 형식 validator, 공백문자불가 , 앞뒤공백 제거(src.trim())
     */
    public static boolean alphaUpper(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }

        return Pattern.matches("^[A-Z]+$", src.trim());
    }

    /**
     * 영문(대소문자) + 숫자 형식 validator, 공백문자불가 , 앞뒤공백 제거(src.trim())
     */
    public static boolean alphanum(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }

        return Pattern.matches("^[0-9a-zA-Z]+$", src.trim());
    }

    /**
     * 영문(소문자) + 숫자 형식 validator, 공백문자불가 , 앞뒤공백 제거(src.trim())
     */
    public static boolean alphanumLower(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }

        return Pattern.matches("^[0-9a-z]+$", src.trim());
    }

    /**
     * 영문(대문자) + 숫자 형식 validator, 공백문자불가 , 앞뒤공백 제거(src.trim())
     */
    public static boolean alphanumUpper(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }

        return Pattern.matches("^[0-9A-Z]+$", src.trim());
    }

    /**
     * ID 형식 validator, 공백문자불가 , 영문(대소문자) + 숫자 + "_" , 앞뒤공백 제거(src.trim())
     */
    public static boolean identifier(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }

        return Pattern.matches("^[0-9a-zA-Z_]+$", src.trim());
    }

    /**
     * ID 소문자 형식 validator, 공백문자불가 , 영문(소문자) + 숫자 + "_" , 앞뒤공백 제거(src.trim())
     */
    public static boolean identifierLower(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }

        return Pattern.matches("^[0-9a-z_]+$", src.trim());
    }

    /**
     * ID 대문자 형식 validator, 공백문자불가 , 영문(대문자) + 숫자 + "_" , 앞뒤공백 제거(src.trim())
     */
    public static boolean identifierUpper(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }

        return Pattern.matches("^[0-9A-Z_]+$", src.trim());
    }

    /**
     * CSS 형식 validator, 공백문자불가 , 숫자시작불가, 영문(대소문자) + 숫자 + "_" + "-" , 앞뒤공백
     * 제거(src.trim())
     */
    public static boolean cssClassName(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }

        return Pattern.matches("^-?[_a-zA-Z]+[_a-zA-Z0-9-]*$", src.trim());
    }

    /**
     * 숫자 형식 validator, 공백문자불가 , 앞에 0이 붙어도 상관없음(오직 양수만) , 앞뒤공백 제거(src.trim())
     */
    public static boolean number(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }

        return Pattern.matches("^[0-9]*$", src.trim());
    }

    /**
     * 정수 숫자 형식 validator, 음수 - 0 - 양수 (단 0으로 시작하는 2자리 이상 수는 false) , 앞뒤공백
     * 제거(src.trim())
     */
    public static boolean integerNumber(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }

        return Pattern.matches("^-?(0|[1-9][0-9]*)*$", src.trim());
    }

    /**
     * 실수 숫자 형식 validator, 음수 - 0 - 양수 (단 0으로 시작하는 2자리 이상 수는 false, 숫자 자리수 제한
     * X), 앞뒤공백 제거(src.trim())
     */
    public static boolean floatNumber(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }

        return Pattern.matches("^-?(0|[1-9][0-9]*)(\\.[0-9]+)$", src.trim());
    }

    /**
     * 실수 숫자 형식 validator, 음수 - 0 - 양수 (단 0으로 시작하는 2자리 이상 수는 false, 숫자 자리수 제한
     * 있음), 앞뒤공백 제거(src.trim())
     */
    public static boolean floatNumber(String src, int size) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }
        if (src.length() > size) {
            return false;
        }

        return Pattern.matches("^[-]?(0|[1-9][0-9]*)(\\.[0-9]+)$", src.trim());
    }

    /**
     * 우편변호 형식 validator, ###-### 구우편번호 or 5자리 신우편번호, 앞뒤공백 제거(src.trim())
     */
    public static boolean zipcode(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }

        return Pattern.matches("^\\d{3}-\\d{3}|\\d{5}$", src.trim());
    }

    /**
     * url 형식 validator, http:// & https:// only , 앞뒤공백 제거(src.trim())
     */
    public static boolean url(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }

        return Pattern.matches("^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$", src.trim());
    }

    /**
     * path 형식 validator, File 경로 확인 (D:\directoryname\testing\text.txt
     * ,\john-desktop\tempdir\ssh.ppk) , 앞뒤공백 제거(src.trim())
     */
    public static boolean path(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }

        return Pattern.matches("^(([a-zA-Z]:)|((\\\\|/){1,2}\\w+)\\$?)((\\\\|/)(\\w[\\w ]*.*))+\\.([a-zA-Z0-9]*)$", src.trim());
    }

    /**
     * path 형식 validator, File 경로 확인 , 주어진 확장자의 파일인지 확인 , 앞뒤공백 제거(src.trim())
     */
    public static boolean path(String src, String... extensions) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }
        if (extensions == null || extensions.length == 0) {
            return false;
        }

        String str = "";
        String item = "";
        str = "^(([a-zA-Z]:)|((\\\\|/){1,2}\\w+)\\$?)((\\\\|/)(\\w[\\w ]*.*))+\\.(";
        for (int i = 0; i < extensions.length; i++) {
            item = extensions[i];
            str += item;
            str += "|";
            if (i == extensions.length - 1) {
                str += ")$";
            }
        }

        return Pattern.matches(str, src);
    }

    /**
     * imagePath 형식 validator, image File 경로 확인 (jpeg,jpg,gif,png) , 앞뒤공백
     * 제거(src.trim())
     */
    public static boolean imagePath(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }

        return Pattern.matches("(?:([^:/?#]+):)?(?://([^/?#]*))?([^?#]*\\.(?:jpe?g|gif|png))(?:\\?([^#]*))?(?:#(.*))?", src.trim());
    }

}
