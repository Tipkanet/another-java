package tipka.less_0904;

import java.util.Random;

public class Cat {

    private String catName;
    private boolean catAliveness;
    private int climbingSkillLevel;

    public Cat(String catName) {
        this.catName = catName;
        this.catAliveness = true;
        this.climbingSkillLevel = 0;
    }

    public String getCatName() {
        return catName;
    }

    public boolean isCatAliveness() {
        return catAliveness;
    }

    public void climbTree (Tree tree) {
        
        int survivingChance = getSurvivingChance(tree);

        setClimbingSkill(survivingChance);

        if (this.catAliveness) {
            System.out.println(this.getCatName() +
                    " climbed " + tree.getTreeName() +
                    " and is still ok, her skill level is: " +
                    this.climbingSkillLevel);
        } else {
            System.out.println(this.getCatName() +
                    " climbed " + tree.getTreeName() +
                    ", fell and died... Sad...");
        }
    }

    private void incClimbingSkillLevel() {
        this.climbingSkillLevel++;
    }

    private void decClimbingSkillLevel() {
        if (this.climbingSkillLevel > 0) {
            this.climbingSkillLevel--;
        } else {
            this.catAliveness = false;
        }
    }

    private void setClimbingSkill(int survivingChance) {
        if (survivingChance *100 < new Random().nextInt(150)) {
            this.decClimbingSkillLevel();
        } else {
            this.incClimbingSkillLevel();
        }
    }

    private int getSurvivingChance(Tree tree) {
        int survivingChance = 1;
        if (tree.isConiferTree())       // if the tree is conifer, chances are halved
            survivingChance--;
        if (tree.isFruitTree())         // if the tree is fruit, chances doubled
            survivingChance++;
        return survivingChance;
    }

}
