package game.action.factory;

import game.object.LevelActionShape;

public class ItemStateRemoteActionFactory implements ActionFactory {
    private LevelActionShape las;

    public ItemStateRemoteActionFactory(LevelActionShape las){
        this.las = las;
    }

    public Action getAction() {
        return new ItemStateRemoteAction(las);
    }
}
