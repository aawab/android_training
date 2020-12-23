package mooc.vandy.java4android.buildings.logic;

/**
 * This is the Building class file.
 */
public class Building {

    //private fields specific to buildings
    private int mLength, mWidth, mLotLength, mLotWidth;

    public Building(int length, int width, int lotLength, int lotWidth){
        mLength=length;
        mWidth=width;
        mLotLength=lotLength;
        mLotWidth=lotWidth;
    }

    public int getLength(){
        return mLength;
    }

    public int getWidth(){
        return mWidth;
    }

    public int getLotLength(){
        return mLotLength;
    }

    public int getLotWidth(){
        return mLotWidth;
    }

    public void setLength(int length){
        mLength=length;
    }

    public void setWidth(int width){
        mWidth=width;
    }

    public void setLotLength(int lotLength){
        mLotLength=lotLength;
    }

    public void setLotWidth(int lotWidth){
        mLotWidth=lotWidth;
    }

    public int calcBuildingArea(){
        return mLength*mWidth;
    }

    public int calcLotArea(){
        return mLotLength*mLotWidth;
    }

    public String toString(){
        return "a " + mWidth + "x" + mLength + "building";
    }
}
