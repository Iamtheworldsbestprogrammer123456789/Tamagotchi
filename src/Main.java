import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    static int try_catch_int() {

        int tal = 0;
        while (true) {
            try {
                tal = scan.nextInt();
                //om inputen är mottagbar så sparas den och sedan breakar den ut ur while loopen
                break;
            } catch (Exception e) {
                //om det inte är en acceptabel input printas det och while loopen börjar om
                System.out.print("Ange en siffra!\n: ");
                scan.nextLine();
            }
        }
        return tal;
    }

    static int val() {
        int val;
        System.out.print("\nVal: ");
        val = try_catch_int();
        return val;
    }

    public static void main(String[] args) {
        System.out.println("Hello and welcome to the tamagotchi game!");
        System.out.println("Your task is to take care of your tamagotchi.");
        System.out.println("You will need to feed it and and entertain it or it will die.");
        System.out.println("Press enter to continue...");
        scan.nextLine();
        System.out.println("Please name your tamagotchi.");
        System.out.print("Name: ");
        String name = scan.nextLine();
        Tamagotchi tamagotchi = new Tamagotchi(name);
        boolean fortsätt = true;
        while (fortsätt) {
            System.out.println("Stats:");
            tamagotchi.printStats();
            if (tamagotchi.getAlive() == false) {
                fortsätt = false;
                break;
            }

            if (fortsätt) {
                System.out.println("___________________________________________________________________");
                System.out.println("1. Lärd " + tamagotchi.name + " ett ord.");
                System.out.println("2. Mata " + tamagotchi.name);
                System.out.println("3. Hälsa på" + tamagotchi.name + ". Den kommer säga något av orden du lärt den tillbaka.");
                System.out.println("4. Gör ingenting");
                System.out.println("5. Avsluta spelet");
                System.out.println("___________________________________________________________________");
            }
            switch (val()) {
                case 1:
                    tamagotchi.Teach();
                    tamagotchi.Tick();
                    break;
                case 2:
                    tamagotchi.Feed();
                    tamagotchi.Tick();
                    break;
                case 3:
                    tamagotchi.Hi();
                    tamagotchi.Tick();
                    break;
                case 4:
                    tamagotchi.Tick();
                    break;
                case 5:
                    fortsätt = false;
                    System.out.println("Hejdå!");
                    break;
                default:
                    System.out.println("Fel svar!\nDitt svar måste vara mellan 1-5");
                    break;
            }
        }
    }
}