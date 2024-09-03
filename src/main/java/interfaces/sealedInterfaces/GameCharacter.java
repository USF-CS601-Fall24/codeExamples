package interfaces.sealedInterfaces;

public final class GameCharacter implements Moveable {
    private String name;
    private int currX;
    private int currY;

    public GameCharacter(String name, int currX, int currY) {
        this.name = name;
        this.currX = currX;
        this.currY = currY;
    }

    @Override
    public void move(int x, int y) {
       currX = x;
       currY = y;
    }
}
