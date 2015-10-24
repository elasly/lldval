/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author elasly
 */
public class tunables {
    private String tunable;
    private String Folder;
    private String File;
    private String regExpresion;

    /**
     * @return the tunable
     */
    public String getProperty() {
        return tunable;
    }

    /**
     * @param property the tunable to set
     */
    public void setProperty(String property) {
        this.tunable = property;
    }

    /**
     * @return the Folder
     */
    public String getFolder() {
        return Folder;
    }

    /**
     * @param Folder the Folder to set
     */
    public void setFolder(String Folder) {
        this.Folder = Folder;
    }

    /**
     * @return the File
     */
    public String getFile() {
        return File;
    }

    /**
     * @param File the File to set
     */
    public void setFile(String File) {
        this.File = File;
    }

    /**
     * @return the regExpresion
     */
    public String getRegExpresion() {
        return regExpresion;
    }

    /**
     * @param regExpresion the regExpresion to set
     */
    public void setRegExpresion(String regExpresion) {
        this.regExpresion = regExpresion;
    }
}
