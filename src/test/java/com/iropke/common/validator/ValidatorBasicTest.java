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
        Assert.assertFalse("min length is 3 fail", ValidatorUtils.length("ss", 3));
    }

}
