public class Test {
    public static void main(String[] args) {
        int a=5;
        int b=(a>>1);
        System.out.println("bµÄÖµÊÇ"+b);
        int[] c={1,2,3,4,5,0,0,0,0};
//        int[] d={6,7,8,9,10};
        System.arraycopy(c,3,c,1,3);
        for(int n:c){
            System.out.println(n);
        }
    }
}
