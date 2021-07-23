package com.epam.shape.validator;

import com.epam.shape.validator.impl.CubeDataValidatorImpl;
import org.junit.Assert;
import org.junit.Test;

public class DataValidatorTest {

    @Test
    public void correctDataValidation(){
        String CORRECT_STRING = "1.2,-10.5,10.2,10.0";
        CubeDataValidatorImpl validator = new CubeDataValidatorImpl();
        Assert.assertTrue(validator.validateData(CORRECT_STRING));

    }

    @Test
    public void incorrectDataValidation(){
        String CORRECT_STRING = "-1.2,-10.5,10.2,-10.0";
        CubeDataValidatorImpl validator = new CubeDataValidatorImpl();
        Assert.assertFalse(validator.validateData(CORRECT_STRING));

    }
}
