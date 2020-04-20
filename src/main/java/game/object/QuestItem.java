package game.object;

import org.newdawn.slick.Image;

import java.io.Serializable;

public class QuestItem implements Serializable {

    private static final long serialVersionUID = -379937030652538793L;

    public Image image;
    public float code;
    public int x;
    public int y;
    public boolean show;
    public String description;
    public String content;

    public QuestItem(Image image, float code, int x, int y, boolean show, String description, String content){
        this.image = image;
        this.code = code;
        this.x = x;
        this.y = y;
        this.show = show;
        this.description = description;
        this.content = content;
    }

    public Image getImage() {
        return image;
    }

    public float getCode() {
        return code;
    }

    public void setCode(float code) {
        this.code = code;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
