/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import FilesType.AFile;
import FilesType.FileFactory;
import GUI.Editor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import FilesType.FileFactory;
import FilesType.FileType;
import Memento.EditableVersion;
/**
 *
 * @author Esteb
 */
public class SaveAs implements ICommand{
    

    public SaveAs( ) {}

    @Override
    public boolean execute() {
        JFileChooser fc = new JFileChooser();
        fc.addChoosableFileFilter(FileFactory.create(FileType.TXT));
        fc.addChoosableFileFilter(FileFactory.create(FileType.TSV));
        fc.addChoosableFileFilter(FileFactory.create(FileType.JSON));
        fc.setDialogTitle("Guarde el archivo"); 
        int selection = fc.showSaveDialog(null);
        if (selection == JFileChooser.APPROVE_OPTION) {
            AFile abFile = FileFactory.create(fc.getFileFilter().getDescription());
            if(!abFile.getType().equals(FileType.NULL)){
                abFile.setRoute(fc.getSelectedFile().toString()+abFile.getExtension());
                System.out.println("Get selected file "+fc.getSelectedFile().toString());
                abFile.setText(EditableVersion.getInstance().getEditable().getText()); //set current text to our abstract file to save
                EditableVersion.getInstance().setFile(abFile);
                System.out.println("File type-> "+abFile.getType().name());
                System.out.println("Route ->" +abFile.getRoute());
                return new Save(abFile).execute(); //return the command save because is the same and return boolean
            }
        }
        return false;
    }
 
}
    

