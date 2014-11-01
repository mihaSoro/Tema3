package Interfaces;

import Exceptions.EngineException;

/**
 * Created by hp on 11/1/2014.
 */
/*
  This is an interface for a System in a vehicle, each system can run and can be checked
 */
public interface ISystem {

    public void run();
    public void check() throws EngineException;

}
