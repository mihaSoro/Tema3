package Engines;

import Exceptions.EngineException;

/**
 * Created by hp on 11/1/2014.
 */
public abstract class Engine {

    private String mType;
    private int mPower;
    private int mTorque;
    protected int mNrCycles;

    /*
      The constructor which intializes an engine with a given power and torque
     */
    public Engine(String type,int power, int torque)
    {
        this.mType =type;
        this.mPower =power;
        this.mTorque= power;
        mNrCycles=0;
    }

    /*
       This function performs admission wich is the same for both engines
     */
    protected void Admission()
    {
        System.out.println("Open intake valve to let air in!");
    }

    /*
       This function performs evacuation
     */
    protected  void Evacuation()
    {
        System.out.println("Open evacuation exhaust-valve to let exhaust-gas out!");
    }

    /*
      This function executes an engine cycle- each type of engine has it's own steps
     */
    protected abstract void Cycle();

    /*
      Each engine injects fuel but it is performed differently
     */
    protected abstract void inject_fuel() throws EngineException;

    public String get_Type()
    {
        return mType;
    }


}
