/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import GUI.Editor;
import Memento.StyleVersion;
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
    private StyleVersion style;
    private Editor editor;
    public ChangeBackground(StyleVersion style ) {
        this.style = style;
    }

    public ChangeBackground(StyleVersion style, Editor editor) {
        this.style = style;
        this.editor = editor;
    }

    public ChangeBackground(Editor editor) {
        this.editor = editor;
    }
    
    
    @Override
    public boolean execute() {
        try{
            editor.getCaretaker().add(style.save());
            StyleConstants.setBackground(style.getStyle(), 
                    JColorChooser.showDialog(editor, "Select color", Color.white)
            );
            JTextPane pane = editor.getjTextPane();
            style.getDoc().setCharacterAttributes(pane.getSelectionStart(), 
                    pane.getSelectionEnd()- pane.getSelectionStart(),pane.getStyle("newstyle"), true);
            
            editor.getjButtonUndo().setEnabled(editor.getCaretaker().havePrevious());
            return true;
        }catch (HeadlessException ex){
            
        }
        return false;
    }    

    public void setStyle(StyleVersion style) {
        this.style = style;
    }
}
