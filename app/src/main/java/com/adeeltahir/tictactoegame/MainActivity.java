package com.adeeltahir.tictactoegame;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
boolean gameactive =true;
    String winnerstr;
    int activeplayer =0;
    int [] gamestate ={2,2,2,2,2,2,2,2,2};
    int [][] winningpositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
public void tap(View view){
    ImageView img =(ImageView) view;
int tappedimage =Integer.parseInt(img.getTag().toString());
if(!gameactive){
    gameReset(view);
}
if(gamestate[tappedimage]==2&& gameactive){
    gamestate[tappedimage]=activeplayer;
    img.setTranslationY(-1000f);
    if(activeplayer==0){
        activeplayer = 1;
        img.setImageResource(R.drawable.x);
        TextView status = findViewById(R.id.status);
        status.setText("O's turn tap to play ");
    }
    else if(activeplayer ==1){
        img.setImageResource(R.drawable.zero);
        activeplayer =0;
        TextView status = findViewById(R.id.status);
        status.setText("X's turn tap to play ");
    }
    img.animate().translationYBy(1000f);
    }

for(int [] winposition:winningpositions){
    if(gamestate[winposition[0]]==gamestate[winposition[1]]&&gamestate[winposition[1]]==gamestate[winposition[2]]&&gamestate[winposition[0]]!=2){
        gameactive=false;
        if(gamestate[winposition[0]]==0){
winnerstr="X has won";

        }
        else if(gamestate[winposition[0]]==1){
winnerstr="O has won";
        }
        TextView status = findViewById(R.id.status);
        status.setText(winnerstr);
    }

}
}

public void gameReset(View view){
    gameactive =true;
    activeplayer=0;
    for(int i=0 ;i<gamestate.length;i++){
        gamestate[i]=2;
    }
    ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView11)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView12)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView13)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView14)).setImageResource(0);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}