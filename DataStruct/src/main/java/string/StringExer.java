package string;

public class StringExer {
    String str = new String("嘻嘻");
    char [] ch = {'r','b'};
    public void change(String str , char [] chs){
        str = "嘿嘿";
        chs[0]='m';
    }

    public static void main(String[] args) {
        StringExer stringExer =new StringExer();
        stringExer.change(stringExer.str, stringExer.ch);
        System.out.println(stringExer.str);
        System.out.println(stringExer.ch);
    }
}
