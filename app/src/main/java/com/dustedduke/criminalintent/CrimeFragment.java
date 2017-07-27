package com.dustedduke.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.LayoutInflaterCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

/**
 * Created by dustedduke on 25.07.17.
 */

public class CrimeFragment extends Fragment {
    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;
    private DateFormat dateFormat = new android.text.format.DateFormat();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_crime, container, false);

        mTitleField = (EditText)v.findViewById(R.id.crime_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence c, int start, int count, int after) {
                //Empty space
            }

            @Override
            public void onTextChanged(CharSequence c, int start, int before, int count) {
                mCrime.setmTitle(c.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //Empty space
            }
        });

        mDateButton = (Button) v.findViewById(R.id.crime_date);

        mDateButton.setText(dateFormat.format("dd-MM-yyyy" ,mCrime.getmDate())); //Null pointer exception
        mDateButton.setEnabled(false);

        mSolvedCheckBox = (CheckBox) v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Флаг раскрытия преступления
                mCrime.setmSolved(isChecked);

            }
        });

        return v;

    }

}
