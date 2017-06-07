package szi.utils.common;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by NM.Rabotaev on 07.06.2017.
 */
public class StringUtil {
    public static Set<Integer> parseIntsWithSeparator(String s, String separator) {
        Set<Integer> ints = new HashSet<>();
        if (s!=null && !s.isEmpty()) {
            Arrays.asList(s.split(separator)).forEach(id -> ints.add(Integer.valueOf(id)));
        }
        return ints;
    }
}
