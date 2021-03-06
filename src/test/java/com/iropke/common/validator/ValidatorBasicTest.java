package com.iropke.common.validator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by purple on 16. 8. 26.
 */
public class ValidatorBasicTest {

    @Test
    public void testLengthMin() {
        Assert.assertTrue("min length is 3", ValidatorUtils.length("sss", 3));
        Assert.assertTrue("min length is 3", ValidatorUtils.length("sss     ", 3));
        Assert.assertTrue("min length is 3", ValidatorUtils.length("s s s     ", 3));
        Assert.assertFalse("min length is 3 fail", ValidatorUtils.length("ss", 3));
        Assert.assertFalse("min length is 3 fail", ValidatorUtils.length("ss    ", 3));
        Assert.assertFalse("min length is 3 fail", ValidatorUtils.length("     ", 3));
    }

    @Test
    public void testLengthMinMax() {
        Assert.assertTrue("min length is 3 max length is 10", ValidatorUtils.length("sss", 3, 10));
        Assert.assertTrue("min length is 3 max length is 10", ValidatorUtils.length("sss     ", 3, 10));
        Assert.assertTrue("min length is 3 max length is 10", ValidatorUtils.length("1234567890", 3, 10));
        Assert.assertTrue("min length is 3 max length is 10", ValidatorUtils.length("1234567890      ", 3, 10));
        Assert.assertTrue("min length is 3 max length is 10", ValidatorUtils.length("14 5 6 790      ", 3, 10));
        Assert.assertFalse("min length is 3 max length is 10 fail", ValidatorUtils.length("ss", 3, 10));
        Assert.assertFalse("min length is 3 max length is 10 fail", ValidatorUtils.length("12345678901", 3, 10));
        Assert.assertFalse("min length is 3 max length is 10 fail", ValidatorUtils.length("     ", 3, 10));
    }

    @Test
    public void testEmail() {
        Assert.assertTrue("email is remagine@naver.com", ValidatorUtils.email("remagine@naver.com"));
        Assert.assertTrue("email is remagine@naver.co.kr", ValidatorUtils.email("remagine@naver.co.kr"));
        Assert.assertTrue("email is 0remagine@naver.co.kr", ValidatorUtils.email("0remagine@naver.co.kr"));
        Assert.assertTrue("email is -_0remagine@naver.co.kr", ValidatorUtils.email("-_0remagine@naver.co.kr"));
        Assert.assertFalse("email is @_0remagine@naver.co.kr", ValidatorUtils.email("@_0remagine@naver.co.kr"));
        Assert.assertFalse("email is _0rem@agine@naver.co.kr", ValidatorUtils.email("_0rem@agine@naver.co.kr"));
        Assert.assertFalse("email is _0remaginenaver.co.kr", ValidatorUtils.email("_0remaginenaver.co.kr"));
    }

    @Test
    public void testPhone() {
        Assert.assertTrue("phone is 02-123-1234", ValidatorUtils.phone("02-123-1234"));
        Assert.assertTrue("phone is 02-1231-1234", ValidatorUtils.phone("02-1231-1234"));
        Assert.assertTrue("phone is 023-123-1234", ValidatorUtils.phone("023-123-1234"));
        Assert.assertTrue("phone is 023-1233-1234", ValidatorUtils.phone("023-1233-1234"));
        Assert.assertFalse("phone is 0231-1233-1234", ValidatorUtils.phone("0231-1233-1234"));
        Assert.assertFalse("phone is 231-1233-1234", ValidatorUtils.phone("231-1233-1234"));
        Assert.assertFalse("phone is 023-12331-1234", ValidatorUtils.phone("023-12331-1234"));
        Assert.assertFalse("phone is 023-1233-12341", ValidatorUtils.phone("023-1233-12341"));
        Assert.assertFalse("phone is 02312332341", ValidatorUtils.phone("02312332341"));
        Assert.assertFalse("phone is 023-12-3-1234", ValidatorUtils.phone("023-12-3-1234"));
    }

