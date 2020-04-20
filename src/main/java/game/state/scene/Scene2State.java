package game.state.scene;

import game.object.Camera;
import game.object.Character;
import game.statics.StageInitializer;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;

public class Scene2State extends BasicGameState {

    private Character player;
    private Camera camera;
    private int mapHeight, mapWidth;
    private int tileHeight, tileWidth;

    private Animation animation;
    private TiledMap map;
    private Rectangle collisionBlock;

    public int getID() {
        return 2;
    }

    public void init(GameContainer container, StateBasedGame stateBasedGame) throws SlickException {
        animation = new Animation(StageInitializer.getCharacterStayRight(), 60);

        characterToMapBinding();

        collisionBlock = new Rectangle(tileWidth*14, tileHeight*14, 20,5);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        camera.translate(g, player);
        map.render(0,0);
        player.render();

        g.fill(collisionBlock);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        player.update(gc, mapWidth, mapHeight, tileWidth, tileHeight, map, collisionBlock);

        if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)){
            sbg.enterState(1001, new FadeOutTransition(), new FadeInTransition());
        }
    }

    private void characterToMapBinding() throws SlickException {
        map = new TiledMap(StageInitializer.stage_2.get(getID()));

        mapWidth = map.getWidth() * map.getTileWidth();
        mapHeight = map.getHeight() * map.getTileHeight();
        tileHeight = map.getTileHeight();
        tileWidth = map.getTileWidth();
        player = new Character(tileWidth*14, tileHeight*14, animation);
        camera = new Camera(map, mapWidth, mapHeight);
    }
}
