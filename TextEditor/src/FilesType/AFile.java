/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FilesType;

/**
 *
 * @author Esteb
 */
public abstract class AFile {
    private String fileName;

    public AFile() {
    }

    public AFile(String fileName) {
        this.fileName = fileName;
    }

    public abstract void save();

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    

    public String getFileName() {
        return fileName;
    }
}
