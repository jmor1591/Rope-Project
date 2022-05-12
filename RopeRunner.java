public class RopeRunner {
    
    public void main(String[] args) {
        Rope.addRope(new Rope(5));
        Rope.addRope(new Rope(10, "Bunny Rabbit Knot"));
        Rope.addRope(new Rope(3, "Nylon", Rope.randomKnot()));
        Rope.addRope(new Rope(7, Rope.randomType(), true));
        Rope.addRope(new Rope(5));
        Rope.knotAll();
        Rope.removeIllKnot(Rope.randomKnot());
    }
}
