package com.tdp.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tdp.bean.BeanTipoActividad;
import com.tdp.bean.BeanTipoActividad;
import com.tdp.pasrasapp.R;

public class TipoActividadAdapter extends ArrayAdapter<BeanTipoActividad> {

	
	Context context;
	List<BeanTipoActividad> items;
	List<BeanTipoActividad> filteredData;
	int resource;

	public TipoActividadAdapter(Context context, int resource,
			List<BeanTipoActividad> items) {
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

		BeanTipoActividad item = filteredData.get(position);
		

		LinearLayout nuevaVista;

		if (convertView == null) {
			nuevaVista = new LinearLayout(getContext());
			inflater.inflate(resource, nuevaVista, true);

		} else {
			nuevaVista = (LinearLayout) convertView;
		}

		TextView tv_descricionActividad = (TextView) nuevaVista.findViewById(R.id.tv_descricionActividad)  ;
		TextView tv_idTipoActividad = (TextView) nuevaVista.findViewById(R.id.tv_idTipoActividad);

		if (tv_descricionActividad != null) {
			tv_descricionActividad.setText(item.getDescripcion_actividad());
		}

		if (tv_idTipoActividad != null) {
			tv_idTipoActividad.setText(item.getId_tipo_actividad());
		}
		
		return nuevaVista;
	}
	
	 //For this helper method, return based on filteredData
    public int getCount() 
    {
        return filteredData.size();
    }

    //This should return a data object, not an int
    public BeanTipoActividad getItem(int position) 
    {
        return filteredData.get(position);
    }
    
    public long getItemId(int position) 
    {
        return position;
    }

    
    
}
