package methods;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

public class SheetsWrite {
    String SPREADSHEET_ID = "1tbttmUR3AXDXSH3gWS31R-pDOJhzId2otAy59Wn3iz8";
    private Sheets sheetsService;
    private SheetService googleSheetService = new SheetService();

    public void insertInTable(List<Object> row) throws IOException, GeneralSecurityException {
        this.sheetsService = SheetService.getSheetsService();
        ValueRange appendBody = new ValueRange()
                .setValues(Arrays.asList(row));
        String range = "congress";
        AppendValuesResponse appendValuesResponse = sheetsService.spreadsheets().values()
                .append(SPREADSHEET_ID, range, appendBody)
                .setValueInputOption("USER_ENTERED")
                .setInsertDataOption("INSERT_ROWS")
                .setIncludeValuesInResponse(true)
                .execute();
    }

}
