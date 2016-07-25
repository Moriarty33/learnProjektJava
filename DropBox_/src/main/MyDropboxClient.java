import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

import java.io.*;
import java.nio.file.*;
import java.nio.file.WatchEvent.Kind;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MyDropboxClient {
    Interface inte = new Interface();
    ExecutorService executor = Executors.newFixedThreadPool(Properties.threadPool);

    public void getDirectoryToWatch(){
            watchDirectoryPath();
    }
    public Path getDirectory(){
        File dir = new File(inte.getComboBox());
        return dir.toPath();

    }

    public void watchDirectoryPath() {
        try {
            Boolean isFolder = (Boolean) Files.getAttribute(getDirectory(),
                    "basic:isDirectory", NOFOLLOW_LINKS);
            if (!isFolder) {
                inte.setError("Ścieżka: " + getDirectory()
                        + " nie jest katalogiem");
            }
        } catch (IOException ioe) {
            inte.setError("Katalog: " + getDirectory()
                    + " nie istnieje !");
        }
        inte.setkalalog_value(getDirectory().toString());
        executor.submit(new StatisticThread());


        FileSystem fs = getDirectory().getFileSystem();

        try (WatchService service = fs.newWatchService()) {

            getDirectory().register(service, ENTRY_CREATE);

            WatchKey key;

            while (true) {

                key = service.take();

                Kind<?> kind;
                for (WatchEvent<?> watchEvent : key.pollEvents()) {
                    kind = watchEvent.kind();

                    if (kind == OVERFLOW) {
                        continue; // loop

                    } else if (kind == ENTRY_CREATE) {
                        Path newPath = ((WatchEvent<Path>) watchEvent).context();

                        executor.submit(new SendFileThread(newPath.toString(), DropboxAuth.client));//, executor));

                        listInterface list = new listInterface();
                        list.addfile(newPath.toString());


                    }
                }
                if (!key.reset()) {
                    break; // loop
                }
            }

        } catch (Exception ioe) {
            inte.setError("Katalog: " + getDirectory()
                    + " nie istnieje !");
        }finally {

        }
    }
}