    @Test
    public void testMobile() {
        Assert.assertTrue("mobile is 010-123-1234", ValidatorUtils.mobile("010-123-1234"));
        Assert.assertTrue("mobile is 010-1231-1234", ValidatorUtils.mobile("010-1231-1234"));
        Assert.assertTrue("mobile is 011-1231-1234", ValidatorUtils.mobile("011-1231-1234"));
        Assert.assertTrue("mobile is 016-1231-1234", ValidatorUtils.mobile("016-1231-1234"));
        Assert.assertTrue("mobile is 017-1231-1234", ValidatorUtils.mobile("017-1231-1234"));
        Assert.assertTrue("mobile is 018-1231-1234", ValidatorUtils.mobile("018-1231-1234"));
        Assert.assertTrue("mobile is 019-1231-1234", ValidatorUtils.mobile("019-1231-1234"));
        Assert.assertFalse("mobile is 110-1231-1234", ValidatorUtils.mobile("110-1231-1234"));
        Assert.assertFalse("mobile is 01-1231-1234", ValidatorUtils.mobile("01-1231-1234"));
        Assert.assertFalse("mobile is 010-12311-1234", ValidatorUtils.mobile("010-12311-1234"));
        Assert.assertFalse("mobile is 010-1231-12341", ValidatorUtils.mobile("010-1231-12341"));
        Assert.assertFalse("mobile is 013-1231-1234", ValidatorUtils.mobile("013-1231-1234"));
        Assert.assertFalse("mobile is 01012311234", ValidatorUtils.mobile("01012311234"));
        Assert.assertFalse("mobile is 0 10-1231-1234", ValidatorUtils.mobile("0 10-1231-1234"));
        Assert.assertFalse("mobile is 010-1 231-1234", ValidatorUtils.mobile("010-1 231-1234"));
        Assert.assertFalse("mobile is 010-1231-1 234", ValidatorUtils.mobile("010-1231-1 234"));
        Assert.assertFalse("mobile is 010-12-31-1234", ValidatorUtils.mobile("010-12-31-1234"));
    }

    @Test
    public void testAlpha() {
        Assert.assertTrue("alpha is aAbBcCdD", ValidatorUtils.alpha("aAbBcCdD"));
        Assert.assertTrue("alpha is aAbBcCdDzZ", ValidatorUtils.alpha("aAbBcCdDzZ"));
        Assert.assertTrue("alpha is     aAbBcCdDzZ", ValidatorUtils.alpha("   aAbBcCdDzZ"));
        Assert.assertTrue("alpha is     aAbBcCdDzZ      ", ValidatorUtils.alpha("   aAbBcCdDzZ      "));
        Assert.assertFalse("alpha is aA bBc CdD", ValidatorUtils.alpha("aA bBc CdD"));
        Assert.assertFalse("alpha is 1aAbBcCdD", ValidatorUtils.alpha("1aAbBcCdD"));
        Assert.assertFalse("alpha is aAbBcCdD!", ValidatorUtils.alpha("aAbBcCdD!"));
        Assert.assertFalse("alpha is aAbBcCdDㄱ", ValidatorUtils.alpha("1aAbBcCdDㄱ"));
        Assert.assertFalse("alpha is 1aAbB3cCdD", ValidatorUtils.alpha("1aAbB3cCdD"));
        Assert.assertFalse("alpha is 1aAbB3cCdD", ValidatorUtils.alpha(""));
        Assert.assertFalse("alpha is 1aAbB3cCdD", ValidatorUtils.alpha("       "));
    }

    @Test
    public void testAlphaLower() {
        Assert.assertTrue("alphaLower is abcd", ValidatorUtils.alphaLower("abcd"));
        Assert.assertTrue("alphaLower is    abcd", ValidatorUtils.alphaLower("   abcd"));
        Assert.assertTrue("alphaLower is abcd   ", ValidatorUtils.alphaLower("abcd   "));
        Assert.assertTrue("alphaLower is abcdefgz", ValidatorUtils.alphaLower("abcdefgz"));
        Assert.assertTrue("alphaLower is c", ValidatorUtils.alphaLower("c"));
        Assert.assertFalse("alphaLower is abcd efgz", ValidatorUtils.alphaLower("abcd efgz"));
        Assert.assertFalse("alphaLower is abcd3fgz", ValidatorUtils.alphaLower("abcd3fgz"));
        Assert.assertFalse("alphaLower is abcdEfgz", ValidatorUtils.alphaLower("abcdEfgz"));
        Assert.assertFalse("alphaLower is ", ValidatorUtils.alphaLower(""));
        Assert.assertFalse("alphaLower is     ", ValidatorUtils.alphaLower("    "));
        Assert.assertFalse("alphaLower is   asd_df  ", ValidatorUtils.alphaLower(" asd_df   "));
    }

