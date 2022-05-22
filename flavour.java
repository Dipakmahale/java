import java.io.*;
import java.util.*;

public class q3
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nEnter the number of flavors:");
		int n=Integer.parseInt(br.readLine());
		String c,s;

		Hashtable<String,Integer>flav=new Hashtable<String,Integer>();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the name of flavors:"+(i+1)+" ");
			s=br.readLine();
			if(flav.containsKey(s))
			{
				System.out.println("Duplicate Enteries are not allowed!");
				i--;
				continue;
			}
			System.out.println("Enter the price of flavors:");
			int price=Integer.parseInt(br.readLine());
			flav.put(s,price);

		}
		while(true)
		{
			System.out.println("1.Search specific flavour:");
			System.out.println("2.Sort all the flavour");
			System.out.println("3.Exit");
			System.out.println("Enter your choice:");
			c=br.readLine();
			switch(c)
			{
				case "1":System.out.println("Enter the name of flavout:");
					 s=br.readLine();
					 if(flav.containsKey(s))
					 {
						 System.out.println("Flavour name:"+s+"\n price "+flav.get(s));
					 }
					 else

						 System.out.println("Flavour not found");
					 	 break;
				
				case "2":TreeMap<String,Integer>tm=new TreeMap<String,Integer>(flav);
					 Set<String>keys=tm.keySet();
					 Iterator<String>itr=keys.iterator();
					 System.out.println("\nFlavour in sorted order: ");
					 while(itr.hasNext())
					{
						String i=itr.next();
						System.out.println(i +" "+ tm.get(i));
					}

				case "3":System.exit(0);
			}
		}
	}
}



					
