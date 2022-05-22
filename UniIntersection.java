import java.io.*;
import java.util.*;
public class q2
{
	public static void main(String[] args) throws IOException
	{
		LinkedList l1=new LinkedList();
		LinkedList l2=new LinkedList();
		LinkedList l3=new LinkedList();
		LinkedList l4=new LinkedList();

		int n;
		char ch;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nEnter numbers for linked list 1:");
		do
		{
			System.out.print("\nEnter the number\n");
			n=Integer.parseInt(br.readLine());
			while(l1.contains(n)==true)
			{
				System.out.print("\nDuplicate values are not allowed.\nenter again");
				n=Integer.parseInt(br.readLine());
			}
			System.out.print("\nDo you want to continue:");
			ch=(br.readLine().charAt(0));
			l1.add(n);
		}while(ch=='Y'||ch=='y');
		System.out.print("\nEnter the numbers for linked list 2:");
		do
		{
			System.out.print("\nEnter the number\n");
			n=Integer.parseInt(br.readLine());
			while(l2.contains(n)==true)
			{
				System.out.print("\nDuplicate values are not allowed.\nenter again");
				n=Integer.parseInt(br.readLine());
			}
			System.out.print("\nDo you want to continue:");
			ch=(br.readLine().charAt(0));
			l2.add(n);
		}while(ch=='Y'||ch=='y');
		System.out.print("Linked list 1:"+l1+"\n");
		System.out.print("Linked list 2:"+l2+"\n");
		for(int i=0;i<l1.size();i++)
		{
			l3.add(l1.get(i));
		}

		for(int i=0;i<l2.size();i++)
		{
			if(l3.contains(l2.get(i))==false)
				l3.add(l2.get(i));
		}

		for(int i=0;i<l1.size();i++)
		{
			l4.add(l1.get(i));
		}
		l4.retainAll(l2);
		System.out.print("Union of linkedlist: "+l3+"\n");
		System.out.print("Intersection of linkedlist: "+l4+"\n");
	}
}
