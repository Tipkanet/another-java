package tipka.less_0904;

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

    // get gardener's name
    public String getGardenerName() {
        return gardenerName;
    }


}
