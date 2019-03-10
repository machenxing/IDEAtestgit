import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Java8 filter过滤器
 */
public class Filter {
    public static void main(String[] args) {
        List<Long> listLong = new ArrayList<>();
        for(int i=0; i<100000 ; i++) {
            listLong.add( (long) i);
        }
        List<Long> stream = listLong.stream().filter(Long ->{
            return Long.equals(666L) || Long.equals(777L) || Long.equals(888L);
        }).collect(Collectors.toList());
        for (Long l : stream) {
            System.out.println(l);
        }
//        stream.forEach(System.out::println);
    }
}
