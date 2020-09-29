package models;
import org.junit.*;
import static org.junit.Assert.*;


public class EndangeredTest {
    @Test
    public void endangeredAnimal_instantiatesCorrectly_true() {
        Endangered testEndangered = new Endangered("Platypus", "Healthy", "Young");
        assertEquals(true, testEndangered instanceof Endangered);
    }

    @Test
    public void getHealth_returnsCorrectHealthAttribute_true() {
        Endangered testEndangered = new Endangered("Platypus", "Ill", "Young");
        assertEquals("Healthy", testEndangered.getHealth());
    }

    @Test
    public void save_assignsIdAndSavesObjectToDatabase() {
        Endangered testEndangered = new Endangered("Platypus", "Healthy", "Young");
        testEndangered.save();
        Endangered savedEndangered = Endangered.all().get(0);
        assertEquals(testEndangered.getId(), savedEndangered.getId());
    }

    @Test
    public void all_returnsAllInstancesOfEndangeredAnimal_true() {
        Endangered firstEndangered = new Endangered("Platypus", "Healthy", "Young");
        firstEndangered.save();
        Endangered secondEndangered = new Endangered("Platypus", "Healthy", "Young");
        secondEndangered.save();
        assertEquals(true, Endangered.all().get(0).equals(firstEndangered));
        assertEquals(true, Endangered.all().get(1).equals(secondEndangered));
    }

    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        Endangered firstEndangered = new Endangered("Platypus", "Ill", "Young");
        firstEndangered.save();
        Endangered secondEndangered = new Endangered("Platypus", "Healthy", "Adult");
        secondEndangered.save();
        assertEquals(Endangered.find(secondEndangered.getId()), secondEndangered);
    }

    @Test
    public void update_updatesHealthAttribute_true() {
        Endangered testEndangered = new Endangered("Platypus", "Healthy", "Young");
        testEndangered.save();
        testEndangered.updateHealth("Healthy");
        assertEquals("Healthy", Endangered.find(testEndangered.getId()).getHealth());
    }

    @Test
    public void update_updatesAgeAttribute_true() {
        Endangered testEndangered = new Endangered("Platypus", "Healthy", "Young");
        testEndangered.save();
        testEndangered.updateAge("Young");
        assertEquals("Young", Endangered.find(testEndangered.getId()).getAge());
    }

}