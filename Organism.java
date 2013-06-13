/**********************************************************************************************************************/
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Comparable;
import java.io.*;


abstract class Organism
{
  protected static int foodValue, reproductiveSuccess;
  protected int energy;
  protected String species;
  protected Ecosystem parent;
  protected PreferenceTable habitats; 
  
  //Getters
  public int getRow(){return parent.getRow();}
  public int getCol(){return parent.getCol();}
  public String getSpecies(){return species;}
  public int getFoodValue(){return foodValue;}
  public Ecosystem getParent(){return parent;}
  public int getEnergy(){return energy;}
  public void addEnergy (int food){energy = energy + food;}
  
  
//Setters
  public void setParent(Ecosystem newParent){parent=newParent;}

//Constructors
  public Organism (Ecosystem eco,String createAs)
    //eco, THe ecoystem the organism lives in. 
    //createAs the species of the organism.
  {
    parent=eco;
    species=createAs;
    
  }
  
    public Organism (String createAs,int foodPointValue,PreferenceTable placesToLive)

    //createAs the species of the organism.
  {
    species=createAs;
    foodValue=foodPointValue;
    habitats=placesToLive; 
    energy=3;
    
  }
  //Other methods
  

  public ArrayList<Ecosystem> getAdjacent() {return parent.getAdjacent();}
  
  public boolean act(){
    energy--;
    if (energy <= 0) {
                System.out.println("Something died! E="+energy);
      die();
      return true;
    }
    return false;
  }
  
  public void die()
  {

    parent.remove(this);
  }
  
  public void reproduce()
  {
    if (Math.random() < reproductiveSuccess)
    {
      //try
      //{
      //Class species = getClass();
      //parent.add((Organism) species.newInstance());
        parent.add(SpeciesTable.make(getSpecies()));
      //}
      //catch (InstantiationException iex) {}
      //catch (IllegalAccessException iaex) {}
    }
  }
  
  
}

