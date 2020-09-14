package com.example.viewpagertest;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private FragmentManager fragmentManager;

    //뷰페이져와 프래그먼트를 연결해주는 부분
    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return FragmentAdapter.newInstance("한식");
            case 1:
                return FragmentAdapter.newInstance("중식");
            case 2:
                return FragmentAdapter.newInstance("양식");
            default:
                return null;
        }
    }

    //생성될 프래그먼트 개수
    @Override
    public int getCount() {
        return 3;
    }

    //탭 레이아웃에 값을 넣음
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "한식";
            case 1:
                return "중식";
            case 2:
                return "양식";
            default:
                return null;
        }
    }
}
