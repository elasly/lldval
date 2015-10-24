/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author elasly
 */
public class readFile{
    String startPath;
    String lparName;
    String folder;
    public File inputFile;

    public ArrayList readTxt(String a,String b,String c,String d) throws FileNotFoundException{
        ArrayList arr=new ArrayList(); 
        File f=new File(a+"/"+b+"/"+c+"/"+d);
        Scanner in=new Scanner(f);
//        System.out.println("Read Data From The Txt file ");
            while(in.hasNext()) 
                {   
                    arr.add(in.nextLine());
                }
        return arr;

}
    
//    public readFile(String startPath,String lparName,String folder, String fileToRead ) throws FileNotFoundException{
//    
//File f=new File(startPath+"/"+lparName+"/"+folder+"/"+fileToRead);
//
//Scanner fileRead=new Scanner(f);
//
////System.out.println("Reading Data From The "+fileToRead+" file ");
//System.out.println(fileRead.toString());
//
//    }
    
}
