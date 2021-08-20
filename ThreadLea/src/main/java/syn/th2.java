package syn;

public class th2 extends Thread {
    private SynDemo synDemo;
    public th2(SynDemo synDemo){
        this.synDemo =synDemo;
    }

    @Override
    public void run() {
        try {
            synDemo.dosth2();
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
