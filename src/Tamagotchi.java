import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tamagotchi {
    private int hunger = 10;
    private int boredom = 10;
    private ArrayList<String> words = new ArrayList<String>();
    private boolean isAlive = true;
    private Random generator = new Random();
    public String name;
    Scanner scan = new Scanner(System.in);

    public Tamagotchi(String name) {
        this.name = name;
    }

    public void Tick() {
        hunger -= 1;
        boredom -= 1;
    }

    public void Feed() {
        hunger += 2;
    }

    public void Hi() {
        int rand = generator.nextInt(words.size());
        System.out.println(words.get(rand));
    }

    public void Teach() {
        System.out.print("Ord: ");
        String newWord = scan.nextLine();
        System.out.println("Nu har din tamagotchi lärt sig ordet.");
        words.add(newWord);
    }

    public void printStats() {
        if (this.hunger <= 0 || this.boredom <= 0) {
            isAlive = false;
            System.out.println(name + " is dead.");
        } else {
            System.out.println("Hunger: " + this.hunger);
            System.out.println("Boredome: " + this.boredom);
        }
    }

    public boolean getAlive() {
        return this.isAlive;
    }

    private void ReduceBoredom() {
        boredom += 2;
    }
}
