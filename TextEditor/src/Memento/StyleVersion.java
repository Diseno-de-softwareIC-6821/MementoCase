/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Memento;

import java.text.NumberFormat.Style;
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
    
    public StyleMemento save(){
        try {               
            return new StyleMemento((StyleVersion)this.clone());           
        } catch (Exception e) {               
            throw new RuntimeException("Error al clonar el empleado");           
        }   
    }
    
    public void restore(StyleMemento memento){
    
    }
    
}
