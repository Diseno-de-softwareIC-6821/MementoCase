/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import GUI.Editor;
import Memento.EditableVersion;
import Memento.StyleMemento;
import Memento.SylesCaretaker;

/**
 *
 * @author Esteb
 */
public class Redo implements ICommand{
    private Editor editor;

    public Redo(Editor editor) {
        this.editor = editor;
    }
    
    
    @Override
    public boolean execute() {
        SylesCaretaker caretaker = editor.getCaretaker();
        StyleMemento memento = caretaker.getNext();
        if(memento!=null){
            EditableVersion.getInstance().restore(memento);  
            editor.getjButtonUndo().setEnabled(caretaker.havePrevious());
            editor.getjButtonRedo().setEnabled(caretaker.hasNext());
            return true;
        }
        return false;
    }
    
}
