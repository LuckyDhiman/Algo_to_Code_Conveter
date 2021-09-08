import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Logic {

    static public String[] processString(String[] str) {
//      System.out.println("Hello WORLD");
//      ArrayList<String> str = new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();


        //  System.out.println("Converting....");
        String temp = "";
        String inner = "";
        boolean errFound = false;
        for (String c : str) {
            if (c.equalsIgnoreCase("start")) {
                res.add("void main(){");
            } else if (c.contains("Print")) {
                res.add(toPrint(c));
            } else if (c.contains("Read")) {
                res.add(toScanf(c));
            } else if ((c.substring(0, 2)).equalsIgnoreCase("if")) {
                res.add(toIf(c));

            } else if (c.equalsIgnoreCase("then"))
                res.add("{");
            else if (c.equalsIgnoreCase("endif"))
                res.add("}");
            else if (c.equalsIgnoreCase("else"))
                res.add("else\n{");
            else if (c.equalsIgnoreCase("endElse"))
                res.add("}");
            else if (c.equalsIgnoreCase("end"))
                res.add("}");
            else {
                res.add(c + ";");
            }
        }
       String[] mystr = new String[res.size()];
        mystr = res.toArray(mystr);
        return mystr;
    }

    public static String toPrint(String c) {
        String temp = "printf(\"";
        int ind = c.indexOf('"');
        int lastInd = c.lastIndexOf('"');
        char ch[] = c.toCharArray();
        if (!c.contains(",")) {

            for (int i = ind + 1; i < lastInd; i++) {
//            if(ch[i]==',')
                temp += ch[i];

            }
            temp += "\");";
        } else {
            lastInd = c.lastIndexOf(',');
            for (int i = ind + 1; i < lastInd; i++) {
                temp += ch[i];
            }
            temp += "%d\",";
            temp += ch[lastInd + 1] + ");";
        }
        return temp;
    }

    public static String toScanf(String str) {
        String temp = "scanf(";
        char ch[] = str.toCharArray();
        temp += "\"%d\",&" + ch[ch.length - 1] + ");";
        return temp;
    }

    public static String toIf(String str) {
        String temp = "if(";
        char[] ch = str.toCharArray();
        for (int i = 3; i < ch.length; i++)
            temp += ch[i];
        temp += ")";
        return temp;
    }


}