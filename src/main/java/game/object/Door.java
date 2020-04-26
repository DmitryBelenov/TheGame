package game.object;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

public class Door {

    public Rectangle doorShape;
    public Image doorImageOpen;
    public Image doorImageClosed;

    public Door(Rectangle doorShape, Image doorImageOpen, Image doorImageClosed) {
        this.doorShape = doorShape;
        this.doorImageOpen = doorImageOpen;
        this.doorImageClosed = doorImageClosed;
    }

    public Rectangle getDoorShape() {
        return doorShape;
    }

    public void setDoorShape(Rectangle doorShape) {
        this.doorShape = doorShape;
    }

    public Image getDoorImageOpen() {
        return doorImageOpen;
    }

    public void setDoorImageOpen(Image doorImageOpen) {
        this.doorImageOpen = doorImageOpen;
    }

    public Image getDoorImageClosed() {
        return doorImageClosed;
    }

    public void setDoorImageClosed(Image doorImageClosed) {
        this.doorImageClosed = doorImageClosed;
    }
}
