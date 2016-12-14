package ru.maven.chapter_001;

public class Max {
    public static void main(String[] args) {
        Max max = new Max();
        System.out.println(max.max(3, 2, 1));
        System.out.println(max.max(1, 3, 2));
        System.out.println(max.max(1, 2, 3));
    }

    public int max(int one, int two, int three) {
        return max(one, max(two, three));
    }

    public int max(int one, int two) {
        return one > two ? one : two;
    }
}
