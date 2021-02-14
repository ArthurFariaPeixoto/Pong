import java.awt.*;

public class Player {

    public boolean right, left;
    public int x, y;
    public int WIDTH, HEIGHT;
    public double speed = 2.0;

    public Player(int x, int y){
        this.x = x;
        this.y = y;
        this.WIDTH = 40;
        this.HEIGHT = 5;
    }
    public void tick() {
        if (right) {
            x+=speed;
        } else if (left) {
            x-=speed;
        }
        if(x+WIDTH > Game.WIDTH){
            x = Game.WIDTH - WIDTH;
        }
        else if(x < 0){
            x = 0;
        }
    }
    public void render(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}
