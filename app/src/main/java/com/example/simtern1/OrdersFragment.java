package com.example.simtern1;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;

public class OrdersFragment extends Fragment{
   @Override
   public View onCreateView(LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
      /**
       * Inflate the layout for this fragment
       */
		View fragView = inflater.inflate(
				R.layout.orders_fragment_layout, container, false);
	   
		
	    final CheckedTextView admitToMedFloorChkBox = (CheckedTextView) fragView.findViewById(
	    		R.id.admit_to_medical_floor_check);
	    final CheckedTextView admitToMedFloorMonitorChkBox = (CheckedTextView) fragView.findViewById(
	    		R.id.admit_to_medical_floor_monitor_check);
	    final CheckedTextView admitToStepDownChkBox = (CheckedTextView) fragView.findViewById(
	       		R.id.admit_to_step_down_icu_check);
	    final CheckedTextView admitToCriticalCareChkBox = (CheckedTextView) fragView.findViewById(
	    	    R.id.admit_to_critical_care_check);
	    final CheckedTextView admitToObservationChkBox = (CheckedTextView) fragView.findViewById(
	    	    R.id.admit_to_observation_check);
	    
	    admitToMedFloorChkBox.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v)
	        {
	        	if(((CheckedTextView) v).isChecked()) {
	        		((CheckedTextView) v).toggle();
	        	} else {
	        	    admitToMedFloorChkBox.setChecked(true);
	        	    admitToMedFloorMonitorChkBox.setChecked(false);
	        	    admitToStepDownChkBox.setChecked(false);
	        	    admitToCriticalCareChkBox.setChecked(false);
	        	    admitToObservationChkBox.setChecked(false);
	        	}
	        }
	    });
		
	    admitToMedFloorMonitorChkBox.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v)
	        {
	        	if(((CheckedTextView) v).isChecked()) {
	        		((CheckedTextView) v).toggle();
	        	} else {
	        	    admitToMedFloorChkBox.setChecked(false);
	        	    admitToMedFloorMonitorChkBox.setChecked(true);
	        	    admitToStepDownChkBox.setChecked(false);
	        	    admitToCriticalCareChkBox.setChecked(false);
	        	    admitToObservationChkBox.setChecked(false);
	        	}
	        }
	    });	    
	    
	    admitToStepDownChkBox.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v)
	        {
	        	if(((CheckedTextView) v).isChecked()) {
	        		((CheckedTextView) v).toggle();
	        	} else {
	        	    admitToMedFloorChkBox.setChecked(false);
	        	    admitToMedFloorMonitorChkBox.setChecked(false);
	        	    admitToStepDownChkBox.setChecked(true);
	        	    admitToCriticalCareChkBox.setChecked(false);
	        	    admitToObservationChkBox.setChecked(false);
	        	}
	        }
	    });	    
	    
	    admitToCriticalCareChkBox.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v)
	        {
	        	if(((CheckedTextView) v).isChecked()) {
	        		((CheckedTextView) v).toggle();
	        	} else {
	        	    admitToMedFloorChkBox.setChecked(false);
	        	    admitToMedFloorMonitorChkBox.setChecked(false);
	        	    admitToStepDownChkBox.setChecked(false);
	        	    admitToCriticalCareChkBox.setChecked(true);
	        	    admitToObservationChkBox.setChecked(false);
	        	}
	        }
	    });	    	    

	    admitToObservationChkBox.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v)
	        {
	        	if(((CheckedTextView) v).isChecked()) {
	        		((CheckedTextView) v).toggle();
	        	} else {
	        	    admitToMedFloorChkBox.setChecked(false);
	        	    admitToMedFloorMonitorChkBox.setChecked(false);
	        	    admitToStepDownChkBox.setChecked(false);
	        	    admitToCriticalCareChkBox.setChecked(false);
	        	    admitToObservationChkBox.setChecked(true);
	        	}
	        }
	    });	  
	    
	    final CheckedTextView dietRegularChkBox = (CheckedTextView) fragView.findViewById(
	    		R.id.diet_regular_check);
	    final CheckedTextView dietCardiacChkBox = (CheckedTextView) fragView.findViewById(
	    		R.id.diet_cardiac_check);
	    final CheckedTextView dietDiabeticChkBox = (CheckedTextView) fragView.findViewById(
	       		R.id.diet_diabetic_check);
	    final CheckedTextView dietCardiacDiabeticChkBox = (CheckedTextView) fragView.findViewById(
	    	    R.id.diet_cardiac_diabetic_check);
	    final CheckedTextView dietNPOChkBox = (CheckedTextView) fragView.findViewById(
	    	    R.id.diet_npo_check);
	    final CheckedTextView dietNPOAfterChkBox = (CheckedTextView) fragView.findViewById(
	    	    R.id.diet_npo_after_check);	    
	    
	    dietRegularChkBox.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v)
	        {
	        	if(((CheckedTextView) v).isChecked()) {
	        		((CheckedTextView) v).toggle();
	        	} else {     	    
	        	    dietRegularChkBox.setChecked(true);
	        	    dietCardiacChkBox.setChecked(false);
	        	    dietDiabeticChkBox.setChecked(false);
	        	    dietCardiacDiabeticChkBox.setChecked(false);
	        	    dietNPOChkBox.setChecked(false);
	        	    dietNPOAfterChkBox.setChecked(false);
	        	}
	        }
	    });	       
	    
	    dietCardiacChkBox.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v)
	        {
	        	if(((CheckedTextView) v).isChecked()) {
	        		((CheckedTextView) v).toggle();
	        	} else {     	    
	        	    dietRegularChkBox.setChecked(false);
	        	    dietCardiacChkBox.setChecked(true);
	        	    dietDiabeticChkBox.setChecked(false);
	        	    dietCardiacDiabeticChkBox.setChecked(false);
	        	    dietNPOChkBox.setChecked(false);
	        	    dietNPOAfterChkBox.setChecked(false);
	        	}
	        }
	    });	 
	    
	    dietDiabeticChkBox.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v)
	        {
	        	if(((CheckedTextView) v).isChecked()) {
	        		((CheckedTextView) v).toggle();
	        	} else {     	    
	        	    dietRegularChkBox.setChecked(false);
	        	    dietCardiacChkBox.setChecked(false);
	        	    dietDiabeticChkBox.setChecked(true);
	        	    dietCardiacDiabeticChkBox.setChecked(false);
	        	    dietNPOChkBox.setChecked(false);
	        	    dietNPOAfterChkBox.setChecked(false);
	        	}
	        }
	    });	 
	    
	    dietCardiacDiabeticChkBox.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v)
	        {
	        	if(((CheckedTextView) v).isChecked()) {
	        		((CheckedTextView) v).toggle();
	        	} else {     	    
	        	    dietRegularChkBox.setChecked(false);
	        	    dietCardiacChkBox.setChecked(false);
	        	    dietDiabeticChkBox.setChecked(false);
	        	    dietCardiacDiabeticChkBox.setChecked(true);
	        	    dietNPOChkBox.setChecked(false);
	        	    dietNPOAfterChkBox.setChecked(false);
	        	}
	        }
	    });	 
	    
	    dietNPOChkBox.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v)
	        {
	        	if(((CheckedTextView) v).isChecked()) {
	        		((CheckedTextView) v).toggle();
	        	} else {     	    
	        	    dietRegularChkBox.setChecked(false);
	        	    dietCardiacChkBox.setChecked(false);
	        	    dietDiabeticChkBox.setChecked(false);
	        	    dietCardiacDiabeticChkBox.setChecked(false);
	        	    dietNPOChkBox.setChecked(true);
	        	    dietNPOAfterChkBox.setChecked(false);
	        	}
	        }
	    });	 
	    
	    dietNPOAfterChkBox.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v)
	        {
	        	if(((CheckedTextView) v).isChecked()) {
	        		((CheckedTextView) v).toggle();
	        	} else {     	    
	        	    dietRegularChkBox.setChecked(false);
	        	    dietCardiacChkBox.setChecked(false);
	        	    dietDiabeticChkBox.setChecked(false);
	        	    dietCardiacDiabeticChkBox.setChecked(false);
	        	    dietNPOChkBox.setChecked(false);
	        	    dietNPOAfterChkBox.setChecked(true);
	        	}
	        }
	    });	 
      return fragView;
   }
}
