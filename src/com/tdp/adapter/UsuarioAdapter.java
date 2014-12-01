package com.tdp.adapter;

import java.util.ArrayList;
import java.util.List;

import com.tdp.bean.BeanUsuario;
import com.tdp.pasrasapp.R;





import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UsuarioAdapter extends ArrayAdapter<BeanUsuario> implements Filterable {

	Context context;
	List<BeanUsuario> items;
	List<BeanUsuario> filteredData;
	int resource;

	public UsuarioAdapter(Context context, int resource,
			List<BeanUsuario> items) {
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

		BeanUsuario item = filteredData.get(position);
		

		LinearLayout nuevaVista;

		if (convertView == null) {
			nuevaVista = new LinearLayout(getContext());
			inflater.inflate(resource, nuevaVista, true);

		} else {
			nuevaVista = (LinearLayout) convertView;
		}

		TextView txtNombre = (TextView) nuevaVista.findViewById(R.id.txtNombreCompuesto)  ;
		TextView txtTelefono = (TextView) nuevaVista.findViewById(R.id.txtTelefonoCompuesto);

		if (txtNombre != null) {
			txtNombre.setText(item.getNombre());
		}

		if (txtTelefono != null) {
			txtTelefono.setText("" + item.getIdusuario());
		}
		
		return nuevaVista;
	}
	
	@Override
    public Filter getFilter() {
       return myFilter;
   }
	
	 //For this helper method, return based on filteredData
    public int getCount() 
    {
        return filteredData.size();
    }

    //This should return a data object, not an int
    public BeanUsuario getItem(int position) 
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
         List<BeanUsuario> tempList=new ArrayList<BeanUsuario>();
         //constraint is the result from text you want to filter against. 
         //objects is your data set you will filter from
         if(constraint != null && items!=null) {
             int length=items.size();
             int i=0;
                while(i<length){
                	BeanUsuario item=items.get(i);

                	if (item.getNombre().toLowerCase().contains(constraint.toString().toLowerCase())){
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
    	  filteredData = (ArrayList<BeanUsuario>) results.values;
          if (results.count > 0) {
        	  notifyDataSetChanged();
          } else {
              notifyDataSetInvalidated();
          }  
      }
     };
}
