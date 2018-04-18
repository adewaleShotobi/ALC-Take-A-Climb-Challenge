package ng.com.adewaleshotobi.tictactoe;

import android.widget.Button;

import java.util.Random;

/**
 * Created by Adewale on 4/11/2018.
 * @version 1.0
 * @author Adewale Shotobi
 */

public class Utilities {

    /**
     *
     * @param button is set to enabled and text set to "X"
     */
    public static void setBtnToX(Button button){
        button.setText("X");
        button.setEnabled(false);
    }

    /**
     *
     * @param button is set to enabled and text set to "O"
     */
    public static void setBtnToO(Button button){
        button.setText("O");
        button.setEnabled(false);
    }

    /**
     *
     * @param turns
     * @param gameButtons
     * @param bounds
     */
    public static void RandomClick(int turns, Button[][] gameButtons,int bounds){
        Random random = new Random();
        Button btn = gameButtons[random.nextInt(bounds)][random.nextInt(bounds)];
        if (turns < 1){
            return;
        }
        if (btn.isEnabled()){
            Utilities.setBtnToO(btn);
            return;
        }else {
            turns--;
            RandomClick(turns,gameButtons,bounds);
        }
    }

    public static boolean isGameOver(int rounds){
        if (rounds > 3) {
            return true;
        }
        else{
            return false;
        }
    }
}
