/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FilesType;

import java.awt.Color;

/**
 *
 * @author Esteb
 */
public class Format {
    private String subString;
    private int startIndex;
    private int endIndex ;
    private Color color;
    private FormatType type;
    
    public Format(String subString, int startIndex, int endIndex, Color color, FormatType type) {
        this.subString = subString;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.color = color;
        this.type = type;
    }

    public String getSubString() {
        return subString;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public Color getColor() {
        return color;
    }

    public FormatType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Format{" + "subString=" + subString + ", startIndex=" + startIndex + ", endIndex=" + endIndex + ", color=" + color + ", type=" + type + '}'+"\n";
    }
    
    public static class formatBuilder{
        private String subString="";
        private int startIndex = 0;
        private int endIndex = 0;
        private Color color =null;
        private FormatType type =FormatType.NO_FORMAT;
        public formatBuilder(){}

        public formatBuilder addColor(Color color){
            this.color = color;
            return this;
        }
        public formatBuilder addStartIndex(int i){
            startIndex = i;
            return this;
        }
        public formatBuilder addEndIdex(int i){
            endIndex = i;
            return this;
        }
        public formatBuilder addType(FormatType type){
            this.type = type;
            return this;
        }
        public formatBuilder addSubString(String str){
            this.subString = str;
            return this;
        }
        public Format build(){
            return new Format(subString, startIndex, endIndex, color, type);
        }
        public static FormatType getType(char flag){
            switch (flag) {
                case 'b':
                    return FormatType.BACKGROUND;
                case 'f':
                    return FormatType.FOREGROUND;
                default:
                    return FormatType.NO_FORMAT;
            }
        }
     
    }
    public static enum FormatType{BACKGROUND, FOREGROUND, NO_FORMAT}
}
