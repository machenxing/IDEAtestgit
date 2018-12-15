public class Final {
    int getRet(){
        int ret;
        try {
            ret = 1;
            ret = 5/0;   // 此行注释或不注释，最终均输出 3
            return ret;  // first return
        } catch (Exception e) {
            ret = 2;
            return ret; // second return
        } finally {
            ret = 3;
            return ret; // third return
        }
          // return ret; // fourth return
    }

    public static void main(String[] args) {
        Final f = new Final();
        int s;
        s = f.getRet();
        System.out.println(s);
    }
}
