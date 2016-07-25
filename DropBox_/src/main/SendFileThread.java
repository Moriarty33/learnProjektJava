import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWriteMode;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class SendFileThread implements Runnable {
        String filename;
        DbxClient clientLocal;
        Interface inte = new Interface();

       public SendFileThread(String name,DbxClient client){
           filename = name;
           clientLocal = client;
       }

       @Override
       public void run() {

           try {
               sendFile();
           } catch (Exception e) {
               e.printStackTrace();
           }

       }
        public void sendFile()  throws IOException{
            File inputFile = new File(inte.getComboBox() + "/"  + filename);
            FileInputStream inputStream = new FileInputStream(inputFile);
            try {
                DbxEntry.File uploadedFile = null;
                try {
                    uploadedFile = DropboxAuth.client.uploadFile("/"+ filename,
                            DbxWriteMode.add(), inputFile.length(), inputStream);
                } catch (DbxException e) {
                    e.printStackTrace();
                }

                //System.out.printf(""+uploadedFile.toString());
            } finally {
                inputStream.close();
            }

        }
    }
