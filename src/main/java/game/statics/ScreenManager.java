package game.statics;

import game.SetupGame;
import game.action.ActionManager;
import game.object.*;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import java.util.ArrayList;
import java.util.List;

public class ScreenManager {

    public static List<QuestItem> iItems = new ArrayList<QuestItem>();

    private static String inscription = "";

    private static Animation levelActionAnimation = null;
    private static float animation_x = 0;
    private static float animation_y = 0;

    public static TiledMap sceneMap = null;

    public static void initializeSceneMap(TiledMap map){
        ScreenManager.sceneMap = map;
    }

    public static void renderText(Camera camera, Graphics g) {
        g.setColor(Color.white);
        g.drawString(inscription, camera.getViewPort().getX() + SetupGame.WIDTH / 4, camera.getViewPort().getY() + SetupGame.HEIGHT - 50);
        g.setColor(Color.transparent);
    }

    public static void setInscription(String inscription) {
        if (ScreenManager.inscription.length() == 0) {
            ScreenManager.inscription = inscription;
            setTimer();
        }
    }

    public static void renderAnimation() {
        if (levelActionAnimation != null && animation_x != 0 && animation_y != 0) {
            levelActionAnimation.draw(animation_x, animation_y);
            if (levelActionAnimation.isStopped()) {
                ScreenManager.levelActionAnimation = null;
                animation_x = 0;
                animation_y = 0;
            }
        }
    }

    public static void animateLevelAction(Animation animation, float x, float y) {
        if (animation != null) {
            ScreenManager.levelActionAnimation = animation;
            ScreenManager.animation_x = x;
            ScreenManager.animation_y = y;
        }
    }

    private static void setTimer() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(3000);
                    ScreenManager.inscription = "";
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public static void drawInventory(Graphics g, Camera camera) {
        float x = camera.getViewPort().getX() + 50;
        float y = camera.getViewPort().getY() + SetupGame.HEIGHT - 50;

        int i = 0;
        boolean up = true;
        for (QuestItem item : iItems) {
            Image image = item.getImage();

            g.setColor(Color.white);
            g.drawString(item.getDescription(), x, y - 15);
            image.draw(x, y);
            g.drawString(String.valueOf(i), x, y + 15);
            g.setColor(Color.transparent);

            x += 80;
            i++;
            if (up) {
                y -= 40;
                up = false;
            } else {
                y += 40;
                up = true;
            }
        }
    }

    public static void listenInventoryKeys(Graphics g, GameContainer gc, Camera camera, Rectangle collisionBlock, StateBasedGame sbg, List<LevelActionShape> actionShapes) {
        Input input = gc.getInput();
        if (ScreenManager.inscription.length() == 0 && iItems.size() > 0) {
            try {
                if (input.isKeyDown(Input.KEY_0)) {
                    QuestItem menuItem = iItems.get(0);
                    doAction(collisionBlock, menuItem, sbg, g, camera, actionShapes);
                    g.drawString(menuItem.getContent(), camera.getViewPort().getX() + SetupGame.WIDTH / 4, camera.getViewPort().getY() + SetupGame.HEIGHT - 50);
                } else if (input.isKeyDown(Input.KEY_1)) {
                    QuestItem menuItem = iItems.get(1);
                    doAction(collisionBlock, menuItem, sbg, g, camera, actionShapes);
                    g.drawString(menuItem.getContent(), camera.getViewPort().getX() + SetupGame.WIDTH / 4, camera.getViewPort().getY() + SetupGame.HEIGHT - 50);
                } else if (input.isKeyDown(Input.KEY_2)) {
                    QuestItem menuItem = iItems.get(2);
                    doAction(collisionBlock, menuItem, sbg, g, camera, actionShapes);
                    g.drawString(menuItem.getContent(), camera.getViewPort().getX() + SetupGame.WIDTH / 4, camera.getViewPort().getY() + SetupGame.HEIGHT - 50);
                } else if (input.isKeyDown(Input.KEY_3)) {
                    QuestItem menuItem = iItems.get(3);
                    doAction(collisionBlock, menuItem, sbg, g, camera, actionShapes);
                    g.drawString(menuItem.getContent(), camera.getViewPort().getX() + SetupGame.WIDTH / 4, camera.getViewPort().getY() + SetupGame.HEIGHT - 50);
                } else if (input.isKeyDown(Input.KEY_4)) {
                    QuestItem menuItem = iItems.get(4);
                    doAction(collisionBlock, menuItem, sbg, g, camera, actionShapes);
                    g.drawString(menuItem.getContent(), camera.getViewPort().getX() + SetupGame.WIDTH / 4, camera.getViewPort().getY() + SetupGame.HEIGHT - 50);
                } else if (input.isKeyDown(Input.KEY_5)) {
                    QuestItem menuItem = iItems.get(5);
                    doAction(collisionBlock, menuItem, sbg, g, camera, actionShapes);
                    g.drawString(menuItem.getContent(), camera.getViewPort().getX() + SetupGame.WIDTH / 4, camera.getViewPort().getY() + SetupGame.HEIGHT - 50);
                } else if (input.isKeyDown(Input.KEY_6)) {
                    QuestItem menuItem = iItems.get(6);
                    doAction(collisionBlock, menuItem, sbg, g, camera, actionShapes);
                    g.drawString(menuItem.getContent(), camera.getViewPort().getX() + SetupGame.WIDTH / 4, camera.getViewPort().getY() + SetupGame.HEIGHT - 50);
                } else if (input.isKeyDown(Input.KEY_7)) {
                    QuestItem menuItem = iItems.get(7);
                    doAction(collisionBlock, menuItem, sbg, g, camera, actionShapes);
                    g.drawString(menuItem.getContent(), camera.getViewPort().getX() + SetupGame.WIDTH / 4, camera.getViewPort().getY() + SetupGame.HEIGHT - 50);
                } else if (input.isKeyDown(Input.KEY_8)) {
                    QuestItem menuItem = iItems.get(8);
                    doAction(collisionBlock, menuItem, sbg, g, camera, actionShapes);
                    g.drawString(menuItem.getContent(), camera.getViewPort().getX() + SetupGame.WIDTH / 4, camera.getViewPort().getY() + SetupGame.HEIGHT - 50);
                } else if (input.isKeyDown(Input.KEY_9)) {
                    QuestItem menuItem = iItems.get(9);
                    doAction(collisionBlock, menuItem, sbg, g, camera, actionShapes);
                    g.drawString(menuItem.getContent(), camera.getViewPort().getX() + SetupGame.WIDTH / 4, camera.getViewPort().getY() + SetupGame.HEIGHT - 50);
                }
            } catch (Exception e) {
                g.drawString("Empty slot", camera.getViewPort().getX() + SetupGame.WIDTH / 4, camera.getViewPort().getY() + SetupGame.HEIGHT - 50);
            }
        }
    }

