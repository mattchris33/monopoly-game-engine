package AquaHarmony;

public class Resources implements Square {
    private final int woodValue;

    private final int electricityValue;

    private final int steelValue;

    private final int workforceValue;

    private final int sandValue;

    private final int timeValue;

    private final int value;

    private final int pos;

    private final String name;

    private final String desc;

    public Resources(String name, int pos, int value, int woodValue, int electricityValue, int steelValue, int workforceValue, int sandValue, int timeValue, String desc) {
        this.woodValue = woodValue;
        this.electricityValue = electricityValue;
        this.steelValue = steelValue;
        this.workforceValue = workforceValue;
        this.sandValue = sandValue;
        this.timeValue = timeValue;
        this.value = value;

        this.pos = pos;
        this.name = name;
        this.desc = desc;
    }

    public int cost() {
        return value;
    }

    public void purchase(Player player) {
    }


    public void setMainTaskcomplete(Player player) {
    }

    @Override
    public boolean isDisaster() {
        return false;
    }

    @Override
    public boolean isResources() {
        return true;
    }

    public int timeCost(){
        return timeValue;
    }

    public Player owner() {
        return null;
    }
    public boolean isOwned() {
        return false;
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

    public void checkIfAwin(Player player) {
    }

    public void checkIfBwin(Player player) {
    }

    public void checkIfCwin(Player player) {
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
        return false;
    }
}

