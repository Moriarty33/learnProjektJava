import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class StatisticThread implements Runnable {

    public static int counter;
    void write(String currentDate){
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("statictics.txt", true)))) {
            out.println(currentDate + ": " + counter/(float) Properties.secondBetweenStatisticWriting + "/sek");
        }catch (IOException e) {
        }
    }
    @Override
    public void run() {
        while(true) {
            try {
                TimeUnit.SECONDS.sleep(Properties.secondBetweenStatisticWriting);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Date currentDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss"); //tylko raz
            String dateString = dateFormat.format(currentDate);
            write(dateString);
            resetStaticticCounter();
        }
    }

    public static synchronized void incrementStaticticCounter(){
        counter++;
    }
    public void resetStaticticCounter(){
        counter=0;
    }
}

