/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author elasly
 */
public class pcatFolders {
    
    String startPath;
    public String[] pcatFolderList;
    
    
    public pcatFolders(String startPath){
        
        File listOfLpar = new File(startPath+"/");
        String[] fileList = listOfLpar.list(new FilenameFilter() {
        @Override
        public boolean accept(File current, String name) {
        return new File(current, name).isDirectory();
  }
        
});
        this.pcatFolderList = fileList;

   

    }
    
    
    
}
