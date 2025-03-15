// -8<- [start:one]
public class ValidateExample implements ConfigClass {
    public int orbs = 1;

    @Override
    public void validate() {

    }
}
// -8<- [end:one]
// -8<- [start:two]
public class ValidateExample implements ConfigClass {
    public int orbs = 1;

    @Override
    public void validate() {
        // Is orbs lower than 1 or higher than 60?
        if (orbs < 1 || orbs > 60) {
            // Reset it to 1
            orbs = 1;
        }
    }
}
// -8<- [end:two]
// -8<- [start:three]
public class ValidateExample implements ConfigClass {
    public int orbs = 1;
    public String orb_colour = "RED"

    @Override
    public void validate() {
        // Is orbs lower than 1 or higher than 60?
        if (orbs < 1 || orbs > 60) {
            // Reset it to 1
            orbs = 1;
        }

        // (1)!
        List<String> colours = List.of("RED", "BLUE", "YELLOW", "GREEN");
        // Is orb_colour's value not in the list?
        if (!colours.contains(orb_colour)) {
            // Reset it to "RED"
            orb_colour = "RED";
        }
    }
}
// -8<- [end:three]