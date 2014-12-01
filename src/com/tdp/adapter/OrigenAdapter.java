package com.tdp.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tdp.bean.BeanOrigen;
import com.tdp.bean.BeanOrigen;
import com.tdp.pasrasapp.R;

public class OrigenAdapter extends ArrayAdapter<BeanOrigen> {
	Context context;
	List<BeanOrigen> items;
	List<BeanOrigen> filteredData;
	int resource;

	public OrigenAdapter(Context context, int resource,
			List<BeanOrigen> items) {
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

		BeanOrigen item = filteredData.get(position);
		

		LinearLayout nuevaVista;

		if (convertView == null) {
			nuevaVista = new LinearLayout(getContext());
			inflater.inflate(resource, nuevaVista, true);

		} else {
			nuevaVista = (LinearLayout) convertView;
		}

		TextView tv_idOrigen = (TextView) nuevaVista.findViewById(R.id.tv_idOrigen)  ;
		TextView tv_descripcionOrigen = (TextView) nuevaVista.findViewById(R.id.tv_descripcionOrigen);

		if (tv_descripcionOrigen != null) {
			tv_descripcionOrigen.setText(item.getDescripcion_origen());
		}

		if (tv_idOrigen != null) {
			tv_idOrigen.setText("" +item.getId_origen());
		}
		
		return nuevaVista;
	}
	
	 //For this helper method, return based on filteredData
    public int getCount() 
    {
        return filteredData.size();
    }

    //This should return a data object, not an int
    public BeanOrigen getItem(int position) 
    {
        return filteredData.get(position);
    }
    
    public long getItemId(int position) 
    {
        return position;
    }
}
