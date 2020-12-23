package mooc.vandy.java4android.buildings.logic;

/**
 * This is the cottage class file.  It is a subclass of House.
 */
public class Cottage
       extends House {

    // cottage-specific fields
    private boolean mSecondFloor;

    public Cottage(int dimension, int lotLength, int lotWidth){
        super(dimension,dimension, lotLength,lotWidth);
    }

    public Cottage(int dimension, int lotLength, int lotWidth, String owner, boolean
            secondFloor){
        super(dimension, dimension, lotLength, lotWidth, owner);
        mSecondFloor=secondFloor;
    }

    public boolean hasSecondFloor(){
        return mSecondFloor;
    }

    public String toString(){
        return super.toString()+"; is a "+ (mSecondFloor? "two story ":"")+"cottage";
    }
}

