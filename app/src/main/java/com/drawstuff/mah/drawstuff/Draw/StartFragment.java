package com.drawstuff.mah.drawstuff.Draw;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.drawstuff.mah.drawstuff.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends Fragment {


    public StartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_start, container, false);
        Button drawButton;
        drawButton = (Button) v.findViewById(R.id.drawBtn);
        drawButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                DrawFragment df = new DrawFragment();

                //  Vgrar skifta till DrawFragment, error:
                //  No view found for id 0x7f0c0051 (com.drawstuff.mah.drawstuff:id/drawfragment) for fragment DrawFragment{78c4b54 #0 id=0x7f0c0051}
                //Place the id where the fragment should be placed
                ft.replace(R.id.main_activity_container,df);

                //setContentView(mDrawingView);
                ft.commit();

            }
        });
        return v;
    }


}
