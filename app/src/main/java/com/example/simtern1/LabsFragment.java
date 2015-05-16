package com.example.simtern1;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LabsFragment extends Fragment{
	private String LearningCaseFileName = "";
	private String WBCText = "";
	private String RBCText = "";
	private String HbText = "";
	private String HctText = "";
	private String RDWText = "";
	private String RBCMCVText = "";
	private String MCHCText = "";
	private String PltText = "";
	private String SodiumText = "";
	private String PotassiumText = "";
	private String ChlorideText = "";
	private String BicarbonateText = "";
	private String UreaNitrogenText = "";
	private String CreatineText = "";
	private String GlucoseText = "";
	private String CalciumText = "";
	private String ASTText = "";
	private String ALTText = "";
	private String AlkalinePhosphataseText = "";
	private String TotalBilirubinText = "";
	private String ProteinText = "";
	private String AlbuminText = "";
	private String PTTText = "";
	private String PTText = "";
	private String INRText = "";
 	boolean cbcRequested = false;
	boolean bmpRequested = false;
	boolean cmpRequested = false;
	boolean cfRequested = false; 
	final ArrayList<String> extraERLabsName = new ArrayList<String>();
	final ArrayList<String> extraERLabsValue = new ArrayList<String>();
	//final ArrayList<String> rRLabsName = new ArrayList<String>();
	//final ArrayList<String> rRLabsValue = new ArrayList<String>();
	final private HashMap<String,String> rRLabs =new HashMap<String, String>();
 	   
   @Override
   public View onCreateView(LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
      /**
       * Inflate the layout for this fragment
       */
		View fragView = inflater.inflate(
				R.layout.labs_fragment_layout, container, false);
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
		
		XmlPullParser rrparser = Xml.newPullParser();
		try {
			InputStream in_s = getActivity().getApplicationContext().getAssets().open("SimTernReferenceRanges.xml");
	        rrparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            rrparser.setInput(in_s, null);

            parseRRXml(rrparser);

		} catch (XmlPullParserException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RelativeLayout relativeLayout = (RelativeLayout)fragView.findViewById(R.id.labs_fragment_layout);
		int latestId = -1;
		final int dpValue = 20; // margin in dips
		final int dpValueRight = 90;
		final int dpValueLeft = 10;
		final float d = getActivity().getApplicationContext().getResources().getDisplayMetrics().density;
		final int margin = (int)(dpValue * d); // margin in pixels
		final int rightMargin = (int)(dpValueRight * d); // margin in pixels
		final int leftMargin = (int)(dpValueLeft * d); // margin in pixels
		if(cbcRequested) {
			
				RelativeLayout cbcView = (RelativeLayout)inflater.inflate( R.layout.labs_cbc_layout, null );
				latestId = cbcView.getId();
				RelativeLayout.LayoutParams llp = new RelativeLayout.LayoutParams(
			            LayoutParams.WRAP_CONTENT,
			            LayoutParams.WRAP_CONTENT);
				llp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
				llp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
				llp.setMargins(leftMargin, leftMargin, 0, 0);//(left, top, right, bottom);
				cbcView.setLayoutParams(llp);
				TextView currentView = (TextView)cbcView.findViewById(R.id.wbc);
				currentView.setText(WBCText);
				currentView = (TextView)cbcView.findViewById(R.id.RBC);
				currentView.setText(RBCText);
				currentView = (TextView)cbcView.findViewById(R.id.hemoglobin);
				currentView.setText(HbText);
				currentView = (TextView)cbcView.findViewById(R.id.hct);
				currentView.setText(HctText);
				currentView = (TextView)cbcView.findViewById(R.id.RDW);
				currentView.setText(RDWText);
				currentView = (TextView)cbcView.findViewById(R.id.MCV);
				currentView.setText(RBCMCVText);
				currentView = (TextView)cbcView.findViewById(R.id.MCHC);
				currentView.setText(MCHCText);
				currentView = (TextView)cbcView.findViewById(R.id.platelets);
				currentView.setText(PltText);
				relativeLayout.addView(cbcView);
				
				TextView newReferenceRange = new TextView(getActivity().getApplicationContext());
				RelativeLayout.LayoutParams rrparams = new RelativeLayout.LayoutParams(
			            LayoutParams.WRAP_CONTENT,
			            LayoutParams.WRAP_CONTENT);
 				newReferenceRange.setText("CBC Reference Ranges:\n"+rRLabs.get("CBC"));
				newReferenceRange.setTextSize(8);		
				
				rrparams.addRule(RelativeLayout.RIGHT_OF, latestId);
				rrparams.addRule(RelativeLayout.ALIGN_TOP, latestId);
				rrparams.setMargins(margin, 0, 0, 0);//(left, top, right, bottom);
				newReferenceRange.setLayoutParams(rrparams);
				newReferenceRange.setTextColor(Color.DKGRAY);
				relativeLayout.addView(newReferenceRange);
				
		}
		if(bmpRequested) {
			RelativeLayout bmpView = (RelativeLayout)inflater.inflate( R.layout.labs_bmp_layout, null );
			
			RelativeLayout.LayoutParams llp = new RelativeLayout.LayoutParams(
		            LayoutParams.WRAP_CONTENT,
		            LayoutParams.WRAP_CONTENT);
			if(latestId == -1){
				llp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
				llp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
				llp.setMargins(leftMargin, margin, 0, 0);//(left, top, right, bottom);
			} else {
				llp.addRule(RelativeLayout.BELOW, latestId);
				llp.addRule(RelativeLayout.ALIGN_LEFT, latestId);
				llp.setMargins(0, 0, 0, 0);//(left, top, right, bottom);
			}
			bmpView.setLayoutParams(llp);	
			latestId = bmpView.getId();
			TextView currentView = (TextView)bmpView.findViewById(R.id.sodium);
			currentView.setText(SodiumText);
			currentView = (TextView)bmpView.findViewById(R.id.potassium);
			currentView.setText(PotassiumText);
			currentView = (TextView)bmpView.findViewById(R.id.chloride);
			currentView.setText(ChlorideText);
			currentView = (TextView)bmpView.findViewById(R.id.bicarbonate);
			currentView.setText(BicarbonateText);
			currentView = (TextView)bmpView.findViewById(R.id.BUN);
			currentView.setText(UreaNitrogenText);
			currentView = (TextView)bmpView.findViewById(R.id.creatine);
			currentView.setText(CreatineText);
			currentView = (TextView)bmpView.findViewById(R.id.glucose);
			currentView.setText(GlucoseText);
			currentView = (TextView)bmpView.findViewById(R.id.calcium);
			currentView.setText(CalciumText);
			relativeLayout.addView(bmpView);
		}
		if(cfRequested) {
			RelativeLayout cfView = (RelativeLayout)inflater.inflate( R.layout.labs_cp_layout, null );
			
			RelativeLayout.LayoutParams llp = new RelativeLayout.LayoutParams(
		            LayoutParams.WRAP_CONTENT,
		            LayoutParams.WRAP_CONTENT);
			if(latestId == -1){
				llp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
				llp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
				llp.setMargins(leftMargin, margin, 0, 0);//(left, top, right, bottom);
			} else {
				llp.addRule(RelativeLayout.BELOW, latestId);
				llp.addRule(RelativeLayout.ALIGN_LEFT, latestId);
				llp.setMargins(0, 0, 0, 0);//(left, top, right, bottom);
			}
			cfView.setLayoutParams(llp);	
			latestId = cfView.getId();
			TextView currentView = (TextView)cfView.findViewById(R.id.ptt);
			currentView.setText(PTTText);
			currentView = (TextView)cfView.findViewById(R.id.pt);
			currentView.setText(PTText);
			currentView = (TextView)cfView.findViewById(R.id.inr);
			currentView.setText(INRText);
			relativeLayout.addView(cfView);
		}
		if(cmpRequested) {
			RelativeLayout cmpView = (RelativeLayout)inflater.inflate( R.layout.labs_cmp_layout, null );
			
			RelativeLayout.LayoutParams llp = new RelativeLayout.LayoutParams(
		            LayoutParams.WRAP_CONTENT,
		            LayoutParams.WRAP_CONTENT);
			if(latestId == -1){
				llp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
				llp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
				llp.setMargins(leftMargin, margin, 0, 0);//(left, top, right, bottom);
			} else {
				llp.addRule(RelativeLayout.BELOW, latestId);
				llp.addRule(RelativeLayout.ALIGN_LEFT, latestId);
				llp.setMargins(0, 0, 0, 0);//(left, top, right, bottom);
			}
			cmpView.setLayoutParams(llp);	
			latestId = cmpView.getId();
			TextView currentView = (TextView)cmpView.findViewById(R.id.ast);
			currentView.setText(ASTText);
			currentView = (TextView)cmpView.findViewById(R.id.alt);
			currentView.setText(ALTText);
			currentView = (TextView)cmpView.findViewById(R.id.alkaline_phosphatase);
			currentView.setText(AlkalinePhosphataseText);
			currentView = (TextView)cmpView.findViewById(R.id.total_bilirubin);
			currentView.setText(TotalBilirubinText);
			currentView = (TextView)cmpView.findViewById(R.id.protein);
			currentView.setText(ProteinText);
			currentView = (TextView)cmpView.findViewById(R.id.albumin);
			currentView.setText(AlbuminText);
			relativeLayout.addView(cmpView);
		}

		//get the values above working.  And then make the fishbone stuff an option as well.
		if( extraERLabsName.size()>0) {

			for (int i = 0; i<extraERLabsName.size(); i++) {
				TextView newTextView = new TextView(getActivity().getApplicationContext());
				newTextView.setText(extraERLabsName.get(i)+":");
				newTextView.setTextSize(8);
				
				RelativeLayout.LayoutParams llp = new RelativeLayout.LayoutParams(
			            LayoutParams.WRAP_CONTENT,
			            LayoutParams.WRAP_CONTENT);
						
				
				if(latestId == -1){
					llp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
					llp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
					llp.setMargins(leftMargin, margin*(i+1), 0, 0);//(left, top, right, bottom);
				} else {
					llp.addRule(RelativeLayout.BELOW, latestId);
					llp.addRule(RelativeLayout.ALIGN_LEFT, latestId);
					llp.setMargins(0, margin*(i+1), 0, 0);//(left, top, right, bottom);
				}
				newTextView.setLayoutParams(llp);
				newTextView.setTextColor(Color.DKGRAY);
				relativeLayout.addView(newTextView);
				
				TextView newTextView2 = new TextView(getActivity().getApplicationContext());
				newTextView2.setText(extraERLabsValue.get(i));
				newTextView2.setTextSize(8);
				
				RelativeLayout.LayoutParams llp2 = new RelativeLayout.LayoutParams(
			            LayoutParams.WRAP_CONTENT,
			            LayoutParams.WRAP_CONTENT);
						
				if(latestId == -1){
					llp2.setMargins(rightMargin+leftMargin, margin*(i+1),0 , 0);//(left, top, right, bottom);
					llp2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
					llp2.addRule(RelativeLayout.ALIGN_PARENT_TOP);
				} else {
					llp2.setMargins(rightMargin, margin*(i+1), 0, 0);//(left, top, right, bottom);
					llp2.addRule(RelativeLayout.BELOW, latestId);
					llp2.addRule(RelativeLayout.ALIGN_LEFT, latestId);
				}
				newTextView2.setLayoutParams(llp2);
				newTextView2.setTextColor(Color.DKGRAY);
				relativeLayout.addView(newTextView2);			
			}
		}
      return fragView;
   }
   private void parseRRXml(XmlPullParser parser)throws XmlPullParserException,IOException
	{
	   int eventType = parser.getEventType();
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
                  if (!name.equalsIgnoreCase("SimTernReferenceRanges")) {
                	  rRLabs.put(name,text);
                			
	               }
          
                  break;
              case XmlPullParser.TEXT:
           	   text = parser.getText();
           	   break;
          }
          eventType = parser.next();
      }
	}

	private void parseXML(XmlPullParser parser) throws XmlPullParserException,IOException
	{
	   int eventType = parser.getEventType();
	   String text = "";
	   
	   // TODO:  Handle XML files that have errors
	   boolean withinERLabs = false;
	   boolean withinCBC = false;
	   boolean withinBMP = false;
	   boolean withinCMP = false;
	   boolean withinCF = false;
      while (eventType != XmlPullParser.END_DOCUMENT){
          String name = null;
          switch (eventType){
              case XmlPullParser.START_DOCUMENT:
                  break;
              case XmlPullParser.START_TAG:
                  name = parser.getName();
                  if (name.equalsIgnoreCase("ERLabs")) {
               	   withinERLabs = true;
                  } else if(name.equalsIgnoreCase("CBC")) {
                	  cbcRequested = true;
                	  withinCBC = true;
                  } else if(name.equalsIgnoreCase("BMP")) {
                	  bmpRequested = true;
                	  withinBMP = true;
                  } else if(name.equalsIgnoreCase("CMP")) {
                	  cmpRequested = true;
                	  withinCMP = true;
                  } else if(name.equalsIgnoreCase("CoagulationFactors")) {
                	  cfRequested = true;
                	  withinCF = true;
                  }
                  break;
              case XmlPullParser.END_TAG:
                  name = parser.getName();
                  if (name.equalsIgnoreCase("ERLabs")) {
                	  withinERLabs = false;
                  } else if (withinERLabs) {
                	  if(name.equalsIgnoreCase("CBC")) {
                		  withinCBC = false;
                	  } else if(name.equalsIgnoreCase("BMP")) {
                		  withinBMP = false;
                	  } else if(name.equalsIgnoreCase("CMP")) {
                		  withinCMP = false;
                	  } else if(name.equalsIgnoreCase("CoagulationFactors")) {
                		  withinCF = false;
                	  } else if(withinCBC){
		                   if (name.equalsIgnoreCase("WBC")){
		                	   WBCText = text;
		                   } else if (name.equalsIgnoreCase("RBC")){
		                	   RBCText = text;
		                   } else if (name.equalsIgnoreCase("Hb")){
		                	   HbText = text;
		                   } else if (name.equalsIgnoreCase("Hct")){
		                	   HctText = text;
		                   } else if (name.equalsIgnoreCase("RDW")){
		                	   RDWText = text;
		                   } else if (name.equalsIgnoreCase("RBCMCV")){
		                	   RBCMCVText = text;
		                   } else if (name.equalsIgnoreCase("MCHC")){
		                	   MCHCText = text;
		                   } else if (name.equalsIgnoreCase("Plt")){
		                	   PltText = text;
		                   }
	                   } else if (withinBMP) {  
		                   if (name.equalsIgnoreCase("Sodium")){
		                	   SodiumText = text;
		                   } else if (name.equalsIgnoreCase("Potassium")){
		                	   PotassiumText = text;
		                   } else if (name.equalsIgnoreCase("Chloride")){
		                	   ChlorideText = text;
		                   } else if (name.equalsIgnoreCase("Bicarbonate")){
		                	   BicarbonateText = text;
		                   } else if (name.equalsIgnoreCase("UreaNitrogen")){
		                	   UreaNitrogenText = text;
		                   } else if (name.equalsIgnoreCase("Creatine")){
		                	   CreatineText = text;
		                   } else if (name.equalsIgnoreCase("Glucose")){
		                	   GlucoseText = text;
		                   } else if (name.equalsIgnoreCase("Calcium")){
		                	   CalciumText = text;
		                   }
	                   } else if (withinCMP){
		                   if (name.equalsIgnoreCase("AST")){
		                	   ASTText = text;
		                   } else if (name.equalsIgnoreCase("ALT")){
		                	   ALTText = text;
		                   } else if (name.equalsIgnoreCase("AlkalinePhosphatase")){
		                	   AlkalinePhosphataseText = text;
		                   } else if (name.equalsIgnoreCase("TotalBilirubin")){
		                	   TotalBilirubinText = text;
		                   } else if (name.equalsIgnoreCase("Protein")){
		                	   ProteinText = text;
		                   } else if (name.equalsIgnoreCase("Albumin")){
		                	   AlbuminText = text;
		                   }   
	                   } else if (withinCF) {
		                   if (name.equalsIgnoreCase("PTT")){
		                	   PTTText = text;
		                   } else if (name.equalsIgnoreCase("PT")){
		                	   PTText = text;
		                   } else if (name.equalsIgnoreCase("INR")){
		                	   INRText = text; 	   
		                   }
	                   } else {
	                	   extraERLabsName.add(name);
	                	   extraERLabsValue.add(text);
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
}
