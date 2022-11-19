/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Memento;

/**
 *
 * @author Esteb
 */
public class StyleMemento {
    private EditableVersion editable;

    public StyleMemento(EditableVersion style) {
        this.editable = style;
    }

    public EditableVersion getEditable() {
        return editable;
    }

    
    
    
}
