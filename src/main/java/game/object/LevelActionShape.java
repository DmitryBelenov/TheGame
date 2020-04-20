package game.object;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

public class LevelActionShape {
    public String name;
    public ActionType type;
    public Rectangle actionShape;
    public float code;
    public QuestItem tiedItem;
    public LevelActionShape tiedActionShape;
    public String goToStageCode;
    public Image shapeImage;
    public Image alternateShapeImage;
    public boolean remoteActionDone;

    public LevelActionShape(String name, float x, float y, float width, float height, float code,
                            ActionType type, QuestItem tiedItem, LevelActionShape tiedActionShape, String goToStageCode,
                            Image shapeImage, Image alternateShapeImage, boolean remoteActionDone){
        this.name = name;
        this.type = type;
        this.actionShape = new Rectangle(x,y,width,height);
        this.code = code;
        this.tiedItem = tiedItem;
        this.tiedActionShape = tiedActionShape;
        this.goToStageCode = goToStageCode;
        this.shapeImage = shapeImage;
        this.alternateShapeImage = alternateShapeImage;
        this.remoteActionDone = remoteActionDone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rectangle getActionShape() {
        return actionShape;
    }

    public void setActionShape(Rectangle actionShape) {
        this.actionShape = actionShape;
    }

    public float getCode() {
        return code;
    }

    public void setCode(float code) {
        this.code = code;
    }

    public QuestItem getTiedItem() {
        return tiedItem;
    }

    public void setTiedItem(QuestItem tiedItem) {
        this.tiedItem = tiedItem;
    }

    public LevelActionShape getTiedActionShape() {
        return tiedActionShape;
    }

    public void setTiedActionShape(LevelActionShape tiedActionShape) {
        this.tiedActionShape = tiedActionShape;
    }

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    public String getGoToStageCode() {
        return goToStageCode;
    }

    public void setGoToStageCode(String goToStageCode) {
        this.goToStageCode = goToStageCode;
    }

    public Image getShapeImage() {
        return shapeImage;
    }

    public void setShapeImage(Image shapeImage) {
        this.shapeImage = shapeImage;
    }

    public Image getAlternateShapeImage() {
        return alternateShapeImage;
    }

    public void setAlternateShapeImage(Image alternateShapeImage) {
        this.alternateShapeImage = alternateShapeImage;
    }

    public boolean isRemoteActionDone() {
        return remoteActionDone;
    }

    public void setRemoteActionDone(boolean remoteActionDone) {
        this.remoteActionDone = remoteActionDone;
    }
}
