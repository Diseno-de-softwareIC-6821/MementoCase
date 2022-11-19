/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FilesType;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Esteb
 */
public abstract class AFile extends FileFilter{
    private String fileName= "";
    private String route = "";
    private FileType type;
    private String extension ="";
    private String description= "";
    private String text ="";
    
    public AFile(FileType filetype, String extention, String description) {
        this.type = filetype;
        this.extension = extention;
        this.description = description;
    }


    

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
    
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    

    
    //File filter methods
    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        return file.getName().endsWith(extension);
        
    }

    @Override
    public String getDescription() {
         return this.description;
    }
    public String getExtension(){
        return this.extension;
    }

    public FileType getType() {
        return type;
    }

  
    
    
    
    
}
