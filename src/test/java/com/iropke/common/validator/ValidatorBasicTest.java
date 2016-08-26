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
    public void testEmail(){
        Assert.assertTrue("email is remagine@naver.com" , ValidatorUtils.email("remagine@naver.com"));
        Assert.assertTrue("email is remagine@naver.co.kr" , ValidatorUtils.email("remagine@naver.co.kr"));
        Assert.assertTrue("email is 0remagine@naver.co.kr" , ValidatorUtils.email("0remagine@naver.co.kr"));
        Assert.assertTrue("email is -_0remagine@naver.co.kr" , ValidatorUtils.email("-_0remagine@naver.co.kr"));
        Assert.assertFalse("email is @_0remagine@naver.co.kr" , ValidatorUtils.email("@_0remagine@naver.co.kr"));
        Assert.assertFalse("email is _0rem@agine@naver.co.kr" , ValidatorUtils.email("_0rem@agine@naver.co.kr"));
        Assert.assertFalse("email is _0remaginenaver.co.kr" , ValidatorUtils.email("_0remaginenaver.co.kr"));
    }

    @Test
    public void testPhone(){
        Assert.assertTrue("phone is 02-123-1234" , ValidatorUtils.phone("02-123-1234"));
        Assert.assertTrue("phone is 02-1231-1234" , ValidatorUtils.phone("02-1231-1234"));
        Assert.assertTrue("phone is 023-123-1234" , ValidatorUtils.phone("023-123-1234"));
        Assert.assertTrue("phone is 023-1233-1234" , ValidatorUtils.phone("023-1233-1234"));
        Assert.assertFalse("phone is 0231-1233-1234" , ValidatorUtils.phone("0231-1233-1234"));
        Assert.assertFalse("phone is 231-1233-1234" , ValidatorUtils.phone("231-1233-1234"));
        Assert.assertFalse("phone is 023-12331-1234" , ValidatorUtils.phone("023-12331-1234"));
        Assert.assertFalse("phone is 023-1233-12341" , ValidatorUtils.phone("023-1233-12341"));
        Assert.assertFalse("phone is 02312332341" , ValidatorUtils.phone("02312332341"));
        Assert.assertFalse("phone is 023-12-3-1234" , ValidatorUtils.phone("023-12-3-1234"));
    }

    @Test
    public void testMobile(){
        Assert.assertTrue("mobile is 010-123-1234" , ValidatorUtils.mobile("010-123-1234"));
        Assert.assertTrue("mobile is 010-1231-1234" , ValidatorUtils.mobile("010-1231-1234"));
        Assert.assertTrue("mobile is 011-1231-1234" , ValidatorUtils.mobile("011-1231-1234"));
        Assert.assertTrue("mobile is 016-1231-1234" , ValidatorUtils.mobile("016-1231-1234"));
        Assert.assertTrue("mobile is 017-1231-1234" , ValidatorUtils.mobile("017-1231-1234"));
        Assert.assertTrue("mobile is 018-1231-1234" , ValidatorUtils.mobile("018-1231-1234"));
        Assert.assertTrue("mobile is 019-1231-1234" , ValidatorUtils.mobile("019-1231-1234"));
        Assert.assertFalse("mobile is 110-1231-1234" , ValidatorUtils.mobile("110-1231-1234"));
        Assert.assertFalse("mobile is 01-1231-1234" , ValidatorUtils.mobile("01-1231-1234"));
        Assert.assertFalse("mobile is 010-12311-1234" , ValidatorUtils.mobile("010-12311-1234"));
        Assert.assertFalse("mobile is 010-1231-12341" , ValidatorUtils.mobile("010-1231-12341"));
        Assert.assertFalse("mobile is 013-1231-1234" , ValidatorUtils.mobile("013-1231-1234"));
        Assert.assertFalse("mobile is 01012311234" , ValidatorUtils.mobile("01012311234"));
        Assert.assertFalse("mobile is 0 10-1231-1234" , ValidatorUtils.mobile("0 10-1231-1234"));
        Assert.assertFalse("mobile is 010-1 231-1234" , ValidatorUtils.mobile("010-1 231-1234"));
        Assert.assertFalse("mobile is 010-1231-1 234" , ValidatorUtils.mobile("010-1231-1 234"));
        Assert.assertFalse("mobile is 010-12-31-1234" , ValidatorUtils.mobile("010-12-31-1234"));
    }

    @Test
    public void testAlpha(){
        Assert.assertTrue("alpha is aAbBcCdD" , ValidatorUtils.alpha("aAbBcCdD"));
        Assert.assertTrue("alpha is aAbBcCdDzZ" , ValidatorUtils.alpha("aAbBcCdDzZ"));
        Assert.assertTrue("alpha is     aAbBcCdDzZ" , ValidatorUtils.alpha("   aAbBcCdDzZ"));
        Assert.assertTrue("alpha is     aAbBcCdDzZ      " , ValidatorUtils.alpha("   aAbBcCdDzZ      "));
        Assert.assertFalse("alpha is aA bBc CdD" , ValidatorUtils.alpha("aA bBc CdD"));
        Assert.assertFalse("alpha is 1aAbBcCdD" , ValidatorUtils.alpha("1aAbBcCdD"));
        Assert.assertFalse("alpha is aAbBcCdD!" , ValidatorUtils.alpha("aAbBcCdD!"));
        Assert.assertFalse("alpha is aAbBcCdDㄱ" , ValidatorUtils.alpha("1aAbBcCdDㄱ"));
        Assert.assertFalse("alpha is 1aAbB3cCdD" , ValidatorUtils.alpha("1aAbB3cCdD"));
        Assert.assertFalse("alpha is 1aAbB3cCdD" , ValidatorUtils.alpha(""));
        Assert.assertFalse("alpha is 1aAbB3cCdD" , ValidatorUtils.alpha("       "));
    }

    @Test
    public void testAlphaLower(){
        Assert.assertTrue("alphaLower is abcd" , ValidatorUtils.alphaLower("abcd"));
        Assert.assertTrue("alphaLower is    abcd" , ValidatorUtils.alphaLower("   abcd"));
        Assert.assertTrue("alphaLower is abcd   " , ValidatorUtils.alphaLower("abcd   "));
        Assert.assertTrue("alphaLower is abcdefgz" , ValidatorUtils.alphaLower("abcdefgz"));
        Assert.assertTrue("alphaLower is c" , ValidatorUtils.alphaLower("c"));
        Assert.assertFalse("alphaLower is abcd efgz" , ValidatorUtils.alphaLower("abcd efgz"));
        Assert.assertFalse("alphaLower is abcd3fgz" , ValidatorUtils.alphaLower("abcd3fgz"));
        Assert.assertFalse("alphaLower is abcdEfgz" , ValidatorUtils.alphaLower("abcdEfgz"));
        Assert.assertFalse("alphaLower is " , ValidatorUtils.alphaLower(""));
        Assert.assertFalse("alphaLower is     " , ValidatorUtils.alphaLower("    "));
        Assert.assertFalse("alphaLower is   asd_df  " , ValidatorUtils.alphaLower(" asd_df   "));
    }

    @Test
    public void testAlphaUpper(){
        Assert.assertTrue("alphaUpper is ABCD" , ValidatorUtils.alphaUpper("ABCD"));
        Assert.assertTrue("alphaUpper is ABCDEFGZ" , ValidatorUtils.alphaUpper("ABCDEFGZ"));
        Assert.assertTrue("alphaUpper is ABCDEFGZ     " , ValidatorUtils.alphaUpper("ABCDEFGZ       "));
        Assert.assertTrue("alphaUpper is      ABCDEFGZ" , ValidatorUtils.alphaUpper("       ABCDEFGZ"));
        Assert.assertFalse("alphaUpper is ABCD EFGZ" , ValidatorUtils.alphaUpper("ABCD EFGZ"));
        Assert.assertFalse("alphaUpper is ABCD3EFGZ" , ValidatorUtils.alphaUpper("ABCD3EFGZ"));
        Assert.assertFalse("alphaUpper is ABCD!EFGZ" , ValidatorUtils.alphaUpper("ABCD!EFGZ"));
        Assert.assertFalse("alphaUpper is ABCDhEFGZ" , ValidatorUtils.alphaUpper("ABCDhEFGZ"));
        Assert.assertFalse("alphaUpper is ABCD3EFGZ" , ValidatorUtils.alphaUpper("ABCD_EFGZ"));
        Assert.assertFalse("alphaUpper is " , ValidatorUtils.alphaUpper(""));
        Assert.assertFalse("alphaUpper is    " , ValidatorUtils.alphaUpper("  "));
    }

    @Test
    public void testAlphanum(){
        Assert.assertTrue("alphanum is ABCD" , ValidatorUtils.alphanum("ABCD"));
        Assert.assertTrue("alphanum is 1234" , ValidatorUtils.alphanum("1234"));
        Assert.assertTrue("alphanum is asdf" , ValidatorUtils.alphanum("asdf"));
        Assert.assertTrue("alphanum is AaBbCcDd" , ValidatorUtils.alphanum("AaBbCcDd"));
        Assert.assertTrue("alphanum is ABCD1234" , ValidatorUtils.alphanum("ABCD1234"));
        Assert.assertTrue("alphanum is AaBbCcDd1234" , ValidatorUtils.alphanum("AaBbCcDd1234"));
        Assert.assertTrue("alphanum is      AaBbCcDd1234     " , ValidatorUtils.alphanum("    AaBbCcDd1234      "));
        Assert.assertFalse("alphanum is AB CD" , ValidatorUtils.alphanum("AB CD"));
        Assert.assertFalse("alphanum is ab cd" , ValidatorUtils.alphanum("ab cd"));
        Assert.assertFalse("alphanum is ABCDㄱ" , ValidatorUtils.alphanum("ABCDㄱ"));
        Assert.assertFalse("alphanum is AB CD" , ValidatorUtils.alphanum("ABCD"));
    }
}
