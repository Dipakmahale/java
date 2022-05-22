import java.io.*;
import java.util.*;
class student
{
	int roll,age;
	String Name;
	
	student(int r, int a,String n)
	{
		this.roll=r;
		this.age=a;
		this.Name=n;
	}
}

class SortbyName implements Comparator<student>
{
	public int compare(student a,student b)
	{
		return a.Name.compareTo(b.Name);
	}
}

class Sortbyage implements Comparator<student>
{
	public int compare(student a,student b)
	{
		return a.age-b.age;
	}
}


public class q4
{
	public static void main(String [] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		ArrayList<student> stud=new ArrayList<student> ();
		stud.add(new student(100,23,"Ram"));

		stud.add(new student(101,24,"Sham"));
		stud.add(new student(102,25,"Om"));
		
		System.out.println("\n----------------------------------------------------");
		System.out.println("\nSorted by name:");
		System.out.println("\n----------------------------------------------------");

		Collections.sort(stud,new SortbyName());
		for(int i=0;i<stud.size();i++)
		{
			System.out.println("\n Name: "+stud.get(i).Name+"\n roll: "+stud.get(i).roll+"\n Age: "+stud.get(i).age);
		}

		System.out.println("\n----------------------------------------------------");
		System.out.println("\nSorted by Age:");
		System.out.println("\n----------------------------------------------------");
			
		Collections.sort(stud,new Sortbyage());
		for(int i=0;i<stud.size();i++)
		{
			System.out.println("\n Name:"+stud.get(i).Name+"\n roll: "+stud.get(i).roll+"\n Age: "+stud.get(i).age);
		}
	}
}
