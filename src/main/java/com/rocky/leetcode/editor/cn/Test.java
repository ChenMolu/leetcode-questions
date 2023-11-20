package com.rocky.leetcode.editor.cn;


/**
 * 字节面试饮料问题？
 * 15瓶饮料，2个空瓶子换一瓶，4个空瓶盖换一瓶，问一共能喝多少瓶
 */
public class Test {
    public static int all = 15;
    public static int leftBottle;
    public static int leftTop;

    public static void main(String[] args) {
        all = all + drink(15, 15);
        System.out.println("总共能喝" + all);
        System.out.println("剩下酒瓶个数" + leftBottle);
        System.out.println("剩下盖子个数" + leftTop);
    }

    public static int drink(int bottle, int top) {
        if (bottle >= 2 || top >= 4) {
            leftBottle = (bottle / 2) + (bottle % 2) + (top / 4);
            leftTop = (top / 4) + (top % 4) + (bottle / 2);
            return (bottle / 2) + (top / 4) + drink(leftBottle, leftTop);
        }
        return 0;
    }
}