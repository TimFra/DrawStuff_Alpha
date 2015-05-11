package com.drawstuff.mah.drawstuff;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.drawstuff.mah.drawstuff.Constants.Constants;
import com.drawstuff.mah.drawstuff.Draw.DrawFragment;
import com.drawstuff.mah.drawstuff.Draw.DrawingView;


public class Main extends ActionBarActivity {

    private DrawingView mDrawingView;
    //final View drawView = (View) mDrawingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final Button drawButton = (Button) findViewById(R.id.drawBtn);

        drawButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                DrawFragment df = new DrawFragment();

                //  Vägrar skifta till DrawFragment, error:
                //  No view found for id 0x7f0c0051 (com.drawstuff.mah.drawstuff:id/drawfragment) for fragment DrawFragment{78c4b54 #0 id=0x7f0c0051}
                ft.replace(R.id.drawfragment,df);

                //setContentView(mDrawingView);
                ft.commit();

            }
        });




        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);

        menu.add(0, Constants.COLOR_MENU_ID, 0, "Color").setShortcut('3', 'c');
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



    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        return true;
    }



}
