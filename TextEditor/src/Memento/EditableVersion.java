/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Memento;

import FilesType.AFile;
import FilesType.Editable;
import FilesType.FileFactory;
import FilesType.FileType;

/**
 *
 * @author Esteb
 */
public class EditableVersion implements Cloneable{
    private AFile file;
    private Editable editable;
    private static EditableVersion instance;
    
    
    
    private EditableVersion(AFile file, Editable editable) {
        this.file = file;
        this.editable = editable;
    }
    public static EditableVersion getInstance(){
        if(instance ==null){
            instance = new EditableVersion(FileFactory.create(FileType.NULL), (Editable) FileFactory.create(FileType.EDITABLE));
        }
        return instance;
    }
    
    
    public StyleMemento record(){
        try {               
            return new StyleMemento((EditableVersion)this.clone());           
        } catch (CloneNotSupportedException e) {               
            throw new RuntimeException("Error al clonar el empleado");           
        }   
    }
    
    public void restore(StyleMemento memento){
        EditableVersion styleVersion=  memento.getEditable();
        file = styleVersion.getFile();
        editable = styleVersion.getEditable();
    }
    
    
    public Editable getEditable() {
        return editable;
    }

    public void setEditable(Editable editable) {
        this.editable = editable;
    }

    public AFile getFile() {
        return file;
    }

    public void setFile(AFile file) {
        this.file = file;
    }
    
    
    
    
    
}
