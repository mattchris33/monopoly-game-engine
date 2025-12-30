package AquaHarmony;

public class Tasks implements Square {

    private final int value;

    private int woodValue;

    private int electricityValue;

    private int steelValue;

    private int workforceValue;

    private int sandValue;

    private final int timeValue;

    private int pos;
    private String name;

    private String desc;
    private boolean owned;

    boolean mainTaskCompleted;

    private Player owner;

    public Tasks(String name, int pos, int value, int woodValue, int electricityValue, int steelValue, int workforceValue, int sandValue, int timeValue, String desc) {
        this.value = value;
        this.woodValue = woodValue;
        this.electricityValue = electricityValue;
        this.steelValue = steelValue;
        this.workforceValue = workforceValue;
        this.sandValue = sandValue;
        this.timeValue = timeValue;
        owned = false;
        mainTaskCompleted = false;

        this.pos = pos;
        this.name = name;
        this.desc = desc;
    }

    public int position() {
        return pos;
    }

    public String name() {
        return name;
    }

    public String desc(){
        return desc;
    }

    public boolean isOwnable() {
        return true;
    }

    public void purchase(Player player) {
        owned = true;
        owner = player;

        checkLost(player);
        checkWin(player);
    }

    public void setMainTaskcomplete(Player player) {
        owned = true;
        owner = player;
        mainTaskCompleted = true;

        checkWin(player);
    }

    private void checkLost(Player player){
        if(player.getTimeAssets() <= 5 || player.getMoney() <= 200 || player.getSandAssets() <= 20 || player.getWorkforceAssets() <= 20 || player.getWoodAssets() <= 20 || player.getElectricityAssets() <= 20 || player.getTimeAssets() <= 5 || player.getSteelAssets() <= 20){
            System.out.println("----------------------------------------");
            System.out.print("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
            System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
            System.out.println();
            System.out.println();
            System.out.println(
                            "╔══════════════════════════════════════════╗\n" +
                            "║                                          ║\n" +
                            "║                  Lost!                   ║\n" +
                            "║                                          ║\n" +
                            "║                                          ║\n" +
                            "╚══════════════════════════════════════════╝\n");
            System.out.println("GAME OVER!! IT SEEMS THAT PLAYER " + player.name() + " HAS FAILED. ALL BECAUSE SHE/HE DOES NOT HAVE ANY RESOURCES/TIME LEFT TO CONTRIBUTE! \nKNOWING THAT THE TEAM DID NOT WORK WELL ENOUGH TO BUILD SUSTAINABLE CLEAN WATER, THE PEOPLE OF PU NGAOL WILL CONTINUE TO USE UNHYGIENIC WATER FOR DAILY USE. \nLET THIS BE A REMINDER FOR ALL TO DO BETTER IN THE NEXT OPPORTUNITY");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("////////////////////////////////////////");
            System.out.println("----------------------------------------");
            System.exit(0);
        }
    }

    private void checkWin(Player player){
        if(mainTaskCompleted){
            System.out.println("----------------------------------------");
            System.out.print("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
            System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
            System.out.println();
            System.out.println();
            System.out.println(
                            "╔══════════════════════════════════════════╗\n" +
                            "║                                          ║\n" +
                            "║                  Win!                    ║\n" +
                            "║                                          ║\n" +
                            "║                                          ║\n" +
                            "╚══════════════════════════════════════════╝\n");
            System.out.println("CONGRATULATIONS!! THE ENTIRE TEAM HAS ACHIEVED VICTORY! WORKING TOGETHER, EACH PLAYER, HAS SUCCESSFULLY COMPLETED THEIR TASK. \nTHEIR COLLECTIVE EFFORTS HAVE RESULTED IN THE ESTABLISHMENT OF A SUSTAINABLE WATER SYSTEM FOR PU NGAOL. \nTHE COMMUNITY CAN NOW THRIVE WITH ACCESS TO CLEAN AND SAFE WATER THANKS TO YOUR TEAMWORK. \nWELL DONE, AND MAY THIS SUCCESS ENCOURAGE YOU TO TACKLE FUTURE CHALLENGES WITH THE SAME UNITY!");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("////////////////////////////////////////");
            System.out.println("----------------------------------------");
            System.exit(0);
        }
    }

    public boolean isOwned() {
        return owned;
    }

    public boolean isResources(){
        return false;
    }

    public boolean isDisaster(){
        return false;
    }

    public int cost() {
        return value;
    }

    public int woodCost(){
        return woodValue;
    }

    public int electricityCost(){
        return electricityValue;
    }

    public int steelCost(){
        return steelValue;
    }

    public int workforceCost(){
        return workforceValue;
    }

    public int sandCost(){
        return sandValue;
    }

    public int timeCost(){
        return timeValue;
    }

    public Player owner() {
        return owner;
    }

    public String toString() {
        return name;
    }
}

