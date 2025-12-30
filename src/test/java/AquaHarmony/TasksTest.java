package AquaHarmony;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TasksTest {

    @Test
    void testConstructor() {
        Tasks task = new Tasks("TaskName", 1, 100, 80, 80, 80, 80, 80, 15, "Task Description");


        assertEquals("TaskName", task.name());
        assertEquals(1, task.position());
        assertEquals(100, task.cost());
        assertEquals(80, task.woodCost());
        assertEquals(80, task.electricityCost());
        assertEquals(80, task.steelCost());
        assertEquals(80, task.workforceCost());
        assertEquals(80, task.sandCost());
        assertEquals(15, task.timeCost());
        assertEquals("Task Description", task.desc());


        assertFalse(task.isOwned());
        assertFalse(task.isResources());
        assertFalse(task.isDisaster());
        assertFalse(task.mainTaskCompleted);
        assertNull(task.owner());
    }

    @Test
    void testPurchase() {
        TestPlayer player = new TestPlayer("PlayerName");
        Tasks task = new Tasks("TaskName", 1, 100, 80, 80, 80, 80, 80, 15, "Task Description");


        task.purchase(player);
        assertTrue(task.isOwned());
        assertEquals(player, task.owner());
    }

    @Test
    void testSetMainTaskComplete() {
        TestPlayer player = new TestPlayer("PlayerName");
        Tasks task = new Tasks("TaskName", 1, 100, 50, 20, 30, 10, 5, 15, "Task Description");


        task.setMainTaskcomplete(player);
        assertTrue(task.isOwned());
        assertTrue(task.mainTaskCompleted);
        assertEquals(player, task.owner());
    }


    private static class TestPlayer implements Player {
        private final String name;

        public TestPlayer(String name) {
            this.name = name;
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


    }
}
