package AquaHarmony;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SquareTest {
    private Square square;

    @BeforeEach
    public void setUp() {
        square = new MockSquare("TestSquare", 0, 100, 50, 30, 20, 10, 5, 6, "Test Description");
    }

    @Test
    public void testPosition() {
        assertEquals(0, square.position());
    }

    @Test
    public void testName() {
        assertEquals("TestSquare", square.name());
    }

    @Test
    public void testDescription() {
        assertEquals("Test Description", square.desc());
    }

    @Test
    public void testOwnable() {
        assertFalse(square.isOwnable());
    }

    @Test
    public void testOwned() {
        assertFalse(square.isOwned());
    }

    @Test
    public void testCost() {
        assertEquals(100, square.cost());
    }

    @Test
    public void testWoodCost() {
        assertEquals(50, square.woodCost());
    }

    @Test
    public void testElectricityCost() {
        assertEquals(30, square.electricityCost());
    }

    @Test
    public void testSteelCost() {
        assertEquals(20, square.steelCost());
    }

    @Test
    public void testWorkforceCost() {
        assertEquals(10, square.workforceCost());
    }

    @Test
    public void testSandCost() {
        assertEquals(5, square.sandCost());
    }

    @Test
    public void testTimeCost() {
        assertEquals(6, square.timeCost());
    }

    @Test
    public void testResources() {
        assertTrue(square.isResources());
    }

    @Test
    public void testDisaster() {
        assertFalse(square.isDisaster());
    }

    @Test
    public void testOwner() {
        assertNull(square.owner());
    }

    @Test
    public void testToString() {
        assertEquals("TestSquare", square.toString());
    }

    private static class MockSquare implements Square {
        private final String name;
        private final int pos;
        private final int cost;
        private final int woodCost;
        private final int electricityCost;
        private final int steelCost;
        private final int workforceCost;
        private final int sandCost;
        private final int timeCost;
        private final String desc;

        public MockSquare(String name, int pos, int cost, int woodCost, int electricityCost, int steelCost, int workforceCost, int sandCost, int timeCost, String desc) {
            this.name = name;
            this.pos = pos;
            this.cost = cost;
            this.woodCost = woodCost;
            this.electricityCost = electricityCost;
            this.steelCost = steelCost;
            this.workforceCost = workforceCost;
            this.sandCost = sandCost;
            this.timeCost = timeCost;
            this.desc = desc;
        }

        @Override
        public int position() {
            return pos;
        }

        @Override
        public String name() {
            return name;
        }

        @Override
        public String desc() {
            return desc;
        }

        @Override
        public boolean isOwnable() {
            return false;
        }

        @Override
        public boolean isOwned() {
            return false;
        }

        @Override
        public int cost() {
            return cost;
        }

        @Override
        public int woodCost() {
            return woodCost;
        }

        @Override
        public int electricityCost() {
            return electricityCost;
        }

        @Override
        public int steelCost() {
            return steelCost;
        }

        @Override
        public int workforceCost() {
            return workforceCost;
        }

        @Override
        public int sandCost() {
            return sandCost;
        }

        @Override
        public int timeCost() {
            return timeCost;
        }

        @Override
        public void purchase(Player player) {
        }

        @Override
        public void setMainTaskcomplete(Player player) {
        }

        @Override
        public Player owner() {
            return null;
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public boolean isResources() {
            return true;
        }

        @Override
        public boolean isDisaster() {
            return false;
        }
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
