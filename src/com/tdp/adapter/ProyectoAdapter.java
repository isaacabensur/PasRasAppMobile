package com.tdp.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tdp.bean.BeanProyecto;
import com.tdp.pasrasapp.R;

public class ProyectoAdapter extends ArrayAdapter<BeanProyecto> implements Filterable{

	Context context;
	List<BeanProyecto> items;
	List<BeanProyecto> filteredData;
	int resource;

	public ProyectoAdapter(Context context, int resource,
			List<BeanProyecto> items) {
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

		BeanProyecto item = filteredData.get(position);
		

		LinearLayout nuevaVista;

		if (convertView == null) {
			nuevaVista = new LinearLayout(getContext());
			inflater.inflate(resource, nuevaVista, true);

		} else {
			nuevaVista = (LinearLayout) convertView;
		}

		TextView tv_idProyecto = (TextView) nuevaVista.findViewById(R.id.tv_idProyecto)  ;
		TextView tv_nroProyecto = (TextView) nuevaVista.findViewById(R.id.tv_nroProyecto);

		if (tv_nroProyecto != null) {
			tv_nroProyecto.setText("" + item.getNro_proyecto());
		}

		if (tv_idProyecto != null) {
			tv_idProyecto.setText("" +item.getId_proyecto());
		}
		
		return nuevaVista;
	}
	
	 //For this helper method, return based on filteredData
    public int getCount() 
    {
        return filteredData.size();
    }

    //This should return a data object, not an int
    public BeanProyecto getItem(int position) 
    {
        return filteredData.get(position);
    }
    
    public long getItemId(int position) 
    {
        return position;
    }
    Filter myFilter = new Filter() { 
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
         FilterResults filterResults = new FilterResults();   
         List<BeanProyecto> tempList=new ArrayList<BeanProyecto>();
         //constraint is the result from text you want to filter against. 
         //objects is your data set you will filter from
         if(constraint != null && items!=null) {
             int length=items.size();
             int i=0;
                while(i<length){
                	BeanProyecto item=items.get(i);

                	if (( "" + item.getNro_proyecto()).toLowerCase().contains(constraint.toString().toLowerCase())){
                		tempList.add(item);	
                	}
                    i++;
                }
                //following two lines is very important
                //as publish result can only take FilterResults objects
                filterResults.values = tempList;
                filterResults.count = tempList.size();
          }
          return filterResults;
      }

      @SuppressWarnings("unchecked")
      @Override
      protected void publishResults(CharSequence contraint, FilterResults results) {
    	  filteredData = (ArrayList<BeanProyecto>) results.values;
          if (results.count > 0) {
        	  notifyDataSetChanged();
          } else {
              notifyDataSetInvalidated();
          }  
      }
     };
     
     
}
