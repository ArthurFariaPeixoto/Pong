import java.awt.*;
import java.util.Random;

public class Ball {

    public double x, y;
    public int WIDTH, HEIGHT;
    public double dx, dy;
    public double speed = 1.7;

    public Ball(int x, int y){
        this.x = x;
        this.y = y;
        this.WIDTH = 4;
        this.HEIGHT = 4;

        int angle = new Random().nextInt((120 - 45) + 46);
        dx = Math.cos(Math.toRadians(angle));
        dy = Math.sin(Math.toRadians(angle));
    }

    public void tick(){
        /*Colisao com parede*/
        if(x + (dx * speed) + WIDTH >= Game.WIDTH){
            Sound.bounce.play();
            dx *= -1;
        }
        else if(x + (dx * speed) < 0){
            Sound.bounce.play();
            dx *= -1;
        }
        /* ****** */
        if(y>= Game.HEIGHT){
            Sound.lose.play();
            Enemy.ponto++;
            //System.out.println("Ponto do bot");
            //System.out.println("Player: "+Player.ponto);
            //System.out.println("Bot: "+Enemy.ponto);
            new Game();
            return;
        }
        else if(y < 0){
            Sound.win.play();
            Player.ponto++;
            //System.out.println("Ponto do jogador");
            //System.out.println("Player: "+Player.ponto);
            //System.out.println("Bot: "+Enemy.ponto);
            new Game();
            return;
        }
        Rectangle bounds = new Rectangle((int)x + ((int)dx * (int)speed), (int)y + ((int)dy*(int)speed), WIDTH, HEIGHT);
        Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.WIDTH, Game.player.HEIGHT);
        Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x, (int)Game.enemy.y, Game.enemy.WIDTH, Game.enemy.HEIGHT);

        /*Colisao com os jogadores*/
        if(bounds.intersects(boundsPlayer)){
            Sound.bounce.play();
            int angle = new Random().nextInt((120 - 45) + 46);
            dx = Math.cos(Math.toRadians(angle));
            dy = Math.sin(Math.toRadians(angle));
            if(dy > 0){
                dy *= -1;
            }
        }
        else if(bounds.intersects(boundsEnemy)){
            Sound.bounce.play();
            int angle = new Random().nextInt((120 - 45) + 46);
            dx = Math.cos(Math.toRadians(angle));
            dy = Math.sin(Math.toRadians(angle));
            if(dy < 0){
                dy *= -1;
            }
        }
        /* ******* */
        x += dx * speed;
        y += dy * speed;


    }
    public void render(Graphics g){
        g.setColor(Color.RED);
        g.fillRect((int)x,(int) y, WIDTH, HEIGHT);
    }
}
