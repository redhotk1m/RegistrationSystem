package org.openjfx.Model.ReadAndWrite;

import javafx.collections.ObservableList;

import java.io.*;
import java.util.List;

import static javafx.collections.FXCollections.observableArrayList;

public class JOBJReader extends FileHandler {

    ObservableList data;
    public JOBJReader(File file){
        data = observableArrayList();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
            List list = (List) in.readObject();
            data.setAll(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList getData(){
        return data;
    }

}
