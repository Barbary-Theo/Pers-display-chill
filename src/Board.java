import Draw.Cloud;
import Draw.Drawable;

public class Board {
    //Singleton
    public static Board board;
    public static String[][] gameBoard;

    private Board() {
        gameBoard = new String[20][80];
        for ( int i = 0 ; i < gameBoard.length ; i++ ) {
            for (int j = 0; j < gameBoard[i].length; j++) {

                gameBoard[i][j] = " ";

            }
        }

    }

    public static Board getInstance() {
        if (board == null) board = new Board();
        return board;
    }


    public void addDrawable(Drawable drawable) {

        var composition = drawable.getComposition();

        for ( int i = 0 ; i < composition.length ; i++ ) {
            for (int j = 0; j < composition[i].length; j++) {

                gameBoard[i + drawable.getY()][j + drawable.getX()] = composition[i][j];

            }
        }


    }

    public void draw(){

        for (String[] strings : gameBoard) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }

    }


    public static void main(String[] args) throws InterruptedException {

        Board board = Board.getInstance();
        Cloud cloudNorth = new Cloud(0, 0);
        Cloud cloudSouth = new Cloud(15, 2);
        Cloud cloudWest = new Cloud(45, 0);

        board.addDrawable(cloudNorth);
        board.addDrawable(cloudSouth);
        board.addDrawable(cloudWest);
        board.draw();

        while (true) {
            cloudNorth.raining();
            cloudSouth.raining();
            cloudWest.raining();

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            board.addDrawable(cloudNorth);
            board.addDrawable(cloudSouth);
            board.addDrawable(cloudWest);
            board.draw();

            Thread.sleep(100);

        }


    }

}
