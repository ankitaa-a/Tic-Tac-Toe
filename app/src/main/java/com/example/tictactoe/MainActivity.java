package com.example.tictactoe;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameactive = true;
    //0 - x , 1 - o
/* game state:
0 - x , 1 - o , 2 - null
 */


    int activeplayer = 0;
    int[] gamestate={2,2,2,2,2,2,2,2,2};
    int[][] winpositions ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void playatap(View view){
        ImageView img = (ImageView) view ;
        int tappedimg = Integer.parseInt(img.getTag().toString());
        if(!gameactive){
            gamereset(view);
        }
        if(gamestate[tappedimg]==2) {
            gamestate[tappedimg] = activeplayer;
            img.setTranslationY(-1000f);
            if (activeplayer == 0) {
                img.setImageResource(R.drawable.kindpng_46498);
                activeplayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's turn - Tap to PLay");
            } else {
                img.setImageResource(R.drawable.lettero);
                activeplayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's turn - Tap to PLay");


            }


            img.animate().translationYBy(1000f).setDuration(300);
        }

        for (int[] winpos:winpositions){
            if(gamestate[winpos[0]] == gamestate[winpos[1]]  && gamestate[winpos[1]] == gamestate[winpos[2]] && gamestate[winpos[0]] != 2 ){
                String winnerstr;
                gameactive = false;
                if(gamestate[winpos[0]] == 0){
                    winnerstr = "X has won!!! Touch to Continue";
                }
                else if(gamestate[winpos[0]]==1) {
                    winnerstr = "O has won!!! Touch to Continue";
                }
                else{
                    winnerstr = "Its a Draw... Touch to Continue";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winnerstr);
            }
            /*else{
                int c=0;
                /*if(c==9 && (gamestate[winpos[0]] != gamestate[winpos[1]]  || gamestate[winpos[1]] != gamestate[winpos[2]]) ){
                    gameactive= false;
                    TextView status = findViewById(R.id.status);
                    status.setText("Its a Draw");

                }
                for(int i=0;i<9;i++){
                    if(gamestate[i]!=2){
                        c++;
                    }
                }
                if(c==9) {
                    gameactive = false;
                    TextView status = findViewById(R.id.status);
                    status.setText("draw");

                }
            }*/




        }

        int c=0;
        for(int i=0;i<9;i++){
            if(gamestate[i]!=2){
                c++;
            }
        }
        if(c==9){
            gameactive= false;
            TextView status = findViewById(R.id.status);
            status.setText("Its a Draw");

        }


    }
    public void gamereset(View view){
        gameactive = true;
        activeplayer = 0;
        for(int i=0; i< gamestate.length ; i++){
            gamestate[i]=2;

        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap to Play");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}