/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import GUI.Editor;
import Memento.StyleVersion;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JColorChooser;
import javax.swing.JTextPane;
import javax.swing.text.StyleConstants;

/**
 *
 * @author Esteb
 */
public class ChangeForeground implements ICommand{
    private StyleVersion style;
    private Editor editor;
    public ChangeForeground(StyleVersion style ) {
        this.style = style;
    }

    public ChangeForeground(StyleVersion style, Editor editor) {
        this.style = style;
        this.editor = editor;
    }

    public ChangeForeground(Editor editor) {
        this.editor = editor;
    }
    
    
    @Override
    public boolean execute() {
        try{
            editor.getCaretaker().add(style.save());
            StyleConstants.setForeground(style.getStyle(), 
                    JColorChooser.showDialog(editor, "Select color", Color.yellow)
            );
            JTextPane pane = editor.getjTextPane();
            style.getDoc().setCharacterAttributes(pane.getSelectionStart(), 
                    pane.getSelectionEnd()- pane.getSelectionStart(),pane.getStyle("newstyle"), true);
            editor.getjButtonUndo().setEnabled(true);

            return true;
        }catch (Exception ex){
            
        }
        return false;
    }    

    public void setStyle(StyleVersion style) {
        this.style = style;
    }
}
