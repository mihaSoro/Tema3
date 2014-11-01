package Interfaces;

import Exceptions.EngineException;

/**
 * Created by hp on 11/1/2014.
 */
public interface ISystem {

    public void run();
    public void check() throws EngineException;

}
