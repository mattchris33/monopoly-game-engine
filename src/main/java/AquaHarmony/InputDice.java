package AquaHarmony;

public class InputDice implements Dice {
    private final int N;
    private final int SIDES;
    private final Input input;

    public InputDice(Input input) {
        N = 2;
        SIDES = 6;
        this.input = input;
    }

    public int numDice() {
        return N;
    }

    public int sides() {
        return SIDES;
    }

    public Roll roll() {
        System.out.println("Please input two six-sided dice rolls, player must input one dice roll per line.");
        while (true) {
            Roll roll = input.inputRoll();
            if (roll.val < N || roll.val > N * SIDES)
                System.out.println("Please enter a valid dice roll.");
            else
                return roll;
        }
    }
}
