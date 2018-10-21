package unsafe;

public class Dog {
    private String name;
    private int age;

    public Dog(){
        this.name = null;
        this.age = 0;
    }

    public Dog(String name, int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{\"Dog\":{"
                + "                        \"name\":\"" + name + "\""
                + ",                         \"age\":\"" + age + "\""
                + "}}";
    }
}
