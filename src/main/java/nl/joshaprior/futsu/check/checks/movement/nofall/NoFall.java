package nl.joshaprior.futsu.check.checks.movement.nofall;

import nl.joshaprior.futsu.check.Check;
import nl.joshaprior.futsu.check.CheckType;
import nl.joshaprior.futsu.check.checks.movement.nofall.type.*;

public class NoFall extends Check {


    public NoFall(String name, CheckType checkType, Boolean enabled, int max) {
        super(name, checkType, enabled, max);
        detections.add(new TypeA("A", this));
    }
}
