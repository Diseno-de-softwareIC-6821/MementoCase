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
    public static final String TXT_EXTENSION=".txt" ; 
    public static final String TSV_EXTENSION=".tsv" ; 
    public static final String JSON_EXTENSION=".jaon"; 
    //public static final String = ; 
    
    public static AFile create(FileType type){
        switch (type) {
            case TXT:
                return new Txt(type,TXT_EXTENSION,"TEXT" );
            case TSV:
                return new Tsv(type,TSV_EXTENSION, "TSV");
            case JSON:
                return new Json(type,JSON_EXTENSION ,"JSON");
            case EDITABLE:
                return new Editable(type, "", "");
            case NULL:
                return new AFile(type, "", "NO DATA") {};
            default:
                throw new AssertionError();
        }
        
    }
    public static AFile create(String extension){
        if(extension.equals(TXT_EXTENSION) || extension.equals("TEXT") ){
            return create(FileType.TXT);
        }else if(extension.equals(JSON_EXTENSION) || extension.equals("JSON")){
            return create(FileType.JSON);
        }else if(extension.equals(TSV_EXTENSION) || extension.equals("TSV")){
            return create(FileType.TSV);
        } else{
            return create(FileType.NULL);
        }  
    }
    
}
