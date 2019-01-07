package my.examples.miniwebserver.Cat;

public class CatServerMain {
    public static void main(String[] args) {
        CatServer catServer = new CatServer(9999);
        catServer.run();
    }
}
