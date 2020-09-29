package models;

import junit.framework.TestCase;
import junit.framework.TestResult;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SightingTest  {
   @Test
    public void testSighting_getCorrectId_int(){
       Sighting sighting = new Sighting(18, "Zone A", "John");
       assertEquals(18, sighting.getId());
   }

   @Test
   public void testSighting_getCorrectLocation_String(){
       Sighting sighting = new Sighting(18, "Zone A","John");
       assertEquals("Kenya", sighting.getLocation());
   }

   @Test
    public void testSighting_getCorrectRangerName_String(){
       Sighting sighting = new Sighting(18, "Zone A","John");
       assertEquals("Kevin", sighting.getRangerName());
   }


}