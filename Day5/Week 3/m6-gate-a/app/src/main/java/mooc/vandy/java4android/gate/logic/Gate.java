package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    // TODO -- Fill in your code here
    public static final int IN = 1;
    public static final int OUT = -1;
    public static final int CLOSED = 0;
    private int mSwing;

    public Gate() {
        this.mSwing = CLOSED;
    }

    public int getSwingDirection(){
        return this.mSwing;
    }
    public boolean setSwing(int direction) {
        if (direction > 1 || direction < -1) return false;
        else {
            this.mSwing = direction;
            return true;
        }
    }

    public boolean open(int direction) {
        if (direction == IN || direction == OUT) {
            setSwing(direction);
            return true;
        }
        else return false;
    }

    public void close(){
        this.mSwing=CLOSED;
    }

    public int thru(int count){
        switch(this.mSwing){
            case IN:
                return count;
            case OUT:
                return -count;
        }
        return 0;
    }

    public String toString(){
        switch(this.mSwing){
            case CLOSED:
                return "This gate is closed";
            case IN:
                return "This gate is open and swings to enter the pen only";
            case OUT:
                return "This gate is open and swings to exit the pen only";
            default:
                return "This gate has an invalid swing direction";
        }
    }

}
