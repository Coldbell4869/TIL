package my.examples.miniwebserver.Cat;

public class CatClientHandler extends Thread{
    private CatUser catUser;
    public CatClientHandler(CatUser catUser){
        this.catUser = catUser;
    }

    public void run(){
        while(true){
            String line = catUser.read();
            System.out.println(line);
        }
    }
}
