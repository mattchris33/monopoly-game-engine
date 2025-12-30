package AquaHarmony;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

class Main {
    final boolean deterministic;
    final Dice dice;
    final State state;
    public enum DecisionState {
        NONE, COMPLETE, ACTION, TRADE, GIVE_TASKS, GET_TASKS, TAKE_TASK
    }

    public static class State {
        public DecisionState state;
        public Queue<Player> players;
        public Board board;
        public Player current;
        public int val = 0;
    }

    Main() {
        state = new State();
        state.players = new LinkedList<>();
        state.current = null;
        state.state = DecisionState.NONE;
        Input input = new Input();

        System.out.println(
                        "╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                        "║                                                   Welcome to AQUAHARMONY                                             ║\n" +
                        "║                                                                                                                      ║\n" +
                        "║  Congratulations on taking the initiative to address the critical issue of clean water scarcity in our               ║\n" +
                        "║  community. In this challenge, each player will embark on a journey to ensure clean water is readily                 ║\n" +
                        "║  available for all residents.                                                                                        ║\n" +
                        "║                                                                                                                      ║\n" +
                        "║  Before playing the game, please read the instructions carefully:                                                    ║\n" +
                        "║                                                                                                                      ║\n" +
                        "║  ╭────────────────────────────────────────────────────────────────────────────────────────────────────────────────╮  ║\n" +
                        "║  │1) The main objective of the game: all players must work together as a team to complete 3 main tasks            │  ║\n" +
                        "║  │   each main task has specific sub-tasks required to be taken and completed by players, all sub-tasks           │  ║\n" +
                        "║  │   of each main task must be completed first in order to finally take and complete the related main             │  ║\n" +
                        "║  │   task.                                                                                                        │  ║\n" +
                        "║  │                                                                                                                │  ║\n" +
                        "║  │2) If a player wants to complete a main task, he/she must have all the sub-tasks related to the main            │  ║\n" +
                        "║  │   task (sub-tasks/main-tasks accomplished will be shown every turn).                                           │  ║\n" +
                        "║  │                                                                                                                │  ║\n" +
                        "║  │3) Players will start by rolling a dice, with quite similar ways to play monopoly, the Dice number will         │  ║\n" +
                        "║  │   be 2D6, which means the players should roll two six-sided dice.                                              │  ║\n" +
                        "║  │                                                                                                                │  ║\n" +
                        "║  │4) The game will be based on a virtual board, with tiles consisting of:                                         │  ║\n" +
                        "║  │   - resources tiles: if a player lands on a resource tile, he/she has the option to gather certain             │  ║\n" +
                        "║  │     resources, which will require a certain amount of money and time.                                          │  ║\n" +
                        "║  │   - disaster tiles: if a player lands on a disaster tile, he/she will get certain events that can cost         │  ║\n" +
                        "║  │     them certain resources, including money and time.                                                          │  ║\n" +
                        "║  │   - sub-tasks tiles: if a player lands on a sub-task tile, he/she has the option to take responsibility        │  ║\n" +
                        "║  │     of the sub-task, which will require a certain amount of resources.                                         │  ║\n" +
                        "║  │                                                                                                                │  ║\n" +
                        "║  │5) Players can give/trade their accomplished tasks to one another after every turn without any cost,            │  ║\n" +
                        "║  │   so make sure to coordinate with your team about who's taking control of which main task.                     │  ║\n" +
                        "║  │                                                                                                                │  ║\n" +
                        "║  │6) If a player lands on a sub-task tile but refuses to take charge of the sub-task given, other players         │  ║\n" +
                        "║  │   have the option take charge of the task immediately.                                                         │  ║\n" +
                        "║  │                                                                                                                │  ║\n" +
                        "║  │7) If a player lands on a sub-task that is already taken, the player cannot take the sub-task and will          │  ║\n" +
                        "║  │   remain in position.                                                                                          │  ║\n" +
                        "║  │                                                                                                                │  ║\n" +
                        "║  │8) Team can decide whether they want to manually input the dice number or random generated dice number.         │  ║\n" +
                        "║  │   If the team decides to play with random generated input, the rule will inherit monopoly, whereas             │  ║\n" +
                        "║  │   whenever a player rolls a double, he gets another chance to roll again. On the other hand, if the            │  ║\n" +
                        "║  │   team decides to play with manual input, the double roll advantage will not apply.                            │  ║\n" +
                        "║  │                                                                                                                │  ║\n" +
                        "║  │9) VERY IMPORTANT: IN ORDER TO COMPLETE THE GAME, TEAM MUST FIRST POINT OUT ONE PERSON TO BE THE LEADER,        │  ║\n" +
                        "║  │   WHICH HAS THE ABILITY TO COMPLETE THE GAME ONCE HE POSSESSES ALL MAIN TASKS. THEREFORE, USE THE              │  ║\n" +
                        "║  │   GIVE/TRADE TASKS OPTION TO TRANSFER TASKS TO YOUR LEADER.                                                    │  ║\n" +
                        "║  │                                                                                                                │  ║\n" +
                        "║  │   Main Tasks:                                                                                                  │  ║\n" +
                        "║  │   Main Task 1: Build Water Generator                                                                           │  ║\n" +
                        "║  │       Sub-tasks:                                                                                               │  ║\n" +
                        "║  │           - Build the turbine                                                                                  │  ║\n" +
                        "║  │           - Build the generator engine                                                                         │  ║\n" +
                        "║  │           - Build the pipe connection                                                                          │  ║\n" +
                        "║  │                                                                                                                │  ║\n" +
                        "║  │   Main Task 2: Establish Water Filtration System                                                               │  ║\n" +
                        "║  │       Sub-tasks:                                                                                               │  ║\n" +
                        "║  │           - Make the Blueprint                                                                                 │  ║\n" +
                        "║  │           - Make Layer 1                                                                                       │  ║\n" +
                        "║  │           - Make Layer 2                                                                                       │  ║\n" +
                        "║  │           - Make Layer 3                                                                                       │  ║\n" +
                        "║  │                                                                                                                │  ║\n" +
                        "║  │   Main Task 3: Develop Software System                                                                         │  ║\n" +
                        "║  │       Sub-tasks:                                                                                               │  ║\n" +
                        "║  │           - Create Software Development Plan Cycle                                                             │  ║\n" +
                        "║  │           - Developing code                                                                                    │  ║\n" +
                        "║  │           - Education of Software Sustain System                                                               │  ║\n" +
                        "║  │                                                                                                                │  ║\n" +
                        "║  │   In addition to physical infrastructure, players must design and implement a software system to               │  ║\n" +
                        "║  │   monitor and manage the water supply. This system will track water usage, detect leaks or                     │  ║\n" +
                        "║  │   contamination, and ensure efficient distribution.                                                            │  ║\n" +
                        "║  │                                                                                                                │  ║\n" +
                        "║  │   By completing all tasks, players will not only provide access to clean water for drinking, cooking,          │  ║\n" +
                        "║  │   and sanitation but also promote sustainable water management practices to safeguard our environment          │  ║\n" +
                        "║  │   for future generations.                                                                                      │  ║\n" +
                        "║  │                                                                                                                │  ║\n" +
                        "║  │   Are you ready to take on the Clean Water Challenge and make a difference in Pu Ngaol? Let's get              │  ║\n" +
                        "║  │   started!                                                                                                     │  ║\n" +
                        "║  ╰────────────────────────────────────────────────────────────────────────────────────────────────────────────────╯  ║\n" +
                        "╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");

        String userInput;
        do {
            System.out.println(
                            "╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                            "║                                                                                                                      ║\n" +
                            "║                                                      START GAME                                                      ║\n" +
                            "║                                                                                                                      ║\n" +
                            "║                                            Enter 'start' to start the game                                           ║\n" +
                            "║                                                                                                                      ║\n" +
                            "╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");

            userInput = input.nextLine().trim();


            if (!userInput.equalsIgnoreCase("start")) {
                System.out.println("Please enter 'start' to begin the game.");
            }
        } while (!userInput.equalsIgnoreCase("start"));

        System.out.println("Do you want to enter your own dice?");
        System.out.println("(If you answer 'Yes', you can take control manually of the number dice(s) number you want to throw, hence you can enter your desired dice number: 1-6)");
        System.out.println("(If you answer 'No', we will generate random number of dice for the game)");

        deterministic = input.inputBool();
        if (deterministic) {
            dice = new InputDice(input);
        } else {
            dice = new RandomDice();
        }

        state.board = new Board(deterministic);
        playerNum(input);

    }




