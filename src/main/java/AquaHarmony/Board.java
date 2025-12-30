package AquaHarmony;

public class Board {
    private final int N = 41;
    private final Square[] board;

    public Board(boolean deterministic) {
        board = new Square[N];
        for (int i = 0; i < N; i++)
            board[i] = makeSquare(i, deterministic);
    }

    public Square[] getBoard() {
        return board;
    }

    private Square makeSquare(int pos, boolean deterministic) {
        switch (pos) {
            case 0:
                return wood(pos);
            case 1:
                return subTaskA1(pos);
            case 2:
                return DisasterTile3(pos);
            case 3:
                return subTaskA3(pos);
            case 4:
                return woodAndSteel(pos);
            case 5:
                return subTaskB1(pos);
            case 6:
                return sand(pos);
            case 7:
                return moneyAndWorkforce(pos);
            case 8:
                return subTaskA4(pos);
            case 9:
                return DisasterTile1(pos);
            case 10:
                return subTaskC1(pos);
            case 11:
                return steel(pos);
            case 12:
                return DisasterTile5(pos);
            case 13:
                return workforceAndWood(pos);
            case 14:
                return subTaskC2(pos);
            case 15:
                return sand(pos);
            case 16:
                return wood(pos);
            case 17:
                return electricity(pos);
            case 18:
                return DisasterTile2(pos);
            case 19:
                return subTaskB2(pos);
            case 20:
                return workforceAndElectricity(pos);
            case 21:
                return DisasterTile3(pos);
            case 22:
                return workforceAndElectricity(pos);
            case 23:
                return DisasterTile4(pos);
            case 24:
                return woodAndSand(pos);
            case 25:
                return sand(pos);
            case 26:
                return workforceAndElectricity(pos);
            case 27:
                return DisasterTile4(pos);
            case 28:
                return subTaskC3(pos);
            case 29:
                return sand(pos);
            case 30:
                return subTaskA2(pos);
            case 31:
                return DisasterTile1(pos);
            case 32:
                return money(pos);
            case 33:
                return DisasterTile6(pos);
            case 34:
                return subTaskB3(pos);
            case 35:
                return electricity(pos);
            case 36:
                return DisasterTile1(pos);
            case 37:
                return workforceAndElectricity(pos);
            case 38:
                return woodAndSand(pos);
            case 39:
                return woodAndSteel(pos);
            case 40:
                return moneyAndWorkforce(pos);
            case 41:
                return sand(pos);
            default:
                return null;
        }
    }

