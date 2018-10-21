package unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Test {
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
        Test test = new Test();
        Unsafe unsafe = test.getUnsafe();
        Dog dog = new Dog();
        // 获取name属性偏移量
        long nameOffset = unsafe.objectFieldOffset(Dog.class.getDeclaredField("name"));
        unsafe.putObject(dog, nameOffset, "旺财");
        //获取age属性偏移量
        long ageOffset = unsafe.objectFieldOffset(Dog.class.getDeclaredField("age"));
        unsafe.putInt(dog, ageOffset,3);
        System.out.println(dog.toString());
    }

}
