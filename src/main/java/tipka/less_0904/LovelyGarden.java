package tipka.less_0904;

public class LovelyGarden {

    public static void main(String[] args) {

        Gardener bread = new Gardener("Bread");
        Cat donut = new Cat("Donut");

        System.out.println();
        System.out.println(bread.getGardenerName() +
                " planted the trees: ");
        Tree pie = bread.plantTree("Pie");
        pie.getTreeInfo();
        Tree bagel = bread.plantTree("Bagel");
        bagel.getTreeInfo();
        Tree cake = bread.plantTree("Cake");
        cake.getTreeInfo();
        System.out.println();

        System.out.println(donut.getCatName() +
                " loves climbing trees!");
        System.out.println();

        if (donut.isCatAliveness()) {
            donut.climbTree(pie);
            System.out.println();
        }
        if (donut.isCatAliveness()) {
            donut.climbTree(bagel);
            System.out.println();
        }
        if (donut.isCatAliveness()) {
            donut.climbTree(cake);
            System.out.println();
        }

    }
}
