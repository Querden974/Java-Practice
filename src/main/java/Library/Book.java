package Library;

public class Book {
    private String name;
    private int volumes;

    Book(String name, int numPages){
        this.name = name;
        this.volumes = numPages;
    }

    @Override
    public String toString(){
        return this.name + "|" + this.volumes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolumes() {
        return volumes;
    }

    public void setVolumes(int volumes) {
        this.volumes = volumes;
    }

    public void getInfo(){
        String symbol = "═";
        String info = this.name + "  ║ " + this.volumes + " pages" ;
        String decorator = symbol.repeat(info.length() + 2);
        String decoratorsTop = "╔"+ decorator +"╗";
        String decoratorsBot = "╚"+ decorator +"╝";
        System.out.printf("""
                %s
                ║ %s ║
                %s
                
                """, decoratorsTop, info, decoratorsBot);

    }
}