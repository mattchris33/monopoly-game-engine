package AquaHarmony;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DiceTest {

    @Test
    public void testNumDice() {
        Dice dice = new CustomDice(2, 6);
        assertEquals(2, dice.numDice());
    }

    @Test
    public void testSides() {
        Dice dice = new CustomDice(2, 6);
        assertEquals(6, dice.sides());
    }

    @Test
    public void testRoll() {
        Dice dice = new CustomDice(2, 6);
        Dice.Roll roll = dice.roll();
        assertNotNull(roll);
        assertTrue(roll.val >= 2 && roll.val <= 12);
    }

    private static class CustomDice implements Dice {
        private final int numDice;
        private final int sides;

        public CustomDice(int numDice, int sides) {
            this.numDice = numDice;
            this.sides = sides;
        }

        @Override
        public int numDice() {
            return numDice;
        }

        @Override
        public int sides() {
            return sides;
        }

        @Override
        public Roll roll() {
            Roll roll = new Roll();
            roll.val = (int) (Math.random() * (numDice * sides - numDice + 1)) + numDice;
            roll.is_double = (roll.val % 2 == 0);
            return roll;
        }
    }
}
