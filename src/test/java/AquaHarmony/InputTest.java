package AquaHarmony;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InputTest {

    private Input input;
    private final InputStream originalSystemIn = System.in;

    @BeforeEach
    public void setUp() {
        input = new Input();
    }

    @Test
    public void testInputString() {
        String testString = "Test input string";
        provideInput(testString);
        String result = input.inputString();
        assertEquals(testString, result);
        assertEquals("Test input string", result);
    }



    @Test
    public void testInputBool_True() {
        String testBool = "Yes";
        provideInput(testBool);
        assertTrue(input.inputBool());
    }

    @Test
    public void testInputBool_False() {
        String testBool = "No";
        provideInput(testBool);
        assertFalse(input.inputBool());
    }

    @Test
    public void testInputInt() {
        int testInt = 42;
        provideInput(String.valueOf(testInt));
        assertEquals(testInt, input.inputInt());
    }

    @Test
    public void testInputDecision_ValidInput() {
        String[] choices = {"Yes", "No"};
        provideInput("yes");
        assertEquals(0, input.inputDecision(choices));
    }

    @Test
    public void testInputDecision_InvalidInput() {
        String[] choices = {"Yes", "No"};
        provideInput("maybe\nno");
        assertEquals(1, input.inputDecision(choices));
    }

    @Test
    public void testInputPlayer_ValidInput() {
        TestPlayer player1 = new TestPlayer("Player1");
        TestPlayer player2 = new TestPlayer("Player2");
        TestPlayer player3 = new TestPlayer("Player3");
        TestPlayer[] players = {player1, player2, player3};
        String inputName = "Player2";


        provideInput(inputName);


        assertEquals(player2, input.inputPlayer(List.of(players), null));
    }


    @Test
    public void testInputPlayer_InvalidInput() {
        TestPlayer player1 = new TestPlayer("Player1");
        TestPlayer player2 = new TestPlayer("Player2");
        TestPlayer player3 = new TestPlayer("Player3");
        TestPlayer[] players = {player1, player2, player3};
        String inputName = "InvalidPlayer";

        provideInput(inputName, "Player1");

        assertEquals(player1, input.inputPlayer(List.of(players), null));
    }


    private void provideInput(String data) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);
    }

    private void provideInput(String... data) {
        String input = String.join(System.lineSeparator(), data);
        provideInput(input);
    }


    @AfterEach
    public void tearDown() {
        System.setIn(originalSystemIn);
    }

    private static class TestPlayer implements Player {
        private final String name;

        public TestPlayer(String name) {
            this.name = name;
        }

        @Override
        public void addTask(Square square) {

        }

        @Override
        public void addMainTask(Square square) {

        }

        @Override
        public void move(int numSpaces) {

        }

        @Override
        public int position() {
            return 0;
        }

        @Override
        public Iterable<Square> tasks() {
            return null;
        }

        @Override
        public String name() {
            return name;
        }

        @Override
        public int getMoney() {
            return 0;
        }

        @Override
        public void excMoney(int money) {

        }

        @Override
        public void excWood(int wood) {

        }

        @Override
        public void excElectricity(int electricity) {

        }

        @Override
        public void excSteel(int steel) {

        }

        @Override
        public void excWorkforce(int workforce) {

        }

        @Override
        public void giveTask(Square sq) {

        }

        @Override
        public void excSand(int sand) {

        }

        @Override
        public void excTime(int time) {

        }

        @Override
        public int getWoodAssets() {
            return 0;
        }

        @Override
        public int getElectricityAssets() {
            return 0;
        }

        @Override
        public int getSteelAssets() {
            return 0;
        }

        @Override
        public int getWorkforceAssets() {
            return 0;
        }

        @Override
        public int getSandAssets() {
            return 0;
        }

        @Override
        public int getTimeAssets() {
            return 0;
        }

        @Override
        public boolean inputBool(Main.State state) {
            return false;
        }

        @Override
        public int inputInt(Main.State state) {
            return 0;
        }

        @Override
        public int inputDecision(Main.State state, String[] choices) {
            return 0;
        }

        @Override
        public Player inputPlayer(Main.State state, Player notAllowed) {
            return null;
        }
    }
}
