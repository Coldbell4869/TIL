package my.examples.miniwebserver.Cat;

public class CatClientMain {
    public static void main(String[] args) {
        CatClient catClient = new CatClient("127.0.0.1", 9999);
        catClient.run();
    }
}
