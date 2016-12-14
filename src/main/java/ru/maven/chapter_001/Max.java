package ru.maven.chapter_001;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Max {

    public static void main(String[] args) {
        Max max = new Max();
        System.out.println(max.max(3, 2, 1));
        System.out.println(max.max(1, 3, 2));
        System.out.println(max.max(1, 2, 3));
    }

    int max(int one, int two, int three) {
        return max(one, max(two, three));
    }

    private int max(int one, int two) {
        return one > two ? one : two;
    }

    /*
    //Method for define max in any array

    public Max(final int[] values){
        this.values = Arrays.copyOf(values, values.length);
    }

    public int max(){
        int max = this.values[0];
        for (int value : this.values){
            max = this.max(max, value);
        }
     return max;
    }
 */
}
