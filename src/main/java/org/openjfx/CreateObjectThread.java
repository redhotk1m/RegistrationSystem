package org.openjfx;

import javafx.concurrent.Task;

public class CreateObjectThread extends Task<Integer> {
    @Override
    protected Integer call() throws Exception {

        return 10;
    }

    @Override
    protected void updateProgress(long l, long l1) {
        super.updateProgress(l, l1);
    }
}
