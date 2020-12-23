package mooc.vandy.java4android.buildings.logic;

/**
 * This is the office class file, it is a subclass of Building.
 */
public class Office
       extends Building {

    //office-specific fields
    private String mBusinessName;
    private int mParkingSpaces;
    private static int sTotalOffices=0;

    public Office(int length, int width, int lotLength, int lotWidth){
        super(length, width, lotLength, lotWidth);
        sTotalOffices++;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName){
        super(length, width, lotLength, lotWidth);
        mBusinessName=businessName;
        sTotalOffices++;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName,
                   int parkingSpaces){
        super(length, width, lotLength, lotWidth);
        mBusinessName=businessName;
        mParkingSpaces=parkingSpaces;
        sTotalOffices++;
    }

    public String getBusinessName(){
        return mBusinessName;
    }

    public int getParkingSpaces(){
        return mParkingSpaces;
    }

    public static int getTotalOffices(){
        return sTotalOffices;
    }

    public void setBusinessName(String s){
        mBusinessName=s;
    }

    public void setParkingSpaces(int n){
        mParkingSpaces=n;
    }

    public String toString(){
        if(mBusinessName==null){
            return "Business: unoccupied"+" (total offices: " +sTotalOffices+")";
        }
        else return "Business: "+ mBusinessName +
                (mParkingSpaces==0?"":"; has " + mParkingSpaces+ " parking spaces"
                        +" (total offices: " +sTotalOffices+")");
    }

    public boolean equals(Object a){

        if (!(a instanceof Office)) return false;
        Office b = (Office) a;
        return (this.calcBuildingArea()==b.calcBuildingArea())&&
                (this.getParkingSpaces()==b.getParkingSpaces());
    }
}
