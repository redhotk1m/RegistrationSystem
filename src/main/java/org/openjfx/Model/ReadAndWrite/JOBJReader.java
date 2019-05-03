package org.openjfx.Model.ReadAndWrite;

import javafx.collections.ObservableList;
import org.openjfx.Exceptions.EmptyTableException;
import org.openjfx.Model.ErrorMessage;

import java.io.*;
import java.util.List;

import static javafx.collections.FXCollections.observableArrayList;

public class JOBJReader extends FileHandler {

    ObservableList data;
    public JOBJReader(File file) throws EmptyTableException, FileNotFoundException, IOException, ClassNotFoundException {
        data = observableArrayList();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        List list = (List) in.readObject();
        data.setAll(list);
    }

    @Override
    public ObservableList getData(){
        return data;
    }

}
