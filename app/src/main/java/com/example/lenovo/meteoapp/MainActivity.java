package com.example.lenovo.meteoapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyAdapter(getFragmentManager()));
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new TemperatureFragment();
                case 1:
                    return new CloudFragment();
                case 2:
                    return new HumidityFragment();
                case 3:
                    return new EquivalentFragment();
            }
            throw new RuntimeException("");
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

  /*  public void showEquivalentView() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.animator.enter_anim, R.animator.exit_anim);
        transaction.replace(frame_layout, new EquivalentFragment());
        transaction.commit();
    }


    public void showTemperatureView() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.animator.enter_anim, R.animator.exit_anim);
        transaction.replace(frame_layout, new TemperatureFragment());
        transaction.commit();
    }

    public void showHumidityView() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.animator.enter_anim, R.animator.exit_anim);
        transaction.replace(frame_layout, new HumidityFragment());
        transaction.commit();
    }

    public void showCloudView() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.animator.enter_anim, R.animator.exit_anim);
        transaction.replace(frame_layout, new CloudFragment());
        transaction.commit();

    }*/
}
