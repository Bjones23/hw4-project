package model;
import java.util.Map;

public abstract class AbstractVehicle implements Vehicle {
    private int myX;
    private int myY;
    private Direction myDir;
    private String myImageFileName;
    private int myDeathTime;

    private final int myResetX;

    private final int myResetY;

    private final Direction myResetDirValue;

    private int myPokeCount;


    protected AbstractVehicle(final int theVehicleX, final int theVehicleY,
                              final Direction theValueOf, final String theImageFileName,
                              final int theDeathTime) {
        myX = theVehicleX;
        myY = theVehicleY;
        myDir = theValueOf;
        myDeathTime = theDeathTime;
        myImageFileName = theImageFileName;
        myResetX = theVehicleX;
        myResetY = theVehicleY;
        myResetDirValue = theValueOf;
        myPokeCount = 0;


    }

    @Override
    public boolean canPass(Terrain theTerrain, Light theLight) {
        return false;
    }

    @Override
    public Direction chooseDirection(Map<Direction, Terrain> theNeighbors) {
        return null;
    }

    @Override
    public final void collide(final Vehicle theOther) {
        if (theOther.isAlive() && this.isAlive()) {
            if (theOther.getDeathTime() > this.getDeathTime()) {
                theOther.poke();
            } else if (theOther.getDeathTime() < this.getDeathTime()) {
                this.poke();
            }
        }
    }

    @Override
    public int getDeathTime() {
        return myDeathTime;
    }

    @Override
    public String getImageFileName() {
        String image;
        if (this.isAlive()) {
            image = getClass().getSimpleName().toLowerCase() + ".gif";
        } else {
            image = getClass().getSimpleName().toLowerCase() + "_dead.gif";
        }
        return image;
    }

    @Override
    public Direction getDirection() {
        return myDir;
    }

    @Override
    public int getX() {
        return myX;
    }

    @Override
    public int getY() {
        return myY;
    }

    @Override
        public final boolean isAlive () {
            boolean alive = false;
            if (myPokeCount > 0) {
                alive = false;
            } else {
                alive = true;
            }
            return alive;
        }

        @Override
        public final void poke() {
            myPokeCount++;
            if (myPokeCount > getDeathTime()) {
                this.setDirection(Direction.random());
                myPokeCount = 0;
            }

        }


    @Override
    public void reset() {
        setX(myResetX);
        setY(myResetY);
        setDirection(myResetDirValue);
    }

    @Override
    public void setDirection(Direction theDir) {
        myDir = theDir;
    }

    @Override
    public void setX(int theX) {
        myX = theX;
    }

    @Override
    public void setY(int theY) {
        myY = theY;
    }
}
