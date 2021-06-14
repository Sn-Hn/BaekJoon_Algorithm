package dynamicProgramming_DP;

import java.util.ArrayList;
import java.util.List;

public class LIS_BinarySearch {
    public static void main(String[] args) {
        int[] arr = {8, 2, 4, 3, 6, 11, 7, 10, 14, 5, 9, 16, 17, 15};

        LIS_BinarySearch(arr);
    }

    private static void LIS_BinarySearch(int[] arr) {
        int size = 0;

        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            if (value > list.get(list.size() - 1)) {
                list.add(value);
            }else {
                int index = lowerBound(value, list);
                list.set(index, value);
            }
        }

        printList(list);

        System.out.println(list.size());
    }

    private static int lowerBound(int value, List<Integer> list) {
        int start = 0;
        int end = list.size() - 1;
        int mid = 0;

        while(start <= end) {
            mid = (start + end) / 2;

            if (value > list.get(mid)) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        return start;
    }

    private static void printList(List<Integer> list) {
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}