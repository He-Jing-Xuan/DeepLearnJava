package src.DeepLearn;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 管道输入输出：它主要 用于线程之间的数据传输，而传输的媒介为内存。
 *
 */
public class Pipe {
    public static void main(String[] args) throws Exception{
        PipedWriter out=new PipedWriter();
        PipedReader in =new PipedReader();
        // 将输出流和输入流进行连接，否则在使用时会抛出IOException
        out.connect(in);
        Thread printThread = new Thread(new Print(in), "PrintThread");
         printThread.start();
        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1)
            {
                out.write(receive);
            }
        } finally {
            out.close();
        }
    }
    static class Print implements Runnable{
        private PipedReader in;
        public  Print(PipedReader pipedReader){
            in=pipedReader;
        }
        @Override
        public void run() {
            int recive=0;
            try {
                while ((recive=in.read())!=-1){
                    System.out.println((char) recive);
                }
            }catch (IOException e){
            }
        }
    }
}
