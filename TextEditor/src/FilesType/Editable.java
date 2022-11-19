/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FilesType;

import java.io.Serializable;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Esteb
 */
public class Editable extends AFile implements Serializable{
    
    private final String styleName= "newStyle";
    private StyledDocument doc; 
    private Style style;
    private int cursorPos;
    
    
    public Editable(FileType type, String extension, String description){
        super(type, extension, description);
    }
    
    public StyledDocument getDoc() {
        return doc;
    }

    public void setDoc(StyledDocument doc) {
        this.doc = doc;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }
    public int getCursorPos() {
        return cursorPos;
    }

    public void setCursorPos(int cursorPos) {
        this.cursorPos = cursorPos;
    }

    public String getStyleName() {
        return styleName;
    }
    
    
    
    
    
    
    
    
            

    
}
