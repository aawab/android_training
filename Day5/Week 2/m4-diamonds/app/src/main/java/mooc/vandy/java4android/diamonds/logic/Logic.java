    package mooc.vandy.java4android.diamonds.logic;

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {
        // TODO -- add your code here
        printTopLine(size);
        for(int i = 1 ; i <size*2; i++){
            printMiddleLines(size,i);
        }
        printBottomLine(size);
    }

    // TODO -- add any helper methods here
    public void printTopLine(int s){
        mOut.print("+");
        for(int i = 0; i<s*2; i++){
            mOut.print("-");
        }
        mOut.print("+\n");
    }
    public void printMiddleLines(int s, int i){
        mOut.print("|");
        int k = -1*(1-i);
        //Middle Line print
        if(i==s){
            mOut.print("<");
            /*Num of hyphens/equal signs in line is equal to the distance from the closest
            vertical frame edge times two */
            for(int j = 0 ; j <k*2; j++){
                mOut.print((i%2==0)?"-":"=");
            }
            mOut.print(">|\n");
        }
        //Top Half print
        else if(i<s){
            for(int j = i; j <s; j++){
                mOut.print(" ");
            }
            mOut.print("/");
            /*Num of hyphens/equal signs in line is equal to the distance from the closest
            vertical frame edge times two */

            for(int j = 0; j<k*2; j++){
                mOut.print((i%2==0)?"-":"=");
            }
            mOut.print("\\");
            for(int j = i; j <s; j++){
                mOut.print(" ");
            }
            mOut.print("|\n");
        }
        //Bottom Half print
        else if(i>s){
            for(int j = i; j>s; j--){
                mOut.print(" ");
            }
            mOut.print("\\");
            /*Num of hyphens/equal signs in line is equal to the distance from the closest
            vertical frame edge times two*/
            k = (s*2)-1-i;
            for(int j = 0; j<(k*2); j++){
                mOut.print((i%2==0)?"-":"=");
            }
            mOut.print("/");
            for(int j = i; j>s; j--){
                mOut.print(" ");
            }
            mOut.print("|\n");
        }
    }
    public void printBottomLine(int s){
        mOut.print("+");
        for(int i = 1; i<=s*2; i++){
            mOut.print("-");
        }
        mOut.print("+\n");
    }


}
