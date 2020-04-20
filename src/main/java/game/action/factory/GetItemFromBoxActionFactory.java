package game.action.factory;

import game.object.LevelActionShape;
import game.object.QuestItem;

public class GetItemFromBoxActionFactory implements ActionFactory {
    private LevelActionShape levelActionShape;

    public GetItemFromBoxActionFactory(LevelActionShape levelActionShape){
        this.levelActionShape = levelActionShape;
    }

    public Action getAction() {
        return new GetItemFromBoxAction(levelActionShape);
    }
}
