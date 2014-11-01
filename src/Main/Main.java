package Main;
import Engines.MAS;
import Engines.Engine;
import Engines.MAC;
import Interfaces.ISystem;
import Exceptions.EngineException;

/**
 * Created by hp on 11/1/2014.
 */
public class Main {
    public static void main(String[] args) {

       MAS mas =new MAS("VW 1.6 R4",75,148);
       MAC mac =new MAC("VW v6 TDI",165,450);

        mas.run();
        System.out.println();
        mac.run();

        ISystem syst=new MAC("VW v6 TDI",165,450);
        try {
            syst.check();
        }
        catch (EngineException ex)
        {
            System.out.println(ex.getMessage());
        }


    }
}
