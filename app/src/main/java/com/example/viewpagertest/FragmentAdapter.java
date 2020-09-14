package com.example.viewpagertest;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class FragmentAdapter extends Fragment {
    public FragmentAdapter fragmentAdapter;
    MainActivity mainActivity;
    String name;

    public FragmentAdapter(){}

    //페이져와 연결+ 값을 넘겨받기 위함
    public static FragmentAdapter newInstance(String name){
        FragmentAdapter fragmentAdapter = new FragmentAdapter();
        Bundle args = new Bundle();
        args.putString("name", name); // 탭 이름
        fragmentAdapter.setArguments(args);
        return fragmentAdapter;
    }

    //액티비티와 프래그먼트를 붙일 때 호출되는 메소드
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //번들로 받은 값
        if(getArguments() != null){
            name = getArguments().getString("name");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_page, container, false);

        //프래그먼트 속 위젯
        ImageView img = v.findViewById(R.id.img);
        TextView text = v.findViewById(R.id.text);

        //이미지 로딩을 위한 url
        String frontUrl = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory&fname=";

        //페이져에서 받은 값에 따라 이미지 다르게
        switch(name){
            case "한식":
                Glide.with(mainActivity).load(frontUrl+"https://i.imgur.com/fScDzbQ.jpg").into(img);
                text.setText("보릿고개 밥 먹고싶다.");
                break;
            case "중식":
                Glide.with(mainActivity).load(frontUrl+"https://i.imgur.com/eN0FdaV.jpg").into(img);
                text.setText("돌짜장 먹고싶다.");
                break;
            case "양식":
                Glide.with(mainActivity).load(frontUrl+"https://i.imgur.com/vB2YmoW.jpg").into(img);
                text.setText("피자 먹고싶다.");
                break;
        }

        return v;
    }
}
