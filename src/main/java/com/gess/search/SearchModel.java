package com.gess.search;

import com.gess.data.Data;

import java.util.Random;

/**
 * 从1000个数 查找K
 * Random
 */
public class SearchModel {
    public static final int ERROR = -1;
    public static void main(String[] args) {
        System.out.println("顺序查找 " + orderQuery());
    }

    /**
     * 产生数据
     */
    public static void produce(){
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for (int i = 0; i < 1000; i++) {
            int r = random.nextInt(10000);
            sb.append(r);
            sb.append(",");
        }
        sb.append("}");

        System.out.println(sb);
    }

    /**
     * 顺序查找
     */
    public static long orderQuery(){
        int k = 2455;
        Long s = System.currentTimeMillis();
        for (int i = 0; i < Data.SEARCH_DATA.length; i++) {
            if (Data.SEARCH_DATA[i] == k){
                return System.currentTimeMillis() - s;
            }
        }
        return ERROR;
    }

}
