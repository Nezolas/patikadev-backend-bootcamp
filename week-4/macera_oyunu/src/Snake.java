import java.util.Random;

public class Snake extends Obstacle{
    private static final Random random = new Random();
    public Snake() {

        super(4,"Yılan", random.nextInt(3,7), 12,0);
    }
}
