package com.insanie.ecommerce.ecommerce.home_fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.insanie.ecommerce.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Product extends Fragment {

    GridView gridView;
    SimpleAdapter simpleAdapter;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<HashMap<String, String>>();

    public Product() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        gridView =(GridView) view.findViewById(R.id.grdProduct);
        setProduct();
        return view;
    }

    private void setProduct(){
        for (int i = 1; i <= 10; i++){
            HashMap<String,String> map = new HashMap<>();
            map.put("price",  "Rp " + String.valueOf(i) + "0.000");
            map.put("Seller","Fathie_Insanie");
            arrayList.add(map);
        }
        simpleAdapter = new SimpleAdapter(getActivity(),arrayList,R.layout.adapter_product,
                new String[] {"price","Seller"},
                new int[] {R.id.txtPrice,R.id.txtSeller} );
        gridView.setAdapter(simpleAdapter);
    }
}