    private static void doAction(Rectangle collisionBlock, QuestItem menuItem, StateBasedGame sbg, Graphics g, Camera camera, List<LevelActionShape> actionShapes) throws SlickException {
        boolean showContent = true;
        for (LevelActionShape las : actionShapes) {
            if (las.getActionShape().intersects(collisionBlock) || las.getActionShape().contains(collisionBlock)) {
                if (menuItem.getCode() == las.getCode()) {
                    ActionManager actionManager = new ActionManager(sbg, las);
                    actionManager.invokeAction();
                } else {
                    g.setColor(Color.red);
                    g.drawString("It's useless here..", camera.getViewPort().getX() + SetupGame.WIDTH - 200, camera.getViewPort().getY() + SetupGame.HEIGHT - 50);
                    g.setColor(Color.transparent);
                }
                showContent = false;
                break;
            }
        }
        if (showContent) ScreenManager.setInscription(menuItem.getDescription()+": "+menuItem.getContent());
    }

    public static void listenStageActionShapesCollision(List<LevelActionShape> actionShapes, Rectangle collisionBlock, Graphics g, GameContainer gc, StateBasedGame sbg) throws SlickException {
        for (LevelActionShape shape : actionShapes) {
            Rectangle r = shape.getActionShape();
            if (r.intersects(collisionBlock) || r.contains(collisionBlock)) {
                g.setColor(Color.white);
                g.drawString(shape.getName(), r.getX(), r.getY() - 18);
                g.setColor(Color.transparent);

                if ((gc.getInput().isKeyDown(Input.KEY_E) && shape.getType().equals(ActionType.remote_action))
                        || (gc.getInput().isKeyDown(Input.KEY_E) && shape.isRemoteActionDone())
                        || shape.getType().equals(ActionType.dangerous_barrier)) {
                    ActionManager actionManager = new ActionManager(sbg, shape);
                    actionManager.invokeAction();
                    break;
                }
            }
        }
    }

    public static void listenDoors(List<Door> doors, Rectangle collisionBlock){
            for (Door door : doors){
                Rectangle doorShape = door.getDoorShape();
                Image doorOpen = door.getDoorImageOpen();
                Image doorClosed = door.getDoorImageClosed();

                if (doorShape.intersects(collisionBlock) || doorShape.contains(collisionBlock)){
                    doorOpen.draw(doorShape.getX(), doorShape.getY());
                } else {
                    doorClosed.draw(doorShape.getX(), doorShape.getY());
                }
            }
    }
}
