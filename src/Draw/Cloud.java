package Draw;

/*
        "         _____----__      \n" +
        "   ____(             )    \n" +
        "  (                   )__ \n" +
        " (                       )\n" +
        "(_                      _)\n" +
        "   (_           _______)  \n" +
        "     (___________)        \n" +
        " |      |       |     |   \n" +
        "                          \n" +
        "     |    |               \n" +
        "               |     |    \n" +
        "    |     |               \n" +
        "     |           |        \n" +
        "|           |             \n"

 */

import Utils.ConsoleColors;

import java.util.Random;

public class Cloud extends Drawable {
    public static float speed = 1;

    public Cloud(int x, int y) {
        super(x, y);
        initCloud();
    }

    private void initCloud() {
        String[][] initComposition = new String[14][26];

        initComposition[0][14] = initComposition[0][15]  = initComposition[0][16]  = initComposition[0][17]
                = "-";

        initComposition[1][7] = initComposition[2][2]  = initComposition[3][1]  = initComposition[4][0]
                = initComposition[5][3] = initComposition[6][5] = "(";

        initComposition[1][21] = initComposition[2][22]  = initComposition[3][25]  = initComposition[4][25]
                = initComposition[5][23] = initComposition[6][17] = ")";

        initComposition[0][9] = initComposition[0][10]  = initComposition[0][11]  = initComposition[0][12]
                = initComposition[0][13] = initComposition[0][18] = initComposition[0][19] = initComposition[1][3]
                = initComposition[1][4] = initComposition[1][5] = initComposition[1][6] = initComposition[2][23]
                = initComposition[2][24] = initComposition[4][1] = initComposition[4][24] = initComposition[5][4]
                = initComposition[5][16] = initComposition[5][17] = initComposition[5][18] = initComposition[5][19]
                = initComposition[5][20] = initComposition[5][21] = initComposition[5][22] = initComposition[6][6]
                = initComposition[6][7] = initComposition[6][8] = initComposition[6][9] = initComposition[6][10]
                = initComposition[6][11] = initComposition[6][12] = initComposition[6][13] = initComposition[6][14]
                = initComposition[6][15] = initComposition[6][16] = "_";

        initComposition[7][1] = initComposition[7][8]  = initComposition[7][16]  = initComposition[7][22]
                = initComposition[9][5] = initComposition[9][10] = initComposition[10][15] = initComposition[10][21]
                = initComposition[11][4] = initComposition[11][10] = initComposition[12][5] = initComposition[12][17]
                = initComposition[13][0] = initComposition[13][12] = "|";

        for ( int i = 0 ; i < initComposition.length ; i++ ) {
            for ( int j = 0 ; j < initComposition[i].length ; j++ ) {

                if(initComposition[i][j] == null) {
                    initComposition[i][j] = " ";
                }

            }
        }

        this.composition = initComposition;
    }


    public void raining() {

        String[] oldRow;
        String[] actualRow = composition[6];
        String[] newRow;
        Random random = new Random();

        for ( int i = 6 ; i < composition.length ; i++ ) {

            // temps qu'on n'est pas à la dernière ligne
            if(i != 13) {
                oldRow = composition[i + 1];
                newRow = new String[composition[i].length];
                for (int j = 0; j < composition[i].length; j++) {

                    if(i == 6) {
                        // Si la proba est respectée + pas le première colonne et que la colone - 1 n'est pas déjà égale à "|"
                        if(random.nextFloat() >= 0.075 || (j != 0 && newRow[j - 1].equals("|"))) newRow[j] = " ";
                        else newRow[j] = "|";
                    }
                    else {
                        if (actualRow[j].equals("|")) newRow[j] = "|";
                        else newRow[j] = " ";
                    }

                }
                composition[i + 1] = newRow;
                actualRow = oldRow;
            }


        }

    }


    @Override
    public void draw() {



        for ( int i = 0 ; i < composition.length ; i++ ) {
            for (String string : composition[i]) {
                if(i >=7) System.out.print(ConsoleColors.BLUE + string);
                else System.out.print(ConsoleColors.WHITE + string);
            }
            System.out.println();
        }

    }

}
