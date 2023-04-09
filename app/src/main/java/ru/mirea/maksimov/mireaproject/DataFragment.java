package ru.mirea.maksimov.mireaproject;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DataFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    public DataFragment() {
    }
    public static DataFragment newInstance(String param1, String param2) {
        DataFragment fragment = new DataFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        TextView textView = view.findViewById(R.id.textView);
        textView.setText("Э́рик Теодо́р Ка́ртман — персонаж сериала «Южный Парк», один из четырёх главных героев, учеников начальной школы американского городка Южный Парк. Практически все, кроме матери Лиэн Картман, Джимми, Баттерса и работников начальной школы, зовут его по фамилии, а мать ласково называет его «Поросёночком».");
        textView.setTextColor(getResources().getColor(com.google.android.material.R.color.material_dynamic_neutral30));
        return view;
    }
}