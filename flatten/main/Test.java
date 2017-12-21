package com.example.flatten.main;

import com.example.flatten.util.Flatten;

/**
 * Created by lgoel3 on 12/21/2017.
 */
public class Test {
    public static void main(String[] args) {

        //{ { { "1" , "2" } , { 3 ,4 } } , { 5 , 6 } }
        Object[] myarray = new Object[]{
                new Object[]{new String[]{"1", "2"},
                        new Integer[]{3, 4}},
                new Integer[]{5, 6}
        };

        //flatten above array to depth 1 will give length of array = 4 { { "1" , "2" }, { "3" , "4" } , 5 , 6 }
        System.out.println(Flatten.flat(myarray, 1).length);

        //flatten above array to depth 1 will give length of array = 6
        System.out.println(Flatten.flat(myarray, 2).length);

        //flatten above array fully will give length of array = 6
        System.out.println(Flatten.flat(myarray, 0).length);


        //{{1,2},{3,4}}
        Integer[][] i = new Integer[][]{{1, 2}, {3, 4}};

        //flatten above array fully will give length of array = 2
        System.out.println(Flatten.flat(i, 1).length);

        //flatten above array fully will give length of array = 4
        System.out.println(Flatten.flat(i, 0).length);
    }
}
