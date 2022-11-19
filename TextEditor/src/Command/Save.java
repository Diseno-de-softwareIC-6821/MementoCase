/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import FilesType.AFile;

import GUI.Editor;
import Memento.EditableVersion;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author Esteb
 */
public class Save implements ICommand{

    private AFile fileToSave;
    
    public Save(AFile fileToSave) {
        this.fileToSave = fileToSave;
    }

    public Save() {
    }
    
    @Override
    public boolean execute() {       
       if(this.fileToSave !=null  | !this.fileToSave.getType().equals(FilesType.FileType.NULL)){
            System.out.println(EditableVersion.getInstance().getEditable().getText());
            fileToSave.setText(EditableVersion.getInstance().getEditable().getText());
           //String finalPath= fileToSave.getRoute()+fileToSave.getExtension(); 
           String finalPath= fileToSave.getRoute();
           System.out.println("Text to save: "+fileToSave.getText());
           System.out.println("Final path to save "+finalPath);
           try {
                File file = new File(finalPath);
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
               
                fw = new FileWriter(file);
                bw.write(fileToSave.getText());
                bw.close();
                fw.close();
           } catch (IOException ex) {return false;}
           return true;
       }    
       return false;
    }

    public void setFileToSave(AFile fileToSave) {
        this.fileToSave = fileToSave;
    }
    
  
}
