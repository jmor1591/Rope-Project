import java.util.ArrayList;

public class Rope {

    //Length of the rope
    private int length;
    //all ropes are initialized as straight and ready to be tied
    private boolean straight = true;
    //the material of the rope
    private String type = "normal";
    //the type of knot of the rope
    private String knot = "rope";
    //list of "contestants" in a rope competition
    public static ArrayList<Rope> contestants = new ArrayList<Rope>();

    //Creates a rope with a length
    public Rope(int ropeLength) {
        length = ropeLength;
    }

    //Creates a rope object with a length and a knot
    public Rope(int ropeLength, String ropeKnot) {
        length = ropeLength;
        knot = ropeKnot;
        straight = false;
    }

    //Creates a rope object with a length, material, and knot
    public Rope(int ropeLength, String ropeType, String ropeKnot) {
        length = ropeLength;
        type = ropeType;
        knot = ropeKnot;
        straight = false;

    }

    //Creates a rope object with a length, material, and if the rope is straight/able to be knotted
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

    //Sets the rope object's material
    public void setType(String ropeType) {
        System.out.print(this + " is now ");
        type = ropeType;
        System.out.println(this);
    }

    //Sets the rope object's knot
    public void setKnot(String ropeKnot) {
        System.out.print(this + " is now ");
        knot = ropeKnot;
        System.out.println(this);
    }

    //Sets the rope object to be straight (ready to be knotted)
    public void straighten() {
        straight = true;
        System.out.println("The " + this + " is straightened");
        knot = "rope";
    }

    //Coils the rope. Essentially a placeholder for a knot
    public void coil() {
        straight = false;
        System.out.println("The " + this + " is coiled");
        knot = "coil";
    }

    //Shortens the rope by the designated length and also undos the knot it had
    public void cut(int n) {
        if (n < length) {
            System.out.print("The " + this + " is now ");
            length -= n;
            System.out.println(length + " inches and straightened.");
            straight = true;
            knot = "rope";
        }
    }

    //If any rope in contestants does not have a knot (or coiled) it is knotted
    public static void knotAll() {
        for (Rope r : contestants) {
            if (r.getKnot().equals("rope")) {
                r.setKnot(randomKnot());
            }
        }
    }

    //Removes any knots that would be "illegal" for the competition
    public static void removeIllKnot(String illegalKnot) {
        for (int i = 0; i < contestants.size(); i++) {
            if (contestants.get(i).getKnot().equals(illegalKnot)) {
                contestants.get(i).straighten();
                i--;
            }
        }
    }

    //Generates a random knot name
    public static String randomKnot() {
        String [] knotList = {"Sailor knot", "Slipknot", "Half-hitch knot", "Clove-hitch knot"};
        int ran = (int) (Math.random() * knotList.length);
        return knotList[ran];
    }

    //Generates a random material name
    public static String randomType() {
        String[] ropeList = {"Nylon", "Bungee", "Synthetic", "Cotton", "Hemp"};
        int ran = (int) (Math.random() * ropeList.length);
        return ropeList[ran];
    }

    //Adds a rope to contestants
    public static void addRope(Rope r) {
        contestants.add(r);
        System.out.println("A " + r + " has entered the competition.");
    }

    //Eliminates a rope from the competition
    public static void removeRope(int index) {
        System.out.println(contestants.remove(index) + " has left the running.");
    }

    //Prints out the longest rope(s) of the contest
    public static void longestRope() {
        //Initializes max as the length of the first item
        int max = contestants.get(0).getLength();
        //List of indices that will hold indices of ropes that have a length equal to the longest length
        ArrayList<Integer> index = new ArrayList<Integer>();
        //Initializes the index list to have the first item (like max)
        index.add(0);
        //for every rope in contestants, check and see if their length is greater than or equal to the max
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

        //print the winners
        if (index.size() == 1) {
            System.out.println("The winner is " + contestants.get(index.get(0)));
        }

        //if multiple winners, print all of them
        else {
            System.out.print("The winners are");
            for (int n : index) {
                System.out.print(" " + contestants.get(n));
            }
            System.out.println(".");
        }
        
    }

    public String toString() {
        return length + " inch " + type + " " + knot;
    }
}