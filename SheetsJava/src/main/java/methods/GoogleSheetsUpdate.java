package methods;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GoogleSheetsUpdate {
    String SPREADSHEET_ID = "1tbttmUR3AXDXSH3gWS31R-pDOJhzId2otAy59Wn3iz8";
    private Sheets sheetsService;
    private GoogleSheetService sheetService = new GoogleSheetService();

    public void updateTable(List<Object> row, String range) throws IOException, GeneralSecurityException {
        this.sheetsService = GoogleSheetService.getSheetsService();
        ValueRange body = new ValueRange()
                .setValues(Collections.singletonList(row));
        UpdateValuesResponse updateValuesResponse = sheetsService.spreadsheets().values()
                .update(SPREADSHEET_ID, range, body)
                .setValueInputOption("RAW")
                .execute();
    }
}
