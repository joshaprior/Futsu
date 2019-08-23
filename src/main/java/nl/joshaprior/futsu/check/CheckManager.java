package nl.joshaprior.futsu.check;

import nl.joshaprior.futsu.check.checks.movement.nofall.NoFall;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class CheckManager {
    private LinkedList<Check> checks = new LinkedList<>();

    public CheckManager() {
        checks.add(new NoFall("NoFall", CheckType.MOVEMENT, true, 2));
    }

    public LinkedList<Check> getChecks() {
        return checks;
    }

    public LinkedList<Check> getByType(CheckType type) {
        return checks.stream().filter(check -> check.getType().equals(type))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public LinkedList<Check> getEnabled() {
        return checks.stream().filter(Check::isEnabled)
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
