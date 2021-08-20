package src.Valatile;

public class Test1 {
     static int M;
    public static void main(String[] args) {

        new Thread(()->{

           if(M==1){
            System.out.println(1111);
        }
    }).start();
        new Thread(()->{

            if (M==0){
                System.out.println("啦啦啦啦啦");
            }

        }).start();

    }
}
