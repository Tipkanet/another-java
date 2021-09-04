package tipka.net;

import java.util.Objects;

public class Tree {

    private String treeName;
    private boolean coniferTree;    // true - conifer tree, false - deciduous tree
    private boolean fruitTree;      // true - fruit tree, false - decorative tree

    public Tree(String treeName, boolean coniferTree, boolean fruitTree) {
        this.treeName = treeName;
        this.coniferTree = coniferTree;
        this.fruitTree = fruitTree;
    }

    public String getTreeName() {
        return treeName;
    }

    public boolean isConiferTree() {
        return coniferTree;
    }

    public boolean isFruitTree() {
        return fruitTree;
    }

    public void getTreeInfo () {
        System.out.print(this.getTreeName() + ", ");
        if (this.coniferTree) {
            System.out.print("conifer tree, ");
        } else {
            System.out.print("deciduous tree, ");
        }
        if (this.fruitTree) {
            System.out.print("fruit tree.");
        } else {
            System.out.print("decorative tree.");
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree tree = (Tree) o;
        return coniferTree == tree.coniferTree && fruitTree == tree.fruitTree && Objects.equals(treeName, tree.treeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(treeName, coniferTree, fruitTree);
    }
}
