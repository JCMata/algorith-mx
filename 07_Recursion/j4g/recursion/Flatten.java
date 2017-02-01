package j4g.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ernesto_Espinosa on 1/30/2017.
 */
public class Flatten {

    public static Object[] flatten(Object unknown) {
        return isArray(unknown) ? flatten((Object[]) unknown) : new Object[] { unknown };
    }

    private static Object[] flatten(Object[] array) {
        List<Object> flatten = new ArrayList<>();

        for (Object o : array) {
            flatten.addAll(Arrays.asList(flatten(o)));
        }

        return flatten.toArray();
    }

    private static boolean isArray(Object object) {
        return object.getClass().isArray();
    }

    public static void main(String...args) {
        Object[] array = { 1, 2, new Object[] { 3, 4, new Object[] { 5, 6 }, 7 }, new Object[] { 8, 9 }, 10, 11 };
        System.out.println(Arrays.toString(flatten(array)));
    }
}