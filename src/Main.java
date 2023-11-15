import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) throws IOException {
       //1
        getSubMap(Arrays.stream("1:one 2:two 3:three 4:four 5:five 6:six 7:seven".split(" "))
                .map(s -> s.split(":"))
                .collect(Collectors.toMap(p -> Integer.parseInt(p[0]), p -> p[1], (v1, v2) -> v1, TreeMap::new))).
                forEach((i, s) -> System.out.println(i + " : " + s));
        //2
        noLongString(Arrays.stream("its no long string".split(" ")).collect(Collectors.toList())).forEach(System.out::println);

        //3
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "ImageButton JTextField JTextArea CheckBox JMenu";
        List<String> list = Arrays.stream(reader.readLine().split(" "))
                                  .filter(s->s.startsWith("J"))
                                  .map(s -> s.substring(1, s.length()))
                                        .collect(Collectors.toList());
        Collections.reverse(list);
        list.forEach(System.out::println);
    }

    //1
    public static NavigableMap<Integer, String> getSubMap(NavigableMap<Integer, String> map){
        if (map.firstEntry().getKey()%2 !=0){
            return map.subMap(map.firstKey(), true,map.firstKey()+4,true).descendingMap();
        } else{
            return map.subMap(map.lastKey()-4, true, map.lastKey(), true).descendingMap();
        }
    }

    //2
    public static List<String> noLongString(List<String> strings) {

    return strings.stream().filter(s->s.length()<4).collect(Collectors.toList());
    }

}