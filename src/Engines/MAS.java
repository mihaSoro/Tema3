package Engines;

import Exceptions.EngineException;
import Interfaces.ISystem;

/**
 * Created by hp on 11/1/2014.
 */
/*
    This is the class that implements a MAS engine
 */
public class MAS extends Engine implements ISystem {

    private boolean injection_status;

    public MAS(String type,int power, int torque)
    {
        super(type,power,torque);
        injection_status=false;
    }

    @Override
    protected void inject_fuel() throws EngineException {
        System.out.println("Performing gasoline injection!");
        this.injection_status=true;
    }


    private void ignition() throws EngineException {
        if (!this.injection_status)
            throw new EngineException("Gasoline Injection not performed!");

        System.out.println("Performing ignition task!");
        injection_status=false;

    }


    @Override
    protected void Cycle() {
        super.Admission();
        try {
            this.inject_fuel();
            this.ignition();
        }
        catch (EngineException ex)
        {
            System.out.println("Error during injection:"+ex.getMessage());
        }
       super.Evacuation();
    }

    @Override
    public void run() {
        int nr=0;
        System.out.println("MAS Engine is starting");
        while (nr<10) {
            this.Cycle();
            nr++;
            super.mNrCycles++;
        }
        System.out.println("MAS Engine stopped");
    }

    @Override
    public void check() throws EngineException {
        if(mNrCycles==20000)
            throw new EngineException("Consider replacing your engine!");
        else
            System.out.println("Engine is OK!");
    }
}
