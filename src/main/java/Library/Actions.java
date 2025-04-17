package Library;



public class Actions {
    private Commands command;
    private String subCommand;


    public void setAction(String action){
        try {
            if(action.split(" ").length > 1){
                this.command = Commands.valueOf(action.split(" ")[0].toUpperCase());
                this.subCommand = action.split(" ")[1];
                System.out.println(subCommand);
                return;
            }else{
                this.command = Commands.valueOf(action.toUpperCase());
            }
        } catch (IllegalArgumentException e){
            System.out.println("Command not exists");
            this.command = null;
        }
    }

    public Commands getAction(){
        return this.command;
    }

    public void doAction(Library library){
        if(this.command == null) return;
        switch (this.command){
            case QUIT -> {
                System.out.println("EXIT APPLICATION");
                System.exit(0);
            }
            case ADD,CREATE ->library.addBook();

            case GET,SELECT -> {
                if (this.subCommand != null){
                    library.getBook(subCommand);
                } else {
                    library.getBook();
                }
            }
            case LIST -> library.getList();
            case EDIT -> library.editBook();
            case CLEAR -> {
                for(int i = 0; i<30;i++){
                    System.out.println();
                }
            }
            case DELETE,REMOVE -> {
                if (this.subCommand != null){
                    library.removeBook(subCommand);
                } else {
                    library.removeBook();
                }
            }
            default -> System.out.println("Select a valid command.");
        }
        this.command = null;
        this.subCommand = null;
    }

}
