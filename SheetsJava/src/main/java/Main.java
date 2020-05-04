import methods.GoogleSheetsReader;
import methods.GoogleSheetsUpdate;
import methods.GoogleSheetsWrite;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;


import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, GeneralSecurityException {
        GoogleSheetsReader read = new GoogleSheetsReader();
        List<List<Object>> values = read.getSheetContent("A2", "F10");
        if(values == null || values.isEmpty()){
            System.out.println("No Data Found");
        } else {
            for (List row : values){
                System.out.printf("%s %s from %s\n", row.get(5), row.get(4), row.get(1));
            }
        }
        List<Object> inRow = new ArrayList<Object>();
        inRow.add("Hello");

        GoogleSheetsWrite write = new GoogleSheetsWrite();
        write.insertInTable(inRow);

        List<Object> updIn = new ArrayList<Object>();
        updIn.add("oops");

        GoogleSheetsUpdate update = new GoogleSheetsUpdate();
        update.updateTable(updIn,"C543");
    }
}