    public static void main(String[] args) {
        Main aquaharmony = new Main();
        aquaharmony.run();
    }

    private void run() {
        while (state.players.size() > 1) {
            try {
                state.current = state.players.remove();
                turn();
                state.players.add(state.current);
            } catch (NoSuchElementException e) {
                System.out.println("Early Termination initiated.");
                return;
            } finally {
                playerInfo();
            }
        }
    }

    private void playerNum(Input input) {
        System.out.println("How many total players (3-4)?");
        int N = input.inputInt();
        while (N < 3 || N > 4) {
            System.out.println("Must have between 3 and 4 players. Please try again.");
            N = input.inputInt();
        }


        int[] order = new int[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Player " + (i + 1) + " name?");
            state.players.add(new Players(input.inputString()));
        }

        if (deterministic)
            return;

        boolean tie = true;
        boolean[] ties = new boolean[N];
        for (int i = 0; i < N; i++)
            ties[i] = true;
        int first = -1;

        while (tie) {
            for (int i = 0; i < N; i++) {
                if (ties[i])
                    order[i] = dice.roll().val;
            }

            int maxRoll = 0;

            for (int i = 0; i < N; i++) {
                if (ties[i]) {
                    if (order[i] > maxRoll) {
                        maxRoll = order[i];
                        first = i;
                    }
                }
            }

            tie = false;
            for (int i = 0; i < N; i++)
                ties[i] = false;

            for (int i = 0; i < N; i++) {
                if (order[i] == maxRoll && i != first) {
                    ties[i] = true;
                    tie = true;
                }
            }
        }

        for (int i = 0; i < first; i++)
            state.players.add(state.players.remove());

        playerInfo();
    }

