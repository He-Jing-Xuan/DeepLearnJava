package syn;

public class th1 extends Thread{
    private SynDemo synDemo;
    public th1(SynDemo synDemo){
        this.synDemo = synDemo;
    }
    @Override
    public void run() {

        try {
            Thread.sleep(200);
            synDemo.dosth();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
