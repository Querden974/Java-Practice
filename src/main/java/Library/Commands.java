package Library;

public enum Commands {
    QUIT("quit"),
    ADD("add"),
    GET("get"),
    EDIT("edit"),
    CLEAR("clear"),
    DELETE("delete"),
    LIST("list"),
    CREATE("create"),
    REMOVE("remove"),
    SELECT("select"),
    IDLE("idle");

    private final String action;

    Commands(String action){
        this.action = action;
    }

    public String getAction(){

        return this.action;
    }
}