    private void turn() {
        System.out.println("It's " + state.current.name() + "'s turn");
        while (true) {
            Dice.Roll roll = dice.roll();
            System.out.print("You rolled a " + roll.val);
            if (roll.is_double)
                System.out.print(" (double)");
            Square[] square = state.board.getBoard();
            System.out.println(" and landed on the square of " + square[(state.current.position() + roll.val) % 40].name());
            state.current.move(roll.val);

            checkSquare(state.current, square[state.current.position()], roll.val);

            if (!roll.is_double)
                break;
        }

        boolean additional = true;
        while (additional) {
            int pos = 90;
            System.out.println("What further actions do you want to take?");
            System.out.println("Please select choice");
            System.out.println("1. Give/Trade tasks?");
            System.out.println("2. Continue to the next player");
            System.out.println("3. Complete main task A (Build the water Filtration system)");
            System.out.println("4. Complete main task B (Build the water generator pump)");
            System.out.println("5. Complete main task C (Complete software sustainable system)");
            System.out.println("6. Complete the game (choose this if you are the team leader and if you have all of the main tasks)");
            state.state = DecisionState.ACTION;
            int decision = state.current.inputInt(state);

            switch (decision) {
                case 1:
                    TradeTask(state.current);
                    break;
                case 2:
                    additional = false;
                    break;
                case 3:
                    assert false;
                    completeMainTaskA(state.current, mainTaskA(pos));
                    break;
                case 4:
                    assert false;
                    completeMainTaskB(state.current, mainTaskB(pos));
                    break;
                case 5:
                    assert false;
                    completeMainTaskC(state.current, mainTaskC(pos));
                    break;
                case 6:
                    assert false;
                    completeGame(state.current, finishGame(pos));
                    break;
                default:
                    System.out.println("Please enter a valid decision.");
            }
        }

        System.out.println();
    }


    private void tasks(Player player, Square square) {
        int cost = square.cost();
        int woodCost = square.woodCost();
        int electricityCost = square.electricityCost();
        int workforceCost = square.workforceCost();
        int steelCost = square.steelCost();
        int sandCost = square.sandCost();
        int timeCost = square.timeCost();
        String desc = square.desc();

        if (player.getMoney() < cost || player.getWoodAssets()<  woodCost || + player.getElectricityAssets() < electricityCost || player.getSteelAssets() <  steelCost || player.getWorkforceAssets() < workforceCost || player.getSandAssets() < sandCost || player.getTimeAssets() < timeCost) {
            System.out.println("You do not have enough resources to complete the sub-task: " + square.name());
            purchase(GiveTask(player, square), square);
            return;
        }

        boolean additional = false;
        System.out.println(player.name() + ", " + "You are now in position: " + player.position() + " and landed on...\n" + desc + "----------------------------------------------\n" +
                player.name() + ", Would you like to complete the sub-task? \n" + "The sub-task : \n" + square.name() + "\n"
                + "----------------------------------------------\n" + "Resources required to take charge of the sub-task: \t" + "Player " + player.name() + " resources:\n"
                + cost + " pounds \t\t\t\t\t\t\t\t\t   " + " Money: " + player.getMoney() + " Pounds \n"
                + woodCost + " wood \t\t\t\t\t\t\t\t\t   " + "     Wood: " + player.getWoodAssets() + " Wood \n"
                + electricityCost + " electricity \t\t\t\t\t\t\t\t\t   " + " Electricity: " + player.getElectricityAssets() + " Electricity \n"
                + steelCost + " steel \t\t\t\t\t\t\t\t\t   " + "     Steel: " + player.getSteelAssets() + " Steel \n"
                + workforceCost + " workforce \t\t\t\t\t\t\t\t\t   " + " Workforce: " + player.getWorkforceAssets() + " Workforce \n"
                + sandCost + " sand \t\t\t\t\t\t\t\t\t   "  + "         Sand: " + player.getSandAssets() + " Sand \n"
                + timeCost + " Days  \t\t\t\t\t\t\t\t\t   " + "     Time: " + player.getTimeAssets() + " Days \n"
                + "(Yes/No)");
        state.state = DecisionState.COMPLETE;
        if (player.inputBool(state)) {
            if (!additional)
                player.excMoney(-1 * cost);
            player.excWood(-1 * woodCost);
            player.excElectricity(-1 * electricityCost);
            player.excWorkforce(-1 * workforceCost);
            player.excSteel(-1 * steelCost);
            player.excSand(-1 * sandCost);
            player.excTime(-1 * timeCost);
            purchase(player, square);
        }else
            purchase(GiveTask(player, square), square);
    }

