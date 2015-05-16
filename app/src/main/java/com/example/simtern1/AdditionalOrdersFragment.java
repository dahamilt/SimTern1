package com.example.simtern1;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

public class AdditionalOrdersFragment extends Fragment{
   @Override
   public View onCreateView(LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
      /**
       * Inflate the layout for this fragment
       */
	  View fragView = inflater.inflate(
			  R.layout.additional_orders_fragment_layout, container, false);

       List<String> labListStrings = readTextFileAsList(getActivity().getApplicationContext(),R.raw.additional_orders_list);
       //res\raw\AdditionalOrdersList.txt
     /*  XmlPullParser parser = Xml.newPullParser();
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
       currentView.setText(HistoryOfPresentIllness);*/
      return fragView;
   }
  //  private String LearningCaseFileName = "";
    //private String ChiefComplaint = "";

    public static List<String> readTextFileAsList(Context ctx, int resId)
    {
        InputStream inputStream = ctx.getResources().openRawResource(resId);

        InputStreamReader inputreader = new InputStreamReader(inputStream);
        BufferedReader bufferedreader = new BufferedReader(inputreader);
        String line;
        List<String> list = new ArrayList<String>();

        try
        {
            while (( line = bufferedreader.readLine()) != null)
            {
                list.add(line);
            }
        }
        catch (IOException e)
        {
            return null;
        }
        return list;
    }
    /*private void parseXML(XmlPullParser parser) throws XmlPullParserException,IOException
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
                    }
                    break;
                case XmlPullParser.TEXT:
                    text = parser.getText();
                    break;
            }
            eventType = parser.next();
        }
    }*/


    /*public void setLearningCaseFileName(String lcfn) {
        LearningCaseFileName = lcfn;

    }*/
}
