/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import FilesType.AFile;

/**
 *
 * @author Esteb
 */
public class Save implements ICommand{

    private AFile fileToSave;

    public Save( ) {
       
    }
    
    
    @Override
    public boolean execute() {
       if(this.fileToSave !=null){
           fileToSave.save();
           return true;
       }
       return false;
    }

    public void setFileToSave(AFile fileToSave) {
        this.fileToSave = fileToSave;
    }
    
}
