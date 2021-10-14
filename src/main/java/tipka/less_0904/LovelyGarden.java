package tipka.less_0904;

public class LovelyGarden {

    public static void main(String[] args) {

        Gardener bread = new Gardener("Bread");
        Cat donut = new Cat("Donut");

        System.out.println();
        System.out.println(bread.getGardenerName() +
                " planted the trees: ");
        // Planting the trees. Output to console info about.
        Tree pie = bread.plantTree("Pie");
        pie.getTreeInfo();
        Tree bagel = bread.plantTree("Bagel");
        bagel.getTreeInfo();
        Tree cake = bread.plantTree("Cake");
        cake.getTreeInfo();
        System.out.println();

        // Output to console info about a cat.
        System.out.println(donut.getCatName() +
                " loves climbing trees!");
        System.out.println();

        // The cat is climbing trees. Output to console info about.
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
