import java.util.Random;
class Terrain
{
  protected int light; //sd 25, mean 50, min 0, max 100
  protected int water; //same as light
  protected int temp; //min = -46 max = 42
  
  public Terrain ()
  {
    Random r = new Random();
    do
    {
    light = (int)Math.round(r.nextGaussian()*25)+50;
    }
    while (light > 100 && light < 0);
    do
    {
    water = (int)Math.round(r.nextGaussian()*25)+50;
    }
    while (water > 100 && water < 0);
  }
  
  //Initialize the Environment with given constructors
  public Terrain (int lite, int h20, int temperature)
  {
    light = lite;
    if (light < 0)
    {
      light = 0;
    }
    else if (light > 100)
    {
      light = 100;
    }
    
    water = h20;
    if (water < 0)
    {
      water = 0;
    }
    else if (water > 100)
    {
      water = 100:
    }
    
    temp = temperature;
    if (temp < -46)
    {
      temp = -46;
    }
    else if (temp > 42)
    {
      temp = 42;
    }
  }
  
  public int getLight ()
  {
    return light;
  }
  
  public void changeLight (int num)
  {
    light = num;
  }
  
  public int getWater ()
  {
    return water;
  }
  
  public void changeWater (int num)
  {
    water = num;
  }
  
  public int getTemp ()
  {
    return temp;
  }
  
  public void changeTemp (int num)
  {
    temp = num;
  }
}