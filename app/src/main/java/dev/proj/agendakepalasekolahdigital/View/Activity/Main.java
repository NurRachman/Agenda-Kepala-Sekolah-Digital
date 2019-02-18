package dev.proj.agendakepalasekolahdigital.View.Activity;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import com.applandeo.materialcalendarview.CalendarView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dev.proj.agendakepalasekolahdigital.R;
import dev.proj.agendakepalasekolahdigital.View.Fragment.Bulan;
import dev.proj.agendakepalasekolahdigital.View.Fragment.Minggu;
import dev.proj.agendakepalasekolahdigital.View.Fragment.Tanggal;

public class Main extends AppCompatActivity {
    ViewPager pagerFragment;
    TabLayout tableLayout;
    DisplayFragment displayFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Agenda");
        getSupportActionBar().setSubtitle("Login As NurRachman Ganteng");

        pagerFragment = findViewById(R.id.pagerFragment);
        tableLayout = findViewById(R.id.tabMenu);

        displayFragment = new DisplayFragment(getSupportFragmentManager());

        pagerFragment.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tableLayout));
        tableLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(pagerFragment));
        pagerFragment.setAdapter(displayFragment);

    }

    private class DisplayFragment extends FragmentPagerAdapter{
        DisplayFragment(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment;
            switch (i){
                case 0:
                    fragment = new Tanggal();
                    break;
                case 1:
                    fragment = new Minggu();
                    break;
                case 2:
                    fragment = new Bulan();
                    break;
                    default: fragment = new Tanggal();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}
