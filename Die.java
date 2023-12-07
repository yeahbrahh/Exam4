import java.util.concurrent.ThreadLocalRandom;

public class Die {
    private int numSides;
    private int value;

    public Die() {
        this.numSides = 6;
        this.value = 1;
    }

    public Die(int numSides) {
        this.numSides = numSides;
        this.value = 1;
    }
        public int getNumSides () {
            return numSides;
        }

        public void setNumSides ( int numSides){
            this.numSides = numSides;
        }

        public int getValue () {
            return value;
        }

        public void setValue ( int value){
            this.value = value;
        }
        public void roll () {
           this.value = ThreadLocalRandom.current().nextInt(1, numSides + 1);
        }
    @Override
    public String toString() {
        return "Die: " + "Sides: " + numSides +
                "Value: " + value;
    }



}

