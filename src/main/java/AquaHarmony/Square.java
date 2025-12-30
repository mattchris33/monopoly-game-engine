package AquaHarmony;

public interface Square {
    int position();

    String name();

    String desc();

    boolean isOwnable();

    boolean isOwned();

    int cost();

    int woodCost();

    int electricityCost();

    int steelCost();

    int workforceCost();

    int sandCost();

    int timeCost();

    void purchase(Player player);

    void setMainTaskcomplete(Player player);

    Player owner();


    String toString();

    boolean isResources();

    boolean isDisaster();

}
