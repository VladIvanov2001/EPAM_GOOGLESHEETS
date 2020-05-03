import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import methods.GoogleSheetsReader;
import methods.SheetsUpdate;
import methods.SheetsWrite;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.*;


import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, GeneralSecurityException {
        GoogleSheetsReader read = new GoogleSheetsReader();
        List<List<Object>> values = read.getSheetContent("A2", "F10");
        if(values == null || values.isEmpty()){
            System.out.println("No DAta Found");
        } else {
            for (List row : values){
                System.out.printf("%s %s from %s\n", row.get(5), row.get(4), row.get(1));
            }
        }
        List<Object> inRow = new ArrayList<Object>();
        inRow.add("Hello");

        SheetsWrite write = new SheetsWrite();
        write.insertInTable(inRow);

        List<Object> updIn = new ArrayList<Object>();
        updIn.add("oops");

        SheetsUpdate update = new SheetsUpdate();
        update.updateTable(updIn,"C543");
    }
}