    @Test
    public void testAlphaUpper() {
        Assert.assertTrue("alphaUpper is ABCD", ValidatorUtils.alphaUpper("ABCD"));
        Assert.assertTrue("alphaUpper is ABCDEFGZ", ValidatorUtils.alphaUpper("ABCDEFGZ"));
        Assert.assertTrue("alphaUpper is ABCDEFGZ     ", ValidatorUtils.alphaUpper("ABCDEFGZ       "));
        Assert.assertTrue("alphaUpper is      ABCDEFGZ", ValidatorUtils.alphaUpper("       ABCDEFGZ"));
        Assert.assertFalse("alphaUpper is ABCD EFGZ", ValidatorUtils.alphaUpper("ABCD EFGZ"));
        Assert.assertFalse("alphaUpper is ABCD3EFGZ", ValidatorUtils.alphaUpper("ABCD3EFGZ"));
        Assert.assertFalse("alphaUpper is ABCD!EFGZ", ValidatorUtils.alphaUpper("ABCD!EFGZ"));
        Assert.assertFalse("alphaUpper is ABCDhEFGZ", ValidatorUtils.alphaUpper("ABCDhEFGZ"));
        Assert.assertFalse("alphaUpper is ABCD3EFGZ", ValidatorUtils.alphaUpper("ABCD_EFGZ"));
        Assert.assertFalse("alphaUpper is ", ValidatorUtils.alphaUpper(""));
        Assert.assertFalse("alphaUpper is    ", ValidatorUtils.alphaUpper("  "));
    }

    @Test
    public void testAlphanum() {
        Assert.assertTrue("alphanum is ABCD", ValidatorUtils.alphanum("ABCD"));
        Assert.assertTrue("alphanum is 1234", ValidatorUtils.alphanum("1234"));
        Assert.assertTrue("alphanum is asdf", ValidatorUtils.alphanum("asdf"));
        Assert.assertTrue("alphanum is AaBbCcDd", ValidatorUtils.alphanum("AaBbCcDd"));
        Assert.assertTrue("alphanum is ABCD1234", ValidatorUtils.alphanum("ABCD1234"));
        Assert.assertTrue("alphanum is AaBbCcDd1234", ValidatorUtils.alphanum("AaBbCcDd1234"));
        Assert.assertTrue("alphanum is      AaBbCcDd1234     ", ValidatorUtils.alphanum("    AaBbCcDd1234      "));
        Assert.assertFalse("alphanum is AB CD", ValidatorUtils.alphanum("AB CD"));
        Assert.assertFalse("alphanum is ab cd", ValidatorUtils.alphanum("ab cd"));
        Assert.assertFalse("alphanum is ABCDㄱ", ValidatorUtils.alphanum("ABCDㄱ"));
        Assert.assertFalse("alphanum is AB CD", ValidatorUtils.alphanum("AB CD"));
    }

    @Test
    public void testAlphanumLower() {
        Assert.assertTrue("alphanumLower is abcd", ValidatorUtils.alphanumLower("abcd"));
        Assert.assertTrue("alphanumLower is 1234", ValidatorUtils.alphanumLower("1234"));
        Assert.assertTrue("alphanumLower is asdf1234", ValidatorUtils.alphanumLower("asdf1234"));
        Assert.assertTrue("alphanumLower is    asdf1234   ", ValidatorUtils.alphanumLower("   asdf1234   "));
        Assert.assertFalse("alphanumLower is AaBbCcDd", ValidatorUtils.alphanumLower("AaBbCcDd"));
        Assert.assertFalse("alphanumLower is ABCD1234", ValidatorUtils.alphanumLower("ABCD1234"));
        Assert.assertFalse("alphanumLower is AaBbCcDd1234", ValidatorUtils.alphanumLower("AaBbCcDd1234"));
        Assert.assertFalse("alphanumLower is      AaBbCcDd1234     ", ValidatorUtils.alphanumLower("    AaBbCcDd1234      "));
        Assert.assertFalse("alphanumLower is AB CD", ValidatorUtils.alphanumLower("AB CD"));
        Assert.assertFalse("alphanumLower is ab cd", ValidatorUtils.alphanumLower("ab cd"));
        Assert.assertFalse("alphanumLower is ABCDㄱ", ValidatorUtils.alphanumLower("ABCDㄱ"));
        Assert.assertFalse("alphanumLower is AB CD", ValidatorUtils.alphanumLower("ABCD"));
    }

