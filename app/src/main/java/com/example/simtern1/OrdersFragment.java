package com.example.simtern1;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Pair;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;



public class OrdersFragment extends Fragment{

    private String LearningCaseFileName = "";

    CheckedTextView admitToMedFloorChkBox;
    CheckedTextView admitToMedFloorMonitorChkBox;
    CheckedTextView admitToStepDownChkBox;
    CheckedTextView admitToCriticalCareChkBox;
    CheckedTextView admitToObservationChkBox;

    CheckedTextView dietRegularChkBox;
    CheckedTextView dietCardiacChkBox;
    CheckedTextView dietDiabeticChkBox;
    CheckedTextView dietCardiacDiabeticChkBox;
    CheckedTextView dietNPOChkBox;
    CheckedTextView dietNPOAfterChkBox;

    CheckedTextView activityLevelAsToleratedChkBox;
    CheckedTextView activityLevelUpToChairChkBox;
    CheckedTextView activityLevelBedRestChkBox;
    CheckedTextView activityLevelBedRestWithChkBox;
    CheckedTextView activityLevelFallPrecautionsChkBox;

    CheckedTextView vitalSignsPerFloorChkBox;
    CheckedTextView vitalSignsEvery4ChkBox;
    CheckedTextView vitalSignsTelemetryChkBox;
    CheckedTextView vitalSignsContinuousChkBox;

    CheckedTextView neuroChecksEvery8ChkBox;
    CheckedTextView neuroChecksEvery4ChkBox;
    CheckedTextView neuroChecksEvery2ChkBox;
    CheckedTextView neuroChecksNotIndicatedChkBox;

    CheckedTextView ivFluidsNSChkBox;
    CheckedTextView ivFluids12NSChkBox;
    CheckedTextView ivFluidsD512NSChkBox;
    CheckedTextView ivFluidsD512NSWith20ChkBox;
    CheckedTextView ivFluidsSalineLockChkBox;

    CheckedTextView dvtLovenox40OnceChkBox;
    CheckedTextView dvtLovenox40TwiceChkBox;
    CheckedTextView dvtHeparinOnceChkBox;
    CheckedTextView dvtHeparinTwiceChkBox;
    CheckedTextView dvtCompressionChkBox;
    CheckedTextView dvtNotIndicatedChkBox;

    ArrayList<Pair<String,String> > requiredOrdersArray = new ArrayList<Pair<String,String> >();
    ArrayList<Pair<String,String> > requiredOptionOrdersArray = new ArrayList<Pair<String,String> >();

    //private HashMap<String,String> requiredOrders =new HashMap<String, String>();
    //private HashMap<String,String> requiredOptionOrders =new HashMap<String, String>();
    /*private HashMap<String,String> requiredDiet =new HashMap<String, String>();
    private HashMap<String,String> requiredOptionDiet =new HashMap<String, String>();
    private HashMap<String,String> requiredActivityLevel =new HashMap<String, String>();
    private HashMap<String,String> requiredOptionActivityLevel =new HashMap<String, String>();
    private HashMap<String,String> requiredVitals =new HashMap<String, String>();
    private HashMap<String,String> requiredOptionVitals =new HashMap<String, String>();
    private HashMap<String,String> requiredNeuro =new HashMap<String, String>();
    private HashMap<String,String> requiredOptionNeuro =new HashMap<String, String>();
    private HashMap<String,String> requiredIvFluids =new HashMap<String, String>();
    private HashMap<String,String> requiredOptionIvFluids =new HashMap<String, String>();
    private HashMap<String,String> requiredDvt =new HashMap<String, String>();
    private HashMap<String,String> requiredOptionDvt =new HashMap<String, String>();*/

