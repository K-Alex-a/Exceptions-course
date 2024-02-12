package Seminars.lesson_03.Task_4;

public class NewPoint2D {
    int x;
    int y;

    public NewPoint2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", x, y);
    }
}
