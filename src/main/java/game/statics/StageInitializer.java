package game.statics;

import game.object.Door;
import game.state.scene.SwitchSceneState;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import game.object.LevelActionShape;
import game.object.QuestItem;
import org.newdawn.slick.geom.Rectangle;

import java.util.*;
import java.util.List;

public abstract class StageInitializer {
    public static Map<String /* map code */, Map<Integer /* stage number */, String /* stage src */>> stageMap = new HashMap<String, Map<Integer, String>>();
    public static Map<Integer /* stage number */, String /* scene name */> stageNameMap = new HashMap<Integer, String>();

    public static Map<Integer, String> stage_1;
    public static Map<Integer, String> stage_2;

    public static Map<Integer /* stage id */, List<QuestItem> /* items */> questItems = new HashMap<Integer, List<QuestItem>>();

    public static Map<Integer /* stage id */, List<Door> /* doors */> doors = new HashMap<Integer, List<Door>>();

    public static boolean gameOver = false;

    static {
        /* Stages */

        // 1. Awakening
        stage_1 = new HashMap<Integer, String>();
        stage_1.put(1, "tiles/scene/1/scene_1.tmx");
        stageMap.put("START", stage_1);
        stageNameMap.put(1, "Awakening");
        //doors
        try {
        List<Door> doors_st1 = Arrays.asList(
                new Door(new Rectangle(264,264, 48,96), new Image("doors/door_open.png"), new Image("doors/door_closed.png"))
                ,new Door(new Rectangle(152,440, 48,96), new Image("doors/door_open.png"), new Image("doors/door_closed.png"))
                ,new Door(new Rectangle(1064,192, 48,96), new Image("doors/door_open.png"), new Image("doors/door_closed.png"))
                ,new Door(new Rectangle(944,1336, 48,96), new Image("doors/door_open.png"), new Image("doors/door_closed.png"))
        );

            doors.put(1, doors_st1);
        } catch (SlickException se){
            System.out.println("Cant load image of quest item" + se);
        }

        // 2. TEST
        stage_2 = new HashMap<Integer, String>();
        stage_2.put(2, "tiles/scene/2/scene_2.tmx");
        stageMap.put("RESEARCH_CENTER", stage_2);
        stageNameMap.put(2, "Research Center");

        /* Items */
        // fill stage items
        // stage item with code -0.1f (or less than 0) - can't open / switch anything
        try {
            questItems.put(1, Arrays.asList(
                    new QuestItem(new Image("quest/page.png"),  -0.1f,176, 64, true, "Note", "Hi Frank. Please stay in your room.."),
                    new QuestItem(new Image("quest/page.png"),1.02f, 1328, 624, true, "Safe pass", "4738"),
                    new QuestItem(new Image("quest/page.png"),-0.1f, 40, 912, true, "Note", "Mr. garbage man, please don't touch my workspace!\nYou take away important note again!")
            ));
        } catch (SlickException se){
            System.out.println("Cant load image of quest item" + se);
        }

    }

    public static List<Door> getStageDoors(int stageId){
        return doors.get(stageId);
    }

    public static List<QuestItem> getStageQuestItems(int stageId){
        return questItems.get(stageId);
    }

    public static void stageInit(String mapCode) throws SlickException {
        Map<Integer, String> stage = stageMap.get(mapCode);

        if (stage == null)
            throw new SlickException("Wrong map code: [ " + mapCode + " ]");

        for (Integer key : stage.keySet()) {
            SwitchSceneState.stageNumber = key;
            SwitchSceneState.stageName = stageNameMap.get(key);
        }
    }

    public static void checkStageActionCodes(int stageId) throws SlickException {
        List<LevelActionShape> actionShapes = LevelActions.getStageActions(stageId);

        if (actionShapes != null) {
            // check same codes
            List<Float> codes = new ArrayList<Float>();
            for (LevelActionShape las : actionShapes){
                float code = las.getCode();
                if (!codes.contains(code)){
                    if (code != 0.0f) codes.add(code); // disable check 0.0f code for remote action shapes
                } else {
                    throw new SlickException("Same codes of stage actions detected! LAS: " + las.getName() + ", code: " + code);
                }
            }
        } else {
            throw new SlickException("Stage actions fill error. ID: "+stageId);
        }
    }

    public static void setGameOver(){
        StageInitializer.gameOver = true;
    }


    /**
     * Player animations
     * **********************************************************************/

    public static Image[] getCharacterStayRight() throws SlickException {
        return new Image[]{new Image("character/right/stay/1.png")};
    }

    public static Image[] getCharacterStayLeft() throws SlickException {
        return new Image[]{new Image("character/left/stay/1.png")};
    }

    public static Image[] getCharacterStayUp() throws SlickException {
        return new Image[]{new Image("character/up/stay/1.png")};
    }

    public static Image[] getCharacterWalkUp() throws SlickException {
        return new Image[]{new Image("character/up/1.png"),
                new Image("character/up/2.png"),
                new Image("character/up/3.png"),
                new Image("character/up/4.png"),
                new Image("character/up/5.png"),
                new Image("character/up/6.png")
        };
    }

    public static Image[] getCharacterWalkDown() throws SlickException {
        return new Image[]{new Image("character/down/1.png"),
                new Image("character/down/2.png"),
                new Image("character/down/3.png"),
                new Image("character/down/4.png"),
                new Image("character/down/5.png"),
                new Image("character/down/6.png")
        };
    }

    public static Image[] getCharacterWalkRight() throws SlickException {
        return new Image[]{new Image("character/right/1.png"),
                new Image("character/right/2.png"),
                new Image("character/right/3.png"),
                new Image("character/right/4.png"),
                new Image("character/right/5.png"),
                new Image("character/right/6.png"),
                new Image("character/right/7.png"),
                new Image("character/right/8.png")};
    }

    public static Image[] getCharacterWalkLeft() throws SlickException {
        return new Image[]{new Image("character/left/1.png"),
                new Image("character/left/2.png"),
                new Image("character/left/3.png"),
                new Image("character/left/4.png"),
                new Image("character/left/5.png"),
                new Image("character/left/6.png"),
                new Image("character/left/7.png"),
                new Image("character/left/8.png")};
    }

    public static Image[] getBang() throws SlickException {
        return new Image[]{new Image("action/bang/1.png"),
                new Image("action/bang/2.png"),
                new Image("action/bang/3.png"),
                new Image("action/bang/4.png"),
                new Image("action/bang/5.png"),
                new Image("action/bang/6.png"),
                new Image("action/bang/7.png"),
                new Image("action/bang/8.png"),
                new Image("action/bang/9.png"),
                new Image("action/bang/10.png"),
                new Image("action/bang/11.png"),
                new Image("action/bang/12.png"),
                new Image("action/bang/13.png"),
                new Image("action/bang/14.png"),
                new Image("action/bang/15.png"),
                new Image("action/bang/16.png"),
                new Image("action/bang/17.png")};
    }

    /**
     * **********************************************************************/
}
