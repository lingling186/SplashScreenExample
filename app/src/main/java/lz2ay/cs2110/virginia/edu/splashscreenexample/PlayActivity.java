package lz2ay.cs2110.virginia.edu.splashscreenexample;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;


public class PlayActivity extends ActionBarActivity {
    protected RelativeLayout layout;
    private ArrayList<Monster> monsters;
    private ImageView self;
    private int score;

    public void setup(){
        layout = (RelativeLayout) this.findViewById(R.id.relativelayout2);
        self   = (ImageView) this.findViewById(R.id.self);

        //create table
        createMonterTable();
        //use monsters list to set up table
//        TableLayout tableLayout = (TableLayout) findViewById(R.id.monster_table);
//        int row_num  = tableLayout.getChildCount();
//        for(int i = 0 ; i < row_num ; i++){
//            TableRow tablerow = (TableRow)tableLayout.getChildAt(i);
//            for(int j = 0 ; j < tablerow.getChildCount() ; j++) {
//                ImageView imagCell = (ImageView) tablerow.getChildAt(j);
//                imagCell.setImageDrawable(getResources().getDrawable(R.drawable.gengar));
//            }
//        }


        ArrayList<Monster> initial_monsters = new ArrayList<Monster>();
        Monster amonster = new Monster(initial_monsters.size(), 1);
//      set monster list
    }

    public void createMonterTable(){
        TableLayout table = (TableLayout) findViewById(R.id.monster_table);
        int mRows = 5;
        int mCols = 5;
        for (int i = 0; i < mRows; i++) {

            TableRow tr = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
            tr.setLayoutParams(lp);

            for (int j = 0; j < mCols; j++) {

                ImageView view = new ImageView(this);
                view.setImageResource(R.drawable.ivysaur);
                tr.addView(view);
            }
            table.addView(tr);
        }

    }


    public void setupMonsterTable(ArrayList<Monster> list, int level){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        setup();
    }

//    public void buttonClicked(View view){
//        ImageView image = (ImageView)this.findViewById(R.id.img);
//        image.setX(image.getX());
//        image.setY(image.getY() - 10);
//
//    }

    public void addScoreByKillGhost(Monster monster){
        score += monster.level;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class Monster{
        int id;
        int level;
        int health;
        ImageView img;

        public Monster(int last_id, int l){
            this.id = last_id + 1;
            this.level = l;
            this.health = l;
        }

        public int getLevel(){
            return level;
        }

        public int getId(){
            return id;
        }

        public ImageView getImageView(){
            return img;
        }

        public int getHealth(){
            return health;
        }

        public void setImageView(ImageView view){
            img = view;
        }

        public void setImgByLevel(){
            int l = this.level;

            switch (l) {
                case 1:
                    img.setImageDrawable(getResources().getDrawable(R.drawable.gengar));
                case 2:
                    img.setImageDrawable(getResources().getDrawable(R.drawable.surskit));
                case 3:
                    img.setImageDrawable(getResources().getDrawable(R.drawable.squirtle));
                default:
                    img.setImageDrawable(getResources().getDrawable(R.drawable.ivysaur));
            }
        }

        public void getHurt(int bulletVal){
            this.health -= bulletVal;
            if(health < 0 ){
                monsters.remove(this);
            }
        }


    }


}