    @Test
    public void testAlphanumUpper() {
        Assert.assertTrue("alphanumUpper is ABCD", ValidatorUtils.alphanumUpper("ABCD"));
        Assert.assertTrue("alphanumUpper is 1234", ValidatorUtils.alphanumUpper("1234"));
        Assert.assertTrue("alphanumUpper is ABCD1234", ValidatorUtils.alphanumUpper("ABCD1234"));
        Assert.assertTrue("alphanumUpper is    ABCD1234   ", ValidatorUtils.alphanumUpper("   ABCD1234   "));
        Assert.assertFalse("alphanumUpper is AaBbCcDd", ValidatorUtils.alphanumUpper("AaBbCcDd"));
        Assert.assertFalse("alphanumUpper is ~ABCD1234", ValidatorUtils.alphanumUpper("~ABCD1234"));
        Assert.assertFalse("alphanumUpper is AaBbCcDd1234", ValidatorUtils.alphanumUpper("AaBbCcDd1234"));
        Assert.assertFalse("alphanumUpper is      AaBbCcDd1234     ", ValidatorUtils.alphanumUpper("    AaBbCcDd1234      "));
        Assert.assertFalse("alphanumUpper is AB CD", ValidatorUtils.alphanumUpper("AB CD"));
        Assert.assertFalse("alphanumUpper is ab cd", ValidatorUtils.alphanumUpper("ab cd"));
        Assert.assertFalse("alphanumUpper is ABCDㄱ", ValidatorUtils.alphanumUpper("ABCDㄱ"));
        Assert.assertFalse("alphanumUpper is AB CD", ValidatorUtils.alphanumUpper("AB CD"));
    }

    @Test
    public void testIdentifier() {
        Assert.assertTrue("identifier is abcd", ValidatorUtils.identifier("abcde"));
        Assert.assertTrue("identifier is 1234", ValidatorUtils.identifier("12345"));
        Assert.assertTrue("identifier is asdf1234", ValidatorUtils.identifier("asdf1234"));
        Assert.assertTrue("identifier is    asdf1234   ", ValidatorUtils.identifier("   asdf1234   "));
        Assert.assertTrue("identifier is    asdfABCD1234   ", ValidatorUtils.identifier("   asdfABCD1234   "));
        Assert.assertTrue("identifier is    asdfABC_D123_4   ", ValidatorUtils.identifier("   asdfABC_D123_4   "));
        Assert.assertFalse("identifier is AaBb?CcDd", ValidatorUtils.identifier("AaBb?CcDd"));
        Assert.assertFalse("identifier is ABCD@1234", ValidatorUtils.identifier("ABCD@1234"));
        Assert.assertFalse("identifier is AaBbCcDd1234-", ValidatorUtils.identifier("AaBbCcDd1234-"));
        Assert.assertFalse("identifier is AB CD", ValidatorUtils.identifier("AB CD"));
        Assert.assertFalse("identifier is ab cd", ValidatorUtils.identifier("ab cd"));
        Assert.assertFalse("identifier is ABCDㄱ", ValidatorUtils.identifier("ABCDㄱ"));
    }

    @Test
    public void testidentifierLower() {
        Assert.assertTrue("identifierLower is abcde", ValidatorUtils.identifierLower("abcde"));
        Assert.assertTrue("identifierLower is 1234", ValidatorUtils.identifierLower("12345"));
        Assert.assertTrue("identifierLower is asdf1234", ValidatorUtils.identifierLower("asdf1234"));
        Assert.assertTrue("identifierLower is    asdf1234   ", ValidatorUtils.identifierLower("   asdf1234   "));
        Assert.assertTrue("identifierLower is    asdf_a123_4   ", ValidatorUtils.identifierLower("   asdf_a123_4   "));
        Assert.assertFalse("identifierLower is ab?cd", ValidatorUtils.identifierLower("ab?cd"));
        Assert.assertFalse("identifierLower is abcd@1234", ValidatorUtils.identifierLower("abcd@1234"));
        Assert.assertFalse("identifierLower is AaBbCcDd1234-", ValidatorUtils.identifierLower("AaBbCcDd1234-"));
        Assert.assertFalse("identifierLower is AaBbCcDd12345678", ValidatorUtils.identifierLower("AaBbCcDd12345678"));
        Assert.assertFalse("identifierLower is ABCD", ValidatorUtils.identifierLower("ABCD"));
        Assert.assertFalse("identifierLower is ab cd", ValidatorUtils.identifierLower("ab cd"));
        Assert.assertFalse("identifierLower is abcdㄱ", ValidatorUtils.identifierLower("abcdㄱ"));
        Assert.assertFalse("identifierLower is ab cd", ValidatorUtils.identifierLower("ab cd"));
    }

