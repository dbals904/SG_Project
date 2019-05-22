package com.graduate.seoil.sg_projdct.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.graduate.seoil.sg_projdct.AccountSetting;
import com.graduate.seoil.sg_projdct.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class SettingFragment extends Fragment {
    RelativeLayout rel_setting_account;
    RelativeLayout rel_setting_question;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        rel_setting_account =view.findViewById(R.id.relative_setting_account);
        rel_setting_question=view.findViewById(R.id.relative_setting_question);

        rel_setting_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri =Uri.parse("https://cafe.naver.com/goingsucces");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        rel_setting_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AccountSetting.class);
                startActivity(intent);
            }
        });


        return view;
    }

}
