/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import FilesType.Editable;
import GUI.Editor;
import Memento.EditableVersion;
import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JTextPane;
import javax.swing.text.StyleConstants;

/**
 *
 * @author Esteb
 */
public class ChangeForeground implements ICommand{

    private Editor editor;
    public ChangeForeground( Editor editor) {
        this.editor = editor;
    }

    
    @Override
    public boolean execute() {
        try{
            JTextPane pane = editor.getjTextPane(); //get pane
            Editable editable = EditableVersion.getInstance().getEditable();  //get editable abtract file
            editable.setText(pane.getText()); //to save text
            editor.getCaretaker().add(EditableVersion.getInstance().record()); //record the currect features including text
            
            StyleConstants.setForeground(editable.getStyle(), 
                    JColorChooser.showDialog(editor, "Select color", Color.BLACK) //select color
            );
           
            editable.getDoc().setCharacterAttributes(pane.getSelectionStart(), 
                    pane.getSelectionEnd()-pane.getSelectionStart(),EditableVersion.getInstance().getEditable().getStyle(), true);
            editor.getjButtonUndo().setEnabled(true); //paint colors 
            return true;
        }catch (Exception ex){}
        return false;
    }    

 
}