    private Square subTaskA1(int pos) {
        String desc =
                        "╔════════════════════════════════════════════════════════╗\n" +
                        "║                                                        ║\n" +
                        "║    Make the Blueprint (sub-task to build the filter)   ║\n" +
                        "║                                                        ║\n" +
                        "║                                                        ║\n" +
                        "╚════════════════════════════════════════════════════════╝\n" + "The blueprint of the water filtration system serves as the foundational design document that encompasses \n" +
                                "all the essential information required for constructing the filter. \n" +
                                "It lays out the initial planning and design considerations before commencing the construction process.\n";
        int cost = 2000;
        int woodCost = 0;
        int electricityCost = 0;
        int steelCost = 0;
        int workforceCost = 80;
        int sandCost = 0;
        int timeCost = 10;
        return new Tasks("Make the Blueprint (sub-task to build the filter)", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private Square subTaskA2(int pos) {
        String desc =
                        "╔════════════════════════════════════════════════════════╗\n" +
                        "║                                                        ║\n" +
                        "║       Make Layer 1 (sub-task to build the filter)      ║\n" +
                        "║                                                        ║\n" +
                        "║                                                        ║\n" +
                        "╚════════════════════════════════════════════════════════╝\n" + "The first layer sets the groundwork for water intake\n" +
                        "This layer consists of several key components: the lid, the diffuser, and the system coverage.\n" +
                        "A sturdy foundation ensures the system can withstand pressure effectively, aiding in the filtration process.";
        int cost = 2000;
        int woodCost = 100;
        int electricityCost = 0;
        int steelCost = 100;
        int workforceCost = 80;
        int sandCost = 0;
        int timeCost = 10;
        return new Tasks("Make Layer 1 (sub-task to build the filter)", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private Square subTaskA3(int pos) {
        String desc =
                        "╔════════════════════════════════════════════════════════╗\n" +
                        "║                                                        ║\n" +
                        "║       Make Layer 2 (sub-task to build the filter)      ║\n" +
                        "║                                                        ║\n" +
                        "║                                                        ║\n" +
                        "╚════════════════════════════════════════════════════════╝\n" +
                        "The second layer is where the water undergoes filtration, utilizing high-quality fine gravel and sand.\n " +
                        "This layer comprises filtration sand, \n" +
                        "separating gravel, and drainage gravel, ensuring effective filtration.";
        int cost = 1000;
        int woodCost = 100;
        int electricityCost = 0;
        int steelCost = 0;
        int workforceCost = 80;
        int sandCost = 0;
        int timeCost = 10;
        return new Tasks("Make Layer 2 (sub-task to build the filter)", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private Square subTaskA4(int pos) {
        String desc =
                        "╔════════════════════════════════════════════════════════╗\n" +
                        "║                                                        ║\n" +
                        "║       Make Layer 3 (sub-task to build the filter)      ║\n" +
                        "║                                                        ║\n" +
                        "║                                                        ║\n" +
                        "╚════════════════════════════════════════════════════════╝\n" +
                        "The final step in creating the water filtration system involves constructing the outlet for water discharge. \n" +
                        "A robust and high-quality coverage, including pipes, is essential to ensure water hygiene. \n" +
                        "Therefore, designing the structure of the outlet tube is crucial for optimal extraction of clean water and separation from contaminated sources.";
        int cost = 1500;
        int woodCost = 100;
        int electricityCost = 0;
        int steelCost = 0;
        int workforceCost = 60;
        int sandCost = 100;
        int timeCost = 8;
        return new Tasks("Make Layer 3 (sub-task to build the filter)", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private Square subTaskB1(int pos) {
        String desc =
                        "╔══════════════════════════════════════════════════════════════════════════╗\n" +
                        "║                                                                          ║\n" +
                        "║      Build the turbine (sub-task to build the water pump generator)      ║\n" +
                        "║                                                                          ║\n" +
                        "║                                                                          ║\n" +
                        "╚══════════════════════════════════════════════════════════════════════════╝\n" +
                        "This step involves incorporating a turbine, which serves to generate power and propel water through the filtration system. \n" +
                        "This component harnesses kinetic energy from flowing water to rotate a shaft, \n" +
                        "driving both a generator for electricity and a pump for water circulation. \n" +
                        "By integrating a turbine, we ensure both sustainable power generation and efficient water movement, enhancing the system's functionality.";
        int cost = 3000;
        int woodCost = 150;
        int electricityCost = 0;
        int steelCost = 150;
        int workforceCost = 100;
        int sandCost = 0;
        int timeCost = 10;
        return new Tasks("Build the turbine (sub-task to build the water pump generator)", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private Square subTaskB2(int pos) {
        String desc =
                        "╔════════════════════════════════════════════════════════════════════════════════════╗\n" +
                        "║                                                                                    ║\n" +
                        "║       Build the generator engine (sub-task to build the water pump generator)      ║\n" +
                        "║                                                                                    ║\n" +
                        "║                                                                                    ║\n" +
                        "╚════════════════════════════════════════════════════════════════════════════════════╝\n" +
                        "The water generator pump can be powered by a diesel engine, prized for its reliability and efficiency. \n" +
                        "Diesel engines offer robust performance, making them suitable for various water pumping applications. \n" +
                        "The diesel-powered engine in a water generator pump system can be complemented by a turbine, \n" +
                        "which also has the capability to power up the diesel engine. \n" +
                        "This dual-power setup enhances efficiency and reliability, ensuring consistent water delivery even in challenging conditions.";
        int cost = 2000;
        int woodCost = 0;
        int electricityCost = 100;
        int steelCost = 0;
        int workforceCost = 40;
        int sandCost = 0;
        int timeCost = 7;
        return new Tasks("Build the generator engine (sub-task to build the water pump generator)", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private Square subTaskB3(int pos) {
        String desc =
                        "╔════════════════════════════════════════════════════════════════════════════════════╗\n" +
                        "║                                                                                    ║\n" +
                        "║       Build the pipe connection (sub-task to build the water pump generator)       ║\n" +
                        "║                                                                                    ║\n" +
                        "║                                                                                    ║\n" +
                        "╚════════════════════════════════════════════════════════════════════════════════════╝\n" +
                        "To build the water pipe connecting the river and rainwater supply to the filtration system, \n" +
                        "precise planning and execution are vital. Using durable and corrosion-resistant pipes, \n" +
                        "the connection ensures efficient water flow for purification.";
        int cost = 2000;
        int woodCost = 70;
        int electricityCost = 0;
        int steelCost = 70;
        int workforceCost = 80;
        int sandCost = 0;
        int timeCost = 9;
        return new Tasks("Build the pipe connection (sub-task to build the water pump generator)", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private Square subTaskC1(int pos) {
        String desc =
                        "╔════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                        "║                                                                                                    ║\n" +
                        "║       Create Software Development Plan Cycle (sub-task to create Software Sustainable System)      ║\n" +
                        "║                                                                                                    ║\n" +
                        "║                                                                                                    ║\n" +
                        "╚════════════════════════════════════════════════════════════════════════════════════════════════════╝\n" +
                        "This step involves creating a sustainable software system, \n" +
                        "crucial for planning and initial design. The software model continuously scans and retrieves water status data, \n" +
                        "supported by turbine-generated electricity. It monitors for leaks, maintenance dates, and sand renewal, \n" +
                        "ensuring efficient water filtration and system upkeep.";
        int cost = 2000;
        int woodCost = 0;
        int electricityCost = 0;
        int steelCost = 0;
        int workforceCost = 60;
        int sandCost = 0;
        int timeCost = 10;
        return new Tasks("Create Software Development Plan Cycle (sub-task to create Software Sustainable System)", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private Square subTaskC2(int pos) {
        String desc =
                        "╔════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                        "║                                                                                                    ║\n" +
                        "║                   Developing code (sub-task to create Software Sustainable System)                 ║\n" +
                        "║                                                                                                    ║\n" +
                        "║                                                                                                    ║\n" +
                        "╚════════════════════════════════════════════════════════════════════════════════════════════════════╝\n" +
                        "This step requires the entire software team to develop a code system \n" +
                        "capable of detecting anomalies in the clean water system.";
        int cost = 2000;
        int woodCost = 0;
        int electricityCost = 100;
        int steelCost = 0;
        int workforceCost = 80;
        int sandCost = 0;
        int timeCost = 10;
        return new Tasks("Developing code (sub-task to create Software Sustainable System)", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private Square subTaskC3(int pos) {
        String desc =
                        "╔════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                        "║                                                                                                    ║\n" +
                        "║        Education of Software Sustain System (sub-task to create Software Sustainable System)       ║\n" +
                        "║                                                                                                    ║\n" +
                        "║                                                                                                    ║\n" +
                        "╚════════════════════════════════════════════════════════════════════════════════════════════════════╝\n" +
                        "This final phase is essential for educating Pu Ngaol's leaders on understanding the software model, \n" +
                        "interpreting each detection's significance, taking appropriate action, \n" +
                        "and establishing communication channels with the software team for support.";
        int cost = 2000;
        int woodCost = 0;
        int electricityCost = 120;
        int steelCost = 0;
        int workforceCost = 30;
        int sandCost = 0;
        int timeCost = 10;
        return new Tasks("Education of Software Sustain System (sub-task to create Software Sustainable System)", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }


    private Square wood(int pos) {
        String desc =
                        "╔═══════════════════════════════════════════════╗\n" +
                        "║                                               ║\n" +
                        "║                Wood Resources                 ║\n" +
                        "║                                               ║\n" +
                        "║                                               ║\n" +
                        "╚═══════════════════════════════════════════════╝\n" +
                        "Would you like to chop some trees outside Pu Ngaol and take wood? It will grant you 60 wood";
        int cost = 40;
        int woodCost = 60;
        int electricityCost = 0;
        int steelCost = 0;
        int workforceCost = 0;
        int sandCost = 0;
        int timeCost = 4;
        return new Resources("Wood Resources", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private Square woodAndSteel(int pos) {
        String desc =
                        "╔══════════════════════════════════════════╗\n" +
                        "║                                          ║\n" +
                        "║        Wood and Steel Resources          ║\n" +
                        "║                                          ║\n" +
                        "║                                          ║\n" +
                        "╚══════════════════════════════════════════╝\n" +
                        "Would you like to call your crewmate to send more steel and wood from city center? It will grant 60 wood and 60 steel";
        int cost = 100;
        int woodCost = 60;
        int electricityCost = 0;
        int steelCost = 60;
        int workforceCost = 0;
        int sandCost = 0;
        int timeCost = 7;
        return new Resources("Wood and Steel Resources", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private Square sand(int pos) {
        String desc =
                        "╔══════════════════════════════════════════╗\n" +
                        "║                                          ║\n" +
                        "║              Sand Resources              ║\n" +
                        "║                                          ║\n" +
                        "║                                          ║\n" +
                        "╚══════════════════════════════════════════╝\n" +
                        "Would you like to collect and process more sand gravel with the construction team. It will grant you 80 sand";
        int cost = 40;
        int woodCost = 0;
        int electricityCost = 0;
        int steelCost = 0;
        int workforceCost = 0;
        int sandCost = 80;
        int timeCost = 3;
        return new Resources("Sand Resources", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private Square moneyAndWorkforce(int pos) {
        String desc =
                        "╔══════════════════════════════════════════╗\n" +
                        "║                                          ║\n" +
                        "║            Workforce Resources           ║\n" +
                        "║                                          ║\n" +
                        "║                                          ║\n" +
                        "╚══════════════════════════════════════════╝\n" +
                        "Would you like to request reinforcements from the government centre. It will grant you 60 workforce";
        int cost = 100;
        int woodCost = 0;
        int electricityCost = 0;
        int steelCost = 0;
        int workforceCost = 60;
        int sandCost = 0;
        int timeCost = 6;
        return new Resources("Workforce Resources", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private Square workforceAndWood(int pos) {
        String desc =
                        "╔══════════════════════════════════════════╗\n" +
                        "║                                          ║\n" +
                        "║       Wood and Workforce Resources       ║\n" +
                        "║                                          ║\n" +
                        "║                                          ║\n" +
                        "╚══════════════════════════════════════════╝\n" +
                        "The government has offered you more workforce to gather wood in Pu Ngaol. It will grant you 60 wood and 60 workforce. Would you accept?";
        int cost = 200;
        int woodCost = 60;
        int electricityCost = 0;
        int steelCost = 0;
        int workforceCost = 60;
        int sandCost = 0;
        int timeCost = 7;
        return new Resources("Wood and Workforce Resources", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private Square workforceAndElectricity(int pos) {
        String desc =
                        "╔════════════════════════════════════════════════════════════════════╗\n" +
                        "║                                                                    ║\n" +
                        "║                Workforce and Electricity Resources                 ║\n" +
                        "║                                                                    ║\n" +
                        "║                                                                    ║\n" +
                        "╚════════════════════════════════════════════════════════════════════╝\n" +
                        "Would you like to get more workforce and electricity power from the city center? It will grant you 60 electricity and 60 workforce";
        int cost = 100;
        int woodCost = 0;
        int electricityCost = 60;
        int steelCost = 0;
        int workforceCost = 60;
        int sandCost = 0;
        int timeCost = 8;
        return new Resources("Workforce and Electricity Resources", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }


    private Square electricity(int pos) {
        String desc =
                        "╔══════════════════════════════════════════════════════╗\n" +
                        "║                                                      ║\n" +
                        "║                Electricity Resources                 ║\n" +
                        "║                                                      ║\n" +
                        "║                                                      ║\n" +
                        "╚══════════════════════════════════════════════════════╝\n" +
                        "Would you like to acquire more generators from electricity team in city center? It will grant you 60 electricity";
        int cost = 50;
        int woodCost = 0;
        int electricityCost = 60;
        int steelCost = 0;
        int workforceCost = 0;
        int sandCost = 0;
        int timeCost = 6;
        return new Resources("Electricity Resources", pos,cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private Square steel(int pos) {
        String desc =
                        "╔══════════════════════════════════════════╗\n" +
                        "║                                          ║\n" +
                        "║              Steel Resources             ║\n" +
                        "║                                          ║\n" +
                        "║                                          ║\n" +
                        "╚══════════════════════════════════════════╝\n" +
                "Would you like to buy more steel from the construction team? It will grant you 60 steel";
        int cost = 50;
        int woodCost = 0;
        int electricityCost = 0;
        int steelCost = 60;
        int workforceCost = 0;
        int sandCost = 0;
        int timeCost = 5;
        return new Resources("Steel Resources", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private Square DisasterTile1(int pos) {
        String desc =
                        "╔══════════════════════════════════════════╗\n" +
                        "║                                          ║\n" +
                        "║           Heavy rain incident            ║\n" +
                        "║                                          ║\n" +
                        "║                                          ║\n" +
                        "╚══════════════════════════════════════════╝\n" +
                "Heavy rain has descended upon Pu Ngaol, triggering widespread flooding." +
                "Therefore you and your workers cannot work for a while, you'll lose 3 days";
        int cost = 0;
        int woodCost = 0;
        int electricityCost = 0;
        int steelCost = 0;
        int workforceCost = 0;
        int sandCost = 0;
        int timeCost = 3;
        return new DisasterTile("Heavy rain incident.", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private Square DisasterTile2(int pos) {
        String desc =
                        "╔══════════════════════════════════════════╗\n" +
                        "║                                          ║\n" +
                        "║            Wildfire accident             ║\n" +
                        "║                                          ║\n" +
                        "║                                          ║\n" +
                        "╚══════════════════════════════════════════╝\n" +
                "One of your workers caused a wildfire in one of the construction site\n" +
                "You'll lose 60 wood, 70 steel, 60 money, and 4 days";
        int cost = 60;
        int woodCost = 60;
        int electricityCost = 0;
        int steelCost = 70;
        int workforceCost = 0;
        int sandCost = 0;
        int timeCost = 4;
        return new DisasterTile("Wildfire accident.", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }
    private Square DisasterTile3(int pos) {
        String desc =
                        "╔══════════════════════════════════════════╗\n" +
                        "║                                          ║\n" +
                        "║           Earthquake accident            ║\n" +
                        "║                                          ║\n" +
                        "║                                          ║\n" +
                        "╚══════════════════════════════════════════╝\n" +
                "A small earthquake happened near the construction site\n"+
                "The impact of the accident is 70 money, 40 steel, 80 people from your work force and 4 days";
        int cost = 70;
        int woodCost = 0;
        int electricityCost = 0;
        int steelCost = 40;
        int workforceCost = 80;
        int sandCost = 0;
        int timeCost = 4;
        return new DisasterTile("Earthquake accident.", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }
    private Square DisasterTile4(int pos) {
        String desc =
                        "╔══════════════════════════════════════════╗\n" +
                        "║                                          ║\n" +
                        "║            Epidemic outbreak             ║\n" +
                        "║                                          ║\n" +
                        "║                                          ║\n" +
                        "╚══════════════════════════════════════════╝\n" +
                "An outbreak of a contagious illness occurred among the workers on-site.\n" +
                "Unfortunately, you'll lose 30 people from your work force, 80 money, and 4 days";
        int cost = 80;
        int woodCost = 0;
        int electricityCost = 0;
        int steelCost = 0;
        int workforceCost = 30;
        int sandCost = 0;
        int timeCost = 4;
        return new DisasterTile("Epidemic outbreak.", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private Square DisasterTile6(int pos) {
        String desc =
                        "╔══════════════════════════════════════════╗\n" +
                        "║                                          ║\n" +
                        "║           Landslide accident             ║\n" +
                        "║                                          ║\n" +
                        "║                                          ║\n" +
                        "╚══════════════════════════════════════════╝\n" +
                "A massive landslide happened, triggered by unforeseen circumstances, has struck the construction site.\n" +
                "The aftermath is you'll lose 40 wood, 100 sand, 50 money, 30 steel, and 1 day";
        int cost = 50;
        int woodCost = 40;
        int electricityCost = 0;
        int steelCost = 30;
        int workforceCost = 0;
        int sandCost = 100;
        int timeCost = 1;
        return new DisasterTile("Landslide accident.", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private Square DisasterTile5(int pos) {
        String desc =
                        "╔══════════════════════════════════════════╗\n" +
                        "║                                          ║\n" +
                        "║             Power outage                 ║\n" +
                        "║                                          ║\n" +
                        "║                                          ║\n" +
                        "╚══════════════════════════════════════════╝\n" +
                "Sudden power outage, an unexpected power outage has occured at the construction site\n" +
                "This incident requires 50 electricity units and 2 days to repair";
        int cost = 0;
        int woodCost = 0;
        int electricityCost = 50;
        int steelCost = 0;
        int workforceCost = 0;
        int sandCost = 0;
        int timeCost = 2;
        return new DisasterTile("Power outage.", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private Square money(int pos) {
        String desc =
                        "╔══════════════════════════════════════════╗\n" +
                        "║                                          ║\n" +
                        "║              Money Resources             ║\n" +
                        "║                                          ║\n" +
                        "║                                          ║\n" +
                        "╚══════════════════════════════════════════╝\n" +
                "You have been offered fund from a charity organisation, would you accept?";
        int cost = 50;
        int woodCost = 0;
        int electricityCost = 0;
        int steelCost = 0;
        int workforceCost = 0;
        int sandCost = 0;
        int timeCost = 6;
        return new Resources("Money Resources", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }


    private Square woodAndSand(int pos) {
        String desc =
                        "╔══════════════════════════════════════════╗\n" +
                        "║                                          ║\n" +
                        "║          Wood and Sand Resources         ║\n" +
                        "║                                          ║\n" +
                        "║                                          ║\n" +
                        "╚══════════════════════════════════════════╝\n" +
                "Would you like to get wood and sand from construction team? It will grant you 60 wood and 60 sand";
        int cost = 60;
        int woodCost = 60;
        int electricityCost = 0;
        int steelCost = 0;
        int workforceCost = 0;
        int sandCost = 60;
        int timeCost = 5;
        return new Resources("Wood and Sand Resources", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }
}



