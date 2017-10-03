
class Triplet {
    private int side1, side2, side3;

    Triplet(int side1, int side2, int side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }


    boolean isPythagorean() {
        return (side1 * side1) + (side2 * side2) == (side3 * side3);
    }

    public String toString() {
        return side1 + " " + side2 + " " + side3;
    }
}