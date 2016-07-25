package MyList;

/**
 * Created by jamin on 21.11.2015.
 */import java.util.Arrays;

public class MyList<T> {

    private T[] table, tempTable;
    public MyList() { table = (T[])new Object[0]; }

    public int size() {return table.length;}

    public void add(T object)
    {
        table = Arrays.copyOf(table, table.length+1);
        table[table.length-1] = object;
    }

    public T get(int paramIndex)
    {
        if(paramIndex<table.length)
            return table[paramIndex];
        else
            return null;
    }

    public void remove(T param)
    {
        if(table.length == 0)
            return;
        tempTable = (T[])new Object[table.length];
        int j=0;
        for (int i=0; i< table.length; ++i)
        {
            if(table[i] != param)
            {
                tempTable[j] = table[i];
                j++;
            }
        }
        table=Arrays.copyOf(tempTable, j);
    }
    public void removeIndex(int param)
    {
        if(table.length == 0)
            return;
        tempTable = (T[])new Object[table.length];
        int j=0;
        for (int i=0; i< table.length; ++i)
        {
            if(i != param)
            {
                tempTable[j] = table[i];
                j++;
            }
        }
        table=Arrays.copyOf(tempTable, j);
    }
    public int findFirst(T param)
    {
        for (int i=0; i< table.length; ++i)
            if(table[i] == param)
                return i;
        return -1;
    }
    public boolean replace(int first, int second)
    {
        if (first >= table.length || second >= table.length)
            return false;
        else if(first <0 || second < 0)
            return false;
        T temp = table[first];
        table[first] = table[second];
        table[second] = temp;
        return true;
    }
}
