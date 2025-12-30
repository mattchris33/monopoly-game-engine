package AquaHarmony;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void testConstructor() {

        InputStream deterministicInput = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(deterministicInput);


        Main main = new Main();

        assertEquals(Main.DecisionState.NONE, main.state.state);
        assertTrue(main.deterministic);
        assertInstanceOf(InputDice.class, main.dice);
        assertInstanceOf(Board.class, main.state.board);
    }

    static class InputMock extends Input {
        private boolean boolValue;

        public InputMock(boolean boolValue) {
            this.boolValue = boolValue;
        }

        @Override
        public boolean inputBool() {
            return boolValue;
        }
    }
}

