package game.object;

import game.statics.StageInitializer;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.tiled.TiledMap;

public class Character {

    private int x, y;
    private Animation animation;

    private boolean down, up, right, left;
    private int duration = 35; // 35 - optimal

    public Character(int x, int y, Animation animation) {
        this.x = x;
        this.y = y;
        this.animation = animation;
    }

    public void update(GameContainer gc, int mapWidth, int mapHeight, int tileWidth, int tileHeight, TiledMap map, Rectangle collisionBlock) throws SlickException {
        Vector2f trans = new Vector2f(0, 0);
        Input input = gc.getInput();

        // animation
        if (input.isKeyDown(Input.KEY_DOWN)) {
            if (!down){
                animation = new Animation(StageInitializer.getCharacterWalkDown(), duration);
                down = true; up = false; right = false; left = false;
            }
        } else if (input.isKeyDown(Input.KEY_UP)) {
            if (!up){
                animation = new Animation(StageInitializer.getCharacterWalkUp(), duration);
                down = false; up = true; right = false; left = false;
            }
        } else if (input.isKeyDown(Input.KEY_LEFT)) {
            if (!left){
                animation = new Animation(StageInitializer.getCharacterWalkLeft(), duration);
                down = false; up = false; right = false; left = true;
            }
        } else if (input.isKeyDown(Input.KEY_RIGHT)) {
            if (!right){
                animation = new Animation(StageInitializer.getCharacterWalkRight(), duration);
                down = false; up = false; right = true; left = false;
            }
        }

        int wallLayerIndex = map.getLayerIndex("Collisions");

        map.getTileId(0,0, wallLayerIndex);

        int step = 8 /*pixels*/;

        /********** walk x,y,z directions ************************/
//        if (input.isKeyDown(Input.KEY_UP) && input.isKeyDown(Input.KEY_LEFT)) {
//            if (map.getTileId((x/ step)-1, (y/ step)-1, wallLayerIndex) == 0) {
//                trans.y -= step;
//                trans.x -= step;
//            }
//        } else if (input.isKeyDown(Input.KEY_UP) && input.isKeyDown(Input.KEY_RIGHT)) {
//            if (map.getTileId((x/ step)+1, (y/ step)-1, wallLayerIndex) == 0) {
//                trans.y -= step;
//                trans.x += step;
//            }
//        } else if (input.isKeyDown(Input.KEY_DOWN) && input.isKeyDown(Input.KEY_LEFT)) {
//            if (map.getTileId((x/ step)-1, (y/ step)+1, wallLayerIndex) == 0) {
//                trans.y += step;
//                trans.x -= step;
//            }
//        } else if (input.isKeyDown(Input.KEY_DOWN) && input.isKeyDown(Input.KEY_RIGHT)) {
//            if (map.getTileId((x/ step)+1, (y/ step)+1, wallLayerIndex) == 0) {
//                trans.y += step;
//                trans.x += step;
//            }
//        } else
        /**********************************************************/

        if (input.isKeyDown(Input.KEY_UP)) {
            if (map.getTileId(x/ step, (y/ step)-1, wallLayerIndex) == 0) {
                trans.y -= step;
            }
        } else if (input.isKeyDown(Input.KEY_DOWN)) {
            if (map.getTileId(x/ step, (y/ step)+1, wallLayerIndex) == 0) {
                trans.y += step;
            }
        } else if (input.isKeyDown(Input.KEY_RIGHT)) {
            if (map.getTileId((x/ step)+1, y/ step, wallLayerIndex) == 0) {
                trans.x += step;
            }
        } else if (input.isKeyDown(Input.KEY_LEFT)) {
            if (map.getTileId((x/ step)-1, y/ step, wallLayerIndex) == 0) {
                trans.x -= step;
            }
        } else {
            if (down){
                animation = new Animation(StageInitializer.getCharacterStayRight(), duration);
                down = false;
            } else if (up){
                animation = new Animation(StageInitializer.getCharacterStayUp(), duration);
                up = false;
            } else if (left){
                animation = new Animation(StageInitializer.getCharacterStayLeft(), duration);
                left = false;
            } else if (right){
                animation = new Animation(StageInitializer.getCharacterStayRight(), duration);
                right = false;
            }
        }

        if (x + trans.x > tileWidth && x + trans.x < (mapWidth - (2 * tileWidth))) {
            x += trans.x / 4;
        }

        if (y + trans.y > tileHeight && y + trans.y < (mapHeight - (4 * tileHeight))) {
            y += trans.y / 4;
        }

        collisionBlock.setCenterX(x);
        collisionBlock.setCenterY(y);
    }

    public void render() {
        animation.draw(x-10, y-85);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}