/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import FilesType.Editable;
import GUI.Editor;
import Memento.EditableVersion;

import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JColorChooser;
import javax.swing.JTextPane;
import javax.swing.text.StyleConstants;

/**
 *
 * @author Esteb
 */
public class ChangeBackground implements ICommand{
    private Editor editor;
    public ChangeBackground(Editor editor) {
        this.editor = editor;
    }

        @Override
    public boolean execute() {
        try{
            JTextPane pane = editor.getjTextPane(); //get pane
            Editable editable = EditableVersion.getInstance().getEditable();  //get editable abtract file
            editable.setText(pane.getText()); //to save text
            editor.getCaretaker().add(EditableVersion.getInstance().record()); //
            Color color = JColorChooser.showDialog(editor, "Select background for text", Color.white);
            System.out.println(color.getAlpha());
            StyleConstants.setBackground(editable.getStyle(), 
                   color
            );
            editable.getDoc().setCharacterAttributes(pane.getSelectionStart(), 
                    pane.getSelectionEnd()- pane.getSelectionStart(),EditableVersion.getInstance().getEditable().getStyle(), true);
            
            editor.getjButtonUndo().setEnabled(editor.getCaretaker().havePrevious());
            return true;
        }catch (HeadlessException ex){
            
        }
        return false;
    } 
}
