package AquaHarmony;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayersTest {
    private Players player;

    @BeforeEach
    public void setUp() {
        player = new Players("TestPlayer");
    }

    @Test
    public void testConstructor() {
        assertEquals("TestPlayer", player.name());
        assertEquals(15000, player.getMoney());
        assertEquals(300, player.getWoodAssets());
        assertEquals(300, player.getElectricityAssets());
        assertEquals(300, player.getSteelAssets());
        assertEquals(300, player.getWorkforceAssets());
        assertEquals(300, player.getSandAssets());
        assertEquals(180, player.getTimeAssets());
        assertEquals(0, player.position());
        assertTrue(player.tasks().isEmpty());
    }

    @Test
    public void testAddTask() {
        Square square = new Tasks("Test Task", 0, 100, 50, 30, 20, 10, 5, 6, "Test");
        player.addTask(square);

        assertFalse(player.tasks().isEmpty());
        assertEquals(1, player.tasks().size());
        assertEquals(square, player.tasks().peek());
    }

    @Test
    public void testAddMainTask() {
        Square square = new Tasks("Test Main Task", 0, 200, 100, 50, 40, 20, 10,5,"Test Main Description");
        player.addMainTask(square);

        assertFalse(player.tasks().isEmpty());
        assertEquals(1, player.tasks().size());
        assertEquals(square, player.tasks().peek());
    }

    @Test
    public void testMove() {
        player.move(5);
        assertEquals(5, player.position());

        player.move(40);
        assertEquals(5, player.position());
    }

    @Test
    public void testMoveTo() {
        player.moveTo(10);
        assertEquals(10, player.position());
    }

    @Test
    public void testExcMoney() {
        player.excMoney(500);
        assertEquals(15500, player.getMoney());
    }

    @Test
    public void testExcWood() {
        player.excWood(50);
        assertEquals(350, player.getWoodAssets());
    }

    @Test
    public void testExcElectricity() {
        player.excElectricity(50);
        assertEquals(350, player.getElectricityAssets());
    }

    @Test
    public void testExcSteel() {
        player.excSteel(50);
        assertEquals(350, player.getSteelAssets());
    }

    @Test
    public void testExcWorkforce() {
        player.excWorkforce(50);
        assertEquals(350, player.getWorkforceAssets());
    }

    @Test
    public void testExcSand() {
        player.excSand(50);
        assertEquals(350, player.getSandAssets());
    }

    @Test
    public void testExcTime() {
        player.excTime(50);
        assertEquals(230, player.getTimeAssets());
    }

    @Test
    public void testGiveTask() {
        Square square = new Tasks("Test Task", 0, 100, 50, 30, 20, 10, 5, 6, "Test Description");
        player.addTask(square);
        player.giveTask(square);

        assertTrue(player.tasks().isEmpty());
    }

    @Test
    public void testInputBool() {
        assertFalse(player.inputBool(null));
    }

    @Test
    public void testInputInt() {
        assertEquals(0, player.inputInt(null));
    }

    @Test
    public void testInputDecision() {
        String[] choices = {"Choice 1", "Choice 2", "Choice 3"};
        assertEquals(0, player.inputDecision(null, choices));
    }

    @Test
    public void testInputPlayer() {
        Players otherPlayer = new Players("OtherPlayer");
        assertEquals(otherPlayer, player.inputPlayer(null, null));
    }
}
