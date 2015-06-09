package com.example.simtern1;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

public class AdditionalOrdersFragment extends Fragment{

    ArrayList<String> m_LabListArray;
    ArrayList<String> m_PostSearchListArray;
    ArrayList<String> m_AddedOrdersArray;
    EditText searchEditText;
    ArrayAdapter<String> listAdapter;
    ArrayAdapter<String> addedListAdapter;
    ListView additionalOrderListView;
    ListView addedOrderListView;
    @Override
   public View onCreateView(LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
      /**
       * Inflate the layout for this fragment
       */
	  View fragView = inflater.inflate(
			  R.layout.additional_orders_fragment_layout, container, false);

       searchEditText = (EditText)fragView.findViewById(R.id.search_edit_text);

       m_LabListArray = (ArrayList<String>)readTextFileAsList(getActivity().getApplicationContext(),R.raw.additional_orders_list);
       m_LabListArray.addAll((ArrayList<String>)readTextFileAsList(getActivity().getApplicationContext(),R.raw.labs_list));
       m_PostSearchListArray = new ArrayList<String>(m_LabListArray);
       //m_LabListArray = new ArrayList<String>();
       //m_LabListArray.addAll(labListStrings);
       // m_PostSearchListArray.addAll(labListStrings);
       additionalOrderListView = (ListView)fragView.findViewById(R.id.orders_search_result_listview);

       listAdapter = new ArrayAdapter<String>(getActivity(),R.layout.exams_list_view_item,//android.R.layout.simple_list_item_1,
               m_PostSearchListArray);//android.R.id.text1,

        additionalOrderListView.setAdapter(listAdapter);
        additionalOrderListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        additionalOrderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                //final String item = (String) parent.getItemAtPosition(position);
               // updateExamsTextView(listview, currentTextView);
            }

        });
        //get the reference for the added orders listview, store it to the member variable
        addedOrderListView = (ListView)fragView.findViewById(R.id.added_orders_listview);
        m_AddedOrdersArray = new ArrayList<String>();
        addedListAdapter= new ArrayAdapter<String>(getActivity(),R.layout.exams_list_view_item,
                m_AddedOrdersArray);
        addedOrderListView.setAdapter(addedListAdapter);
        addedOrderListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);


        Button searchButton = (Button) fragView.findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onClickSearchOrders(v);
            }
        });

        Button addButton = (Button) fragView.findViewById(R.id.add_orders_button);
        addButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onClickAddOrders(v);
            }
        });
        // ListView Item Click Listener
   /*    listView.setOnItemClickListener(new OnItemClickListener() {

           @Override
           public void onItemClick(AdapterView<?> parent, View view,
                                   int position, long id) {

               // ListView Clicked item index
               int itemPosition     = position;

               // ListView Clicked item value
               String  itemValue    = (String) listView.getItemAtPosition(position);

               // Show Alert
               Toast.makeText(getApplicationContext(),
                       "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                       .show();

           }*/

           //additionalOrderListView.add
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

    public void onClickSearchOrders(View view) {
        String searchTerm = searchEditText.getText().toString();
        ArrayList newSearchList = new ArrayList<String>();
        for(int i = 0; i < m_LabListArray.size(); i++) {
            if(m_LabListArray.get(i).contains(searchTerm)){
                newSearchList.add(m_LabListArray.get(i));
            }
        }
       // m_PostSearchListArray = newSearchList;
        additionalOrderListView.clearChoices();
        listAdapter.clear();
        listAdapter.addAll(newSearchList);

        listAdapter.notifyDataSetChanged();
        //searchEditText.getText();
       //  m_LabListArray
    }
    public void onClickAddOrders(View view) {
        SparseBooleanArray checked = additionalOrderListView.getCheckedItemPositions();
        ArrayList newAddList = new ArrayList<String>(m_AddedOrdersArray);
        for(int i = 0; i < m_PostSearchListArray.size(); i++) {
            if(checked.get(i)) {
                newAddList.add(m_PostSearchListArray.get(i));
            }
            //if(m_LabListArray.get(i).contains(searchTerm)){
            //    newSearchList.add(m_LabListArray.get(i));
            //}
        }
        addedOrderListView.clearChoices();
        addedListAdapter.clear();
        addedListAdapter.addAll(newAddList);
        addedListAdapter.notifyDataSetChanged();

        for(int j = m_PostSearchListArray.size()-1; j>=0; j--) {
            if(checked.get(j)) {
                m_LabListArray.remove(m_PostSearchListArray.get(j));
                m_PostSearchListArray.remove(j);

                //need to somehow remove this from master list as well, otherwise it will
                //repopulate
            }
        }
        additionalOrderListView.clearChoices();
       // additionalOrderListView.requestLayout();
      //  listAdapter.clear();
      //  listAdapter.addAll(m_PostSearchListArray);
        listAdapter.notifyDataSetChanged();
}
    /*public void setLearningCaseFileName(String lcfn) {
        LearningCaseFileName = lcfn;

    }*/

    //TODO   -  option to remove from added .
    //TODO   -  proceed to check if response are correct.
    //TODO  -  store response, whether correct or not
    //TODO  -  When correct, close all tabs and fire up day 0 and day 1
}
