package org.openjfx;

import javafx.concurrent.Task;

import java.io.File;

public class readDataThread extends Task {

    File file;
    @Override
    protected Object call() throws Exception {
        return null;
    }


    public void setFile(File file) {
        this.file = file;
    }

}
