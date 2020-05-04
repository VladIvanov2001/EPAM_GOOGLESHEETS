package methods;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

public class GoogleSheetsReader {
    private GoogleSheetService sheetService = new GoogleSheetService();


    public List<List<Object>> getSheetContent(String begin, String end) throws IOException, GeneralSecurityException {
        Sheets sheetsService = GoogleSheetService.getSheetsService();
        String range = "congress" + "!" + begin + ":" + end;
        String SPREADSHEET_ID = "1tbttmUR3AXDXSH3gWS31R-pDOJhzId2otAy59Wn3iz8";
        ValueRange response = sheetsService.spreadsheets().values().get(SPREADSHEET_ID, range)
                .execute();
        return response.getValues();
    }
}

