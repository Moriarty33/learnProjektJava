package kolejka;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by jamin on 22.11.2015.
 */
public class Test {
    public static void Test() {
        Abstract myQueue;
        Scanner reader = new Scanner(System.in);

        System.out.println("1 - LIFO ");
        System.out.println("2 - FIFO ");
        String inputQueueType = reader.next();
        if(inputQueueType.equals("1"))
            myQueue = new LifoQueue<String>();
        else if (inputQueueType.equals("2"))
            myQueue = new FifoQueue<String>();
        else
            return;

        while(true) {
            System.out.println("1 - add element");
            System.out.println("2 - get element");
            System.out.println("3 - exit");
            String inputOperation = reader.next();
            if (inputOperation.equals("1")) {
                System.out.println("Enter data:");
                String inputData = reader.next();
                System.out.println("Priority: \n1 - LOW \n2 - NORMAL \n3 - URGNET");
                String inputPriority = reader.next();
                if (inputPriority.equals("1"))
                    myQueue.add(inputData, MYQUEUE.priority.LOW);
                else if (inputPriority.equals("2"))
                    myQueue.add(inputData, MYQUEUE.priority.NORMAL);
                else if (inputPriority.equals("3"))
                    myQueue.add(inputData, MYQUEUE.priority.URGENT);
                else
                    break;
            } else if (inputOperation.equals("2")) {
                try {
                    object temp = myQueue.get();
                    System.out.println("\tDate: " + temp.data + "\tPriority:" + temp.priority + "\tid=" + temp.id + "\n");
                } catch (NoSuchElementException e) {
                    System.out.println("\tEmpty !\n");
                }
            }
            else
                break;
        }
    }
}
