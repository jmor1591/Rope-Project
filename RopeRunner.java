public class RopeRunner {
    
    public static void main(String[] args) {
        Rope.addRope(new Rope(5));
        Rope.addRope(new Rope(10, "Bunny Rabbit Knot"));
        Rope.addRope(new Rope(3, "Nylon", Rope.randomKnot()));
        Rope.addRope(new Rope(7, Rope.randomType(), true));
        Rope.addRope(new Rope(6));
        //"unties" any illegal knots
        Rope.removeIllKnot(Rope.randomKnot());
        //tests the setKnot and randomKnot methods
        Rope.contestants.get(0).setKnot(Rope.randomKnot());
        //for every rope in contestants; either coil it or if it has a knot (and is longer than 5 inches),
        // cut it and then knot it again (not taking into account any illegal knottery)
        for (Rope r : Rope.contestants) {
            if (r.getKnot().equals("rope")) {
                r.coil();
            }

            if (r.getLength() > 5) {
                //makes sure the rope is only cut at a minimum of 1 and a maximum of 1 less than its length
                r.cut((int) (Math.random() * (r.getLength()-1) + 1));
                r.setKnot(Rope.randomKnot());
            }
        }
        //reknot all of the cut rope
        Rope.knotAll();
        //find the winner
        Rope.longestRope();
    }
}
