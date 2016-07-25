package kolejka;

/**
 * Created by jamin on 22.11.2015.
 */

class FifoQueue<T> extends Abstract<T> {

    @Override
    public void add(T parameterData, MYQUEUE.priority parameterPriority) {
        myObiect = new object<>();
        myObiect.data=parameterData;
        myObiect.priority= parameterPriority;
        myObiect.id=idCounter++;
        myList.addFirst(myObiect);
    }
}
