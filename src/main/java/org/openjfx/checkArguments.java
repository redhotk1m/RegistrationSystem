package org.openjfx;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class checkArguments {

    public checkArguments() {
    }


    public boolean stringTest(String s) {
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }


    public boolean streetTest(String s) {
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c) && !Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }


    public boolean dateTest(String s) {
        DateFormat format = new SimpleDateFormat("dd-MM-yy");
        format.setLenient(false);

        try {
            format.parse(s);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }


    public boolean numberTest(String s){
        if(s.matches("[0-9]*$"))
            return true;
        return false;
    }
}
