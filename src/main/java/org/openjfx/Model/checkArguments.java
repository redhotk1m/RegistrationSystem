package org.openjfx.Model;

import javafx.application.Platform;
import org.openjfx.Exceptions.EmptyTableException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class checkArguments {

    public checkArguments() {
    }

    public void stringTest(String s) throws EmptyTableException {
        checkIfNull(s);
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                throw new EmptyTableException("Not a valid string");

            }
        }
    }


    public void streetTest(String s) throws  EmptyTableException {
        checkIfNull(s);
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c) && !Character.isDigit(c)) {
                throw new EmptyTableException("Special characters are not allowed");
            }
        }
    }


    public void dateTest(String s) throws EmptyTableException {
        checkIfNull(s);
        if (!s.matches(
                "([0-9]{2})" + "([.])" + "([0-9]{2})" + "([.])" + "([0-9]{4})"))
            throw new EmptyTableException("This is not a valid date");
    }


    public void numberTest(String s) throws EmptyTableException{
        checkIfNull(s);
        if(!s.matches("[0-9]*$"))
            throw new EmptyTableException("This is not a valid number");
    }

    public void checkIfNull(String s) throws EmptyTableException {
        if (s == null || s.length() < 1){
            throw new EmptyTableException("Cannot be empty");
        }
    }
}
