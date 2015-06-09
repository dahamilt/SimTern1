package com.example.simtern1;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;

public class OrdersFragment extends Fragment{

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
                   ivFluidsSalineLockChkBox.setChecked(false);
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
                   ivFluidsSalineLockChkBox.setChecked(false);
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
                   ivFluidsSalineLockChkBox.setChecked(false);
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
                   ivFluidsSalineLockChkBox.setChecked(false);
               }
           }
       });
       ivFluidsSalineLockChkBox.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               if(((CheckedTextView) v).isChecked()) {
                   ((CheckedTextView) v).toggle();
               } else {
                   ivFluidsNSChkBox.setChecked(false);
                   ivFluids12NSChkBox.setChecked(false);
                   ivFluidsD512NSChkBox.setChecked(false);
                   ivFluidsD512NSWith20ChkBox.setChecked(false);
                   ivFluidsSalineLockChkBox.setChecked(true);
               }
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
       return fragView;
   }
    public void onClickProceed(View view) {
       /* CheckedTextView admitToMedFloorChkBox;
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
        CheckedTextView dvtNotIndicatedChkBox;*/
    }

}
