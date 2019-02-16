package frc.robot.vision;

public class Block {
    public int sig;
    public int x;
    public int y;
    public int width;
    public int height;
    public int index;
    public int age;

    public Block(int sig, int x, int y, int width, int height, int index, int age) { 
        this.sig = sig;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.index = index;
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("sig: " + sig);
        sb.append(" x: " + x);
        sb.append(" y: " + y);
        sb.append(" width: " + width);
        sb.append(" height: " + height);
        sb.append(" index: " + index);
        sb.append(" age: " + age);
        return sb.toString();
    }
}