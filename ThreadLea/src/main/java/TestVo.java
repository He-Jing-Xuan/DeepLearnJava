import syn.SynDemo;
import syn.th1;
import syn.th2;

public class TestVo {
    public volatile int inc = 0;
    public void increase(){
        inc++;
    }

    public static void main(String[] args) throws Exception{
        SynDemo synDemo =new SynDemo();
        th1 h1 = new th1(synDemo);
        th2 h2 =new th2(synDemo);
        h1.start();
        h2.start();
    }
}
