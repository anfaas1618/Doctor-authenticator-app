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
    public  Boolean isYearSelected=false;

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
        NumberPicker picker= view.findViewById(R.id.numberPicker);
         E_name=view.findViewById(R.id.edit_name);
        E_regId=view.findViewById(R.id.edit_id);
        E_state=view.findViewById(R.id.edit_state);
        TextView yearText=view.findViewById(R.id.textView);
        picker.setVisibility(View.INVISIBLE);
        yearText.setVisibility(View.INVISIBLE);
        CheckBox box= view.findViewById(R.id.checkBox);
        search_btn=view.findViewById(R.id.searchbtn);
        box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("TAG", "onCheckedChanged: "+isChecked);
                if (isChecked)
                {
                    picker.setVisibility(View.VISIBLE);
                    yearText.setVisibility(View.VISIBLE);
                    isYearSelected=true;
                }
                else
                   {
                       picker.setVisibility(View.INVISIBLE);
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
                    if (E_state.getText()!=null) queryBuilder.setState(E_state.getText().toString().trim());

                }
            }
        });
        picker.setMinValue(1970);
        picker.setMaxValue(2050);
        picker.setValue(1999);
        picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                year = picker.getValue();
                Log.d("picker value", year + "");
            }
        });
    }
}
