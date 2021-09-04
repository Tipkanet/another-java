package tipka.net;

import java.util.Random;

public class Gardener {

    private String gardenerName;

    public Gardener(String gardenerName) {
        this.gardenerName = gardenerName;
    }

    public Tree plantTree (String treeName) {
        Random chance = new Random();
        return new Tree(treeName, chance.nextBoolean(), chance.nextBoolean());
    }

    public String getGardenerName() {
        return gardenerName;
    }


}
