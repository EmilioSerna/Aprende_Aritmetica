package com.emilioserna.aprendearitmtica;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class TitleFragment extends Fragment implements View.OnClickListener {
    private Button mSumButton;
    private Button mSubButton;
    private Button mMulButton;
    private Button mDivButton;
    private Button mQuitButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_title, container, false);

        mSumButton = (Button) v.findViewById(R.id.button_sum);
        mSubButton = (Button) v.findViewById(R.id.button_sub);
        mMulButton = (Button) v.findViewById(R.id.button_mul);
        mDivButton = (Button) v.findViewById(R.id.button_div);
        mQuitButton = (Button) v.findViewById(R.id.button_quit);

        mSumButton.setOnClickListener(this);
        mSubButton.setOnClickListener(this);
        mMulButton.setOnClickListener(this);
        mDivButton.setOnClickListener(this);
        mQuitButton.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;

        switch (v.getId()) {
            case R.id.button_sum:
                fragment = new SumFragment();
                break;
            case R.id.button_sub:
                fragment = new SubFragment();
                break;
            case R.id.button_mul:
                fragment = new MulFragment();
                break;
            case R.id.button_div:
                fragment = new DivFragment();
                break;
            case R.id.button_quit:
                getActivity().finish();
                System.exit(0);
                break;

        }

        replaceFragment(fragment);
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
