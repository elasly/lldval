/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author elasly
 */
public class pcatLparFolders {
    
    String startPath;
    public ArrayList<String[]> pcatFolderList;
    
    public String[] fileList;
    public pcatLparFolders(String startPath, String LPARS){
        
        

        File fileForLpar = new File(startPath+"/"+LPARS);
        fileList = fileForLpar.list(new FilenameFilter() {
        @Override
        public boolean accept(File current, String name) {
        return new File(current, name).isDirectory();
  }
        
});



    }
   }
    

