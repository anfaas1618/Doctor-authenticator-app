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
    public listadapterr(@NonNull Context context, ArrayList<doctorModel> docs) {
        super(context,R.layout.doc_list);
        this.docs=docs;
        this.context=context;
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
        View myView= layoutInflater.inflate(R.layout.doc_list,null,false);
        doctorModel doc_list=docs.get(position);
        TextView docname=myView.findViewById(R.id.name);
        TextView doc_reg=myView.findViewById(R.id.id);
        docname.setText(doc_list.getName());
        doc_reg.setText(doc_list.regid);
        return myView;
    }
}
