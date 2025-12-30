package AquaHarmony;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Players implements Player {
    private final Input input;
    private final Queue<Square> tasks;
    private final String playerName;
    private int money;

    private int time;

    private int wood;

    private int electricity;

    private int steel;

    private int workforce;

    private int sand;
    private int position;

    public Players(String playerName) {
        input = new Input();
        money = 15000;
        wood = 400;
        electricity = 400;
        steel = 400;
        workforce = 400;
        sand = 400;
        time = 180;
        tasks = new LinkedList<>();
        position = 0;
        this.playerName = playerName;
    }

    public void addTask(Square square) {
        tasks.add(square);
        square.purchase(this);
    }

    public void addMainTask(Square square) {
        tasks.add(square);
        square.setMainTaskcomplete(this);
    }

    public void move(int numSpaces) {
        position += numSpaces;
        int BOARD_SIZE = 40;
        if (position >= BOARD_SIZE) {
            position -= BOARD_SIZE;
            excMoney(200);
        }
    }

    public void moveTo(int pos) {
        position = pos;
    }

    public int position() {
        return position;
    }

    public Queue<Square> tasks() {
        return tasks.stream().collect(Collectors.toCollection(LinkedList::new));
    }

    public String name() {
        return playerName;
    }

    public int getMoney() {
        return money;
    }

    public void excMoney(int money) {
        this.money += money;
    }

    public void excWood(int wood){
        this.wood += wood;
    }

    public void excElectricity(int electricity){
        this.electricity += electricity;
    }

    public void excSteel(int steel){
        this.steel += steel;
    }

    public void excWorkforce(int workforce){
        this.workforce += workforce;
    }

    public void excSand(int sand){
        this.sand += sand;
    }

    public void excTime(int time){
        this.time += time;
    }


    public void giveTask(Square sq) {
        tasks.remove(sq);
    }


    public int getAssets() {
        return money;
    }
    public int getWoodAssets() {
        return wood;
    }

    public int getElectricityAssets() {
        return electricity;
    }

    public int getSteelAssets() {
        return steel;
    }

    public int getWorkforceAssets() {
        return workforce;
    }

    public int getSandAssets() {
        return sand;
    }

    public int getTimeAssets(){
        return time;
    }

    public boolean inputBool(Main.State state) {
        return input.inputBool();
    }

    public int inputInt(Main.State state) {
        return input.inputInt();
    }

    public int inputDecision(Main.State state, String[] choices) {
        return input.inputDecision(choices);
    }

    public Player inputPlayer(Main.State state, Player notAllowed) {
        return input.inputPlayer(state.players, notAllowed);
    }
}
