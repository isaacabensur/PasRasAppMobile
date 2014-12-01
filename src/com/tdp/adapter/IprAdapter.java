package com.tdp.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tdp.bean.BeanIpr;
import com.tdp.pasrasapp.R;

public class IprAdapter extends ArrayAdapter<BeanIpr>{

	Context context;
	List<BeanIpr> items;
	List<BeanIpr> filteredData;
	int resource;

	public IprAdapter(Context context, int resource,
			List<BeanIpr> items) {
		super(context, resource, items);

		this.context = context;
		this.items = items;
		this.filteredData = items;
		this.resource = resource;
	}
	

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		BeanIpr item = filteredData.get(position);
		

		LinearLayout nuevaVista;

		if (convertView == null) {
			nuevaVista = new LinearLayout(getContext());
			inflater.inflate(resource, nuevaVista, true);

		} else {
			nuevaVista = (LinearLayout) convertView;
		}

		TextView tv_idIpr = (TextView) nuevaVista.findViewById(R.id.tv_idIpr)  ;
		TextView tv_nroIpr = (TextView) nuevaVista.findViewById(R.id.tv_nroIpr);

		if (tv_nroIpr != null) {
			tv_nroIpr.setText("" + item.getNro_ipr());
		}

		if (tv_idIpr != null) {
			tv_idIpr.setText("" + item.getId_ipr());
		}
		
		return nuevaVista;
	}
	
	 //For this helper method, return based on filteredData
    public int getCount() 
    {
        return filteredData.size();
    }

    //This should return a data object, not an int
    public BeanIpr getItem(int position) 
    {
        return filteredData.get(position);
    }
    
    public long getItemId(int position) 
    {
        return position;
    }
}
