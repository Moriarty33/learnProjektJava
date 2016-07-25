import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;

import java.util.Locale;


public class DropboxAuth {

    static DbxClient client;

    public void autorizeDropbox() {

        DbxRequestConfig config = new DbxRequestConfig(
                "JavaTutorial/1.0", Locale.getDefault().toString());
        Interface inte = new Interface();
        try {
            client = new DbxClient(config, Properties.accessToken);
            inte.setScenetitle("DropBox. Połączono z kontem: " + client.getAccountInfo().displayName);


        } catch (DbxException e) {
            inte.setScenetitle("Błąd połączenia z kontem! ");
            System.exit(0);
        }
    }
}