    private Square mainTaskA(int pos) {
        String desc = "Congratulations on completing all the sub-tasks! \n" +
                "Now, it is time to assemble and build the complete water filtration system.";
        int cost = 2000;
        int woodCost = 30;
        int electricityCost = 100;
        int steelCost = 60;
        int workforceCost = 80;
        int sandCost = 80;
        int timeCost = 20;
        return new Tasks("complete water filtration system", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private Square mainTaskB(int pos) {
        String desc = "Congratulations on completing all the sub-tasks!\n" +
                "Now, it is time to assemble and build the complete water pump generator.";
        int cost = 2000;
        int woodCost = 0;
        int electricityCost = 150;
        int steelCost = 100;
        int workforceCost = 80;
        int sandCost = 0;
        int timeCost = 20;
        return new Tasks("complete water pump generator", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private Square mainTaskC(int pos) {
        String desc = "Congratulations on completing all the sub-tasks!\n" +
                "Now, it is time to deploy the complete software sustainable system.";
        int cost = 2000;
        int woodCost = 0;
        int electricityCost = 150;
        int steelCost = 0;
        int workforceCost = 40;
        int sandCost = 0;
        int timeCost = 20;
        return new Tasks("complete software sustainable system to track water ", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private Square finishGame(int pos) {
        String desc = ".";
        int cost = 0;
        int woodCost = 0;
        int electricityCost = 0;
        int steelCost = 0;
        int workforceCost = 0;
        int sandCost = 0;
        int timeCost = 0;
        return new Tasks("Finish Game", pos, cost, woodCost, electricityCost, steelCost, workforceCost, sandCost, timeCost, desc);
    }

    private void completeGame(Player player, Square finishGame) {
        boolean finishGame1 = false;

        Iterable<Square> owned = player.tasks();

        String[] taskNames = {
                "complete software sustainable system to track water ",
                "complete water pump generator",
                "complete water filtration system"
        };

        int matchingCount = 0;

        for (Square task : owned) {
            for (String name : taskNames) {
                if (task.name().equals(name)) {
                    matchingCount++;
                    break;
                }
            }
        }

        if (matchingCount == taskNames.length) {
            finishGame1 = true;
        }


        if (!finishGame1) {
            System.out.println("You have not yet possessed all main tasks to complete the game");
            return;
        }

        boolean action = false;
        System.out.println(player.name() + ", You have completed all the main tasks, would you like to complete and finish the game?");
        state.state = DecisionState.COMPLETE;
        if (player.inputBool(state)) {
            if (!action)
                setMainTaskCompleted(player, finishGame);
        }
    }

    private void completeMainTaskA(Player player, Square mainTaskA) {
        int cost = mainTaskA.cost();
        int woodCost = mainTaskA.woodCost();
        int electricityCost = mainTaskA.electricityCost();
        int workforceCost = mainTaskA.workforceCost();
        int steelCost = mainTaskA.steelCost();
        int sandCost = mainTaskA.sandCost();
        int timeCost = mainTaskA.timeCost();
        String desc = mainTaskA.desc();
        boolean subTaskA = false;

        Iterable<Square> owned = player.tasks();

        String[] taskNames = {
                "Make the Blueprint (sub-task to build the filter)",
                "Make Layer 1 (sub-task to build the filter)",
                "Make Layer 2 (sub-task to build the filter)",
                "Make Layer 3 (sub-task to build the filter)"
        };

        int matchingCount = 0;

        for (Square task : owned) {
            for (String name : taskNames) {
                if (task.name().equals(name)) {
                    matchingCount++;
                    break;
                }
            }
        }

        if (matchingCount == taskNames.length) {
            subTaskA = true;
        }


        if (!subTaskA) {
            System.out.println("You haven't completed all the subtasks to build the filter. ");
            return;
        }

        if (player.getMoney() < cost || player.getWoodAssets() <  woodCost || player.getElectricityAssets() < electricityCost || player.getSteelAssets() <  steelCost || player.getWorkforceAssets() < workforceCost || player.getSandAssets() < sandCost || player.getTimeAssets() < timeCost) {
            System.out.println("You do not have enough resources to complete the main task: " + mainTaskA.name());
            return;
        }

        boolean action = false;
        System.out.println(player.name() + ", " + desc + ". Would you like to complete the main task? \n" + "The main task : \n" + mainTaskA.name() + "\n" + "Resources required to complete the main task: \t" + "Player " + player.name() + " resources:\n"
                + cost + " pounds \t\t\t\t\t\t\t\t\t   " + " Money: " + player.getMoney() + " Pounds \n"
                + woodCost + " wood \t\t\t\t\t\t\t\t\t   " + "     Wood: " + player.getWoodAssets() + " Wood \n"
                + electricityCost + " electricity \t\t\t\t\t\t\t\t\t   " + " Electricity: " + player.getElectricityAssets() + " Electricity \n"
                + steelCost + " steel \t\t\t\t\t\t\t\t\t   " + "     Steel: " + player.getSteelAssets() + " Steel \n"
                + workforceCost + " workforce \t\t\t\t\t\t\t\t\t   " + " Workforce: " + player.getWorkforceAssets() + " Workforce \n"
                + sandCost + " sand \t\t\t\t\t\t\t\t\t   "  + "         Sand: " + player.getSandAssets() + " Sand \n"
                + timeCost + " Days  \t\t\t\t\t\t\t\t\t   " + "     Time: " + player.getTimeAssets() + " Days \n"
                + "(Yes/No)");
        state.state = DecisionState.COMPLETE;
        if (player.inputBool(state)) {
            if (!action)
                player.excMoney(-1 * cost);
            player.excWood(-1 * woodCost);
            player.excElectricity(-1 * electricityCost);
            player.excWorkforce(-1 * workforceCost);
            player.excSteel(-1 * steelCost);
            player.excSand(-1 * sandCost);
            player.excTime(-1 * timeCost);
            purchase(player, mainTaskA);
        }
    }

    private void completeMainTaskB(Player player, Square mainTaskB) {
        int cost = mainTaskB.cost();
        int woodCost = mainTaskB.woodCost();
        int electricityCost = mainTaskB.electricityCost();
        int workforceCost = mainTaskB.workforceCost();
        int steelCost = mainTaskB.steelCost();
        int sandCost = mainTaskB.sandCost();
        int timeCost = mainTaskB.timeCost();
        String desc = mainTaskB.desc();
        boolean subTaskB = false;

        Iterable<Square> owned = player.tasks();

        String[] taskNames = {
                "Build the turbine (sub-task to build the water pump generator)",
                "Build the generator engine (sub-task to build the water pump generator)",
                "Build the pipe connection (sub-task to build the water pump generator)"
        };

        int matchingCount = 0;

        for (Square task : owned) {
            for (String name : taskNames) {
                if (task.name().equals(name)) {
                    matchingCount++;
                    break;
                }
            }
        }

        if (matchingCount == taskNames.length) {
            subTaskB = true;
        }


        if (!subTaskB) {
            System.out.println("You haven't completed all the subtasks to build the filter pump generator ");
            return;
        }

        if (player.getMoney() < cost || player.getWoodAssets() <  woodCost || player.getElectricityAssets() < electricityCost || player.getSteelAssets() <  steelCost || player.getWorkforceAssets() < workforceCost || player.getSandAssets() < sandCost || player.getTimeAssets() < timeCost) {
            System.out.println("You do not have enough resources to complete the main task: " + mainTaskB.name());
            return;
        }

        boolean additional = false;
        System.out.println(player.name() + ", " + desc + ". Would you like to complete the main task? \n" + "The main task : \n" + mainTaskB.name() + "\n" + "Resources required to complete the main task: \t" + "Player " + player.name() + " resources:\n"
                + cost + " pounds \t\t\t\t\t\t\t\t\t   " + " Money: " + player.getMoney() + " Pounds \n"
                + woodCost + " wood \t\t\t\t\t\t\t\t\t   " + "     Wood: " + player.getWoodAssets() + " Wood \n"
                + electricityCost + " electricity \t\t\t\t\t\t\t\t\t   " + " Electricity: " + player.getElectricityAssets() + " Electricity \n"
                + steelCost + " steel \t\t\t\t\t\t\t\t\t   " + "     Steel: " + player.getSteelAssets() + " Steel \n"
                + workforceCost + " workforce \t\t\t\t\t\t\t\t\t   " + " Workforce: " + player.getWorkforceAssets() + " Workforce \n"
                + sandCost + " sand \t\t\t\t\t\t\t\t\t   "  + "         Sand: " + player.getSandAssets() + " Sand \n"
                + timeCost + " Days  \t\t\t\t\t\t\t\t\t   " + "     Time: " + player.getTimeAssets() + " Days \n"
                + "(Yes/No)");
        state.state = DecisionState.COMPLETE;
        if (player.inputBool(state)) {
            if (!additional)
                player.excMoney(-1 * cost);
            player.excWood(-1 * woodCost);
            player.excElectricity(-1 * electricityCost);
            player.excWorkforce(-1 * workforceCost);
            player.excSteel(-1 * steelCost);
            player.excSand(-1 * sandCost);
            player.excTime(-1 * timeCost);
            purchase(player, mainTaskB);
        }
    }

    private void completeMainTaskC(Player player, Square mainTaskC) {
        int cost = mainTaskC.cost();
        int woodCost = mainTaskC.woodCost();
        int electricityCost = mainTaskC.electricityCost();
        int workforceCost = mainTaskC.workforceCost();
        int steelCost = mainTaskC.steelCost();
        int sandCost = mainTaskC.sandCost();
        int timeCost = mainTaskC.timeCost();
        boolean subTaskC = false;
        String desc = mainTaskC.desc();

        Iterable<Square> owned = player.tasks();

        String[] taskNames = {
                "Create Software Development Plan Cycle (sub-task to create Software Sustainable System)",
                "Developing code (sub-task to create Software Sustainable System)",
                "Education of Software Sustain System (sub-task to create Software Sustainable System)"
        };

        int matchingCount = 0;


        for (Square task : owned) {
            for (String name : taskNames) {
                if (task.name().equals(name)) {
                    matchingCount++;
                    break;
                }
            }
        }


        if (matchingCount == taskNames.length) {
            subTaskC = true;
        }


        if (!subTaskC) {
            System.out.println("You haven't completed all the subtasks to build software sustainable system. ");
            return;
        }

        if (player.getMoney() < cost || player.getWoodAssets() <  woodCost || player.getElectricityAssets() < electricityCost || player.getSteelAssets() <  steelCost || player.getWorkforceAssets() < workforceCost || player.getSandAssets() < sandCost || player.getTimeAssets() < timeCost) {
            System.out.println("You do not have enough resources to complete the main task: " + mainTaskC.name());
            return;
        }

        boolean action = false;
        System.out.println(player.name() + ", " + desc + ". Would you like to complete the main task? \n" + "The main task : \n" + mainTaskC.name() + "\n" + "Resources required to complete the main task: \t" + "Player " + player.name() + " resources:\n"
                + cost + " pounds \t\t\t\t\t\t\t\t\t   " + " Money: " + player.getMoney() + " Pounds \n"
                + woodCost + " wood \t\t\t\t\t\t\t\t\t   " + "     Wood: " + player.getWoodAssets() + " Wood \n"
                + electricityCost + " electricity \t\t\t\t\t\t\t\t\t   " + " Electricity: " + player.getElectricityAssets() + " Electricity \n"
                + steelCost + " steel \t\t\t\t\t\t\t\t\t   " + "     Steel: " + player.getSteelAssets() + " Steel \n"
                + workforceCost + " workforce \t\t\t\t\t\t\t\t\t   " + " Workforce: " + player.getWorkforceAssets() + " Workforce \n"
                + sandCost + " sand \t\t\t\t\t\t\t\t\t   "  + "         Sand: " + player.getSandAssets() + " Sand \n"
                + timeCost + " days  \t\t\t\t\t\t\t\t\t   " + "     Time: " + player.getTimeAssets() + " days \n"
                + "(Yes/No)");
        state.state = DecisionState.COMPLETE;
        if (player.inputBool(state)) {
            if (!action)
                player.excMoney(-1 * cost);
            player.excWood(-1 * woodCost);
            player.excElectricity(-1 * electricityCost);
            player.excWorkforce(-1 * workforceCost);
            player.excSteel(-1 * steelCost);
            player.excSand(-1 * sandCost);
            player.excTime(-1 * timeCost);
            purchase(player, mainTaskC);
        }
    }

    private void checkSquare(Player player, Square sq, int roll) {
        boolean owned = sq.isOwned();
        boolean ownable = sq.isOwnable();
        boolean resources = sq.isResources();
        boolean disaster = sq.isDisaster();
        if (!owned && ownable)
            tasks(player, sq);
        else if (ownable)
            taskowned(player, sq, roll);
        else if (resources)
            resources(player, sq);
        else if(disaster)
            disaster(player, sq);
    }

    private void resources(Player player, Square square) {
        int cost = square.cost();
        int woodCost = square.woodCost();
        int electricityCost = square.electricityCost();
        int workforceCost = square.workforceCost();
        int steelCost = square.steelCost();
        int sandCost = square.sandCost();
        int timeCost = square.timeCost();
        String desc = square.desc();

        if (player.getMoney() < cost || player.getTimeAssets() < timeCost) {
            System.out.println("You do not have enough money and/or time to harvest resources. " + square.name());
            return;
        }

        boolean action = false;
        System.out.println(player.name() + ", " + "You are now in position: " + player.position() + " and landed on...\n" + desc
                + "\nIt will require " + timeCost + " time unit and " + cost + " pounds\n"
                + "---------------------------------\n"
                + "Player " + player.name() + " resources:\n"
                + "Money: " + player.getMoney() + " pounds\n"
                + "Wood: " + player.getWoodAssets() + " Wood\n"
                + "Electricity: " + player.getElectricityAssets() + " Electricity\n"
                + "Steel: " + player.getSteelAssets() + " Steel\n"
                + "Workforce: " + player.getWorkforceAssets() + " Workforce\n"
                + "Sand: " + player.getSandAssets() + " Sand\n"
                + "Time: " + player.getTimeAssets() + " days\n"
                + "(Yes/No)?");
        state.state = DecisionState.COMPLETE;
        if (player.inputBool(state)) {
            if (!action)
                player.excWood(woodCost);
            player.excElectricity(electricityCost);
            player.excWorkforce(workforceCost);
            player.excSteel(steelCost);
            player.excSand(sandCost);
            player.excMoney(-1 * cost);
            player.excTime(-1 * timeCost);
            purchase(player, square);
        }
    }

    private void disaster(Player player, Square square) {
        int cost = square.cost();
        int woodCost = square.woodCost();
        int electricityCost = square.electricityCost();
        int workforceCost = square.workforceCost();
        int steelCost = square.steelCost();
        int sandCost = square.sandCost();
        int timeCost = square.timeCost();
        String desc = square.desc();

        System.out.println(player.name() + ", " + "You are now in position: " + player.position() + " and landed on...\n" + desc);
        player.excWood(-1 * woodCost);
        player.excElectricity(-1 * electricityCost);
        player.excWorkforce(-1 * workforceCost);
        player.excSteel(-1 * steelCost);
        player.excSand(-1 * sandCost);
        player.excMoney(-1 * cost);
        player.excTime(-1 * timeCost);
        purchase(player, square);
    }

    private void purchase(Player player, Square square) {
        if (player == null || square == null) return;

        if (!square.isOwnable()) return;

        player.addTask(square);
        square.purchase(player);
    }

    private void setMainTaskCompleted(Player player, Square square) {
        if (player == null || square == null) return;

        if (!square.isOwnable()) return;

        player.addMainTask(square);
        square.setMainTaskcomplete(player);
    }

    private Player GiveTask(Player player, Square square) {
        System.out.println("Assigning " + square.name() + "to someone else.");
        int cost = square.cost();
        int woodCost = square.woodCost();
        int electricityCost = square.electricityCost();
        int workforceCost = square.workforceCost();
        int steelCost = square.steelCost();
        int sandCost = square.sandCost();
        int timeCost = square.timeCost();


        Player newPlayer = null;
        while (true) {
            System.out.println("Would anyone like to take the task? (Yes/No) ");
            state.state = DecisionState.TAKE_TASK;
            if (!player.inputBool(state))
                break;

            System.out.println("Please enter player name"); //TODO has to be changed for CPU
            newPlayer = player.inputPlayer(state, player);
            state.state = DecisionState.COMPLETE;
            if (newPlayer.getMoney() < cost || newPlayer.getWoodAssets()<  woodCost || + newPlayer.getElectricityAssets() < electricityCost || newPlayer.getSteelAssets() <  steelCost || newPlayer.getWorkforceAssets() < workforceCost || newPlayer.getSandAssets() < sandCost || newPlayer.getTimeAssets() < timeCost) {
                System.out.println("resources are not enough to fulfill task");
                continue;
            }
            break;
        }

        if (newPlayer != null) {
            newPlayer.excMoney(-1 * cost);
            newPlayer.excWood(-1 * woodCost);
            newPlayer.excElectricity(-1 * electricityCost);
            newPlayer.excSteel(-1 * steelCost);
            newPlayer.excWorkforce(-1 * workforceCost);
            newPlayer.excSand(-1 * sandCost);
            System.out.println(newPlayer.name() + " has taken the task");
        }else
            System.out.println("No player wants the task");
        return newPlayer;
    }

    private void taskowned(Player player, Square square, int val) {
        Player owner = square.owner();
        if (!player.name().equals(owner.name()))
            System.out.println("You have landed on " + square.name() + ", which the task already taken");
    }


    private Square squareSelect(Player player) {
        return TaskSelect(player.tasks(), player);
    }

    private Square TaskSelect(Iterable<Square> tasks, Player player) {
        if (tasks == null || !tasks.iterator().hasNext()) {
            System.out.println("You don't own any tasks");
            return null;
        } else {
            System.out.println("You have the following tasks:");
            int counter = 1;
            for (Square sq : tasks) {
                System.out.println(counter++ + ") " + sq.name());
            }

            while (true) {
                System.out.println("Please select a task (input 0 to cancel if you do not own any tasks):");
                int TaskNum = player.inputInt(state);
                int TaskState = 1;

                if (TaskNum == 0) {
                    System.out.println("Trade canceled.");
                    return null;
                }

                for (Square sq : tasks) {
                    if (TaskState++ == TaskNum) {
                        return sq;
                    }
                }

                System.out.println("Selection not valid, please retry.");
            }
        }
    }

    private void TradeTask(Player player) {
        System.out.println(player.name() + ", with which player would you like to give/trade? (input a player's name)");
        state.state = DecisionState.TRADE;
        Player other = player.inputPlayer(state, player);


        System.out.println("Would you like to transfer your task? (Yes/No)");
        state.state = DecisionState.GIVE_TASKS;
        while (player.inputBool(state)) {
            Square sq = squareSelect(player);
            if (sq != null) {
                sq.purchase(other);
                player.giveTask(sq);
                other.addTask(sq);
                System.out.println("Any more tasks to give? (Yes/No)");
            } else {
                System.out.println("No more tasks to give.");
                break;
            }
        }

        System.out.println("Would " + other.name() + " like to hand out their tasks? (Yes/No)");
        state.state = DecisionState.GET_TASKS;
        while (player.inputBool(state)) {
            Square sq = squareSelect(other);
            if (sq != null) {
                sq.purchase(player);
                other.giveTask(sq);
                player.addTask(sq);
                System.out.println("Any more tasks to give? (Yes/No)");
            } else {
                System.out.println("No more tasks to give.");
                break;
            }
        }
    }

    private void playerInfo() {
        int counter = 1;
        for (Player player : state.players) {
            System.out.println("--------------------------------------------------");
            System.out.println("Player " + counter++);
            System.out.printf("%-10s%40s%n", "Name", player.name());
            System.out.printf("%-10s%40s%n", "Money", player.getMoney());
            System.out.printf("%-10s%40s%n", "Wood", player.getWoodAssets());
            System.out.printf("%-10s%40s%n", "Sand", player.getSandAssets());
            System.out.printf("%-10s%40s%n", "Electricity", player.getElectricityAssets());
            System.out.printf("%-10s%40s%n", "Steel", player.getSteelAssets());
            System.out.printf("%-10s%40s%n", "Workforce", player.getWorkforceAssets());
            System.out.printf("%-10s%40s%n", "Time", player.getTimeAssets());
            System.out.printf("%-10s%40s%n", "Position", player.position());
            System.out.printf("%-10s", "Tasks completed: \n");
            Iterable<Square> owned = player.tasks();

            boolean first = true;
            for (Square s : owned) {
                if (first)
                    System.out.printf("%40s%n", s);
                else
                    System.out.printf("%50s%n", s);
                first = false;
            }

            if (first)
                System.out.printf("%40s%n", "none");
            System.out.println("--------------------------------------------------");
        }
    }
}