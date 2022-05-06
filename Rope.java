public class Rope {
    
    private int length;
    private boolean usable = true;
    private boolean straight = true;
    private String type;
    private String knot;

    public Rope(int ropeLength) {
        length = ropeLength;
    }

    public Rope(int ropeLength, String ropeKnot) {
        length = ropeLength;
        knot = ropeKnot;
        straight = false;
    }

    public Rope(int ropeLength, String ropeType, String ropeKnot) {
        length = ropeLength;
        type = ropeType;
        knot = ropeKnot;
        straight = false;
    }

    public Rope(int ropeLength, String ropeType, boolean ropeStraight) {
        straight = ropeStraight;
        length = ropeLength;
        type = ropeType;
    }
}