package game.object;

import game.SetupGame;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

public class Camera {

    public int x, y;
    public int mapWidth, mapHeight;

    public Rectangle viewPort;

    public Camera(TiledMap map, int mapWidth, int mapHeight) {
        x = 0;
        y = 0;
        viewPort = new Rectangle(0, 0, SetupGame.WIDTH, SetupGame.HEIGHT);
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
    }

    public void translate(Graphics g, Character character) {

        if (character.getX() - SetupGame.WIDTH / 2 + 16 < 0) {
            x = 0;
        } else if (character.getX() + SetupGame.WIDTH / 2 + 16 > mapWidth) {
            x = -mapWidth + SetupGame.WIDTH;
        } else {
            x = (int) -character.getX() + SetupGame.WIDTH / 2 - 16;
        }

        if (character.getY() - SetupGame.HEIGHT / 2 + 16 < 0) {
            y = 0;
        } else if (character.getY() + SetupGame.HEIGHT / 2 + 16 > mapHeight) {
            y = -mapHeight + SetupGame.HEIGHT;
        } else {
            y = (int) -character.getY() + SetupGame.HEIGHT / 2 - 16;
        }
        g.translate(x, y);
        viewPort.setX(-x);
        viewPort.setY(-y);
    }

    public Rectangle getViewPort() {
        return viewPort;
    }
}