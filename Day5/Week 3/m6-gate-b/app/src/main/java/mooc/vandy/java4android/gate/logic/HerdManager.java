package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mWestGate;

    /**
     * The output Gate object.
     */
    private Gate mEastGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;

    /**
     * Constructor initializes the fields.
     */
    public HerdManager(OutputInterface out,
                       Gate gate1,
                       Gate gate2) {
        mOut = out;

        mWestGate = gate1;
        mWestGate.open(Gate.IN);

        mEastGate = gate2;
        mEastGate.open(Gate.OUT);
    }

    // TODO -- Fill your code in here

    public static final int HERD =24;

    public void simulateHerd(Random rand){
        int inside=HERD;
        int outside=0;
        int moved;
        mOut.print("\nThere are currently 24 snails in the pen and 0 snails in the pasture");
        for(int i =0 ; i<MAX_ITERATIONS; i++){
            switch(inside){
                case 24:
                    moved=rand.nextInt(inside)+1;
                    inside+=mEastGate.thru(moved);
                    break;
                case 0:
                    moved=rand.nextInt(outside)+1;
                    inside+=mWestGate.thru(moved);
                    break;
                default:
                    int num = rand.nextInt(2);
                    if(num==1){
                        moved=rand.nextInt(outside)+1;
                        inside+=mWestGate.thru(moved);
                    }
                    else if(num==0){
                        moved=rand.nextInt(inside)+1;
                        inside+=mEastGate.thru(moved);
                    }

            }
            outside=HERD-inside;
            mOut.print("\nThere are currently " + inside + " snails in the pen and " +
                    outside + " snails inthe pasture");
        }
    }
    
}