    @Test
    public void testIdentifierUpper() {
        Assert.assertTrue("identifierUpper is ABCDE", ValidatorUtils.identifierUpper("ABCDE"));
        Assert.assertTrue("identifierUpper is 12345", ValidatorUtils.identifierUpper("12345"));
        Assert.assertTrue("identifierUpper is ASDF1234", ValidatorUtils.identifierUpper("ASDF1234"));
        Assert.assertTrue("identifierUpper is    ASDF1234   ", ValidatorUtils.identifierUpper("   ASDF1234   "));
        Assert.assertTrue("identifierUpper is    _A_BCD1234   ", ValidatorUtils.identifierUpper("   _A_BCD1234   "));
        Assert.assertTrue("identifierUpper is    ABC_D123_4   ", ValidatorUtils.identifierUpper("   ABC_D123_4   "));
        Assert.assertFalse("identifierUpper is AaBb?CcDd", ValidatorUtils.identifierUpper("AaBb?CcDd"));
        Assert.assertFalse("identifierUpper is ABCD@1234", ValidatorUtils.identifierUpper("ABCD@1234"));
        Assert.assertFalse("identifierUpper is AaBbCcDd1234-", ValidatorUtils.identifierUpper("AaBbCcDd1234-"));
        Assert.assertFalse("identifierUpper is AaBbCcDd12345678", ValidatorUtils.identifierUpper("AaBbCcDd12345678"));
        Assert.assertFalse("identifierUpper is AB CD", ValidatorUtils.identifierUpper("AB CD"));
        Assert.assertFalse("identifierUpper is ab cd", ValidatorUtils.identifierUpper("ab cd"));
        Assert.assertFalse("identifierUpper is ABCDㄱ", ValidatorUtils.identifierUpper("ABCDㄱ"));
        Assert.assertFalse("identifierUpper is abcd", ValidatorUtils.identifierUpper("abcd"));
    }

    @Test
    public void testCssClassName() {
        Assert.assertTrue("cssClassName is exp-tbl-h", ValidatorUtils.cssClassName("exp-tbl-h"));
        Assert.assertTrue("cssClassName is exp-tbl-h", ValidatorUtils.cssClassName("EXP-TBL-H"));
        Assert.assertTrue("cssClassName is exp-tbl-cont", ValidatorUtils.cssClassName("exp-tbl-cont"));
        Assert.assertTrue("cssClassName is apply_btn", ValidatorUtils.cssClassName("apply_btn"));
        Assert.assertTrue("cssClassName is    APPLY-BTN   ", ValidatorUtils.cssClassName("   APPLY-BTN   "));
        Assert.assertTrue("cssClassName is    _a_bcd1234   ", ValidatorUtils.cssClassName("   a_bcd1234   "));
        Assert.assertFalse("cssClassName is    selectbox select-layer   ", ValidatorUtils.cssClassName("   selectbox select-layer   "));
        Assert.assertFalse("cssClassName is 1exp-tbl-h", ValidatorUtils.cssClassName("1exp-tbl-h"));
        Assert.assertFalse("cssClassName is ?exp-tbl-h", ValidatorUtils.cssClassName("?exp-tbl-h"));
        Assert.assertFalse("cssClassName is exp-t bl-h", ValidatorUtils.cssClassName("exp-t bl-h"));
        Assert.assertFalse("cssClassName is exp-tbl-h$", ValidatorUtils.cssClassName("exp-tbl-h$"));
    }

    @Test
    public void testNumber() {
        Assert.assertTrue("number is 0123456789", ValidatorUtils.number("0123456789"));
        Assert.assertTrue("number is 1234567890", ValidatorUtils.number("1234567890"));
        Assert.assertTrue("number is    1234567890", ValidatorUtils.number("   1234567890"));
        Assert.assertTrue("number is    1234567890    ", ValidatorUtils.number("   1234567890   "));
        Assert.assertFalse("number is 123 4567890", ValidatorUtils.number("123 4567890"));
        Assert.assertFalse("number is 123.4567890", ValidatorUtils.number("123.4567890"));
        Assert.assertFalse("number is +1234567890", ValidatorUtils.number("+1234567890"));
        Assert.assertFalse("number is -1234567890", ValidatorUtils.number("-1234567890"));
        Assert.assertFalse("number is 1234567890$", ValidatorUtils.number("1234567890$"));
    }

