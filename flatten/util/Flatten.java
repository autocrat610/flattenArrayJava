package com.example.flatten.util;

import java.util.LinkedList;
import java.util.List;


/**
 * This class is used to flatten the array. It can be used only with non-primitive data types (Integer, Long,
 * String, Object, etc)
 *
 * However, we can extend this to primitive(int, long, short etc) also. This is future work.
 */
public class Flatten {

    /**
     * This method will flat the array based on input depth
     * <p>
     * If depth is less or equal to 0, it will completely flat the array
     * It depth is 1, then it will flat till 1 depth
     * It depth is 2, then it will flat till 2 depth and so on
     *
     * @param arr
     * @param depth
     * @return
     */
    public static Object[] flat(Object[] arr, int depth) {
        Object[] temp = arr;
        if (depth <= 0) {
            return flat(temp);
        }
        for (int i = 0; i < depth; i++) {
            temp = flatOnce(temp);
        }
        return temp;
    }

    /**
     * This method will completely flat the array
     *
     * @param arr
     * @return
     */
    private static Object[] flat(final Object[] arr) {
        List<Object> list = null;
        Object[] temparr = arr;
        Boolean flag = false;
        while (!flag) {
            flag = true;
            list = new LinkedList<>();
            for (int i = 0; i < temparr.length; i++) {
                if (isArray(temparr[i])) {
                    flag = false;
                    Object[] temp = (Object[]) temparr[i];
                    for (int j = 0; j < temp.length; j++) {
                        list.add(temp[j]);
                    }
                } else {
                    list.add(temparr[i]);
                }
            }
            temparr = list.toArray();
        }
        return temparr;
    }

    /**
     * This method will flat the array 1 depth
     *
     * @param arr
     * @return
     */
    private static Object[] flatOnce(Object[] arr) {
        List<Object> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (isArray(arr[i])) {
                Object[] temp = (Object[]) arr[i];
                for (int j = 0; j < temp.length; j++) {
                    list.add(temp[j]);
                }
            } else {
                list.add(arr[i]);
            }
        }
        return list.toArray();
    }

    /**
     * This method will check if obj is array or not
     *
     * @param obj
     * @return
     */
    public static boolean isArray(Object obj) {
        return obj != null && obj.getClass().isArray();
    }
}

