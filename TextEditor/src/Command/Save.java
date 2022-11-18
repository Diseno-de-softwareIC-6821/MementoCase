/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import FilesType.AFile;
import FilesType.FileFactory;
import FilesType.FileType;
import GUI.Editor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Esteb
 */
public class Save implements ICommand{

    private AFile fileToSave;
    private Editor editor;

    public Save(Editor editor) {
       this.editor = editor;
    }
    
    @Override
    public boolean execute() {/*
        
       if(this.fileToSave !=null){
           fileToSave.save();
           return true;
       }
        
       return false;*/
        JFileChooser fc = new JFileChooser();
        fc.addChoosableFileFilter(new FileTypeFilter(FileFactory.TXT_EXTENTION, "TEXT Files"));
        fc.addChoosableFileFilter(new FileTypeFilter(FileFactory.TXTTAB_EXTENTION, "TSV Files"));
        fc.addChoosableFileFilter(new FileTypeFilter(FileFactory.JSON_EXTENSION, "JSON Files"));
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos",
                FileFactory.TXT_EXTENTION ,
                FileFactory.TXTTAB_EXTENTION,
                FileFactory.JSON_EXTENSION);
        fc.setDialogTitle("Guarde el archivo"); 
        int selection = fc.showSaveDialog(null);
        if (selection == JFileChooser.APPROVE_OPTION) {
            File fichero = fc.getCurrentDirectory();
            String ruta = fichero.getAbsolutePath();
            try{
                String fileName = fc.getSelectedFile().toString() + fc.getFileFilter().getDescription();
                //System.out.println(fileName + fc.getFileFilter().getDescription());
                //System.out.println(fileName);
                File file = new File(fileName);
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(editor.getjTextPane().getText());
                bw.close();
                fw.close();
                return true;
            }
            catch(IOException ioe){
                System.out.println(ioe);
            }
        }
        return false;
    }

    public void setFileToSave(AFile fileToSave) {
        this.fileToSave = fileToSave;
    }
    
    public class FileTypeFilter extends FileFilter {
    private String extension;
    private String description;
 
    public FileTypeFilter(String extension, String description) {
        this.extension = extension;
        this.description = description;
    }
 
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        return file.getName().endsWith(extension);
    }
 
    public String getDescription() {
        return extension;
    }
}
}
