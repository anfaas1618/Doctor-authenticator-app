package com.anfaas.doctorauthenticator.ui.searchFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.anfaas.doctorauthenticator.R;
import com.anfaas.doctorauthenticator.clientlib.ClientQueryBuilder;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class SearchFragment extends Fragment {
EditText E_name,E_regId,E_state;

int year;
Button search_btn;
    private SearchViewModel searchViewModel;
    public  Boolean isYearSelected=false,isStateSelected=false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        searchViewModel =
                ViewModelProviders.of(this).get(SearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NumberPicker yearpick= view.findViewById(R.id.yearpick);
        NumberPicker statepick= view.findViewById(R.id.statePick);
        TextView stateText =view.findViewById(R.id.stateText);
         E_name=view.findViewById(R.id.edit_name);
         CheckBox stateCheck=view.findViewById(R.id.stateCheck);
        E_regId=view.findViewById(R.id.edit_id);
        TextView yearText=view.findViewById(R.id.textView);

        CheckBox box= view.findViewById(R.id.checkBox);
        search_btn=view.findViewById(R.id.searchbtn);
        statepick.setVisibility(View.INVISIBLE);
        stateText.setVisibility(View.INVISIBLE);
        yearpick.setVisibility(View.INVISIBLE);
        yearText.setVisibility(View.INVISIBLE);
        String[] states = new String[] {"andra pradesh", "goa", "delhi", "mp", "rajasthan"};//todo add states here Vaishnav
        stateCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    statepick.setVisibility(View.VISIBLE);
                    stateText.setVisibility(View.VISIBLE);
                    isStateSelected=true;
                }
                else
                {
                    statepick.setVisibility(View.INVISIBLE);
                    stateText.setVisibility(View.INVISIBLE);
                    isStateSelected=false;
                }
            }
        });
        box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("TAG", "onCheckedChanged: "+isChecked);
                if (isChecked)
                {
                    yearpick.setVisibility(View.VISIBLE);
                    yearText.setVisibility(View.VISIBLE);
                    isYearSelected=true;
                }
                else
                   {
                       yearpick.setVisibility(View.INVISIBLE);
                       yearText.setVisibility(View.INVISIBLE);
                       isYearSelected=false;
                   }
            }
        });
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isYearSelected==true)
                {//TODO vaishnav add here builder
                    ClientQueryBuilder queryBuilder= new ClientQueryBuilder();
                    queryBuilder.fetchData("www.host.com");
                    String yearString = String.valueOf(year);
                    queryBuilder.setRegYear(yearString);

                    if (E_name.getText()!=null) queryBuilder.setDoctorName(E_name.getText().toString().trim());
                  //  if (E_state.getText()!=null) queryBuilder.setState(E_state.getText().toString().trim());

                }
            }
        });
        statepick.setMinValue(0);
        statepick.setMaxValue(30);//todo add max no of states here Vaishnav
        yearpick.setMinValue(1970);
        yearpick.setMaxValue(2050);
        yearpick.setValue(1999);
        yearpick.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                year = yearpick.getValue();
                Log.d("picker value", year + "");
            }
        });
    }
}
