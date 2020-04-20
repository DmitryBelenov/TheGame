package game.statics;

import game.object.ActionType;
import game.object.LevelActionShape;
import game.object.QuestItem;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;
import java.util.List;

public class LevelActions {

    public static List<LevelActionShape> stage_1 = new ArrayList<LevelActionShape>();

    // shapes with code 0.0f - remote actions to open / switch another shapes
    // shapes with code >0.0f - need quest item with same code to open / switch
    static {
        try {
        // STAGE 1
        LevelActionShape exit = new LevelActionShape("Exit", 1570, 1500, 30,80, 1.01f, ActionType.stage, null, null,
                "RESEARCH_CENTER", null, null, false);
        stage_1.add(exit);

        stage_1.add(new LevelActionShape("Safe", 1291, 1360, 40,72, 1.02f, ActionType.itemBox,
                new QuestItem(new Image("quest/page.png"),1.01f, 0,0, false, "Key card", "Class D"), null,null,
                new Image("quest/safe_closed.png"), new Image("quest/safe_opened.png"), false));

        stage_1.add(new LevelActionShape("Box", 1100, 1100, 50,80, 0.0f, ActionType.remote_action, null, exit,null,
                    new Image("quest/safe_closed.png"), new Image("quest/safe_opened.png"), false));

        } catch (SlickException e) {
            System.out.println("Can't append action to stage");
        }
    }

    public static List<LevelActionShape> getStageActions(int stageId){
        if (stageId == 1) {
            return stage_1;
        }

        return null;
    }
}
