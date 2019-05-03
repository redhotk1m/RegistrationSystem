package org.openjfx.Model.ReadAndWrite;

import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class JOBJWriter extends FileHandler {


    @Override
    public void saveFile(File file, ObservableList data, String tableClassType) {
        //Lagrer listen ettersom, der vi ønsker ved bruk av FileChooser (file)
        //tableClassType blir ikke brukt her, glemt å lage to metoder, en uten og en med (mtp CSV bruker den)
        //Hadde ikke tid til dette før levering
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                out.writeObject(new ArrayList<>(data)); //Skriver objektet til en ny ArrayList
                // (sånn at vi får en fil, ikke en per objekt)
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
