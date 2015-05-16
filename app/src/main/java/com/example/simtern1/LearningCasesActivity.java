package com.example.simtern1;

//import android.app.ActionBar.Tab;
import android.app.Activity;
//import android.app.Fragment;
//import android.app.FragmentTransaction;
//import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
//import android.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import com.example.simtern1.HistoryFragment;
import com.example.simtern1.ExamsFragment;
import android.widget.TextView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LearningCasesActivity extends ActionBarActivity  {
	
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
	private String LearningCaseFileName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.learning_cases);
		LearningCaseFileName = "SimTernSampleCase.xml";
	    // setup action bar for tabs
	    android.support.v7.app.ActionBar actionBar = getSupportActionBar();
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    actionBar.setDisplayShowTitleEnabled(false);

	    android.support.v7.app.ActionBar.Tab tab = actionBar.newTab()
	                       .setText("History")
	                       .setTabListener(new TabListener<HistoryFragment>(
	                               this, "History", HistoryFragment.class,LearningCaseFileName));
	    actionBar.addTab(tab);

	    
	    
	    tab = actionBar.newTab()
	                   .setText("Exams")
	                   .setTabListener(new TabListener<ExamsFragment>(
	                           this, "Exams", ExamsFragment.class,LearningCaseFileName));
	    actionBar.addTab(tab);
	    
	    tab = actionBar.newTab()
                .setText("Labs")
                .setTabListener(new TabListener<LabsFragment>(
                        this, "Labs", LabsFragment.class,LearningCaseFileName));
		actionBar.addTab(tab);
		 
		tab = actionBar.newTab()
		         .setText("Orders")
		         .setTabListener(new TabListener<OrdersFragment>(
		                 this, "Orders", OrdersFragment.class,LearningCaseFileName));
		actionBar.addTab(tab);
	}

	 @Override
	  public void onRestoreInstanceState(Bundle savedInstanceState) {
	    // Restore the previously serialized current tab position.
	    if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
	      getActionBar().setSelectedNavigationItem(savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
	    }
	  }

	  @Override
	  public void onSaveInstanceState(Bundle outState) {
	    // Serialize the current tab position.
	    outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
	        .getSelectedNavigationIndex());
	  }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
/*	@Override
	  public void onTabSelected(ActionBar.Tab tab,
	      FragmentTransaction fragmentTransaction) {
	    // When the given tab is selected, show the tab contents in the
	    // container view.
	    Fragment fragment = new DummySectionFragment();
	    Bundle args = new Bundle();
	    args.putInt(DummySectionFragment.ARG_SECTION_NUMBER,
	        tab.getPosition() + 1);
	    fragment.setArguments(args);
	    getFragmentManager().beginTransaction()
	        .replace(R.id.container, fragment).commit();
	  }

	  @Override
	  public void onTabUnselected(ActionBar.Tab tab,
	      FragmentTransaction fragmentTransaction) {
	  }

	  @Override
	  public void onTabReselected(ActionBar.Tab tab,
	      FragmentTransaction fragmentTransaction) {
	  }	*/
	  
	  public static class TabListener<T extends Fragment> implements ActionBar.TabListener {
		    private Fragment mFragment;
		    private final Activity mActivity;
		    private final String mTag;
		    private final Class<T> mClass;
		    private final String learningCaseFileName;

		    /** Constructor used each time a new tab is created.
		      * @param activity  The host Activity, used to instantiate the fragment
		      * @param tag  The identifier tag for the fragment
		      * @param clz  The fragment's Class, used to instantiate the fragment
		      */
		    public TabListener(Activity activity, String tag, Class<T> clz, String newLCFileName) {
		        mActivity = activity;
		        mTag = tag;
		        mClass = clz;
		        learningCaseFileName = newLCFileName;
		    }

		    /* The following are each of the ActionBar.TabListener callbacks */

		    public void onTabSelected(Tab tab, FragmentTransaction ft) {
		        // Check if the fragment is already initialized
		        if (mFragment == null) {
		            // If not, instantiate and add it to the activity
		            mFragment = Fragment.instantiate(mActivity, mClass.getName());
		            ft.add(android.R.id.content, mFragment, mTag);
		            if(mFragment instanceof HistoryFragment)  {
		            	HistoryFragment tempHist = (HistoryFragment) mFragment;
		            	tempHist.setLearningCaseFileName(learningCaseFileName);
		            } else if(mFragment instanceof ExamsFragment) {
		            	ExamsFragment tempExams = (ExamsFragment) mFragment;
		            	tempExams.setLearningCaseFileName(learningCaseFileName);
		             }else if(mFragment instanceof LabsFragment) {
		            	 LabsFragment tempExams = (LabsFragment) mFragment;
		            	tempExams.setLearningCaseFileName(learningCaseFileName);
		            }
		           // }
		           // if (mFragment.getClass().getName().equals("com.example.simtern1.HistoryFragment") //||
		            		//mClass.getName() == "ExamsFragment" ||
		            		//mClass.getName() == "OrdersFragment" ||
		            		//mClass.getName() == "LabsFragment"
		            	//	) {
		            	/*try {
		            			Method method = 
		            					mFragment.getClass().getMethod("setLearningCaseFileName", String.class);
		            			method.invoke(mFragment.getClass(),learningCaseFileName);
		            		} catch (NoSuchMethodException e) {
		            		// TODO Auto-generated catch block
		            			e.printStackTrace();		            			
		            		} catch (IllegalAccessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IllegalArgumentException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}*/
		            	
		           // }
		        } else {
		            // If it exists, simply attach it in order to show it
		            ft.attach(mFragment);
		        }
		    }

		    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		        if (mFragment != null) {
		            // Detach the fragment, because another one is being attached
		            ft.detach(mFragment);
		        }
		    }

		    public void onTabReselected(Tab tab, FragmentTransaction ft) {
		        // User selected the already selected tab. Usually do nothing.
		    }
		     
		}
	public void activateLabsTab() {
		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		android.support.v7.app.ActionBar.Tab tab = actionBar.newTab()
        .setText("Orders")
        .setTabListener(new TabListener<OrdersFragment>(
                this, "Orders", OrdersFragment.class,LearningCaseFileName));
		actionBar.addTab(tab);
	}
}
