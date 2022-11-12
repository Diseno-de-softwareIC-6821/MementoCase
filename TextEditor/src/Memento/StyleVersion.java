/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Memento;


import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Esteb
 */
public class StyleVersion implements Cloneable{
    private StyledDocument doc; 
    private Style style;
    private String text;
    private int cursorPos;

    public StyleVersion() {}
    
    
    
    
    public StyleMemento save(){
        try {               
            return new StyleMemento((StyleVersion)this.clone());           
        } catch (Exception e) {               
            throw new RuntimeException("Error al clonar el empleado");           
        }   
    }
    
    public void restore(StyleMemento memento){
        StyleVersion styleVersion=  memento.getStyle();
        doc = styleVersion.getDoc();
        style = styleVersion.getStyle();
        text = styleVersion.getText();
        
    }
    

    public void setDoc(StyledDocument doc) {
        this.doc = doc;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCursorPos(int cursorPos) {
        this.cursorPos = cursorPos;
    }

    public StyledDocument getDoc() {
        return doc;
    }

    public Style getStyle() {
        return style;
    }

    public String getText() {
        return text;
    }

    public int getCursorPos() {
        return cursorPos;
    }
    
    
}
