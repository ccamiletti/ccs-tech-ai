package nl.ccstech.ai;

import java.util.HashSet;

public class Test {

    public static void main(String[] args) {
        HashSet set = new HashSet<String>();
        set.add("a");
        set.add("a");
        set.add("b");

        set.stream().forEach(a -> System.out.println(a));
    }


}
