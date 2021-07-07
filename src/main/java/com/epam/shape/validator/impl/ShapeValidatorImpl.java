package com.epam.shape.validator.impl;

import com.epam.shape.validator.ShapeValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class ShapeValidatorImpl implements ShapeValidator {
    private static final String CORRECT_REGEX =
            "-?\\d+\\.\\d+,-?\\d+\\.\\d+,-?\\d+\\.\\d+," +
                    "-?\\d+\\.\\d+,-?\\d+\\.\\d+,-?\\d+\\.\\d+," +
                    "-?\\d+\\.\\d+,-?\\d+\\.\\d+,-?\\d+\\.\\d+," +
                    "-?\\d+\\.\\d+,-?\\d+\\.\\d+,-?\\d+\\.\\d+," +
                    "-?\\d+\\.\\d+,-?\\d+\\.\\d+,-?\\d+\\.\\d+," +
                    "-?\\d+\\.\\d+,-?\\d+\\.\\d+,-?\\d+\\.\\d+," +
                    "-?\\d+\\.\\d+,-?\\d+\\.\\d+,-?\\d+\\.\\d+," +
                    "-?\\d+\\.\\d+,-?\\d+\\.\\d+,-?\\d+\\.\\d+"; //crazy, but works
    static final Logger logger = LogManager.getLogger(ShapeValidatorImpl.class);
    private final Pattern pattern;

    public ShapeValidatorImpl() {
        this.pattern = Pattern.compile(CORRECT_REGEX);
    }

    @Override
    public boolean validateData(String data) {
        if (pattern.matcher(data).matches()) {
            logger.info("Validated correct [Shape] string -> \"" + data + "\"");
            return true;
        } else {
            logger.debug("String is incorrect -> \"" + data + "\"");
            return false;
        }
    }
}
