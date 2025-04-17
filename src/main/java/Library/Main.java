package Library;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library("Manga Collection");

        library.welcomeMessage();

        Scanner input = new Scanner(System.in);

        Actions action = new Actions();

        while(action.getAction() != Commands.QUIT){

            System.out.print("Which action you want to proceed? -> ");
            action.setAction(input.nextLine());
            System.out.println("_".repeat(24));
            action.doAction(library);


        }

        input.close();
    }
}