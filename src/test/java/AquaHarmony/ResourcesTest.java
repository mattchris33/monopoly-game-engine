package AquaHarmony;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResourcesTest {
    private Resources resource;

    @BeforeEach
    public void setUp() {
        resource = new Resources("Wood", 0, 100, 50, 30, 20, 10, 5, 6, "Test");
    }

    @Test
    public void testConstructor() {
        assertEquals("Wood", resource.name());
        assertEquals(100, resource.cost());
        assertEquals(50, resource.woodCost());
        assertEquals(30, resource.electricityCost());
        assertEquals(20, resource.steelCost());
        assertEquals(10, resource.workforceCost());
        assertEquals(5, resource.sandCost());
        assertEquals(6, resource.timeCost());
        assertEquals(0, resource.position());
        assertTrue(resource.isResources());
        assertFalse(resource.isDisaster());
        assertFalse(resource.isOwned());
        assertFalse(resource.isOwnable());
    }

    @Test
    public void testOwner() {
        assertNull(resource.owner());
    }

    @Test
    public void testCheckWin() {
        resource.checkIfAwin(null);
        resource.checkIfBwin(null);
        resource.checkIfCwin(null);
    }

    @Test
    public void testDescription() {
        assertEquals("Test", resource.desc());
    }
}
