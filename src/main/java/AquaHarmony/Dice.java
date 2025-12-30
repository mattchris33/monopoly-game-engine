package AquaHarmony;

public interface Dice {

    int numDice();

    int sides();

    Roll roll();

    class Roll {
        public int val;
        public boolean is_double;
    }
}
