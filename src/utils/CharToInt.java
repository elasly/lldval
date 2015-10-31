/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.IOException;
import static utils.ReadWriteExcelFile.readXLSXFile;

/**
 *
 * @author amrmostafa
 */
public class CharToInt {
    public static int CharToInt (String ColChar){
        int columCount = 0;
        switch (ColChar){
                        case "A":
                columCount=1;
                break;
            case "B":
                columCount=2;
                break;
            case "C":
                columCount=3;
                break;
            case "D":
                columCount=4;
                break;
            case "E":
                columCount=5;
                break;
            case "F":
                columCount=6;
                break;
            case "G":
                columCount=7;
                break;
            case "H":
                columCount=8;
                break;
            case "I":
                columCount=9;
                break;
            case "J":
                columCount=10;
                break;
            case "K":
                columCount=11;
                break;
            case "L":
                columCount=12;
                break;
            case "M":
                columCount=13;
                break;
            case "N":
                columCount=14;
                break;
            case "O":
                columCount=15;
                break;
            case "P":
                columCount=16;
                break;
            case "Q":
                columCount=17;
                break;
            case "R":
                columCount=18;
                break;
            case "S":
                columCount=19;
                break;
            case "T":
                columCount=20;
                break;
            case "U":
                columCount=21;
                break;
            case "V":
                columCount=22;
                break;
            case "W":
                columCount=23;
                break;
            case "X":
                columCount=24;
                break;
            case "Y":
                columCount=25;
                break;
            case "Z":
                columCount=26;
                break;
            case "AA":
                columCount=27;
                break;
            case "AB":
                columCount=28;
                break;
            case "AC":
                columCount=29;
                break;
            case "AD":
                columCount=30;
                break;
            case "AE":
                columCount=31;
                break;
            case "AF":
                columCount=32;
                break;
            case "AG":
                columCount=33;
                break;
            case "AH":
                columCount=34;
                break;
            case "AI":
                columCount=35;
                break;
            case "AJ":
                columCount=36;
                break;
            case "AK":
                columCount=37;
                break;
            case "AL":
                columCount=38;
                break;
            case "AM":
                columCount=39;
                break;
            case "AN":
                columCount=40;
                break;
            case "AO":
                columCount=41;
                break;
            case "AP":
                columCount=42;
                break;
            case "AQ":
                columCount=43;
                break;
            case "AR":
                columCount=44;
                break;
            case "AS":
                columCount=45;
                break;
            case "AT":
                columCount=46;
                break;
            case "AU":
                columCount=47;
                break;
            case "AV":
                columCount=48;
                break;
            case "AW":
                columCount=49;
                break;
            case "AX":
                columCount=50;
                break;
            case "AY":
                columCount=51;
                break;
            case "AZ":
                columCount=52;
                break;
            default:
                    break;                
    }
        return columCount;
}
    
    public static void main(String[] args) throws IOException {
		

        int colCount = CharToInt("AA");
        System.out.println(colCount);
	}
}
