package game.state.scene;

import game.object.Character;
import game.object.Camera;
import game.statics.ItemActions;
import game.statics.ScreenManager;
import game.statics.StageInitializer;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;
import game.object.LevelActionShape;
import game.statics.LevelActions;
import game.object.QuestItem;

import java.util.List;

/**
 * Awakening scene
 * */
public class Scene1State extends BasicGameState {

    private Character player;
    private Rectangle collisionBlock;

    private Camera camera;
    private int mapHeight, mapWidth;
    private int tileHeight, tileWidth;

    private Animation animation;
    private TiledMap map;

    private List<QuestItem> questItems;
    private List<LevelActionShape> actionShapes;

    public int getID() {
        return 1;
    }

    public void init(GameContainer container, StateBasedGame stateBasedGame) throws SlickException {
        animation = new Animation(StageInitializer.getCharacterStayRight(), 60);

        characterToMapBinding();

        collisionBlock = new Rectangle(tileWidth*14, tileHeight*14, 20,5);

        StageInitializer.checkStageActionCodes(getID());

        questItems = StageInitializer.getStageQuestItems(getID());
        actionShapes = LevelActions.getStageActions(getID());
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        camera.translate(g, player);
        map.render(0,0);

        ItemActions.itemApproachAction(questItems, g, gc, player);

        g.fill(collisionBlock);

        if (actionShapes != null) {
            for (LevelActionShape las : actionShapes) {
                g.fill(las.getActionShape());

                Image image = las.getShapeImage();
                if (image != null){
                    image.draw(las.getActionShape().getX() + 16, las.getActionShape().getY() + 16);
                }
            }

            ScreenManager.listenStageActionShapesCollision(actionShapes, collisionBlock, g, gc, sbg);
        }

        ScreenManager.renderText(camera, g);

        if (gc.getInput().isKeyDown(Input.KEY_I)){
            ScreenManager.drawInventory(g, camera);
        }

        ScreenManager.listenInventoryKeys(g, gc, camera, collisionBlock, sbg, actionShapes);

        // player animation render after all
        player.render();
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        player.update(gc, mapWidth, mapHeight, tileWidth, tileHeight, map, collisionBlock);

        if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)){
            //todo menu exit here
            sbg.enterState(1001, new FadeOutTransition(), new FadeInTransition());
        }
    }

    private void characterToMapBinding() throws SlickException {
        map = new TiledMap(StageInitializer.stage_1.get(getID()));

        mapWidth = map.getWidth() * map.getTileWidth();
        mapHeight = map.getHeight() * map.getTileHeight();
        tileHeight = map.getTileHeight();
        tileWidth = map.getTileWidth();

        player = new Character(tileWidth*14, tileHeight*14, animation);
        camera = new Camera(map, mapWidth, mapHeight);
    }
}
