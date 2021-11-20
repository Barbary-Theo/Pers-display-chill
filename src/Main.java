import Draw.Cloud;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        System.out.println();
        Cloud cloud = new Cloud(0, 0);
        cloud.draw();

        while (true) {
            cloud.raining();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            cloud.draw();

            Thread.sleep(100);
        }


    }

}
