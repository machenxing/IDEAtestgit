import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int a=5;
        int b=(a>>1);
        System.out.println("b��ֵ��"+b);
        int[] c={1,2,3,4,5,0,0,0,0};
//        int[] d={6,7,8,9,10};
        System.arraycopy(c,3,c,1,3);
        for(int n:c){
            System.out.println(n);
        }
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("1");
        // ��Ҫ��foreachѭ�������Ԫ�ص�remove/add����������ע�ʹ���ᱨ��
        /*for (String item : list) {
            if ("1".equals(item)) {
                list.remove(item);
            }
        }*/
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("1".equals(item)) {
                iterator.remove();
            }
        }
    }
}
