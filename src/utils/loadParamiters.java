/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
    import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author elasly
 */
public class loadParamiters {

    public  void loadParamiters(String[] args) throws FileNotFoundException
    {
        //Get scanner instance
        Scanner scanner = new Scanner(new File("tunables.csv"));
         
        //Set the delimiter used in file
        scanner.useDelimiter(",");
         
        //Get all tokens and store them in some data structure
        //I am just printing them
        while (scanner.hasNext())
        {
            System.out.print(scanner.next() + "|");
            
        }
         
        //Do not forget to close the scanner 
        scanner.close();
    }
}

