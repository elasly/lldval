
import java.util.List;
import static utils.ReadLLDSheet.ReadLLDSheet;
import static utils.sqlinsert.sqlinsert;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Testing {
    public static void main(String[] args) throws Exception{
    List Sheet = ReadLLDSheet("./LLD.xlsx",8);
sqlinsert("testdb",Sheet,8);
        showListData(Sheet);

    }
private static void showListData(List sheetData) {
        //
        // Iterates the data and print it out to the console.
        //
        for (int i = 0; i < sheetData.size(); i++) {
            List list = (List) sheetData.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j)+" ");
                if (j < list.size() - 1) {
                    System.out.print("");
                }
            }
            System.out.println("");
        }
}
}
