package com.anfaas.doctorauthenticator;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class listadapterr extends ArrayAdapter<doctorModel> {
    ArrayList <doctorModel> docs;
    Context context;
    public listadapterr(Context context, ArrayList<doctorModel> values) {
        super(context, -1, values);
        this.context = context;
        this.docs = values;
    }

    @Nullable
    @Override
    public doctorModel getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater layoutInflater = LayoutInflater.from(context.getApplicationContext());
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myView = inflater.inflate(R.layout.doc_list, parent, false);
        doctorModel doc_list=docs.get(position);
        TextView docname=myView.findViewById(R.id.name);
        TextView parent_name=myView.findViewById(R.id.parent_name);
        TextView regdate=myView.findViewById(R.id.reg_date);
        TextView birthdate=myView.findViewById(R.id.birthDateStr);
        TextView docDegree=myView.findViewById(R.id.doc_degree);
        TextView doc_reg=myView.findViewById(R.id.id);
        parent_name.setText(doc_list.getParent_name());
        regdate.setText(doc_list.getRegDate());
        birthdate.setText(doc_list.getBirthDateStr());
        docDegree.setText(doc_list.getDoctorDegree());
        docname.setText(doc_list.getName());
        doc_reg.setText(doc_list.regid);
        return myView;
    }
}
