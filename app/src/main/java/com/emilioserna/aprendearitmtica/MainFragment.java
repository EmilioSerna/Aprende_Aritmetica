package com.emilioserna.aprendearitmtica;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.w3c.dom.Text;

public class MainFragment extends Fragment implements View.OnClickListener {
    private Button mSumButton;
    private Button mSubButton;
    private Button mMulButton;
    private Button mDivButton;
    private Button mQuitButton;

    public static int grade;
    public static int nums[] = new int[8];

    public static boolean answered[] = {true, true, true, true};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_title, container, false);

        grade = 0;

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

    public static TextView setText(View v, int id, int text) {
        TextView mText;
        mText = v.findViewById(id);
        mText.setText(text);
        return mText;
    }

    public static TextView setText(View v, int id, String text) {
        TextView mText;
        mText = v.findViewById(id);
        mText.setText(text);
        return mText;
    }

    public static void randomize(int indexAnswer, int indexNum1, int indexNum2) {
        if (MainFragment.answered[indexAnswer]) {
            MainFragment.nums[indexNum1] = Random.getRandomNumber();
            MainFragment.nums[indexNum2] = Random.getRandomNumber();
            MainFragment.answered[indexAnswer] = false;
        }
    }
}
