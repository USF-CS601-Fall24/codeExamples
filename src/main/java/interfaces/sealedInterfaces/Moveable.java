package interfaces.sealedInterfaces;

public sealed interface Moveable permits GameCharacter {
    void move(int x, int y);
}
