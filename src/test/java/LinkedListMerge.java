import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListMerge {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(6);

        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.add(2);
        list2.add(3);
        list2.add(4);

        LinkedList<Integer> list3 = new LinkedList<Integer>();
        list3.add(3);
        list3.add(5);
        list3.add(7);
        list3.add(14);

        ArrayList<LinkedList<Integer>> lists = new ArrayList<LinkedList<Integer>>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

        LinkedList<Integer> resultList = new LinkedList<Integer>();
        merge(lists, resultList);
        System.out.println(resultList);
    }

    private static void merge(ArrayList<LinkedList<Integer>> lists, LinkedList<Integer> resultList) {
        ArrayList<Integer> headList = new ArrayList<Integer>();
        for (int i = 0; i < lists.size(); i++) {
            LinkedList<Integer> list = lists.get(i);
            if (list == null || list.size() == 0) {
                lists.remove(i);
                i--;
                continue;
            } else {
                headList.add(list.get(0));
            }
        }

        if (headList != null && headList.size() > 0) {
            // 计算headList的最小值
            Integer min = headList.get(0);
            int listIndex = 0;
            for (int i = 1; i < headList.size(); i++) {
                Integer tmp = headList.get(i);
                if (tmp < min) {
                    min = tmp;
                    listIndex = i;
                }
            }
            LinkedList<Integer> list = lists.get(listIndex);
            list.remove(0);

            if (resultList.size() == 0) {
                resultList.add(min);
            } else if (!resultList.getLast().equals(min)) {
                resultList.add(min);
            }

            merge(lists, resultList);
        }
    }


}

