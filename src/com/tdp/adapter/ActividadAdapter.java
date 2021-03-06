package com.tdp.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tdp.bean.BeanActividad;
import com.tdp.pasrasapp.R;

public class ActividadAdapter extends ArrayAdapter<BeanActividad> {

	Context context;
	List<BeanActividad> items;
	List<BeanActividad> filteredData;
	int resource;

	public ActividadAdapter(Context context, int resource,
			List<BeanActividad> items) {
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

		BeanActividad item = filteredData.get(position);
		LinearLayout nuevaVista = null;
		
			if (convertView == null) {
				nuevaVista = new LinearLayout(getContext());
				inflater.inflate(resource, nuevaVista, true);
	
			} else {
				nuevaVista = (LinearLayout) convertView;
			}
	
			TextView tv_descripcionActividad_lista = (TextView) nuevaVista.findViewById(R.id.tv_descripcionActividad_lista)  ;
			TextView tv_idActividad_lista = (TextView) nuevaVista.findViewById(R.id.tv_idActividad_lista);
	
			if (tv_descripcionActividad_lista != null && item != null) {
				tv_descripcionActividad_lista.setText(item.getDescripcion_actividad().toString());
			}
	
			if (tv_idActividad_lista != null && item != null) {
				tv_idActividad_lista.setText("" + item.getId_actividad());
			}		
		
		return nuevaVista;
	}
	
	 //For this helper method, return based on filteredData
    public int getCount() 
    {
        return filteredData.size();
    }

    //This should return a data object, not an int
    public BeanActividad getItem(int position) 
    {
        return filteredData.get(position);
    }
    
    public long getItemId(int position) 
    {
        return position;
    }
    
}
