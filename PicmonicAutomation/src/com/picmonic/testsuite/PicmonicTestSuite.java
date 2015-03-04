package com.picmonic.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.picmonic.selenium.tests.*;

//Specify a runner class.
@RunWith(Suite.class)
//Specify an array of test classes
@Suite.SuiteClasses({
	  Dashboard.class,
	  EditProfile.class,
	  Library.class,
	  Menu.class,
	  MySubscription.class,
	  PlayList.class,
	  Settings.class,
	  Store.class
		   
	})
public class PicmonicTestSuite {

}
