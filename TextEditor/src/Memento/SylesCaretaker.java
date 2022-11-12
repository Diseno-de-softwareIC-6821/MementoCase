/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Memento;

import java.util.LinkedList;

/**
 *
 * @author Esteb
 */
public class SylesCaretaker {
    private final int  max_States = 20; 
    private int currentIndex;
    private LinkedList<StyleMemento> listMementos;

    public SylesCaretaker() {
        this.currentIndex = 0;
        this.listMementos = new LinkedList<>();
    }
    public StyleMemento getPrevious(){
        int newIndex = currentIndex-1;                      
        if(newIndex  <= -1 ){               
            return null;           
        }
        currentIndex= newIndex;           
        return listMementos.get(currentIndex);
    }
    public StyleMemento getNext(){
        int newIndex = currentIndex +1;           
        if( newIndex >= listMementos.size()){               
            return null;           
        } 
        currentIndex = newIndex;           
        return listMementos.get(currentIndex);   
    }
    public boolean hasNext(){
        return currentIndex +1 <= listMementos.size()-1;
    }
    public boolean havePrevious(){
        return currentIndex-1 >=0;
    }
    
    
    public void add(StyleMemento style){
        listMementos.add(style);
        if(listMementos.size()>20){
            listMementos.remove(0);
        }
        currentIndex++;
    }
    public StyleMemento getCurrent(){
        
        return listMementos.get(currentIndex);
    }
    
}
