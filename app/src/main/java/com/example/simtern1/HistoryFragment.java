package com.example.simtern1;

//import java.io.IOException;
import java.io.IOException;
import java.io.InputStream;
//import android.content.res.AssetManager;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HistoryFragment extends Fragment{
	private String LearningCaseFileName = "";
	private String ChiefComplaint = "";
	private String HistoryOfPresentIllness = "";
	private String ReviewOfSystems = "";
	private String PastMedicalHistory = "";
	private String PastSurgicalHistory = "";
	private String Medications = "";
	private String Allergies = "";
	private String FamilyHistory = "";
	private String SocialHistory = "";
	private String VitalSigns = "";
	
   @Override
   public View onCreateView(LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
      /**
       * Inflate the layout for this fragment
       */
	   
		View fragView = inflater.inflate(
				R.layout.history_fragment_layout, container, false);
		XmlPullParser parser = Xml.newPullParser();
		try {
			InputStream in_s = getActivity().getApplicationContext().getAssets().open(LearningCaseFileName);
	        parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);

            parseXML(parser);

		} catch (XmlPullParserException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TextView currentView = (TextView)fragView.findViewById(R.id.ChiefComplaintTextView);
		currentView.setText(ChiefComplaint);
		currentView = (TextView)fragView.findViewById(R.id.HistoryOfPresentIllnessTextView);
		currentView.setText(HistoryOfPresentIllness);
		currentView = (TextView)fragView.findViewById(R.id.ReviewOfSystemsTextView);
		currentView.setText(ReviewOfSystems);
		currentView = (TextView)fragView.findViewById(R.id.PastMedicalHistoryTextView);
		currentView.setText(PastMedicalHistory);
		currentView = (TextView)fragView.findViewById(R.id.PastSurgicalHistoryTextView);
		currentView.setText(PastSurgicalHistory);
		currentView = (TextView)fragView.findViewById(R.id.MedicationsTextView);
		currentView.setText(Medications);
		currentView = (TextView)fragView.findViewById(R.id.AllergiesTextView);
		currentView.setText(Allergies);
		currentView = (TextView)fragView.findViewById(R.id.FamilyHistoryTextView);
		currentView.setText(FamilyHistory);
		currentView = (TextView)fragView.findViewById(R.id.SocialHistoryTextView);
		currentView.setText(SocialHistory);
		currentView = (TextView)fragView.findViewById(R.id.VitalSignsTextView);
		currentView.setText(VitalSigns);
      return fragView;
   }
   
	private void parseXML(XmlPullParser parser) throws XmlPullParserException,IOException
	{
		//ArrayList<product> products = null;
       int eventType = parser.getEventType();
       //Product currentProduct = null;
       String text = "";
       while (eventType != XmlPullParser.END_DOCUMENT){
           String name = null;
           switch (eventType){
               case XmlPullParser.START_DOCUMENT:
                   break;
               case XmlPullParser.START_TAG:
                   name = parser.getName();

                   break;
               case XmlPullParser.END_TAG:
                   name = parser.getName();
                   if (name.equalsIgnoreCase("ChiefComplaint")){
                	   ChiefComplaint = text;
                   } else if (name.equalsIgnoreCase("HistoryOfPresentIllness")){
                	   HistoryOfPresentIllness = text;
                   } else if (name.equalsIgnoreCase("ReviewOfSystems")){
                	   ReviewOfSystems = text;
                   } else if (name.equalsIgnoreCase("PastMedicalHistory")){
                	   PastMedicalHistory = text;
                   } else if (name.equalsIgnoreCase("PastSurgicalHistory")){
                	   PastSurgicalHistory = text;
                   } else if (name.equalsIgnoreCase("Medications")){
                	   Medications = text;
                   } else if (name.equalsIgnoreCase("Allergies")){
                	   Allergies = text;
                   } else if (name.equalsIgnoreCase("FamilyHistory")){
                	   FamilyHistory = text;
                   } else if (name.equalsIgnoreCase("SocialHistory")){
                	   SocialHistory = text;
                   } else if (name.equalsIgnoreCase("VitalSigns")){
                	   VitalSigns = text;
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
}
