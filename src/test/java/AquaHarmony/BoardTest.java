package AquaHarmony;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class BoardTest {

    @Test
    public void testMakeSquare_subTaskA1() {
        Board board = new Board(true);

        Square taskSquare = board.getBoard()[1];


        assertInstanceOf(Tasks.class, taskSquare);
        Tasks task = (Tasks) taskSquare;

        assertEquals("╔════════════════════════════════════════════════════════╗\n" +
                             "║                                                        ║\n" +
                             "║    Make the Blueprint (sub-task to build the filter)   ║\n" +
                             "║                                                        ║\n" +
                             "║                                                        ║\n" +
                             "╚════════════════════════════════════════════════════════╝\n" + "The blueprint of the water filtration system serves as the foundational design document that encompasses \n" +
                "all the essential information required for constructing the filter. \n" +
                "It lays out the initial planning and design considerations before commencing the construction process.\n", task.desc());
        assertEquals(2000, task.cost());
        assertEquals(0, task.woodCost());
        assertEquals(0, task.electricityCost());
        assertEquals(0, task.steelCost());
        assertEquals(80, task.workforceCost());
        assertEquals(0, task.sandCost());
        assertEquals(10, task.timeCost());

    }

    @Test
    public void testMakeSquare_DisasterTile3() {
        Board board = new Board(true);
        Square disasterTileSquare = board.getBoard()[2];

        assertInstanceOf(DisasterTile.class, disasterTileSquare);
        DisasterTile disasterTile = (DisasterTile) disasterTileSquare;
        assertEquals(  "╔══════════════════════════════════════════╗\n" +
                               "║                                          ║\n" +
                               "║           Earthquake accident            ║\n" +
                               "║                                          ║\n" +
                               "║                                          ║\n" +
                               "╚══════════════════════════════════════════╝\n" +
                "A small earthquake happened near the construction site\n"+
                "The impact of the accident is 70 money, 40 steel, 80 people from your work force and 4 days", disasterTile.desc());
        assertEquals(70, disasterTile.cost());
        assertEquals(0, disasterTile.woodCost());
        assertEquals(0, disasterTile.electricityCost());
        assertEquals(40, disasterTile.steelCost());
        assertEquals(80, disasterTile.workforceCost());
        assertEquals(0, disasterTile.sandCost());
        assertEquals(4, disasterTile.timeCost());
    }

    @Test
    public void testMakeSquare_subTaskA3() {
        Board board = new Board(true);
        Square taskSquare = board.getBoard()[3];

        assertInstanceOf(Tasks.class, taskSquare);
        Tasks task = (Tasks) taskSquare;

        assertEquals(  "╔════════════════════════════════════════════════════════╗\n" +
                                "║                                                        ║\n" +
                                "║       Make Layer 2 (sub-task to build the filter)      ║\n" +
                                "║                                                        ║\n" +
                                "║                                                        ║\n" +
                                "╚════════════════════════════════════════════════════════╝\n" +
                "The second layer is where the water undergoes filtration, utilizing high-quality fine gravel and sand.\n " +
                "This layer comprises filtration sand, \n" +
                "separating gravel, and drainage gravel, ensuring effective filtration.", task.desc());
        assertEquals(1000, task.cost());
        assertEquals(100, task.woodCost());
        assertEquals(0, task.electricityCost());
        assertEquals(0, task.steelCost());
        assertEquals(80, task.workforceCost());
        assertEquals(0, task.sandCost());
        assertEquals(10, task.timeCost());

    }

    @Test
    public void testMakeSquare_woodAndSteel() {
        Board board = new Board(true);
        Square resourceSquare = board.getBoard()[4];

        assertInstanceOf(Resources.class, resourceSquare);
        Resources resource = (Resources) resourceSquare;
        assertEquals("╔══════════════════════════════════════════╗\n" +
                             "║                                          ║\n" +
                             "║        Wood and Steel Resources          ║\n" +
                             "║                                          ║\n" +
                             "║                                          ║\n" +
                             "╚══════════════════════════════════════════╝\n" +
                "Would you like to call your crewmate to send more steel and wood from city center? It will grant 60 wood and 60 steel", resource.desc());
        assertEquals(100, resource.cost());
        assertEquals(60, resource.woodCost());
        assertEquals(0, resource.electricityCost());
        assertEquals(60, resource.steelCost());
        assertEquals(0, resource.workforceCost());
        assertEquals(0, resource.sandCost());
        assertEquals(7, resource.timeCost());
    }

    @Test
    public void testMakeSquare_subTaskB1() {
        Board board = new Board(true);
        Square taskSquare = board.getBoard()[5];

        assertInstanceOf(Tasks.class, taskSquare);
        Tasks task = (Tasks) taskSquare;
        assertEquals("╔══════════════════════════════════════════════════════════════════════════╗\n" +
                             "║                                                                          ║\n" +
                             "║      Build the turbine (sub-task to build the water pump generator)      ║\n" +
                             "║                                                                          ║\n" +
                             "║                                                                          ║\n" +
                             "╚══════════════════════════════════════════════════════════════════════════╝\n" +
                "This step involves incorporating a turbine, which serves to generate power and propel water through the filtration system. \n" +
                "This component harnesses kinetic energy from flowing water to rotate a shaft, \n" +
                "driving both a generator for electricity and a pump for water circulation. \n" +
                "By integrating a turbine, we ensure both sustainable power generation and efficient water movement, enhancing the system's functionality.", task.desc());
        assertEquals(3000, task.cost());
        assertEquals(150, task.woodCost());
        assertEquals(0, task.electricityCost());
        assertEquals(150, task.steelCost());
        assertEquals(100, task.workforceCost());
        assertEquals(0, task.sandCost());
        assertEquals(10, task.timeCost());
    }

    @Test
    public void testMakeSquare_sand() {
        Board board = new Board(true);
        Square resourceSquare = board.getBoard()[6];

        assertInstanceOf(Resources.class, resourceSquare);
        Resources resource = (Resources) resourceSquare;
        assertEquals("╔══════════════════════════════════════════╗\n" +
                             "║                                          ║\n" +
                             "║              Sand Resources              ║\n" +
                             "║                                          ║\n" +
                             "║                                          ║\n" +
                             "╚══════════════════════════════════════════╝\n" +
                "Would you like to collect and process more sand gravel with the construction team. It will grant you 80 sand", resource.desc());
        assertEquals(40, resource.cost());
        assertEquals(0, resource.woodCost());
        assertEquals(0, resource.electricityCost());
        assertEquals(0, resource.steelCost());
        assertEquals(0, resource.workforceCost());
        assertEquals(80, resource.sandCost());
        assertEquals(3, resource.timeCost());
    }

    @Test
    public void testMakeSquare_moneyAndWorkforce() {
        Board board = new Board(true);
        Square resourceSquare = board.getBoard()[40];

        assertInstanceOf(Resources.class, resourceSquare);
        Resources resource = (Resources) resourceSquare;
        assertEquals("╔══════════════════════════════════════════╗\n" +
                             "║                                          ║\n" +
                             "║            Workforce Resources           ║\n" +
                             "║                                          ║\n" +
                             "║                                          ║\n" +
                             "╚══════════════════════════════════════════╝\n" +
                "Would you like to request reinforcements from the government centre. It will grant you 60 workforce", resource.desc());
        assertEquals(100, resource.cost());
        assertEquals(0, resource.woodCost());
        assertEquals(0, resource.electricityCost());
        assertEquals(0, resource.steelCost());
        assertEquals(60, resource.workforceCost());
        assertEquals(0, resource.sandCost());
        assertEquals(6, resource.timeCost());
    }

    @Test
    public void testMakeSquare_subTaskA4() {
        Board board = new Board(true);
        Square taskSquare = board.getBoard()[8];

        assertInstanceOf(Tasks.class, taskSquare);
        Tasks task = (Tasks) taskSquare;
        assertEquals("╔════════════════════════════════════════════════════════╗\n" +
                             "║                                                        ║\n" +
                             "║       Make Layer 3 (sub-task to build the filter)      ║\n" +
                             "║                                                        ║\n" +
                             "║                                                        ║\n" +
                             "╚════════════════════════════════════════════════════════╝\n" +
                "The final step in creating the water filtration system involves constructing the outlet for water discharge. \n" +
                "A robust and high-quality coverage, including pipes, is essential to ensure water hygiene. \n" +
                "Therefore, designing the structure of the outlet tube is crucial for optimal extraction of clean water and separation from contaminated sources.", task.desc());
        assertEquals(1500, task.cost());
        assertEquals(100, task.woodCost());
        assertEquals(0, task.electricityCost());
        assertEquals(0, task.steelCost());
        assertEquals(60, task.workforceCost());
        assertEquals(100, task.sandCost());
        assertEquals(8, task.timeCost());
    }

    @Test
    public void testMakeSquare_DisasterTile1() {
        Board board = new Board(true);
        Square disasterTileSquare = board.getBoard()[9];

        assertTrue(disasterTileSquare instanceof DisasterTile);
        DisasterTile disasterTile = (DisasterTile) disasterTileSquare;
        assertEquals( "╔══════════════════════════════════════════╗\n" +
                              "║                                          ║\n" +
                              "║           Heavy rain incident            ║\n" +
                              "║                                          ║\n" +
                              "║                                          ║\n" +
                              "╚══════════════════════════════════════════╝\n" +
                "Heavy rain has descended upon Pu Ngaol, triggering widespread flooding." +
                "Therefore you and your workers cannot work for a while, you'll lose 3 days", disasterTile.desc());
        assertEquals(0, disasterTile.cost());
        assertEquals(0, disasterTile.woodCost());
        assertEquals(0, disasterTile.electricityCost());
        assertEquals(0, disasterTile.steelCost());
        assertEquals(0, disasterTile.workforceCost());
        assertEquals(0, disasterTile.sandCost());
        assertEquals(3, disasterTile.timeCost());
    }

    @Test
    public void testMakeSquare_steel() {
        Board board = new Board(true);
        Square resourceSquare = board.getBoard()[11];

        assertInstanceOf(Resources.class, resourceSquare);
        Resources resource = (Resources) resourceSquare;
        assertEquals( "╔══════════════════════════════════════════╗\n" +
                              "║                                          ║\n" +
                              "║              Steel Resources             ║\n" +
                              "║                                          ║\n" +
                              "║                                          ║\n" +
                              "╚══════════════════════════════════════════╝\n" +
                "Would you like to buy more steel from the construction team? It will grant you 60 steel", resource.desc());
        assertEquals(50, resource.cost());
        assertEquals(0, resource.woodCost());
        assertEquals(0, resource.electricityCost());
        assertEquals(60, resource.steelCost());
        assertEquals(0, resource.workforceCost());
        assertEquals(0, resource.sandCost());
        assertEquals(5, resource.timeCost());
    }

    @Test
    public void testMakeSquare_wood2() {
        Board board = new Board(true);
        Square resourceSquare = board.getBoard()[0];

        assertInstanceOf(Resources.class, resourceSquare);
        Resources resource = (Resources) resourceSquare;
        assertEquals("╔═══════════════════════════════════════════════╗\n" +
                             "║                                               ║\n" +
                             "║                Wood Resources                 ║\n" +
                             "║                                               ║\n" +
                             "║                                               ║\n" +
                             "╚═══════════════════════════════════════════════╝\n" +
                "Would you like to chop some trees outside Pu Ngaol and take wood? It will grant you 60 wood", resource.desc());
        assertEquals(40, resource.cost());
        assertEquals(60, resource.woodCost());
        assertEquals(0, resource.electricityCost());
        assertEquals(0, resource.steelCost());
        assertEquals(0, resource.workforceCost());
        assertEquals(0, resource.sandCost());
        assertEquals(4, resource.timeCost());
    }


    @Test
    public void testMakeSquare_workforceAndElectricity() {
        Board board = new Board(true);
        Square resourceSquare = board.getBoard()[22];

        assertInstanceOf(Resources.class, resourceSquare);
        Resources resource = (Resources) resourceSquare;
        assertEquals( "╔════════════════════════════════════════════════════════════════════╗\n" +
                              "║                                                                    ║\n" +
                              "║                Workforce and Electricity Resources                 ║\n" +
                              "║                                                                    ║\n" +
                              "║                                                                    ║\n" +
                              "╚════════════════════════════════════════════════════════════════════╝\n" +
                        "Would you like to get more workforce and electricity power from the city center? It will grant you 60 electricity and 60 workforce", resource.desc());
        assertEquals(100, resource.cost());
        assertEquals(0, resource.woodCost());
        assertEquals(60, resource.electricityCost());
        assertEquals(0, resource.steelCost());
        assertEquals(60, resource.workforceCost());
        assertEquals(0, resource.sandCost());
        assertEquals(8, resource.timeCost());
    }

    @Test
    public void testMakeSquare_DisasterTile4() {
        Board board = new Board(true);
        Square disasterTileSquare = board.getBoard()[23];

        assertInstanceOf(DisasterTile.class, disasterTileSquare);
        DisasterTile disasterTile = (DisasterTile) disasterTileSquare;
        assertEquals( "╔══════════════════════════════════════════╗\n" +
                              "║                                          ║\n" +
                              "║            Epidemic outbreak             ║\n" +
                              "║                                          ║\n" +
                              "║                                          ║\n" +
                              "╚══════════════════════════════════════════╝\n" +
                "An outbreak of a contagious illness occurred among the workers on-site.\n" +
                "Unfortunately, you'll lose 30 people from your work force, 80 money, and 4 days", disasterTile.desc());
        assertEquals(80, disasterTile.cost());
        assertEquals(0, disasterTile.woodCost());
        assertEquals(0, disasterTile.electricityCost());
        assertEquals(0, disasterTile.steelCost());
        assertEquals(30, disasterTile.workforceCost());
        assertEquals(0, disasterTile.sandCost());
        assertEquals(4, disasterTile.timeCost());
    }

    @Test
    public void testMakeSquare_DisasterTile5() {
        Board board = new Board(true);
        Square disasterTileSquare = board.getBoard()[12];

        assertInstanceOf(DisasterTile.class, disasterTileSquare);
        DisasterTile disasterTile = (DisasterTile) disasterTileSquare;
        assertEquals("╔══════════════════════════════════════════╗\n" +
                             "║                                          ║\n" +
                             "║             Power outage                 ║\n" +
                             "║                                          ║\n" +
                             "║                                          ║\n" +
                             "╚══════════════════════════════════════════╝\n" +
                "Sudden power outage, an unexpected power outage has occured at the construction site\n" +
                "This incident requires 50 electricity units and 2 days to repair", disasterTile.desc());
        assertEquals(0, disasterTile.cost());
        assertEquals(0, disasterTile.woodCost());
        assertEquals(50, disasterTile.electricityCost());
        assertEquals(0, disasterTile.steelCost());
        assertEquals(0, disasterTile.workforceCost());
        assertEquals(0, disasterTile.sandCost());
        assertEquals(2, disasterTile.timeCost());
    }

    @Test
    public void testMakeSquare_DisasterTile6() {
        Board board = new Board(true);
        Square disasterTileSquare = board.getBoard()[33];

        assertInstanceOf(DisasterTile.class, disasterTileSquare);
        DisasterTile disasterTile = (DisasterTile) disasterTileSquare;
        assertEquals("╔══════════════════════════════════════════╗\n" +
                             "║                                          ║\n" +
                             "║           Landslide accident             ║\n" +
                             "║                                          ║\n" +
                             "║                                          ║\n" +
                             "╚══════════════════════════════════════════╝\n" +
                "A massive landslide happened, triggered by unforeseen circumstances, has struck the construction site.\n" +
                "The aftermath is you'll lose 40 wood, 100 sand, 50 money, 30 steel, and 1 day", disasterTile.desc());
        assertEquals(50, disasterTile.cost());
        assertEquals(40, disasterTile.woodCost());
        assertEquals(0, disasterTile.electricityCost());
        assertEquals(30, disasterTile.steelCost());
        assertEquals(0, disasterTile.workforceCost());
        assertEquals(100, disasterTile.sandCost());
        assertEquals(1, disasterTile.timeCost());
    }

    @Test
    public void testMakeSquare_woodSand() {
        Board board = new Board(true);
        Square resourceSquare = board.getBoard()[24];

        assertInstanceOf(Resources.class, resourceSquare);
        Resources resource = (Resources) resourceSquare;
        assertEquals("╔══════════════════════════════════════════╗\n" +
                             "║                                          ║\n" +
                             "║          Wood and Sand Resources         ║\n" +
                             "║                                          ║\n" +
                             "║                                          ║\n" +
                             "╚══════════════════════════════════════════╝\n" +
                "Would you like to get wood and sand from construction team? It will grant you 60 wood and 60 sand", resource.desc());
        assertEquals(60, resource.cost());
        assertEquals(60, resource.woodCost());
        assertEquals(0, resource.electricityCost());
        assertEquals(0, resource.steelCost());
        assertEquals(0, resource.workforceCost());
        assertEquals(60, resource.sandCost());
        assertEquals(5, resource.timeCost());
    }

    @Test
    public void testMakeSquare_wood() {
        Board board = new Board(true);
        Square resourceSquare = board.getBoard()[16];

        assertInstanceOf(Resources.class, resourceSquare);
        Resources resource = (Resources) resourceSquare;
        assertEquals( "╔═══════════════════════════════════════════════╗\n" +
                              "║                                               ║\n" +
                              "║                Wood Resources                 ║\n" +
                              "║                                               ║\n" +
                              "║                                               ║\n" +
                              "╚═══════════════════════════════════════════════╝\n" +
                "Would you like to chop some trees outside Pu Ngaol and take wood? It will grant you 60 wood", resource.desc());
        assertEquals(40, resource.cost());
        assertEquals(60, resource.woodCost());
        assertEquals(0, resource.electricityCost());
        assertEquals(0, resource.steelCost());
        assertEquals(0, resource.workforceCost());
        assertEquals(0, resource.sandCost());
        assertEquals(4, resource.timeCost());
    }

    @Test
    public void testMakeSquare_subTaskC3() {
        Board board = new Board(true);
        Square taskSquare = board.getBoard()[28];

        assertInstanceOf(Tasks.class, taskSquare);
        Tasks task = (Tasks) taskSquare;
        assertEquals("╔════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                             "║                                                                                                    ║\n" +
                             "║        Education of Software Sustain System (sub-task to create Software Sustainable System)       ║\n" +
                             "║                                                                                                    ║\n" +
                             "║                                                                                                    ║\n" +
                             "╚════════════════════════════════════════════════════════════════════════════════════════════════════╝\n" +
                "This final phase is essential for educating Pu Ngaol's leaders on understanding the software model, \n" +
                "interpreting each detection's significance, taking appropriate action, \n" +
                "and establishing communication channels with the software team for support.", task.desc());
        assertEquals(2000, task.cost());
        assertEquals(0, task.woodCost());
        assertEquals(120, task.electricityCost());
        assertEquals(0, task.steelCost());
        assertEquals(30, task.workforceCost());
        assertEquals(0, task.sandCost());
        assertEquals(10, task.timeCost());
    }

    @Test
    public void testMakeSquare_subTaskA2() {
        Board board = new Board(true);
        Square taskSquare = board.getBoard()[30];

        assertInstanceOf(Tasks.class, taskSquare);
        Tasks task = (Tasks) taskSquare;
        assertEquals( "╔════════════════════════════════════════════════════════╗\n" +
                              "║                                                        ║\n" +
                              "║       Make Layer 1 (sub-task to build the filter)      ║\n" +
                              "║                                                        ║\n" +
                              "║                                                        ║\n" +
                              "╚════════════════════════════════════════════════════════╝\n" + "The first layer sets the groundwork for water intake\n" +
                "This layer consists of several key components: the lid, the diffuser, and the system coverage.\n" +
                "A sturdy foundation ensures the system can withstand pressure effectively, aiding in the filtration process.", task.desc());
        assertEquals(2000, task.cost());
        assertEquals(100, task.woodCost());
        assertEquals(0, task.electricityCost());
        assertEquals(100, task.steelCost());
        assertEquals(80, task.workforceCost());
        assertEquals(0, task.sandCost());
        assertEquals(10, task.timeCost());
    }


    @Test
    public void testMakeSquare_money() {
        Board board = new Board(true);
        Square resourceSquare = board.getBoard()[32];

        assertInstanceOf(Resources.class, resourceSquare);
        Resources resource = (Resources) resourceSquare;
        assertEquals(  "╔══════════════════════════════════════════╗\n" +
                               "║                                          ║\n" +
                               "║              Money Resources             ║\n" +
                               "║                                          ║\n" +
                               "║                                          ║\n" +
                               "╚══════════════════════════════════════════╝\n" +
                "You have been offered fund from a charity organisation, would you accept?", resource.desc());
        assertEquals(50, resource.cost());
        assertEquals(0, resource.woodCost());
        assertEquals(0, resource.electricityCost());
        assertEquals(0, resource.steelCost());
        assertEquals(0, resource.workforceCost());
        assertEquals(0, resource.sandCost());
        assertEquals(6, resource.timeCost());
    }

    @Test
    public void testMakeSquare_woodSteel() {
        Board board = new Board(true);
        Square resourceSquare = board.getBoard()[4];

        assertInstanceOf(Resources.class, resourceSquare);
        Resources resource = (Resources) resourceSquare;
        assertEquals("╔══════════════════════════════════════════╗\n" +
                             "║                                          ║\n" +
                             "║        Wood and Steel Resources          ║\n" +
                             "║                                          ║\n" +
                             "║                                          ║\n" +
                             "╚══════════════════════════════════════════╝\n" +
                        "Would you like to call your crewmate to send more steel and wood from city center? It will grant 60 wood and 60 steel", resource.desc());
        assertEquals(100, resource.cost());
        assertEquals(60, resource.woodCost());
        assertEquals(0, resource.electricityCost());
        assertEquals(60, resource.steelCost());
        assertEquals(0, resource.workforceCost());
        assertEquals(0, resource.sandCost());
        assertEquals(7, resource.timeCost());
    }

    @Test
    public void testMakeSquare_subTaskB3() {
        Board board = new Board(true);
        Square taskSquare = board.getBoard()[34];

        assertInstanceOf(Tasks.class, taskSquare);
        Tasks task = (Tasks) taskSquare;
        assertEquals("╔════════════════════════════════════════════════════════════════════════════════════╗\n" +
                             "║                                                                                    ║\n" +
                             "║       Build the pipe connection (sub-task to build the water pump generator)       ║\n" +
                             "║                                                                                    ║\n" +
                             "║                                                                                    ║\n" +
                             "╚════════════════════════════════════════════════════════════════════════════════════╝\n" +
                "To build the water pipe connecting the river and rainwater supply to the filtration system, \n" +
                "precise planning and execution are vital. Using durable and corrosion-resistant pipes, \n" +
                "the connection ensures efficient water flow for purification.", task.desc());
        assertEquals(2000, task.cost());
        assertEquals(70, task.woodCost());
        assertEquals(0, task.electricityCost());
        assertEquals(70, task.steelCost());
        assertEquals(80, task.workforceCost());
        assertEquals(0, task.sandCost());
        assertEquals(9, task.timeCost());
    }

    @Test
    public void testMakeSquare_electricity() {
        Board board = new Board(true);
        Square resourceSquare = board.getBoard()[35];

        assertInstanceOf(Resources.class, resourceSquare);
        Resources resource = (Resources) resourceSquare;
        assertEquals( "╔══════════════════════════════════════════════════════╗\n" +
                              "║                                                      ║\n" +
                              "║                Electricity Resources                 ║\n" +
                              "║                                                      ║\n" +
                              "║                                                      ║\n" +
                              "╚══════════════════════════════════════════════════════╝\n" +
                "Would you like to acquire more generators from electricity team in city center? It will grant you 60 electricity", resource.desc());
        assertEquals(50, resource.cost());
        assertEquals(0, resource.woodCost());
        assertEquals(60, resource.electricityCost());
        assertEquals(0, resource.steelCost());
        assertEquals(0, resource.workforceCost());
        assertEquals(0, resource.sandCost());
        assertEquals(6, resource.timeCost());
    }

    @Test
    public void testMakeSquare_moneyWorkforce() {
        Board board = new Board(true);
        Square resourceSquare = board.getBoard()[40];

        assertInstanceOf(Resources.class, resourceSquare);
        Resources resource = (Resources) resourceSquare;
        assertEquals("╔══════════════════════════════════════════╗\n" +
                             "║                                          ║\n" +
                             "║            Workforce Resources           ║\n" +
                             "║                                          ║\n" +
                             "║                                          ║\n" +
                             "╚══════════════════════════════════════════╝\n" +
                "Would you like to request reinforcements from the government centre. It will grant you 60 workforce", resource.desc());
        assertEquals(100, resource.cost());
        assertEquals(0, resource.woodCost());
        assertEquals(0, resource.electricityCost());
        assertEquals(0, resource.steelCost());
        assertEquals(60, resource.workforceCost());
        assertEquals(0, resource.sandCost());
        assertEquals(6, resource.timeCost());
    }


}
