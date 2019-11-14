package com.me.sauditourism;

import androidx.appcompat.app.ActionBarDrawerToggle;

import androidx.core.view.GravityCompat;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import android.text.Html;

import android.util.DisplayMetrics;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class MainFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    private Button menuBtn;
    private Button eventsBtn;
    private Button tourGuideBtn;
    private Button carsBtn;
    private Button offersBtn;
    private Button tourProvidersBtn;
    private Button flightsBtn;
    private Button hotelsBtn;
    private Button tourismMapBtn;
    private Button favoritesBtn;
    private Button complainsBtn;
    private Button emergencyServicesBtn;

    private ImageView asirIv;

    private FragmentPagerAdapter adapterViewPager;

    private ViewPager vpPager;

    private TextView saudiTv;
    private TextView linkTv;

    private Handler handler = new Handler(Looper.getMainLooper());

    private Context mContext;

    private String[] tittle;

    private DrawerLayout drawer;

    private Locale myLocale;

    private int[] riyadhViews = {R.drawable.riyadh1 , R.drawable.riyadh2, R.drawable.riyadh3 , R.drawable.riyadh4};
    private int[] jeddahViews = {R.drawable.jeddah1 , R.drawable.jeddah2 , R.drawable.jeddah3 , R.drawable.jeddah4};
    private int[] meccaViews = {R.drawable.mecca1 , R.drawable.mecca2 , R.drawable.mecca3 , R.drawable.mecca4};
    private int[] khobarViews = {R.drawable.khobar1 , R.drawable.khobar2 , R.drawable.khobar3 , R.drawable.khobar4};

    public class MyPagerAdapter extends FragmentPagerAdapter {

        List<Fragment> fragments;

        MyPagerAdapter(FragmentManager fragmentManager, List<Fragment> fragments) {
            super(fragmentManager);
            this.fragments = fragments;
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @NonNull
        @Override
        public androidx.fragment.app.Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return tittle[position];
        }
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            final int height = 4;
            handler.post(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i <= vpPager.getCurrentItem(); i++ ){
                        if (vpPager.getCurrentItem() == i) {
                            vpPager.setCurrentItem(i + 1);
                            break;
                        }
                         else if (vpPager.getCurrentItem() == height-1) {
                            vpPager.setCurrentItem(0);
                            break;
                        }
                    }
                }
            });
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        drawer = view.findViewById(R.id.fra);
        final NavigationView navigationView = view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainFragment.this.getActivity(), drawer,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mContext = getActivity();

        tittle = getContext().getResources().getStringArray(R.array.cities);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask() , 4000 , 5000);

        vpPager = (ViewPager) view.findViewById(R.id.pager_header);

        List<Fragment> fragments = new ArrayList<>();

        fragments.add(new GovernmentFragment(new Data(0, tittle[0], riyadhViews)));
        fragments.add(new GovernmentFragment(new Data(1, tittle[1], jeddahViews)));
        fragments.add(new GovernmentFragment(new Data(2, tittle[2], meccaViews)));
        fragments.add(new GovernmentFragment(new Data(3, tittle[3], khobarViews)));

        adapterViewPager = new MyPagerAdapter(getFragmentManager(), fragments);
        vpPager.setAdapter(adapterViewPager);
        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        eventsBtn = (Button) view.findViewById(R.id.eventsBtn);
        eventsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainFragment.this.getContext() , "You Clicked" , Toast.LENGTH_SHORT).show();
            }
        });

        tourGuideBtn =(Button) view.findViewById(R.id.tourGuideBtn);
        tourGuideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainFragment.this.getContext() , "You Clicked" , Toast.LENGTH_SHORT).show();
            }
        });

        carsBtn= (Button) view.findViewById(R.id.carsBtn);
        carsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainFragment.this.getContext() , "You Clicked" , Toast.LENGTH_SHORT).show();
            }
        });

        offersBtn = (Button) view.findViewById(R.id.offersBtn);
        offersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainFragment.this.getContext() , "You Clicked" , Toast.LENGTH_SHORT).show();
            }
        });

        tourProvidersBtn = (Button) view.findViewById(R.id.tourProvidersBtn);
        tourProvidersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainFragment.this.getContext() , "You Clicked" , Toast.LENGTH_SHORT).show();
            }
        });

        flightsBtn = (Button) view.findViewById(R.id.flightBtn);
        flightsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainFragment.this.getContext() , "You Clicked" , Toast.LENGTH_SHORT).show();
            }
        });

        hotelsBtn = (Button) view.findViewById(R.id.hotelsBtn);
        hotelsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainFragment.this.getContext() , "You Clicked" , Toast.LENGTH_SHORT).show();
            }
        });

        tourismMapBtn = (Button) view.findViewById(R.id.tourismMapBtn);
        tourismMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainFragment.this.getContext() , "You Clicked" , Toast.LENGTH_SHORT).show();
            }
        });

        favoritesBtn = (Button) view.findViewById(R.id.favoritesBtn);
        favoritesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainFragment.this.getContext() , "You Clicked" , Toast.LENGTH_SHORT).show();
            }
        });

        complainsBtn = (Button) view.findViewById(R.id.complainsBtn);
        complainsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainFragment.this.getContext() , "You Clicked" , Toast.LENGTH_SHORT).show();
            }
        });

        emergencyServicesBtn = (Button) view.findViewById(R.id.emergencyServicesBtn);
        emergencyServicesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainFragment.this.getContext() , "You Clicked" , Toast.LENGTH_SHORT).show();
            }
        });

        menuBtn = (Button) view.findViewById(R.id.menuBtn);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });

        asirIv = (ImageView) view.findViewById(R.id.mountainIv);
        asirIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainFragment.this.getContext() , "This is Pyramid Tower" , Toast.LENGTH_SHORT).show();
            }
        });

        saudiTv = (TextView) view.findViewById(R.id.SaudiTv);
        String text = "<font color='red'>الــ</font>ســ</font><font color='yellow'>عــو</font><font color='blue'>د</font><font color='green'>يــة</font>";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            saudiTv.setText(Html.fromHtml(text,  Html.FROM_HTML_MODE_LEGACY), TextView.BufferType.SPANNABLE);
        } else {
            saudiTv.setText(Html.fromHtml(text), TextView.BufferType.SPANNABLE);
        }

        linkTv = (TextView) view.findViewById(R.id.linkTv);
        String text4 = "<font color='red'>Sa</font>ud</font><font color='yellow'>i</font><font color='yellow'>T</font><font color='blue'>ouri</font><font color='green'>sm.sa</font>";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            linkTv.setText(Html.fromHtml(text4,  Html.FROM_HTML_MODE_LEGACY), TextView.BufferType.SPANNABLE);
        } else {
            linkTv.setText(Html.fromHtml(text4), TextView.BufferType.SPANNABLE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment,container,false);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull final MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.itemA:
                Toast.makeText(MainFragment.this.getActivity() , "Share this Application to support us" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemB:
                 MainFragment.this.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container1,
                        new RateActivity()).commit();
                break;
            case R.id.item1:
                setLocale("ar");
                break;
            case R.id.item2:
                setLocale("en");
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setLocale(String lang) {
        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        FragmentManager manager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
        final FragmentTransaction ft = manager.beginTransaction();
        ft.detach(MainFragment.this);
        ft.attach(MainFragment.this);
        ft.commit();
    }
}