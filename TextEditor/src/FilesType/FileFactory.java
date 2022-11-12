/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FilesType;

/**
 *
 * @author Esteb
 */
public class FileFactory {
    public static final String TXT_EXTENTION =".txt";
    public static final String JSON_EXTENSION =".json";
    public static final String TXTTAB_EXTENTION=".csv";

    public static AFile create(FileType type){
        switch (type) {
            case TXT:
                return new Txt();
            case TSV:
                return new Tsv();
            case JSON:
                return new Json();
            default:
                throw new AssertionError();
        }
        
    }
    
}
