package mooc.vandy.java4android.calculator.logic;

import java.util.HashMap;

import mooc.vandy.java4android.calculator.ui.ActivityInterface;

/**
 * Performs an operation selected by the user.
 */
public class Logic implements LogicInterface {
    /**
     * Reference to the Activity output.
     */
    protected ActivityInterface mOut;
    public static final int ADD=1;
    public static final int SUB=2;
    public static final int MULT=3;
    public static final int DIV=4;
    
    /**
     * Constructor initializes the field.
     */
    public Logic(ActivityInterface out) {
        mOut = out;
        
    }

    

    /**
     * Perform the operation on argumentOne and argumentTwo.
     */
    public void process(int argumentOne, int argumentTwo, int operation) {
        // TODO - Put your code here.
        switch(operation){
            case ADD:
                mOut.print(""+Add.compute(argumentOne,argumentTwo));
                break;
            case SUB:
                mOut.print(""+Subtract.compute(argumentOne,argumentTwo));
                break;
            case MULT:
                mOut.print(""+Multiply.compute(argumentOne,argumentTwo));
                break;
            case DIV:
                if(argumentTwo==0) mOut.print("Unable to divide by 0");
                else mOut.print(""+Divide.compute(argumentOne,argumentTwo));
                break;
            default:
                mOut.print("Invalid operation");
        }
    }
}
