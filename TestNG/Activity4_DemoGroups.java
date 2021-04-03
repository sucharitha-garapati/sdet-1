package testNGTests;

import org.testng.annotations.Test;

public class Activity4_DemoGroups {
   @Test (groups = { "Car" })
	  public void Car1() {
	      System.out.println("Batch Car - Test car 1");
	  }

	  @Test (groups = { "Car" })
	  public void Car2() {
	      System.out.println("Batch Car - Test car 2");
	  }
  }
