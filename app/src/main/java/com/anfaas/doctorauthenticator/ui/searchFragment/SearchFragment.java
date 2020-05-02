package com.anfaas.doctorauthenticator.ui.searchFragment;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.anfaas.doctorauthenticator.R;
import com.anfaas.doctorauthenticator.clientlib.ClientQueryBuilder;
import com.anfaas.doctorauthenticator.clientlib.DoctorData;
import com.anfaas.doctorauthenticator.doctorModel;
import com.anfaas.doctorauthenticator.enums.State;
import com.anfaas.doctorauthenticator.listadapterr;

import org.json.JSONException;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class SearchFragment extends Fragment {
EditText E_name,E_regId,E_state;
    String state_state;
    ListView list;
   public ClientQueryBuilder queryBuilder;
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
        String[] states = new String[] {
                "ANDHRA_PRADESH",
                "ARUNACHAL_PRADESH",
                "ASSAM",
                "BIHAR",
                "DELHI",
                "GOA",
                "GUJARAT",
                "HARYANA",
                "HIMACHAL_PRADESH",
                "JAMMU_n_KASHMIR",
                "JHARKHAND",
                "KARNATAKA",
                "MADHYA_PRADESH",
                "MAHARASHTRA",
                "MANIPUR",
                "MIZORAM",
                "NAGALAND",
                "ORISSA",
                "PUNJAB",
                "RAJASTHAN",
                "SIKKIM",
                "TAMIL_NADU",
                "TELANGANA",
                "KERALA",
                "TRIPURA",
                "UTTARAKHAND",
                "UTTAR_PRADESH",
                "WEST_BENGAL"};
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
        list=view.findViewById(R.id.list);
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CardView cardView=view.findViewById(R.id.cardView);
                cardView.setVisibility(View.GONE);

                 queryBuilder= new ClientQueryBuilder();

                String yearString = String.valueOf(year);
                if (isYearSelected) queryBuilder.setRegYear(yearString);
       //         if (isStateSelected) queryBuilder.setState(State.valueOf( state_state));
                if (E_name.getText()!=null) queryBuilder.setDoctorName(E_name.getText().toString().trim());
                if (E_regId.getText()!=null)queryBuilder.setRegYear(E_regId.getText().toString().trim());
            new   task().execute();

//                for (DoctorData doctorData:data)
//                {
//                    try {
//                        doctorData.getAddress();
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
         }
        });
        statepick.setMinValue(0);
        statepick.setMaxValue(27);
        statepick.setDisplayedValues(states);
        statepick.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                int x=picker.getValue();
                 state_state=states[x];
            }
        });
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
    class  task extends AsyncTask<Void,Void,Void>{
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            DoctorData[] data = (DoctorData[]) queryBuilder.fetchData(" http://anfaas-com.stackstaging.com/hackcovid");
            ArrayList<doctorModel> mod=new ArrayList<>();
            for (DoctorData data1:data)
            {
                doctorModel model;
                try {
                    model = new doctorModel(data1.getDoctorName(),data1.getRegistrationNumber());
                    mod.add(model);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listadapterr adapter= new listadapterr(getContext(),mod);
                list.setAdapter(adapter);
            }
            return null;
        }
    }
}
