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
public class pcatFiles {
    
    String startPath;
    public String[] fileList;
    
    
    public pcatFiles(String startPath,String[] LPAR,String[] Folder){
        for (int i = 0;i<=LPAR.length-1;i++){
            for (int j = 0; j <= Folder.length -1 ; j++){
        File file = new File(startPath+"/"+LPAR[i]+"/"+Folder[j]);
        String[] directories = file.list(new FilenameFilter() {
        @Override
        public boolean accept(File current, String name) {
        return new File(current, name).isFile();
  }
        
});
        this.fileList = directories;

        }}
   

    }
    
    
    
}