    @Test
    public void testIntegerNumber() {
        Assert.assertTrue("integerNumber is -123456789", ValidatorUtils.integerNumber("-123456789"));
        Assert.assertTrue("integerNumber is 1234567890", ValidatorUtils.integerNumber("1234567890"));
        Assert.assertTrue("integerNumber is    1234567890", ValidatorUtils.integerNumber("   1234567890"));
        Assert.assertTrue("integerNumber is    1234567890    ", ValidatorUtils.integerNumber("   1234567890   "));
        Assert.assertTrue("integerNumber is 0", ValidatorUtils.integerNumber("0"));
        Assert.assertTrue("integerNumber is -0", ValidatorUtils.integerNumber("-0"));
        Assert.assertFalse("integerNumber is 123 4567890", ValidatorUtils.integerNumber("123 4567890"));
        Assert.assertFalse("integerNumber is 123.4567890", ValidatorUtils.integerNumber("123.4567890"));
        Assert.assertFalse("integerNumber is +1234567890", ValidatorUtils.integerNumber("+1234567890"));
        Assert.assertFalse("integerNumber is --1234567890", ValidatorUtils.integerNumber("--1234567890"));
        Assert.assertFalse("integerNumber is 1234567890$", ValidatorUtils.integerNumber("1234567890$"));
    }

    @Test
    public void testFloatNumber() {
        Assert.assertTrue("floatNumber is -123456789.0", ValidatorUtils.floatNumber("-123456789.0"));
        Assert.assertTrue("floatNumber is 1234567890.0", ValidatorUtils.floatNumber("1234567890.0"));
        Assert.assertTrue("floatNumber is 1234567890.0234", ValidatorUtils.floatNumber("1234567890.0234"));
        Assert.assertTrue("floatNumber is 1234567890.000000", ValidatorUtils.floatNumber("1234567890.000000"));
        Assert.assertTrue("floatNumber is 1234567890.0", ValidatorUtils.floatNumber("1234567890.00012"));
        Assert.assertTrue("floatNumber is    1234567890.0", ValidatorUtils.floatNumber("   1234567890.0"));
        Assert.assertTrue("floatNumber is    1234567890.0    ", ValidatorUtils.floatNumber("   1234567890.0   "));
        Assert.assertTrue("floatNumber is 0.0", ValidatorUtils.floatNumber("0.0"));
        Assert.assertTrue("floatNumber is -0.0", ValidatorUtils.floatNumber("-0.0"));
        Assert.assertFalse("floatNumber is 123 4567890", ValidatorUtils.floatNumber("123 4567890.0"));
        Assert.assertFalse("floatNumber is 123.4567890", ValidatorUtils.floatNumber("123.4567890.0"));
        Assert.assertFalse("floatNumber is +1234567890", ValidatorUtils.floatNumber("+1234567890.0"));
        Assert.assertFalse("floatNumber is --1234567890", ValidatorUtils.floatNumber("--1234567890.0"));
        Assert.assertFalse("floatNumber is 1234567890$", ValidatorUtils.floatNumber("1234567890$.0"));
    }

    @Test
    public void testFloatNumberSize() {
        Assert.assertTrue("floatNumber is -123456789.0 size", ValidatorUtils.floatNumber("-123456789.0", 12));
        Assert.assertTrue("floatNumber is 1234567890.0", ValidatorUtils.floatNumber("1234567890.0", 12));
        Assert.assertTrue("floatNumber is 1234567890.0234", ValidatorUtils.floatNumber("1234567890.0234", 20));
        Assert.assertTrue("floatNumber is 1234567890.000000", ValidatorUtils.floatNumber("1234567890.000000", 20));
        Assert.assertTrue("floatNumber is 1234567890.0", ValidatorUtils.floatNumber("1234567890.00012", 20));
        Assert.assertTrue("floatNumber is    1234567890.0", ValidatorUtils.floatNumber("   1234567890.0", 20));
        Assert.assertTrue("floatNumber is    1234567890.0    ", ValidatorUtils.floatNumber("   1234567890.0   ", 20));
        Assert.assertTrue("floatNumber is 0.0", ValidatorUtils.floatNumber("0.0", 3));
        Assert.assertTrue("floatNumber is -0.0", ValidatorUtils.floatNumber("-0.0", 4));
        Assert.assertFalse("floatNumber is 123 4567890", ValidatorUtils.floatNumber("123 4567890.0", 20));
        Assert.assertFalse("floatNumber is 123.4567890.0", ValidatorUtils.floatNumber("123.45678900.0", 20));
        Assert.assertFalse("floatNumber is 123.4567890", ValidatorUtils.floatNumber("123.45678900", 10));
        Assert.assertFalse("floatNumber is +1234567890", ValidatorUtils.floatNumber("+1234567890.0", 20));
        Assert.assertFalse("floatNumber is --1234567890", ValidatorUtils.floatNumber("--1234567890.0", 20));
        Assert.assertFalse("floatNumber is 1234567890$", ValidatorUtils.floatNumber("1234567890$.0", 20));
    }

