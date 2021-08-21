package code;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String [][] str = new String[n][2];
        for(int i=0 ;i < n;i++){
            String temp = scanner.next();
            System.out.println(temp);
            str[i][0] =temp.split("-")[0];
            str[i][1] = temp.split("-")[1];
        }
        int [][] arr =new int[4][2];
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        PriorityQueue<String> pq = new PriorityQueue<>();
       int num =0 ;
       int time =0;
       String last = str[0][0];
       int i=0 ;
       while(i<n  || !pq.isEmpty()){
           while (i<n&& str[i][0].equals(last)){
               pq.offer(str[i++][1]);
           }
           while (!pq.isEmpty()&&pq.peek().compareTo(last)==-1){
               pq.poll();
           }
           if(!pq.isEmpty()){
               pq.poll();
               time += calTime(str[i][1],str[i][0]);
               num++;
           }
           last =str[i][1];
       }
    }
    public  static long calTime (String time1 ,String time2){
        DateFormat df = new SimpleDateFormat("HH:mm");
        long minutes = 0L;
        try{
            Date d1 = df.parse(time1);
            Date d2 = df.parse(time2);
            long diff = d1.getTime() -d2.getTime();
            minutes = diff/(1000*60);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  minutes;
    }
}
