package AquaHarmony;

interface Player {

    void addTask(Square square);

    void addMainTask(Square square);

    void move(int numSpaces);

    int position();

    Iterable<Square> tasks();

    String name();

    int getMoney();


    void excMoney(int money);

    void excWood(int wood);

    void excElectricity(int electricity);

    void excSteel(int steel);

    void excWorkforce(int workforce);

    void giveTask(Square sq);

    void excSand(int sand);

    void excTime(int time);


    int getWoodAssets();

    int getElectricityAssets();

    int getSteelAssets();

    int getWorkforceAssets();

    int getSandAssets();

    int getTimeAssets();

    /* Input stuff */
    boolean inputBool(Main.State state);

    int inputInt(Main.State state);

    int inputDecision(Main.State state, String[] choices);

    Player inputPlayer(Main.State state, Player notAllowed);
}
