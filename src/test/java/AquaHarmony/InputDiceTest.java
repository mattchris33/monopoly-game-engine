package AquaHarmony;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class InputDiceTest {

    @Test
    public void testNumDice() {
        InputDice inputDice = new InputDice(new MockInput());
        assertEquals(2, inputDice.numDice());
    }

    @Test
    public void testSides() {
        InputDice inputDice = new InputDice(new MockInput());
        assertEquals(6, inputDice.sides());
    }

    @Test
    public void testRoll_ValidInput() {
        MockInput mockInput = new MockInput();
        Dice.Roll roll1 = new Dice.Roll();
        roll1.val = 5;
        Dice.Roll roll2 = new Dice.Roll();
        roll2.val = 3;
        mockInput.addRoll(roll1);
        mockInput.addRoll(roll2);
        InputDice inputDice = new InputDice(mockInput);
        Dice.Roll roll = inputDice.roll();
        assertNotNull(roll);
        assertEquals(2 + 3, roll.val);
    }

    @Test
    public void testRoll_InvalidInput() {
        MockInput mockInput = new MockInput();
        Dice.Roll roll1 = new Dice.Roll();
        roll1.val = 7;
        Dice.Roll roll2 = new Dice.Roll();
        roll2.val = 2;
        mockInput.addRoll(roll1);
        mockInput.addRoll(roll2);
        InputDice inputDice = new InputDice(mockInput);
        Dice.Roll roll = inputDice.roll();
        assertNotNull(roll);
        assertEquals(7, roll.val);
    }

    private static class MockInput extends Input {
        private final Queue<Dice.Roll> rolls = new LinkedList<>();

        public void addRoll(Dice.Roll roll) {
            rolls.add(roll);
        }

        @Override
        public Dice.Roll inputRoll() {
            return rolls.poll();
        }
    }
}
