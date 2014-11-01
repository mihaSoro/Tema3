package Engines;

import Exceptions.EngineException;
import Interfaces.ISystem;

/**
 * Created by hp on 11/1/2014.
 */
/*
   This is the class that implements a MAC engine
 */
public class MAC extends Engine implements ISystem {

    private boolean pilot_status;

    public MAC(String type,int power, int torque)
    {
        super(type,power,torque);
        pilot_status=false;
    }

    @Override
    protected void inject_fuel() throws EngineException {
        if (!pilot_status)
            throw new EngineException("Pilot injection not performed!");
        System.out.println("Performing main injection! Injecting diesel!");
    }

    private void pilot_injection() {
        System.out.println("Performing pilot injection!");
        pilot_status=true;
    }

    @Override
    protected void Evacuation() {
        super.Evacuation();
        pilot_status=false;
    }

    /*
          This is the function that starts the engine
         */
    @Override
    protected void Cycle() {
        super.Admission();
        try {
            this.pilot_injection();
            this.inject_fuel();
        }
        catch (EngineException ex)
        {
                System.out.println("Error during Injection:"+ex.getMessage());

        }
        this.Evacuation();
    }

    @Override
    public void check() throws EngineException {
        if(mNrCycles==10000)
            throw new EngineException("Consider replacing your engine!");
        else
            System.out.println("Engine is OK!");
    }

    @Override
    public void run() {
        int nr=0;
        System.out.println("MAC Engine is starting");
        while (nr<10) {
            this.Cycle();
            nr++;
            super.mNrCycles++;
        }
        System.out.println("MAC Engine stopped");
    }
}
