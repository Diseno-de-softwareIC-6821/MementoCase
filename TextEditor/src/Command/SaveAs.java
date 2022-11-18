/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import GUI.Editor;

/**
 *
 * @author Esteb
 */
public class SaveAs implements ICommand{
    
    private Editor editor;

    public SaveAs(Editor editor) {
        this.editor = editor;
    }

    
    @Override
    public boolean execute() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
