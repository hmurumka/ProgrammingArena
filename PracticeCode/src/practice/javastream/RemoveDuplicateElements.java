package practice.javastream;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class RemoveDuplicateElements {

    public static void main(String[] args) {
        RemoveDuplicateElements o = new RemoveDuplicateElements();
        System.out.println(Arrays.toString(o.clean(new int[]{2, 5, 3, 7, 5, 8})));
    }

    private int[] clean(int[] is) {
        if(Objects.isNull(is) || is.length < 1)
            throw new IllegalArgumentException("Input is not a valid input");
        else
        {
            Stream.of(is).map
        }
    }
}
