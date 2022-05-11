import java.util.ArrayList;

public class Rope {
    
    private int length;
    private boolean straight = true;
    private String type = "normal";
    private String knot = "rope";
    private static ArrayList<Rope> contestants = new ArrayList<Rope>();

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
    
    public int getLength() {
        return length;
    }

    public boolean isStraight() {
        return straight;
    }

    public String getType() {
        return type;
    }

    public String getKnot() {
        return knot;
    }

    public void setType(String ropeType) {
        System.out.print(this + " is now ");
        type = ropeType;
        System.out.println(this);
    }

    public void setKnot(String ropeKnot) {
        System.out.print(this + " is now ");
        knot = ropeKnot;
        System.out.println(this);
    }

    public void straighten() {
        straight = true;
        System.out.println("This " + type + " " + knot + " is straightened");
        knot = "rope";
    }

    public void coil() {
        straight = false;
        knot = "coiled";
        System.out.println("This " + type + " " + knot + " is coiled");
    }

    public void cut(int n) {
        straighten();
        if (n < length) {
            length -= n;
            System.out.println("The rope is now " + length + " inches.");
        }
    }

    public void knot() {
        for (Rope r : contestants) {
            r.setKnot(randomKnot());
        }
    }

    public void removeKnot(String illegalKnot) {
        for (int i = 0; i < contestants.size(); i++) {
            if (contestants.get(i).getType().equals(illegalKnot)) {
                removeRope(i);
                i--;
            }
        }
    }

    public String randomKnot() {
        String [] knotList = {"Sailor", "Slipknot", "Half-hitch knot", "Clove-hitch knot"};
        int ran = (int) (Math.random() * knotList.length);
        return knotList[ran];
    }

    public String randomType() {
        String[] ropeList = {"Nylon", "Bungee", "Synthetic", "Cotton", "Hemp"};
        int ran = (int) (Math.random() * ropeList.length);
        return ropeList[ran];
    }

    public static void addRope(Rope r) {
        contestants.add(r);
        System.out.println(r + " has entered the competition.");
    }

    public static void removeRope(int index) {
        System.out.println(contestants.remove(index) + " has left the running.");
    }

    public void longestRope() {
        int max = contestants.get(0).getLength();
        ArrayList<Integer> index = new ArrayList<Integer>();
        index.add(0);
        for (int i = 1; i < contestants.size(); i++) {
            if (contestants.get(i).getLength() == max) {
                index.add(i);
            }

            if (contestants.get(i).getLength() > max) {
                max = contestants.get(i).getLength();
                index.clear();
                index.add(i);
            }
        }

        if (index.size() == 1) {
            System.out.println("The winner is " + contestants.get(index.get(0)));
        }
        else {
            System.out.print("The winners are");
            for (int n : index) {
                System.out.print(" " + contestants.get(n));
            }
            System.out.println();
        }
        
    }

    public String toString() {
        return "A" + length + " inch " + type + " " + knot;
    }
}