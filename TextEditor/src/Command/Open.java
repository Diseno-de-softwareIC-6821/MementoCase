/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import FilesType.Editable;
import FilesType.FileFactory;
import FilesType.FileType;
import GUI.Editor;
import Memento.EditableVersion;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Esteb
 */
public class Open implements ICommand{

    public Editor editor;
    public Open(Editor editor) {
        this.editor = editor;
    }
    
    @Override
    public boolean execute() {
        JFileChooser fc = new JFileChooser();
        fc.addChoosableFileFilter(FileFactory.create(FileType.TXT));
        fc.addChoosableFileFilter(FileFactory.create(FileType.TSV));
        fc.addChoosableFileFilter(FileFactory.create(FileType.JSON));
        int selection = fc.showOpenDialog(null);
        if (selection == JFileChooser.APPROVE_OPTION) {
            //méFile fichero = fc.getSelectedFile();todo para leer el archivo y mostrarlo en el textArea
            File fichero = fc.getSelectedFile(); 
            String ruta = fichero.getAbsolutePath();
    
            EditableVersion.getInstance().getFile().setRoute(ruta);

            System.out.println("La ruta del archivo seleccionado ha sido obtenida exitosamente");
     
            try(FileReader fr = new FileReader(fichero)){
                Editable.FormatParser format = new Editable.FormatParser(fr);
                format.parse();
                EditableVersion.getInstance().getEditable().setText(format.getCleanStr());
                EditableVersion.getInstance().getEditable().parseFormat(format.getFormats());
                EditableVersion.getInstance().getFile().setText(format.getCleanStr());
                this.editor.getjTextPane().setText(format.getCleanStr());
                this.editor.getjTextPane().setDocument(EditableVersion.getInstance().getEditable().getDoc());
                this.editor.getjTextFieldName().setText(ruta);
                
                return true;
            }catch(IOException ex){
                System.out.println("Error al leer el archivo");
            }
            
        }
        
        return false;
    }
    
}
