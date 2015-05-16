package com.example.simtern1;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.support.v4.app.Fragment;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ListView;


public class ExamsFragment extends Fragment{
	private String LearningCaseFileName = "";
	private String GeneralText = "";
	private String HEENTText = "";
	private String CardiovascularText = "";
	private String RespiratoryText = "";
	private String AbdomenText = "";
	private String GenitourinaryText = "";
	private String ExtremitiesText = "";
	private String BackText = "";
	private String SkinText = "";
	private String NeurologicalText = "";
	private HashMap<String,Boolean> requiredExams =new HashMap<String, Boolean>();
	boolean correctSelections = false; 
	private SparseBooleanArray finalExamsSelection = new SparseBooleanArray();
   @Override

   public View onCreateView(LayoutInflater inflater,
		      ViewGroup container, Bundle savedInstanceState) {
	  /**
	   * Inflate the layout for this fragment
	   */
		View fragView = inflater.inflate(
				R.layout.exams_fragment_layout, container, false);
		//getActivity().setContentView(R.layout.exams_fragment_layout);
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
			
	    final ListView listview = (ListView) fragView.findViewById(R.id.exams_selection_listview);
	    String[] values = new String[] { "General", "HEENT", "Cardiovascular",
	        "Respiratory", "Abdomen", "Genitourinary", "Extremities", "Back",
	        "Skin", "Neurological" };

	    final ArrayList<String> list = new ArrayList<String>();
	    for (int i = 0; i < values.length; ++i) {
	      list.add(values[i]);
	    }
	    final TextView currentTextView = (TextView) fragView.findViewById(R.id.exams_output_textview);
	    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
	    		//android.R.layout.simple_list_item_multiple_choice, list);
	    		R.layout.exams_list_view_item, list);
	    listview.setAdapter(adapter);
	    listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
		    @Override
		    public void onItemClick(AdapterView<?> parent, final View view,
		            int position, long id) {
		        //final String item = (String) parent.getItemAtPosition(position);
		        updateExamsTextView(listview, currentTextView);
		    }

	    });	
		
		Button button = (Button) fragView.findViewById(R.id.proceed_button);
		button.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {
		    	if (!correctSelections) {
			        SparseBooleanArray checked = listview.getCheckedItemPositions();
			        //List<String> missingExams = new ArrayList<String>();
			        ///missingExams.clear();
			        String missingExams = "Missing Exams: \n";
			        correctSelections = true;
			        for (int i = 0; i < requiredExams.size(); i++) {			        	
		        		if(requiredExams.get(listview.getItemAtPosition(i).toString())) {
		        			if(!checked.get(i, false)){
		        				correctSelections = false;
		        				missingExams = missingExams +listview.getItemAtPosition(i).toString() + "\n";		        				
		        			}
		        		}
			        }
			        if(!correctSelections) {
			        	AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
			        	builder.setTitle("Missing Exams...");
			        	builder.setMessage(missingExams);
			        	builder.setPositiveButton("OK",
			                    new DialogInterface.OnClickListener() {
			                public void onClick(DialogInterface dialog, int id) {
			                    dialog.cancel();
			                }
			            });
			        	//alertDialog.setIcon(R.drawable.icon);
			        	AlertDialog alert11 = builder.create();
			        	alert11.show();
			        } else {
			        	finalExamsSelection = checked;	
			     	    listview.setEnabled(false);
			       	   // listview.setOnClickListener(null);
			        	switchToNextTab();
			        }
		    	}
		    }
		});
		if(correctSelections) {
			listview.setEnabled(false);
			for (int i=0; i<finalExamsSelection.size() ;i++) {
				listview.setItemChecked(i, finalExamsSelection.valueAt(i));
			}
		}
		updateExamsTextView(listview, currentTextView);
		return fragView;
    }
	   
    private void updateExamsTextView (ListView listview, TextView currentTextView) {
    	//final ListView listview = (ListView) .findViewById(R.id.exams_selection_listview);
    	
    	SparseBooleanArray checked = listview.getCheckedItemPositions();
    	//TextView currentTextView = (TextView) view.findViewById(R.id.exams_output_textview);
    	currentTextView.setText("");
       // ArrayList<String> checkedItems = new ArrayList<String>();
        for(int i = 0; i < checked.size(); i++){
            if(checked.valueAt(i)) {
                if(listview.getItemAtPosition(checked.keyAt(i)).toString().equalsIgnoreCase("General")) {
                	currentTextView.append("General: \n");
                	currentTextView.append(GeneralText);
                	currentTextView.append("\n\n");
                } else if(listview.getItemAtPosition(checked.keyAt(i)).toString().equalsIgnoreCase("HEENT")) {
                	currentTextView.append("HEENT: \n");
                	currentTextView.append(HEENTText);
                	currentTextView.append("\n\n");                	
                } else if(listview.getItemAtPosition(checked.keyAt(i)).toString().equalsIgnoreCase("Cardiovascular")) {
                	currentTextView.append("Cardiovascular: \n");
                	currentTextView.append(CardiovascularText);
                	currentTextView.append("\n\n");                	
                }  else if(listview.getItemAtPosition(checked.keyAt(i)).toString().equalsIgnoreCase("Respiratory")) {
                	currentTextView.append("Respiratory: \n");
                	currentTextView.append(RespiratoryText);
                	currentTextView.append("\n\n");                	
                }  else if(listview.getItemAtPosition(checked.keyAt(i)).toString().equalsIgnoreCase("Abdomen")) {
                	currentTextView.append("Abdomen: \n");
                	currentTextView.append(AbdomenText);
                	currentTextView.append("\n\n");                	
                }  else if(listview.getItemAtPosition(checked.keyAt(i)).toString().equalsIgnoreCase("Genitourinary")) {
                	currentTextView.append("Genitourinary: \n");
                	currentTextView.append(GenitourinaryText);
                	currentTextView.append("\n\n");                	
                }  else if(listview.getItemAtPosition(checked.keyAt(i)).toString().equalsIgnoreCase("Extremities")) {
                	currentTextView.append("Extremities: \n");
                	currentTextView.append(ExtremitiesText);
                	currentTextView.append("\n\n");                	
                }  else if(listview.getItemAtPosition(checked.keyAt(i)).toString().equalsIgnoreCase("Back")) {
                	currentTextView.append("Back: \n");
                	currentTextView.append(BackText);
                	currentTextView.append("\n\n");                	
                }  else if(listview.getItemAtPosition(checked.keyAt(i)).toString().equalsIgnoreCase("Skin")) {
                	currentTextView.append("Skin: \n");
                	currentTextView.append(SkinText);
                	currentTextView.append("\n\n");                	
                }  else if(listview.getItemAtPosition(checked.keyAt(i)).toString().equalsIgnoreCase("Neurological")) {
                	currentTextView.append("Neurological: \n");
                	currentTextView.append(NeurologicalText);
                	currentTextView.append("\n\n");                	
                }  
            }
        }
    }
   
	private void parseXML(XmlPullParser parser) throws XmlPullParserException,IOException
	{
		//ArrayList<product> products = null;
	   int eventType = parser.getEventType();
	   //Product currentProduct = null;
	   String text = "";
	   // TODO:  Handle XML files that have errors
	   boolean withinHistory = false;
       while (eventType != XmlPullParser.END_DOCUMENT){
           String name = null;
           switch (eventType){
               case XmlPullParser.START_DOCUMENT:
                   break;
               case XmlPullParser.START_TAG:
                   name = parser.getName();
                   if (name.equalsIgnoreCase("PhysicalExam")) {
                	   withinHistory = true;
                   }
                   if (withinHistory) {
	                   if(parser.getAttributeCount()>0 &&
	                		   parser.getAttributeName(0).equalsIgnoreCase("Required")) {
	                	   if(parser.getAttributeValue(0).equalsIgnoreCase("1")) {
	                		   requiredExams.put(parser.getName(),true);
	                	   } else if(parser.getAttributeValue(0).equalsIgnoreCase("0")) {
	                		   requiredExams.put(parser.getName(),false);
	                	   }
	                   }
                   }
                   break;
               case XmlPullParser.END_TAG:
                   name = parser.getName();
                   if (name.equalsIgnoreCase("PhysicalExam")) {
                	   withinHistory = false;
                   }
                   if (withinHistory) {
	                   if (name.equalsIgnoreCase("General")){
	                	   GeneralText = text;
	                   } else if (name.equalsIgnoreCase("HEENT")){
	                	   HEENTText = text;
	                   } else if (name.equalsIgnoreCase("Cardiovascular")){
	                	   CardiovascularText = text;
	                   } else if (name.equalsIgnoreCase("Respiratory")){
	                	   RespiratoryText = text;
	                   } else if (name.equalsIgnoreCase("Abdomen")){
	                	   AbdomenText = text;
	                   } else if (name.equalsIgnoreCase("Genitourinary")){
	                	   GenitourinaryText = text;
	                   } else if (name.equalsIgnoreCase("Extremities")){
	                	   ExtremitiesText = text;
	                   } else if (name.equalsIgnoreCase("Back")){
	                	   BackText = text;
	                   } else if (name.equalsIgnoreCase("Skin")){
	                	   SkinText = text;
	                   } else if (name.equalsIgnoreCase("Neurological")){
	                	   NeurologicalText = text;
	                   } 
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
   
   public SparseBooleanArray getFinalExamsSelection() {
	   return finalExamsSelection;
   }
   
   private void switchToNextTab() {
	   int tab =2; //or any number
	   LearningCasesActivity activity = (LearningCasesActivity)getActivity();  
	   activity.activateLabsTab();
	   activity.getActionBar().setSelectedNavigationItem(tab);
   }
   
}