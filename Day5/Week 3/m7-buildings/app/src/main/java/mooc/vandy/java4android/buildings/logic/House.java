package mooc.vandy.java4android.buildings.logic;

/**
 * This is the House class file that extends Building.
 */
public class House
       extends Building {

    //house class specific fields
    private String mOwner;
    private boolean mPool;

    public House(int length, int width, int lotLength, int lotWidth){
        super(length,width,lotLength,lotWidth);
    }

    public House(int length, int width, int lotLength, int lotWidth, String owner){
        super(length,width,lotLength,lotWidth);
        mOwner=owner;
    }

    public House(int length, int width, int lotLength, int lotWidth, String owner, boolean pool){
        super(length,width,lotLength,lotWidth);
        mOwner=owner;
        mPool=pool;
    }

    public String getOwner(){
        return mOwner;
    }

    public boolean hasPool(){
        return mPool;
    }

    public void setOwner(String s){
        mOwner=s;
    }

    public void setPool(boolean h){
        mPool=h;
    }

    public String toString(){
        return "Owner: " + (mOwner==null?"n/a":mOwner  + (mPool?"; has a pool":"" )+
                ((calcLotArea()-calcBuildingArea())>calcBuildingArea()?"; has a big open space":""));
    }

    public boolean equals(Object a){
        House h = (House) a;
        return (this.calcBuildingArea()==h.calcBuildingArea())&&(this.hasPool()==h.hasPool());
    }
}
