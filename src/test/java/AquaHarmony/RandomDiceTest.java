package AquaHarmony;

import org.junit.Test;
import static org.junit.Assert.*;

public class RandomDiceTest {

    @Test
    public void testNumDice() {
        RandomDice randomDice = new RandomDice();
        assertEquals(2, randomDice.numDice());
    }

    @Test
    public void testSides() {
        RandomDice randomDice = new RandomDice();
        assertEquals(6, randomDice.sides());
    }

    @Test
    public void testRoll() {
        RandomDice randomDice = new RandomDice();
        Dice.Roll roll = randomDice.roll();
        assertNotNull(roll);


        assertTrue(roll.val >= 2 && roll.val <= 12);


        if (roll.val % 2 == 0) {
            assertTrue(roll.is_double);
        } else {
            assertFalse(roll.is_double);
        }
    }
}