    @Test
    public void testZipCode() {
        Assert.assertTrue("zipcode is 03123", ValidatorUtils.zipcode("03123"));
        Assert.assertTrue("zipcode is 138-225", ValidatorUtils.zipcode("138-225"));
        Assert.assertTrue("zipcode is    12345", ValidatorUtils.zipcode("   12345"));
        Assert.assertTrue("zipcode is    123-345    ", ValidatorUtils.zipcode("   123-345   "));
        Assert.assertFalse("zipcode is 013123", ValidatorUtils.zipcode("013123"));
        Assert.assertFalse("zipcode is asdfg", ValidatorUtils.zipcode("asdfg"));
        Assert.assertFalse("zipcode is a38-225", ValidatorUtils.zipcode("a38-225"));
        Assert.assertFalse("zipcode is 1138-225", ValidatorUtils.zipcode("1138-225"));
        Assert.assertFalse("zipcode is    1234 5", ValidatorUtils.zipcode("   1234 5"));
        Assert.assertFalse("zipcode is    123_345    ", ValidatorUtils.zipcode("   123_345   "));

    }

    @Test
    public void testUrl() {
        Assert.assertTrue("url is https://calendar.google.com/calendar/render#main_7", ValidatorUtils.url("https://calendar.google.com/calendar/render#main_7"));
        Assert.assertTrue("url is http://calendar.google.com/calendar/render#main_7", ValidatorUtils.url("http://calendar.google.com/calendar/render#main_7"));
        Assert.assertTrue("url is    https://calendar.google.com/calendar/render#main_7", ValidatorUtils.url("   https://calendar.google.com/calendar/render#main_7"));
        Assert.assertTrue("url is    http://calendar.google.com/calendar/render#main_7    ", ValidatorUtils.url("   http://calendar.google.com/calendar/render#main_7   "));
        Assert.assertFalse("url is https://calendar. google.com/calendar/render#main_7", ValidatorUtils.url("https://calendar. google.com/calendar/render#main_7"));
        Assert.assertFalse("url is https://calendar..google.com/calendar/render#main_7", ValidatorUtils.url("https://calendar..google.com/calendar/render#main_7"));
        Assert.assertFalse("url is fps://calendar..google.com/calendar/render#main_7", ValidatorUtils.url("ftp://calendar.google.com/calendar/render#main_7"));
        Assert.assertFalse("url is http:///calendar..google.com/calendar/render#main_7", ValidatorUtils.url("http:///calendar.google.com/calendar/render#main_7"));
        Assert.assertFalse("url is calendar..google.com/calendar/render#main_7", ValidatorUtils.url("calendar.google.com/calendar/render#main_7"));
    }

    @Test
    public void testPath() {
        Assert.assertTrue("path is d:/user/user.ryhtm", ValidatorUtils.path("d:/user/user.ryhtm"));
        Assert.assertTrue("path is d:/user/user.html", ValidatorUtils.path("d:/user/user.html"));
        Assert.assertTrue("path is d:\\user\\user.jsp", ValidatorUtils.path("d:\\user\\user.jsp"));
        Assert.assertTrue("path is \\user\\user.jsp", ValidatorUtils.path("\\user\\user.jsp"));
        Assert.assertTrue("path is /user/user/js.js", ValidatorUtils.path("/user/user/js.js"));
        Assert.assertFalse("path is    C:\folder\test.txt.txt\testing  ", ValidatorUtils.path("   C:\folder\test.txt.txt\testing   "));
        Assert.assertFalse("path is d:\\", ValidatorUtils.path("d:\\"));
        Assert.assertFalse("path is d:/", ValidatorUtils.path("d:/"));
        Assert.assertFalse("path is d:\\,", ValidatorUtils.path("d:\\,"));
        Assert.assertFalse("path is d:///", ValidatorUtils.path("d:///"));
        Assert.assertFalse("path is $:/user/user.html", ValidatorUtils.path("$:/user/user.html"));
        Assert.assertFalse("path is d::\\user\\user.jsp", ValidatorUtils.path("d::\\user\\user.jsp"));
        Assert.assertFalse("path is    ~C:\folder\test.txt.txt\testing  ", ValidatorUtils.path("   ~C:\folder\test.txt.txt\testing   "));
        Assert.assertFalse("path is /user|user/js.js", ValidatorUtils.path("/user|user/js.js"));
    }

