/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import GUI.Editor;
import Memento.StyleMemento;
import Memento.SylesCaretaker;

/**
 *
 * @author Esteb
 */
public class Undo implements ICommand{
    private  Editor editor;

    public Undo(Editor editor) {
        this.editor = editor;
    }
    
    
    
    
    
    @Override
    public boolean execute() {
        SylesCaretaker caretaker = editor.getCaretaker();
        StyleMemento memento = caretaker.getPrevious();
        if(memento!=null){
            editor.getStyleversion().restore(memento);
            editor.getjTextPane().setDocument(editor.getStyleversion().getDoc());
            editor.getjTextPane().updateUI();
            return true;
        }
        editor.getjButtonRedo().setEnabled(caretaker.hasNext());
        editor.getjButtonUndo().setEnabled(caretaker.havePrevious());
        return false;
    }
    
}
