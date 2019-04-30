package org.openjfx;

import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class mJOBJWriter extends FileHandler {


    @Override
    public void saveFile(File file, ObservableList data, String tableClassType) {
        if (tableClassType.equals("Clients")){
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                out.writeObject(new ArrayList<>(data));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else System.out.println("Ikke clients");
    }
}
