public class RopeRunner {
    
    public static void main(String[] args) {
        Rope.addRope(new Rope(5));
        Rope.addRope(new Rope(10, "Bunny Rabbit Knot"));
        Rope.addRope(new Rope(3, "Nylon", Rope.randomKnot()));
        Rope.addRope(new Rope(7, Rope.randomType(), true));
        Rope.addRope(new Rope(6));
        Rope.removeIllKnot(Rope.randomKnot());
        Rope.contestants.get(0).setKnot(Rope.randomKnot());
        for (Rope r : Rope.contestants) {
            if (r.getKnot().equals("rope")) {
                r.coil();
            }

            if (r.getLength() > 5) {
                r.cut((int) (Math.random() * (r.getLength()-1) + 1));
                r.setKnot(Rope.randomKnot());
            }
        }
        Rope.knotAll();
        Rope.longestRope();
    }
}
