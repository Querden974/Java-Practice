package Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Library {

    private final String name;
    private final ArrayList<Book> collection = new ArrayList<>();
    private int numberOfBooks = 0;

    Library(String name){
        this.name = name;
    }

    public void welcomeMessage(){
        String symbol = "═";
        String welcomeMessage = "WELCOME TO " + this.name.toUpperCase();
        String decorations = symbol.repeat(welcomeMessage.length() + 2);
        String decoratorsTop = "╔"+ decorations +"╗";
        String decoratorsBot = "╚"+ decorations +"╝";
        System.out.printf("""
                %s
                ║ %s ║
                %s
                """, decoratorsTop, welcomeMessage, decoratorsBot);
    }



    public void getList(){
        System.out.println(numberOfBooks + " Mangas in the collection");
        System.out.println(Arrays.toString(collection.toArray()));
    }

    //GET FUNCTIONS
    public void getBook(){
        System.out.print("Which manga are you looking for? ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        for(Book book : collection)
           if(book.getName().equals(name)){
               System.out.println();
              book.getInfo();
              return;
          }
      System.out.println("Manga not found!");
    }
    public void getBook(String name){
        for(Book book : collection)
            if(book.getName().equals(name)){
                System.out.println();
                book.getInfo();
                return;
            }
        System.out.println("Manga not found!");
    }

    public void addBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter the manga's name: ");
        String name = "";
        while(name.isBlank()){
            try{
                name = scanner.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Name type don't match");
                name = scanner.nextLine();
            }
        }


        System.out.print("How many volumes the manga have: ");
        int pages = 0;
        while(pages == 0){
            try{
                pages = scanner.nextInt();
                if (pages == 0 ) {
                    System.out.print("Volume amount must be grater than 0. Enter correct value: ");
                }
            }catch (InputMismatchException e){
                System.out.print("Volume amount type don't match. It must be an integer: ");
                scanner.nextLine();
                pages = scanner.nextInt();
                if (pages == 0 ) {
                    System.out.print("Volume amount must be grater than 0. Enter correct value: ");
                }
            }
        }

        collection.add(new Book(name, pages));
        System.out.printf(name + " was added to collection and it contains (%d volumes) \n\n",pages);
        this.numberOfBooks++;
        scanner.reset();
    }

    public void removeBook(){
        System.out.print("Which manga you want to delete? ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        for(Book book : collection)
            if(book.getName().equals(name)){
                System.out.println();
                collection.remove(book);
                this.numberOfBooks--;
                return;
            }
        System.out.println("Manga not found!");
    }
    public void removeBook(String name){
        for(Book book : collection)
            if(book.getName().equals(name)){
                System.out.println();
                collection.remove(book);
                this.numberOfBooks--;
                return;
            }
        System.out.println("Manga not found!");
    }

    public void editBook(){
        System.out.print("Which Manga you want to edit? ");
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        for(Book book : collection)
            if(book.getName().equals(name)){
                System.out.println();
                System.out.print("which element you want to edit? (name, volume, all): ");
                String choice = scanner.nextLine();
                switch(choice){
                    case "name" -> {
                        System.out.print("Enter the new book name: ");
                        book.setName(scanner.nextLine());
                        book.getInfo();
                    }
                    case "volume" ->{
                        System.out.print("Enter the new book volumes amount: ");
                        book.setVolumes(scanner.nextInt());
                        book.getInfo();
                    }
                    case "all" ->{
                        System.out.print("Enter the new book name: ");
                        book.setName(scanner.nextLine());
                        System.out.print("Enter the new book volumes amount: ");
                        book.setVolumes(scanner.nextInt());
                        book.getInfo();
                    }
                }
                return;
            }
        System.out.println("Manga not found!");
    }
}