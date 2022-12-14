import java.io.FileReader;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class cheng_lab13 
{
    private ArrayList<Integer> arrayList;

    cheng_lab13()
    {
        this.arrayList = new ArrayList<Integer>();
    }
    
    public void readData(String filename) 
    {
        String inn = "";
        try
        {
            BufferedReader file = new BufferedReader(new InputStreamReader (new FileInputStream(filename))); 
            
            while ((inn = file.readLine()) != null)  
            {
                arrayList.add(Integer.parseInt(inn));
            }
            
            file.close();
        }	
        
        catch(Exception e)
        {
        }
    }

    public long getTotalCount()
    {
        return arrayList.stream().count();
    }
    
    public long getOddCount()
    {
        return arrayList.stream().filter(x -> x % 2 != 0).count();
    }
    
    public long getEvenCount()
    {
        return arrayList.stream().filter(x -> x % 2 == 0).count();
    }
    
    public long getDistinctGreaterThanFiveCount()
    {
        return arrayList.stream().distinct().filter(x -> x > 5).count();
    }
    
    public Integer[] getResult1()
    {
        return arrayList.stream().filter(x -> x > 5 && x < 50 && x % 2 == 0).sorted().toArray(Integer[]::new);
    }
    
    public Integer[] getResult2()
    {
        return arrayList.stream().limit(50).map(x -> x * x * 3).toArray(Integer[]::new);
    }
    
    public Integer[] getResult3()
    {
        return arrayList.stream().filter(x -> x % 2 != 0).map(x -> x * 2).sorted().skip(20).distinct().toArray(Integer[]::new);
    }   
}
