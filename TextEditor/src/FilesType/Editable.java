/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FilesType;

import FilesType.Format.formatBuilder;
import java.awt.Color;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
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
    
    public void setColorBackGround(int start, int end, Color color){
        StyleConstants.setBackground(style, color);
        doc.setCharacterAttributes(start, end-start, style, true);
        String subS1 = this.getText().substring(0,start);
        String subS2 = this.getText().substring(start, end);
        String subS3 = this.getText().substring(end, this.getText().length()-1);
        this.setText(subS1+FormatParser.applyFormat(subS2,FormatParser.CH_BACKGROUND , color)+subS3);
        System.out.println(this.getText());
    }
    
    public void setColorForeground(int start, int end, Color color){
        StyleConstants.setForeground(style, color);
        doc.setCharacterAttributes(start, end-start, style, true);
        String subS1 = this.getText().substring(0,start);
        System.out.println("Sub string 1:"+subS1);
        String subS2 = this.getText().substring(start, end);
        System.out.println("Sub string 2:"+subS2);
        String subS3 = this.getText().substring(end, this.getText().length()-1);
        System.out.println("Sub string 3:"+subS3);
        this.setText(subS1+FormatParser.applyFormat(subS2, FormatParser.CH_FOREGROUND, color)+subS3);
        System.out.println(this.getText());
        
        
    }
    public void parseFormat(LinkedList<Format> formats)  {
        System.out.println("FORMATS PARSED -->");
        for(Format f : formats){
            System.out.println(f.toString());
            if(f.getType().equals(Format.FormatType.BACKGROUND)){
                setColorBackGround(f.getStartIndex(), f.getEndIndex()-1, f.getColor());
            }else{
                setColorForeground(f.getStartIndex(), f.getEndIndex()-1, f.getColor());
            }
        }
    }

    public static class FormatParser{
        public static final char CH_FOREGROUND = 'f';
        public static final char CH_BACKGROUND = 'b';
        public static final char  COLOR_SEPARATOR = ',';
        public static final char COLOR_FLAG = '$';
        public static final char OPEN_FORMAT = '<';
        public static final char CLOSE_FORMAT = '>';
        
        
        private FileReader fr; 
        private String cleanStr = ""; //string without color format
   
        private LinkedList<Format> formats = new LinkedList<>();

        public FormatParser(FileReader fr) {
            this.fr = fr;
        }
        public void parse() throws IOException{
            int chValue = next();
            while (chValue != -1) {                
                char ch = (char)chValue;
                if(ch == OPEN_FORMAT){ //find format key
                    Format format = getFormat(); //set flag to parameter
                    formats.add(format);
                }else{ //if not format so assing the char readed
                    cleanStr = cleanStr+ch; 
                }   
                chValue = next();
            }
            System.out.println("String cleaned"+cleanStr);
         

        }

        private int next() throws IOException{
            int val =fr.read();
            return val;
        }
        private Format getFormat() throws IOException{ //when find open format key < Example    <f hello $100,200,200$>
            char flag = (char) next(); //f that means foreground
            Format.formatBuilder format_builder= new Format.formatBuilder()
                    .addStartIndex(cleanStr.length()) //actual index
                    .addType(formatBuilder.getType(flag)); //FOREGROUND
            char ch =(char) next(); //0 = " " 
            String subString="";
            while(ch != CLOSE_FORMAT){ //0 = , 1=h, 2=e, 3=l, 4=l,5=o, 6=$
                if(ch ==OPEN_FORMAT){ //if find another format
                    Format otherFormat = getFormat();
                    this.formats.add(otherFormat); //added to array list, does not matter the order
                }else if(ch ==COLOR_FLAG){
                    format_builder.addColor(getColor()); //add color
                }else{
                    subString = subString+ch; //add char
                }
                ch =  (char) next(); //next char
                
            }
            cleanStr= cleanStr+subString;
            format_builder.addSubString(subString);
            format_builder.addEndIdex(cleanStr.length()); //actual lenght of cleanStr
            return format_builder.build(); 
        }
        
        private Color getColor() throws IOException{ //if find $ char
            int[] colors = new int[4];//int red, green, blue, transparency;
            int colorIndex =0;
            char ch =(char) next();
            String onecolor="";
            while(ch != COLOR_FLAG){
               
                if(ch == COLOR_SEPARATOR){
                    colors[colorIndex]= Integer.parseInt(onecolor);
                    colorIndex++;
                    onecolor="";//restar color
                }else{
                    onecolor= onecolor+ch;
                }
                ch =(char) next();
            }
            
            return new Color(colors[0], colors[1], colors[2], colors[3]);
        }
        private static String formatColor(Color color){
            String formated = "$"+String.valueOf(color.getRed())+","
                    +String.valueOf(color.getGreen())+","
                    +String.valueOf(color.getBlue())+","
                    +String.valueOf(color.getTransparency())+","+
                    "$";
            return formated;
        }
        public static String applyFormat(String txt,char flag, Color color){
            
            String formated = "<"+flag+txt+formatColor(color)+">";
            return formated;
        }

        public String getCleanStr() {
            return cleanStr;
        }

        public LinkedList<Format> getFormats() {
            return formats;
        }
        

    }

}
