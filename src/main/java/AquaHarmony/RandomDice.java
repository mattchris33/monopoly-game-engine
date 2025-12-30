package AquaHarmony;

import java.util.Random;

public class RandomDice implements Dice {
    private final int N;
    private final int SIDES;
    private final Random rand;

    public RandomDice() {
        N = 2;
        SIDES = 6;
        rand = new Random();
    }

    public int numDice() {
        return N;
    }

    public int sides() {
        return SIDES;
    }

    public Roll roll() {
        Roll roll = new Roll();

        int randA = rand.nextInt(6) + 1;

        int randB = rand.nextInt(6) + 1;
        roll.is_double = randA == randB;

        roll.val = randA + randB;

        return roll;
    }
}
