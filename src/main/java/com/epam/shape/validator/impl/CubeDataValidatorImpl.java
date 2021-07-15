package com.epam.shape.validator.impl;

import com.epam.shape.validator.CubeDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class CubeDataValidatorImpl implements CubeDataValidator {
    private static final String CORRECT_REGEX = "-?\\d+\\.\\d+,-?\\d+\\.\\d+,-?\\d+\\.\\d+,[1-9][0-9]*\\.\\d+";
    static final Logger logger = LogManager.getLogger(CubeDataValidatorImpl.class);
    private final Pattern pattern;

    public CubeDataValidatorImpl() {
        this.pattern = Pattern.compile(CORRECT_REGEX);
    }

    @Override
    public boolean validateData(String data) {
        if (pattern.matcher(data).matches()) {
            logger.info("Validated correct [Cube] string -> \"" + data + "\"");
            return true;
        } else {
            logger.debug("String is incorrect -> \"" + data + "\"");
            return false;
        }
    }
}
