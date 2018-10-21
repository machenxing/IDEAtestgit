package unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Test1 {
    public Unsafe getUnsafe() {
        try {
            final Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            // the unsafe instance
            return (Unsafe) unsafeField.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args)throws Exception {
        Test1 test = new Test1();
        Unsafe unsafe = test.getUnsafe();
        //帮助理解concurrentHashmap
        Dog[] dogs = new Dog[3];
        //获取数组中第一个元素的偏移量
        long dogBase = unsafe.arrayBaseOffset(Dog[].class);
        //获取数组中一个元素的大小
        int ts = unsafe.arrayIndexScale(Dog[].class);
        int dogShift = 31 - Integer.numberOfLeadingZeros(ts);
        unsafe.putOrderedObject(dogs, dogBase, new Dog("旺财",3));
        unsafe.putOrderedObject(dogs, (long)(1 << dogShift) + dogBase, new Dog("小强",4));
        unsafe.putOrderedObject(dogs, ts*2 + dogBase, new Dog("富贵", 5));
        for(int i = 0 ; i < dogs.length ; i++){
            System.out.println(dogs[i].toString());
        }
    }
}
