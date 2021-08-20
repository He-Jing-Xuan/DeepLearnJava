package src;

public class Foo {
    private int x=5;
    public int getX(){
        return x;
    }
    public int setX(int y){
        this.x=y+x;
        return x;
    }
}
