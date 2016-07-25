package List;

import MyList.MyList;

/**
 * Created by jamin on 21.11.2015.
 */
public class TestList {
    public void test()
    {
        MyList<String> list = new MyList<String>();
        list.add("my");
        list.add("firs");
        list.add("list");
        list.add("list2");
        list.add("list1");
        for (int i =0; i < list.size(); i++)
            System.out.println(list.get(i));

        list.remove("list");
        int index = list.findFirst("my");
        list.removeIndex(index);
        list.removeIndex(3);

        index = list.findFirst("list");
        list.replace(index, 3);
        list.remove("list2");
        for (int i =0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}