    @Test
    public void testPathExtensions() {
        Assert.assertTrue("path is d:/user/user.rythm", ValidatorUtils.path("d:/user/user.rythm", "rythm"));
        Assert.assertTrue("path is d:/user/user.html", ValidatorUtils.path("d:/user/user.html", "html"));
        Assert.assertTrue("path is d:\\user\\user.jsp", ValidatorUtils.path("d:\\user\\user.jsp", "jsp"));
        Assert.assertTrue("path is \\user\\user.jsp", ValidatorUtils.path("\\user\\user.jsp", "js", "jsp"));
        Assert.assertTrue("path is /user/user/js.js", ValidatorUtils.path("/user/user/js.js", "js", "html"));
        Assert.assertFalse("path is d:/user/user.rythm", ValidatorUtils.path("d:/user/user.rythm", "rythms", "1"));
        Assert.assertFalse("path is /user/user/js.js", ValidatorUtils.path("/user/user/js.js", "html"));
        Assert.assertFalse("path is /user/user/js.js", ValidatorUtils.path("/user/user/js.js", "html", "jsp"));
        Assert.assertFalse("path is    C:\folder\test.txt.txt\testing  ", ValidatorUtils.path("   C:\folder\test.txt.txt\testing   ", "js", "html"));
        Assert.assertFalse("path is d:\\", ValidatorUtils.path("d:\\", "jpg", "xml"));
        Assert.assertFalse("path is d:/", ValidatorUtils.path("d:/", "jsp"));
        Assert.assertFalse("path is d:\\,", ValidatorUtils.path("d:\\,", "jsp"));
        Assert.assertFalse("path is d:///", ValidatorUtils.path("d:///", "jsp"));
        Assert.assertFalse("path is $:/user/user.html", ValidatorUtils.path("$:/user/user.html", "jsp"));
        Assert.assertFalse("path is d::\\user\\user.jsp", ValidatorUtils.path("d::\\user\\user.jsp", "jsp"));
        Assert.assertFalse("path is    ~C:\folder\test.txt.txt\testing  ", ValidatorUtils.path("   ~C:\folder\test.txt.txt\testing   ", "jsp"));
        Assert.assertFalse("path is /user|user/js.js", ValidatorUtils.path("/user|user/js.js", "jsp"));
    }

    @Test
    public void testImagePath() {
        Assert.assertTrue("imagePath is d:/user/user.jpeg", ValidatorUtils.imagePath("d:/user/user.jpeg"));
        Assert.assertTrue("imagePath is d:/user/user.jpg", ValidatorUtils.imagePath("d:/user/user.jpg"));
        Assert.assertTrue("imagePath is d:\\user\\user.png", ValidatorUtils.imagePath("d:\\user\\user.png"));
        Assert.assertTrue("imagePath is \\user\\user.gif", ValidatorUtils.imagePath("\\user\\user.gif"));
        Assert.assertTrue("imagePath is /user/user/js.jpg", ValidatorUtils.imagePath("/user/user/js.jpg"));
        Assert.assertTrue("imagePath is https://user\\user.gif", ValidatorUtils.imagePath("https://user\\user.gif"));
        Assert.assertFalse("imagePath is d:/user/user.jpeg", ValidatorUtils.imagePath("d:/user/user.img"));
        Assert.assertFalse("imagePath is d:/user/user.jpg", ValidatorUtils.imagePath("d:/user/user.jsp"));
        Assert.assertFalse("imagePath is d:\\user\\user.png", ValidatorUtils.imagePath("d:\\user\\user.html"));
        Assert.assertFalse("imagePath is \\user\\user.gif", ValidatorUtils.imagePath("\\user\\user.gif2"));
        Assert.assertFalse("imagePath is /user/user/js.jpg", ValidatorUtils.imagePath("/user/user/js.jpg3"));
        Assert.assertFalse("imagePath is https://user\\user.gif", ValidatorUtils.imagePath("https://user\\user.gif&"));
        Assert.assertFalse("imagePath is https://user\\user.gif", ValidatorUtils.imagePath("//user\\user"));

    }

}
