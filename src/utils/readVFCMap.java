/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.Scanner;
import objects.vfcMap;
import utils.Collections;


 
public class readVFCMap {
    private Path fFilePath;

    /**
     *
     * @param lparName
     * @throws ClassNotFoundException
     */
    public readVFCMap(String lparName) throws IOException {
        String aFileName="./Systems/"+lparName+"/vio/VIOCLI_lsmap-all-npiv.txt";
            fFilePath = Paths.get(aFileName);
            BufferedReader reader = new BufferedReader(new FileReader(aFileName));
            while (reader.readLine() != null) lines++;
            reader.close();
}
    public int lines;
//    public static vfcMap vfcmap =new vfcMap(); 
    public static List<String> list;
    public static int vfcCount;
    public static ArrayList<vfcMap> vfcs = new ArrayList<vfcMap>();
    public Field[] fields = vfcs.getClass().getDeclaredFields();
//    Field fields[] = vfcmap.getClass().getDeclaredFields();
//    private int columns = fields.length;
//    private static int rows;
//    public String[][] vfcdata = new String[columns][rows];
private final static Charset ENCODING = StandardCharsets.UTF_8;  
    @SuppressWarnings("empty-statement")
    
    
    public final void processPatern() throws IOException{
     try (Scanner scanner =  new Scanner(fFilePath, ENCODING.name())){
        while (scanner.hasNextLine()){
            String line1 = scanner.nextLine();
            vfcMap vfcmap =new vfcMap();
            if(!line1.startsWith("===") && line1 != null ){
                String line2 = scanner.nextLine();
                String line3 = scanner.nextLine();
                String line4 = scanner.nextLine();
                String line5 = scanner.nextLine();
                String line6 = scanner.nextLine();
                String line7 = scanner.nextLine();
                String line8 = scanner.nextLine();
                String line9 = scanner.nextLine();
                String line10 = scanner.nextLine();
                vfcCount++;
// 
//                System.out.println(line3); 
//                System.out.println(line4); 
//                System.out.println(line5); 
//                System.out.println(line6); 
//                System.out.println(line7); 
//                System.out.println(line8); 
//                System.out.println(line9); 
//                System.out.println(line10);
//                
                Scanner scanner3 =new Scanner(line3);
                Scanner scanner5 =new Scanner(line5);
                Scanner scanner6 =new Scanner(line6);
                Scanner scanner7 =new Scanner(line7);
                Scanner scanner8 =new Scanner(line8);
                Scanner scanner9 =new Scanner(line9);

                scanner3.useDelimiter(" +");
                scanner5.useDelimiter(":");
                scanner6.useDelimiter(":|  +");
                scanner7.useDelimiter(":");
                scanner8.useDelimiter(":");
                scanner9.useDelimiter(":|  +");
                
                
                String lineSet3 = scanner3.toString();
                String[] dataSet3 =line3.split(" +");
//                System.out.println(line3);
//                System.out.println(dataSet3.length);
                if (dataSet3.length>=4){
 
                vfcmap.setVfcName(dataSet3[0]);
                vfcmap.setPhysLoc(dataSet3[1]);
                vfcmap.setClntId(dataSet3[2]);
                vfcmap.setClntName(dataSet3[3]);

                String statusname = scanner5.next();
                String StatusValue = scanner5.next();
                String fc_nameName = scanner6.next();
                String fc_nameValue = scanner6.next();
                String fc_loc_codeName = scanner6.next();
                String fc_loc_codeVlaue = scanner6.next();
                String ports_loged_inName=scanner7.next();
                String ports_loged_inValue=scanner7.next();
                String flagsName=scanner8.next();
                String flagsValue = scanner8.next();
                String vfc_client_nameName = scanner9.next();
                String vfc_client_nameValue = scanner9.next();
                String vfc_client_drcName = scanner9.next();
                String vfc_client_drcValue = scanner9.next();
                
//                if(vfcName==null){vfcName="null";}
//                if(physLoc==null){physLoc="null";}
//                if(clntID==null){clntID="null";}
//                if(clntName==null){clntName="null";}
                if(StatusValue==null){StatusValue="null";}
                if(fc_nameValue==null){fc_nameValue="null";}
                if(fc_loc_codeVlaue==null){fc_loc_codeVlaue="null";}
                if(flagsValue==null){flagsValue="null";}
                if(vfc_client_nameValue==null){vfc_client_nameValue="null";}
                if(vfc_client_drcValue==null){vfc_client_drcValue="null";}
                

                vfcmap.setStatus(StatusValue);
                vfcmap.setFc_name(fc_nameValue);
                vfcmap.setFc_loc_code(fc_loc_codeVlaue);
                vfcmap.setFlags(flagsValue);
                vfcmap.setVFC_client_name(vfc_client_nameValue);
                vfcmap.setVFC_client_DRC(vfc_client_drcValue);

//                System.out.println(vfcmap.vfcName+" | "+vfcmap.physLoc+" | "+vfcmap.clntId+" | "+vfcmap.clntName+" | "+vfcmap.status+" | "+vfcmap.fc_name+" | "+vfcmap.fc_loc_code+" | "+vfcmap.flags+" | "+vfcmap.VFC_client_name+" | "+vfcmap.VFC_client_DRC);
                
                     
//                 (vfcmap.vfcName,vfcmap.physLoc,vfcmap.clntId,vfcmap.clntName,vfcmap.status,vfcmap.fc_name,vfcmap.fc_loc_code,vfcmap.flags,vfcmap.VFC_client_name,vfcmap.VFC_client_DRC);
//                                System.out.println(list.toString());

//                System.out.println(line1);
//                System.out.println(line2);
//                System.out.println(line3);
//                System.out.println(line4);
//                System.out.println(line5);
//                System.out.println(line6);
//                System.out.println(line7);
//                System.out.println(line8);
//                System.out.println(line9);
//                System.out.println(line10);
            }else{
                
                vfcmap.setVfcName(dataSet3[0]);
                vfcmap.setPhysLoc(dataSet3[1]);
                vfcmap.setClntId(dataSet3[2]);
                vfcmap.setClntName("");
                vfcmap.setStatus("Not Loged In");
                vfcmap.setFc_name("Not Mapped");
                vfcmap.setFc_loc_code("");
                vfcmap.setFlags("");
                vfcmap.setVFC_client_name("");
                vfcmap.setVFC_client_DRC("");}

//                System.out.println(vfcmap.vfcName+" | "+vfcmap.physLoc+" | "+vfcmap.clntId+" | "+vfcmap.clntName+" | "+vfcmap.status+" | "+vfcmap.fc_name+" | "+vfcmap.fc_loc_code+" | "+vfcmap.flags+" | "+vfcmap.VFC_client_name+" | "+vfcmap.VFC_client_DRC);
        
                vfcs.add(vfcmap);
            }
//            System.out.println(vfcmap.fc_name);



        }

    }   
}
    

       public static void main (String[] args) throws IOException, Exception {
            readVFCMap VFCMAP = new readVFCMap("dx1010");
            VFCMAP.processPatern(); 
            for (int i=0; i <= vfcs.size() - 1; i++){
//            System.out.println(vfcCount);
//            System.out.print(i+"  :");
            System.out.println(vfcs.get(i).vfcName+" | "+vfcs.get(i).physLoc+" | "+vfcs.get(i).clntId+" | "+vfcs.get(i).clntName+" | "+vfcs.get(i).status+" | "+vfcs.get(i).fc_name+" | "+vfcs.get(i).fc_loc_code+" | "+vfcs.get(i).flags+" | "+vfcs.get(i).VFC_client_name+" | "+vfcs.get(i).VFC_client_DRC);
//            vfcs.get(i).vfcName+" | "+vfcs.get(i).physLoc+" | "+vfcs.get(i).clntId+" | "+vfcs.get(i).clntName+" | "+vfcs.get(i).status+" | "+vfcs.get(i).fc_name+" | "+vfcs.get(i).fc_loc_code+" | "+vfcs.get(i).flags+" | "+vfcs.get(i).VFC_client_name+" | "+vfcs.get(i).VFC_client_DRC
            }
}


      
}
