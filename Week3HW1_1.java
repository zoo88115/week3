import java.io.*;
import java.util.Scanner;
import java.util.*;

class Week3HW1_1
{
	public static void main(String[] args) {
		int total=0;
		String s=new String();
		Scanner scanner=new Scanner(System.in);
		System.out.println("輸入英文句子：");
		s=scanner.nextLine();
		s=s.toLowerCase();
		String[] tok=s.split(",| |\\.");
		ArrayList<String> array=new ArrayList<String>();

		for(int ii=0;ii<tok.length;ii++)
		{
			int test=0;
			if(tok[ii].matches("[0-9]+")==true)
			{
				total+=Integer.valueOf(tok[ii]);
			}
			else if(tok[ii].matches("[a-z]+")==true)
			{
				for(int i=0;i<array.size();i++)
				{
					if(array.get(i).equals(tok[ii])==true)
					{
						test++;
						break;
					}
				}
				if(test==0)
				{
					array.add(tok[ii]);
				}
			}
		}
		Collections.sort(array);
		System.out.println("number total : "+total);
		for(int i=0;i<array.size();i++)
		{
			System.out.println(array.get(i));
		}
	}
}