    @Override
   public View onCreateView(LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
      /**
       * Inflate the layout for this fragment
       */
		View fragView = inflater.inflate(
				R.layout.orders_fragment_layout, container, false);
	   
		
	    admitToMedFloorChkBox = (CheckedTextView) fragView.findViewById(
	    		R.id.admit_to_medical_floor_check);
	    admitToMedFloorMonitorChkBox = (CheckedTextView) fragView.findViewById(
	    		R.id.admit_to_medical_floor_monitor_check);
	    admitToStepDownChkBox = (CheckedTextView) fragView.findViewById(
	       		R.id.admit_to_step_down_icu_check);
	    admitToCriticalCareChkBox = (CheckedTextView) fragView.findViewById(
	    	    R.id.admit_to_critical_care_check);
	    admitToObservationChkBox = (CheckedTextView) fragView.findViewById(
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
	    
	    dietRegularChkBox = (CheckedTextView) fragView.findViewById(
	    		R.id.diet_regular_check);
	    dietCardiacChkBox = (CheckedTextView) fragView.findViewById(
	    		R.id.diet_cardiac_check);
	    dietDiabeticChkBox = (CheckedTextView) fragView.findViewById(
	       		R.id.diet_diabetic_check);
	    dietCardiacDiabeticChkBox = (CheckedTextView) fragView.findViewById(
	    	    R.id.diet_cardiac_diabetic_check);
	    dietNPOChkBox = (CheckedTextView) fragView.findViewById(
	    	    R.id.diet_npo_check);
	    dietNPOAfterChkBox = (CheckedTextView) fragView.findViewById(
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

       activityLevelAsToleratedChkBox = (CheckedTextView) fragView.findViewById(
               R.id.activity_level_as_tolerated_check);
       activityLevelUpToChairChkBox = (CheckedTextView) fragView.findViewById(
               R.id.activity_level_up_to_chair_check);
       activityLevelBedRestChkBox = (CheckedTextView) fragView.findViewById(
               R.id.activity_level_bed_rest_check);
       activityLevelBedRestWithChkBox = (CheckedTextView) fragView.findViewById(
               R.id.activity_level_bed_rest_with_check);
       activityLevelFallPrecautionsChkBox = (CheckedTextView) fragView.findViewById(
               R.id.activity_level_fall_precautions_check);

       activityLevelAsToleratedChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               //if(((CheckedTextView) v).isChecked()) {
               ((CheckedTextView) v).toggle();
              /* } else {
               activityLevelAsToleratedChkBox.setChecked(false);
               activityLevelUpToChairChkBox.setChecked(false);
               activityLevelBedRestChkBox.setChecked(false);
               activityLevelBedRestWithChkBox.setChecked(false);
               activityLevelFallPrecautionsChkBox.setChecked(false);
           }*/
           }
       });
       activityLevelUpToChairChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               //if(((CheckedTextView) v).isChecked()) {
               ((CheckedTextView) v).toggle();
              /* } else {
               activityLevelAsToleratedChkBox.setChecked(false);
               activityLevelUpToChairChkBox.setChecked(false);
               activityLevelBedRestChkBox.setChecked(false);
               activityLevelBedRestWithChkBox.setChecked(false);
               activityLevelFallPrecautionsChkBox.setChecked(false);
           }*/
           }
       });
       activityLevelBedRestChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               //if(((CheckedTextView) v).isChecked()) {
               ((CheckedTextView) v).toggle();
              /* } else {
               activityLevelAsToleratedChkBox.setChecked(false);
               activityLevelUpToChairChkBox.setChecked(false);
               activityLevelBedRestChkBox.setChecked(false);
               activityLevelBedRestWithChkBox.setChecked(false);
               activityLevelFallPrecautionsChkBox.setChecked(false);
           }*/
           }
       });
       activityLevelBedRestWithChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               //if(((CheckedTextView) v).isChecked()) {
               ((CheckedTextView) v).toggle();
              /* } else {
               activityLevelAsToleratedChkBox.setChecked(false);
               activityLevelUpToChairChkBox.setChecked(false);
               activityLevelBedRestChkBox.setChecked(false);
               activityLevelBedRestWithChkBox.setChecked(false);
               activityLevelFallPrecautionsChkBox.setChecked(false);
           }*/
           }
       });
       activityLevelFallPrecautionsChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               //if(((CheckedTextView) v).isChecked()) {
               ((CheckedTextView) v).toggle();
              /* } else {
               activityLevelAsToleratedChkBox.setChecked(false);
               activityLevelUpToChairChkBox.setChecked(false);
               activityLevelBedRestChkBox.setChecked(false);
               activityLevelBedRestWithChkBox.setChecked(false);
               activityLevelFallPrecautionsChkBox.setChecked(false);
           }*/
           }
       });

       vitalSignsPerFloorChkBox = (CheckedTextView) fragView.findViewById(
               R.id.vital_signs_per_floor_check);
       vitalSignsEvery4ChkBox = (CheckedTextView) fragView.findViewById(
               R.id.vital_signs_every_4_check);
       vitalSignsTelemetryChkBox = (CheckedTextView) fragView.findViewById(
               R.id.vital_signs_telemetry_check);
       vitalSignsContinuousChkBox = (CheckedTextView) fragView.findViewById(
               R.id.vital_signs_continuous_check);
       vitalSignsPerFloorChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               ((CheckedTextView) v).toggle();
           }
       });
       vitalSignsEvery4ChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               ((CheckedTextView) v).toggle();
           }
       });
       vitalSignsTelemetryChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               ((CheckedTextView) v).toggle();
           }
       });
       vitalSignsContinuousChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               ((CheckedTextView) v).toggle();
           }
       });
       neuroChecksEvery8ChkBox = (CheckedTextView) fragView.findViewById(
               R.id.neuro_checks_every_8_check);
       neuroChecksEvery4ChkBox = (CheckedTextView) fragView.findViewById(
               R.id.neuro_checks_every_4_check);
       neuroChecksEvery2ChkBox = (CheckedTextView) fragView.findViewById(
               R.id.neuro_checks_every_2_check);
       neuroChecksNotIndicatedChkBox = (CheckedTextView) fragView.findViewById(
               R.id.neuro_checks_not_indicated_check);

       neuroChecksEvery8ChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               if(((CheckedTextView) v).isChecked()) {
                    ((CheckedTextView) v).toggle();
               } else {
                   neuroChecksEvery8ChkBox.setChecked(true);
                   neuroChecksEvery4ChkBox.setChecked(false);
                   neuroChecksEvery2ChkBox.setChecked(false);
                   neuroChecksNotIndicatedChkBox.setChecked(false);
                }
           }
       });
       neuroChecksEvery4ChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               if(((CheckedTextView) v).isChecked()) {
               ((CheckedTextView) v).toggle();
               } else {
                   neuroChecksEvery8ChkBox.setChecked(false);
                   neuroChecksEvery4ChkBox.setChecked(true);
                   neuroChecksEvery2ChkBox.setChecked(false);
                   neuroChecksNotIndicatedChkBox.setChecked(false);
           }
           }
       });
       neuroChecksEvery2ChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               if(((CheckedTextView) v).isChecked()) {
               ((CheckedTextView) v).toggle();
               } else {
                   neuroChecksEvery8ChkBox.setChecked(false);
                   neuroChecksEvery4ChkBox.setChecked(false);
                   neuroChecksEvery2ChkBox.setChecked(true);
                   neuroChecksNotIndicatedChkBox.setChecked(false);
           }
           }
       });
       neuroChecksNotIndicatedChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               if(((CheckedTextView) v).isChecked()) {
               ((CheckedTextView) v).toggle();
               } else {
                   neuroChecksEvery8ChkBox.setChecked(false);
                   neuroChecksEvery4ChkBox.setChecked(false);
                   neuroChecksEvery2ChkBox.setChecked(false);
                   neuroChecksNotIndicatedChkBox.setChecked(true);
           }
           }
       });
       ivFluidsNSChkBox = (CheckedTextView) fragView.findViewById(
               R.id.iv_fluids_ns_check);
       ivFluids12NSChkBox = (CheckedTextView) fragView.findViewById(
               R.id.iv_fluids_half_ns_check);
       ivFluidsD512NSChkBox = (CheckedTextView) fragView.findViewById(
               R.id.iv_fluids_ds_half_ns_check);
       ivFluidsD512NSWith20ChkBox = (CheckedTextView) fragView.findViewById(
               R.id.iv_fluids_d5_half_ns_with_kcl_check);
       ivFluidsSalineLockChkBox = (CheckedTextView) fragView.findViewById(
               R.id.iv_fluids_saline_lock_check);

       ivFluidsNSChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               if(((CheckedTextView) v).isChecked()) {
                   ((CheckedTextView) v).toggle();
               } else {
                   ivFluidsNSChkBox.setChecked(true);
                   ivFluids12NSChkBox.setChecked(false);
                   ivFluidsD512NSChkBox.setChecked(false);
                   ivFluidsD512NSWith20ChkBox.setChecked(false);
                   //ivFluidsSalineLockChkBox.setChecked(false);
               }
           }
       });
       ivFluids12NSChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               if(((CheckedTextView) v).isChecked()) {
                   ((CheckedTextView) v).toggle();
               } else {
                   ivFluidsNSChkBox.setChecked(false);
                   ivFluids12NSChkBox.setChecked(true);
                   ivFluidsD512NSChkBox.setChecked(false);
                   ivFluidsD512NSWith20ChkBox.setChecked(false);
                   //ivFluidsSalineLockChkBox.setChecked(false);
               }
           }
       });
       ivFluidsD512NSChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               if(((CheckedTextView) v).isChecked()) {
                   ((CheckedTextView) v).toggle();
               } else {
                   ivFluidsNSChkBox.setChecked(false);
                   ivFluids12NSChkBox.setChecked(false);
                   ivFluidsD512NSChkBox.setChecked(true);
                   ivFluidsD512NSWith20ChkBox.setChecked(false);
                   //ivFluidsSalineLockChkBox.setChecked(false);
               }
           }
       });
       ivFluidsD512NSWith20ChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               if(((CheckedTextView) v).isChecked()) {
                   ((CheckedTextView) v).toggle();
               } else {
                   ivFluidsNSChkBox.setChecked(false);
                   ivFluids12NSChkBox.setChecked(false);
                   ivFluidsD512NSChkBox.setChecked(false);
                   ivFluidsD512NSWith20ChkBox.setChecked(true);
                   //ivFluidsSalineLockChkBox.setChecked(false);
               }
           }
       });
       ivFluidsSalineLockChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               //if(((CheckedTextView) v).isChecked()) {
                   ((CheckedTextView) v).toggle();
              /* } else {
                   ivFluidsNSChkBox.setChecked(false);
                   ivFluids12NSChkBox.setChecked(false);
                   ivFluidsD512NSChkBox.setChecked(false);
                   ivFluidsD512NSWith20ChkBox.setChecked(false);
                   ivFluidsSalineLockChkBox.setChecked(true);
               }*/
           }
       });

       dvtLovenox40OnceChkBox = (CheckedTextView) fragView.findViewById(
               R.id.dvt_lovenox_once_check);
       dvtLovenox40TwiceChkBox = (CheckedTextView) fragView.findViewById(
               R.id.dvt_lovenox_twice_check);
       dvtHeparinOnceChkBox = (CheckedTextView) fragView.findViewById(
               R.id.dvt_heparin_once_check);
       dvtHeparinTwiceChkBox = (CheckedTextView) fragView.findViewById(
               R.id.dvt_heparin_twice_check);
       dvtCompressionChkBox = (CheckedTextView) fragView.findViewById(
               R.id.dvt_compression_cuffs_check);
       dvtNotIndicatedChkBox = (CheckedTextView) fragView.findViewById(
               R.id.dvt_not_indicated_check);

       dvtLovenox40OnceChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               if(((CheckedTextView) v).isChecked()) {
                   ((CheckedTextView) v).toggle();
               } else {
                   dvtLovenox40OnceChkBox.setChecked(true);
                   dvtLovenox40TwiceChkBox.setChecked(false);
                   //dvtHeparinOnceChkBox.setChecked(false);
                   //dvtHeparinTwiceChkBox.setChecked(false);
                   //dvtCompressionChkBox.setChecked(false);
                   dvtNotIndicatedChkBox.setChecked(false);
               }
           }
       });
       dvtLovenox40TwiceChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               if(((CheckedTextView) v).isChecked()) {
                   ((CheckedTextView) v).toggle();
               } else {
                   dvtLovenox40OnceChkBox.setChecked(false);
                   dvtLovenox40TwiceChkBox.setChecked(true);
                   //dvtHeparinOnceChkBox.setChecked(false);
                   //dvtHeparinTwiceChkBox.setChecked(false);
                   //dvtCompressionChkBox.setChecked(false);
                   dvtNotIndicatedChkBox.setChecked(false);
               }
           }
       });
       dvtHeparinOnceChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               if(((CheckedTextView) v).isChecked()) {
                   ((CheckedTextView) v).toggle();
               } else {
                   //dvtLovenox40OnceChkBox.setChecked(true);
                   //dvtLovenox40TwiceChkBox.setChecked(false);
                   dvtHeparinOnceChkBox.setChecked(true);
                   dvtHeparinTwiceChkBox.setChecked(false);
                   //dvtCompressionChkBox.setChecked(false);
                   dvtNotIndicatedChkBox.setChecked(false);
               }
           }
       });
       dvtHeparinTwiceChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               if(((CheckedTextView) v).isChecked()) {
                   ((CheckedTextView) v).toggle();
               } else {
                   //dvtLovenox40OnceChkBox.setChecked(true);
                   //dvtLovenox40TwiceChkBox.setChecked(false);
                   dvtHeparinOnceChkBox.setChecked(false);
                   dvtHeparinTwiceChkBox.setChecked(true);
                  // dvtCompressionChkBox.setChecked(false);
                   dvtNotIndicatedChkBox.setChecked(false);
               }
           }
       });
       dvtCompressionChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               if(((CheckedTextView) v).isChecked()) {
                   ((CheckedTextView) v).toggle();
               } else {
                  // dvtLovenox40OnceChkBox.setChecked(true);
                  // dvtLovenox40TwiceChkBox.setChecked(false);
                  // dvtHeparinOnceChkBox.setChecked(false);
                  //dvtHeparinTwiceChkBox.setChecked(false);
                   dvtCompressionChkBox.setChecked(true);
                   dvtNotIndicatedChkBox.setChecked(false);
               }
           }
       });
       dvtNotIndicatedChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               if(((CheckedTextView) v).isChecked()) {
                   ((CheckedTextView) v).toggle();
               } else {
                   dvtLovenox40OnceChkBox.setChecked(false);
                   dvtLovenox40TwiceChkBox.setChecked(false);
                   dvtHeparinOnceChkBox.setChecked(false);
                   dvtHeparinTwiceChkBox.setChecked(false);
                   dvtCompressionChkBox.setChecked(false);
                   dvtNotIndicatedChkBox.setChecked(true);
               }
           }
       });

       Button proceedButton = (Button) fragView.findViewById(R.id.proceed_to_additional_orders_button);
       proceedButton.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View v)
           {
               onClickProceed(v);
           }
       });

        XmlPullParser parser = Xml.newPullParser();
        try {
            InputStream in_s = getActivity().getApplicationContext().getAssets().open(LearningCaseFileName);
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);

            parseXML(parser);

        } catch (XmlPullParserException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

       return fragView;
   }
    public void onClickProceed(View view) {

        boolean AdmitToOptionsGood = false, AdmitToInit = false;
        boolean DietOptionsGood = false, DietInit = false;
        boolean ActivityOptionsGood = false, ActivityInit = false;
        boolean VitalOptionsGood = false, VitalInit = false;
        boolean NeuroOptionsGood = false, NeuroInit = false;
        boolean IVOptionsGood = false, IVInit = false;
        boolean DVTOptionsGood = false, DVInit = false;

        for(int i = 0;  i<requiredOptionOrdersArray.size(); i++) {
            if(requiredOptionOrdersArray.get(i).first.equalsIgnoreCase("AdmitTo")) {
                AdmitToInit = true;
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Medical floor")){
                    if (admitToMedFloorChkBox.isChecked()) {
                        AdmitToOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Medical floor with monitor")) {
                    if (admitToMedFloorMonitorChkBox.isChecked()) {
                        AdmitToOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Step down ICU")) {
                    if (admitToStepDownChkBox.isChecked()) {
                        AdmitToOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Critical Care")) {
                    if (admitToCriticalCareChkBox.isChecked()) {
                        AdmitToOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Observation")) {
                    if (admitToObservationChkBox.isChecked()) {
                        AdmitToOptionsGood = true;
                    }
                }
            } else if(requiredOptionOrdersArray.get(i).first.equalsIgnoreCase("Diet")){
                DietInit = true;
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Regular")){
                    if (dietRegularChkBox.isChecked()) {
                        DietOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second .equalsIgnoreCase("Cardiac")){
                    if (dietCardiacChkBox.isChecked()) {
                        DietOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Diabetic")){
                    if (dietDiabeticChkBox.isChecked()) {
                        DietOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Cardiac Diabetic")){
                    if (dietCardiacDiabeticChkBox.isChecked()) {
                        DietOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("NPO")) {
                    if (dietNPOChkBox.isChecked()) {
                        DietOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("NPO after midnight for procedure")){
                    if (dietNPOAfterChkBox.isChecked()) {
                        DietOptionsGood = true;
                    }
                }
            } else if(requiredOptionOrdersArray.get(i).first.equalsIgnoreCase("Activity")){
                ActivityInit = true;
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("As tolerated")){
                    if (activityLevelAsToleratedChkBox.isChecked()) {
                        ActivityOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Up to chair")){
                    if (activityLevelUpToChairChkBox.isChecked()) {
                        ActivityOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Bed rest")){
                    if (activityLevelBedRestChkBox.isChecked()) {
                        ActivityOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Bed rest with bathroom privileges")){
                    if (activityLevelBedRestWithChkBox.isChecked()) {
                        ActivityOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Fall precautions")){
                    if (activityLevelFallPrecautionsChkBox.isChecked()) {
                        ActivityOptionsGood = true;
                    }
                }
            } else if(requiredOptionOrdersArray.get(i).first.equalsIgnoreCase("Vital")){
                VitalInit = true;
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Per floor routine")){
                    if (vitalSignsPerFloorChkBox.isChecked()) {
                        VitalOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Every 4 hours")){
                    if (vitalSignsEvery4ChkBox.isChecked()) {
                        VitalOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Telemetry")){
                    if (vitalSignsTelemetryChkBox.isChecked()) {
                        VitalOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Continuous pulse oximetry")){
                    if (vitalSignsContinuousChkBox.isChecked()) {
                        VitalOptionsGood = true;
                    }
                }
            } else if(requiredOptionOrdersArray.get(i).first.equalsIgnoreCase("Neuro")){
                NeuroInit = true;
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Every 8 hours")){
                    if (neuroChecksEvery8ChkBox.isChecked()) {
                        NeuroOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Every 4 hours")){
                    if (neuroChecksEvery4ChkBox.isChecked()) {
                        NeuroOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Every 2 hours")){
                    if (neuroChecksEvery2ChkBox.isChecked()) {
                        NeuroOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Not indicated")){
                    if (neuroChecksNotIndicatedChkBox.isChecked()) {
                        NeuroOptionsGood = true;
                    }
                }
            } else if(requiredOptionOrdersArray.get(i).first.equalsIgnoreCase("IV")){
                IVInit = true;
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("NS")){
                    if (ivFluidsNSChkBox.isChecked()) {
                        IVOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("1/2NS")){
                    if (ivFluids12NSChkBox.isChecked()) {
                        IVOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("D5 1/2NS")){
                    if (ivFluidsD512NSChkBox.isChecked()) {
                        IVOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("D5 1/2NS with 20 mEq KCl")){
                    if (ivFluidsD512NSWith20ChkBox.isChecked()) {
                        IVOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Saline lock")){
                    if (ivFluidsSalineLockChkBox.isChecked()) {
                        IVOptionsGood = true;
                    }
                }
            } else if(requiredOptionOrdersArray.get(i).first.equalsIgnoreCase("DVT")){
                DVInit = true;
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Lovenox 40mg subcutaneous once daily")){
                    if (dvtLovenox40OnceChkBox.isChecked()) {
                        DVTOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Lovenox 40mg subcutaneous twice daily")){
                    if (dvtLovenox40TwiceChkBox.isChecked()) {
                        DVTOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Heparin 5,000 units subcutaneous once daily")){
                    if (dvtHeparinOnceChkBox.isChecked()) {
                        DVTOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Heparin 5,000 units subcutaneous twice daily")){
                    if (dvtHeparinTwiceChkBox.isChecked()) {
                        DVTOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Compression cuffs")){
                    if (dvtCompressionChkBox.isChecked()) {
                        DVTOptionsGood = true;
                    }
                }
                if (requiredOptionOrdersArray.get(i).second.equalsIgnoreCase("Not indicated")){
                    if (dvtNotIndicatedChkBox.isChecked()) {
                        DVTOptionsGood = true;
                    }
                }
            }
        }

        boolean AdmitToGood = true;
        boolean DietGood = true;
        boolean ActivityGood = true;
        boolean VitalGood = true;
        boolean NeuroGood = true;
        boolean IVGood = true;
        boolean DVTGood = true;

        for(int i = 0;  i<requiredOrdersArray.size(); i++) {
            if(requiredOrdersArray.get(i).first.equalsIgnoreCase("AdmitTo")){
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Medical floor")){
                    if (!admitToMedFloorChkBox.isChecked()) {
                        AdmitToGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Medical floor with monitor")){
                    if (!admitToMedFloorMonitorChkBox.isChecked()) {
                        AdmitToGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Step down ICU")){
                    if (!admitToStepDownChkBox.isChecked()) {
                        AdmitToGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Critical Care")){
                    if (!admitToCriticalCareChkBox.isChecked()) {
                        AdmitToGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Observation")){
                    if (!admitToObservationChkBox.isChecked()) {
                        AdmitToGood = false;
                    }
                }
            } else if(requiredOrdersArray.get(i).first.equalsIgnoreCase("Diet")){
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Regular")){
                    if (dietRegularChkBox.isChecked()) {
                        DietGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Cardiac")){
                    if (!dietCardiacChkBox.isChecked()) {
                        DietGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Diabetic")){
                    if (!dietDiabeticChkBox.isChecked()) {
                        DietGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Cardiac Diabetic")){
                    if (!dietCardiacDiabeticChkBox.isChecked()) {
                        DietGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("NPO")){
                    if (!dietNPOChkBox.isChecked()) {
                        DietGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("NPO after midnight for procedure")){
                    if (!dietNPOAfterChkBox.isChecked()) {
                        DietGood = false;
                    }
                }
            } else if(requiredOrdersArray.get(i).first.equalsIgnoreCase("Activity")){
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("As tolerated")){
                    if (!activityLevelAsToleratedChkBox.isChecked()) {
                        ActivityGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Up to chair")){
                    if (!activityLevelUpToChairChkBox.isChecked()) {
                        ActivityGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Bed rest")){
                    if (!activityLevelBedRestChkBox.isChecked()) {
                        ActivityGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Bed rest with bathroom privileges")){
                    if (!activityLevelBedRestWithChkBox.isChecked()) {
                        ActivityGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Fall precautions")){
                    if (!activityLevelFallPrecautionsChkBox.isChecked()) {
                        ActivityGood = false;
                    }
                }
            } else if(requiredOrdersArray.get(i).first.equalsIgnoreCase("Vital")){
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Per floor routine")){
                    if (!vitalSignsPerFloorChkBox.isChecked()) {
                        VitalGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Every 4 hours")){
                    if (!vitalSignsEvery4ChkBox.isChecked()) {
                        VitalGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Telemetry")){
                    if (!vitalSignsTelemetryChkBox.isChecked()) {
                        VitalGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Continuous pulse oximetry")){
                    if (!vitalSignsContinuousChkBox.isChecked()) {
                        VitalGood = false;
                    }
                }
            } else if(requiredOrdersArray.get(i).first.equalsIgnoreCase("Neuro")){
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Every 8 hours")){
                    if (!neuroChecksEvery8ChkBox.isChecked()) {
                        NeuroGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Every 4 hours")){
                    if (!neuroChecksEvery4ChkBox.isChecked()) {
                        NeuroGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Every 2 hours")){
                    if (!neuroChecksEvery2ChkBox.isChecked()) {
                        NeuroGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Not indicated")){
                    if (!neuroChecksNotIndicatedChkBox.isChecked()) {
                        NeuroGood = false;
                    }
                }
            } else if(requiredOrdersArray.get(i).first.equalsIgnoreCase("IV")){
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("NS")){
                    if (!ivFluidsNSChkBox.isChecked()) {
                        IVGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("1/2NS")){
                    if (!ivFluids12NSChkBox.isChecked()) {
                        IVGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("D5 1/2NS")){
                    if (!ivFluidsD512NSChkBox.isChecked()) {
                        IVGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("D5 1/2NS with 20 mEq KCl")){
                    if (!ivFluidsD512NSWith20ChkBox.isChecked()) {
                        IVGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Saline lock")){
                    if (!ivFluidsSalineLockChkBox.isChecked()) {
                        IVGood = false;
                    }
                }
            } else if(requiredOrdersArray.get(i).first.equalsIgnoreCase("DVT")){
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Lovenox 40mg subcutaneous once daily")){
                    if (!dvtLovenox40OnceChkBox.isChecked()) {
                        DVTGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Lovenox 40mg subcutaneous twice daily")){
                    if (!dvtLovenox40TwiceChkBox.isChecked()) {
                        DVTGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Heparin 5,000 units subcutaneous once daily")){
                    if (!dvtHeparinOnceChkBox.isChecked()) {
                        DVTGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Heparin 5,000 units subcutaneous twice daily")){
                    if (!dvtHeparinTwiceChkBox.isChecked()) {
                        DVTGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Compression cuffs")){
                    if (!dvtCompressionChkBox.isChecked()) {
                        DVTGood = false;
                    }
                }
                if (requiredOrdersArray.get(i).second.equalsIgnoreCase("Not indicated")){
                    if (!dvtNotIndicatedChkBox.isChecked()) {
                        DVTGood = false;
                    }
                }
            }
        }


        String output = "";
        boolean goodToProceed = true;
        if(!AdmitToGood || (AdmitToInit&&!AdmitToOptionsGood)){
            goodToProceed = false;
            output+= "Admit To selection incorrect\n";
        }
        if(!DietGood || (DietInit&&!DietOptionsGood)){
            goodToProceed = false;
            output+= "Diet selection incorrect\n";
        }
        if(!ActivityGood || (ActivityInit&&!ActivityOptionsGood)){
            goodToProceed = false;
            output+= "Activity selection incorrect\n";
        }
        if(!VitalGood || (VitalInit&&!VitalOptionsGood)){
            goodToProceed = false;
            output+= "Vital selection incorrect\n";
        }
        if(!NeuroGood || (NeuroInit&&!NeuroOptionsGood)){
            goodToProceed = false;
            output+= "Neuro selection incorrect\n";
        }
        if(!IVGood || (IVInit&&!IVOptionsGood)){
            goodToProceed = false;
            output+= "IV selection incorrect\n";
        }
        if(!DVTGood || (DVInit&&!DVTOptionsGood)){
            goodToProceed = false;
            output+= "DVT selection incorrect\n";
        }
        output += "Please try again";
        if(goodToProceed){
            //lock out future selections and button
            //eventually save choices?
            //proceed to additional orders
            lockAllCheckboxes();
            switchToNextTab();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Incorrect Selections...");
            builder.setMessage(output);
            builder.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            //alertDialog.setIcon(R.drawable.icon);
            AlertDialog alert11 = builder.create();
            alert11.show();
        }
    }

    private void parseXML(XmlPullParser parser) throws XmlPullParserException,IOException
    {
        //ArrayList<product> products = null;
        int eventType = parser.getEventType();
        //Product currentProduct = null;


        //Ok... how do we check this.
        // Have 7 topics.
        // for each we'll have a list of selected options
        //Required Options mean that any of the following can be valid
        //Required means this must be selected.

        //for each


        String text = "";
        // TODO:  Handle XML files that have errors
        HashMap<String,String> requiredCurrent;
        boolean withinOrders = false;
        boolean withinAdmitTo = false;
        boolean withinDiet = false;
        boolean withinActivity = false;
        boolean withinVital = false;
        boolean withinDVT = false;
        boolean withinNeuro = false;
        boolean withinIV = false;
        boolean withinRequired = false;
        boolean withinRequiredOption = false;
       /* private HashMap<String,String> requiredAdmitTos =new HashMap<String, String>();
        private HashMap<String,String> requiredOptionAdmitTo =new HashMap<String, String>();
        private HashMap<String,String> requiredDiet =new HashMap<String, String>();
        private HashMap<String,String> requiredOptionDiet =new HashMap<String, String>();
        private HashMap<String,String> requiredActivityLevel =new HashMap<String, String>();
        private HashMap<String,String> requiredOptionActivityLevel =new HashMap<String, String>();
        private HashMap<String,String> requiredVitals =new HashMap<String, String>();
        private HashMap<String,String> requiredOptionVitals =new HashMap<String, String>();
        private HashMap<String,String> requiredNeuro =new HashMap<String, String>();
        private HashMap<String,String> requiredOptionNeuro =new HashMap<String, String>();
        private HashMap<String,String> requiredIvFluids =new HashMap<String, String>();
        private HashMap<String,String> requiredOptionIvFluids =new HashMap<String, String>();
        private HashMap<String,String> requiredDvt =new HashMap<String, String>();
        private HashMap<String,String> requiredOptionDvt =new HashMap<String, String>();*/

        while (eventType != XmlPullParser.END_DOCUMENT){
            String name = null;
            switch (eventType){
                case XmlPullParser.START_DOCUMENT:
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("Orders")) {
                        withinOrders = true;
                    }
                    if (withinOrders) {
                        if(name.equalsIgnoreCase("AdmitTo")){
                            withinAdmitTo = true;
                        }else if(name.equalsIgnoreCase("Diet")){
                            withinDiet = true;
                        }else if(name.equalsIgnoreCase("Activity")){
                            withinActivity = true;
                        }else if(name.equalsIgnoreCase("Vital")){
                            withinVital = true;
                        }else if(name.equalsIgnoreCase("DVT")){
                            withinDVT = true;
                        }else if(name.equalsIgnoreCase("Neuro")){
                            withinNeuro = true;
                        }else if(name.equalsIgnoreCase("IV")){
                            withinIV = true;
                        }

                           // if(parser.getAttributeCount()>0) {
                               // if(parser.getName()=="") {
                            if (name.equalsIgnoreCase("Required")){//parser.getAttributeName(0).equalsIgnoreCase("Required")) {
                                /*if(parser.getAttributeValue(0).equalsIgnoreCase("1")) {
                                    requiredExams.put(parser.getName(),true);
                                } else if(parser.getAttributeValue(0).equalsIgnoreCase("0")) {
                                    requiredExams.put(parser.getName(),false);
                                }*/
                                /*if(withinAdmitTo){
                                    requiredOrders.put("AdmitTo",parser.getText());
                                }else if(withinDiet){
                                    requiredOrders.put("Diet",parser.getText());
                                }else if(withinActivity){
                                    requiredOrders.put("Activity",parser.getText());
                                }else if(withinVital){
                                    requiredOrders.put("Vital",parser.getText());
                                }else if(withinDVT){
                                    requiredOrders.put("DVT",parser.getText());
                                }else if(withinNeuro){
                                    requiredOrders.put("Neuro",parser.getText());
                                }else if(withinIV){
                                    requiredOrders.put("IV",parser.getText());
                                }*/
                                withinRequired = true;

                            } else if (name.equalsIgnoreCase("RequiredOption")){//(parser.getAttributeName(0).equalsIgnoreCase("RequiredOption")) {
                               /* if(withinAdmitTo){
                                    requiredOptionOrders.put("AdmitTo",parser.getText());
                                }else if(withinDiet){
                                    requiredOptionOrders.put("Diet",parser.getText());
                                }else if(withinActivity){
                                    requiredOptionOrders.put("Activity",parser.getText());
                                }else if(withinVital){
                                    requiredOptionOrders.put("Vital",parser.getText());
                                }else if(withinDVT){
                                    requiredOptionOrders.put("DVT",parser.getText());
                                }else if(withinNeuro){
                                    requiredOptionOrders.put("Neuro",parser.getText());
                                }else if(withinIV){
                                    requiredOptionOrders.put("IV",parser.getText());
                                }*/
                                withinRequiredOption = true;
                            }



                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("Orders")) {
                        withinOrders = false;
                    }
                    else if(name.equalsIgnoreCase("AdmitTo")){
                        withinAdmitTo = false;
                    }else if(name.equalsIgnoreCase("Diet")){
                        withinDiet = false;
                    }else if(name.equalsIgnoreCase("Activity")){
                        withinActivity = false;
                    }else if(name.equalsIgnoreCase("Vital")){
                        withinVital = false;
                    }else if(name.equalsIgnoreCase("DVT")){
                        withinDVT = false;
                    }else if(name.equalsIgnoreCase("Neuro")){
                        withinNeuro = false;
                    }else if(name.equalsIgnoreCase("IV")){
                        withinIV = false;
                    }else if(name.equalsIgnoreCase("Required")){
                        if(withinAdmitTo){
                            Pair<String,String> tempPair= new Pair("AdmitTo",text);
                            requiredOrdersArray.add(tempPair);
                        }else if(withinDiet){
                            Pair<String,String> tempPair= new Pair("Diet",text);
                            requiredOrdersArray.add(tempPair);
                        }else if(withinActivity){
                            Pair<String,String> tempPair= new Pair("Activity",text);
                            requiredOrdersArray.add(tempPair);
                        }else if(withinVital){
                            Pair<String,String> tempPair= new Pair("Vital",text);
                            requiredOrdersArray.add(tempPair);
                        }else if(withinDVT){
                            Pair<String,String> tempPair= new Pair("DVT",text);
                            requiredOrdersArray.add(tempPair);
                        }else if(withinNeuro){
                            Pair<String,String> tempPair= new Pair("Neuro",text);
                            requiredOrdersArray.add(tempPair);
                        }else if(withinIV){
                            Pair<String,String> tempPair= new Pair("IV",text);
                            requiredOrdersArray.add(tempPair);
                        }
                        withinRequired = false;
                    } else if(name.equalsIgnoreCase("RequiredOption")){
                        if(withinAdmitTo){
                            Pair<String,String> tempPair= new Pair("AdmitTo",text);
                            requiredOptionOrdersArray.add(tempPair);
                        }else if(withinDiet){
                            Pair<String,String> tempPair= new Pair("Diet",text);
                            requiredOptionOrdersArray.add(tempPair);
                        }else if(withinActivity){
                            Pair<String,String> tempPair= new Pair("Activity",text);
                            requiredOptionOrdersArray.add(tempPair);
                        }else if(withinVital){
                            Pair<String,String> tempPair= new Pair("Vital",text);
                            requiredOptionOrdersArray.add(tempPair);
                        }else if(withinDVT){
                            Pair<String,String> tempPair= new Pair("DVT",text);
                            requiredOptionOrdersArray.add(tempPair);
                        }else if(withinNeuro){
                            Pair<String,String> tempPair= new Pair("Neuro",text);
                            requiredOptionOrdersArray.add(tempPair);
                        }else if(withinIV){
                            Pair<String,String> tempPair= new Pair("IV",text);
                            requiredOptionOrdersArray.add(tempPair);
                        }
                        withinRequiredOption = false;
                    }

                    break;
                case XmlPullParser.TEXT:
                    text = parser.getText();
                    break;
            }
            eventType = parser.next();
        }
    }
    public void setLearningCaseFileName(String lcfn) {
        LearningCaseFileName = lcfn;

    }

    private void switchToNextTab() {
        int tab =4;
        LearningCasesActivity activity = (LearningCasesActivity)getActivity();
        activity.activateAdditionalTab();
        activity.getActionBar().setSelectedNavigationItem(tab);
    }

    private void lockAllCheckboxes() {
        admitToMedFloorChkBox.setEnabled(false);
        admitToMedFloorMonitorChkBox.setEnabled(false);
        admitToStepDownChkBox.setEnabled(false);
        admitToCriticalCareChkBox.setEnabled(false);
        admitToObservationChkBox.setEnabled(false);

        dietRegularChkBox.setEnabled(false);
        dietCardiacChkBox.setEnabled(false);
        dietDiabeticChkBox.setEnabled(false);
        dietCardiacDiabeticChkBox.setEnabled(false);
        dietNPOChkBox.setEnabled(false);
        dietNPOAfterChkBox.setEnabled(false);

        activityLevelAsToleratedChkBox.setEnabled(false);
        activityLevelUpToChairChkBox.setEnabled(false);
        activityLevelBedRestChkBox.setEnabled(false);
        activityLevelBedRestWithChkBox.setEnabled(false);
        activityLevelFallPrecautionsChkBox.setEnabled(false);

        vitalSignsPerFloorChkBox.setEnabled(false);
        vitalSignsEvery4ChkBox.setEnabled(false);
        vitalSignsTelemetryChkBox.setEnabled(false);
        vitalSignsContinuousChkBox.setEnabled(false);

        neuroChecksEvery8ChkBox.setEnabled(false);
        neuroChecksEvery4ChkBox.setEnabled(false);
        neuroChecksEvery2ChkBox.setEnabled(false);
        neuroChecksNotIndicatedChkBox.setEnabled(false);

        ivFluidsNSChkBox.setEnabled(false);
        ivFluids12NSChkBox.setEnabled(false);
        ivFluidsD512NSChkBox.setEnabled(false);
        ivFluidsD512NSWith20ChkBox.setEnabled(false);
        ivFluidsSalineLockChkBox.setEnabled(false);

        dvtLovenox40OnceChkBox.setEnabled(false);
        dvtLovenox40TwiceChkBox.setEnabled(false);
        dvtHeparinOnceChkBox.setEnabled(false);
        dvtHeparinTwiceChkBox.setEnabled(false);
        dvtCompressionChkBox.setEnabled(false);
        dvtNotIndicatedChkBox.setEnabled(false);
    }
}
