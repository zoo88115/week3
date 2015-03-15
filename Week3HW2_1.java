import java.io.*;
import java.util.Scanner;
import java.util.*;

class Week3HW2_1
{
	public static void main(String[] args) 
	{
		try{
			HashMap hashMap = new HashMap();
			Scanner op=new Scanner(System.in);
			while(true)
			{
				String n;
				int g;
				System.out.print("輸入學生姓名 成績 -1 -1結束輸入:");
				n=op.next();
				g=op.nextInt();
				if(n.equals("-1")==true && g==-1)
				{
					break;
				}
				else
				{
					if(g<0 || g>100)
						System.out.println("輸入錯誤!");
					else
					{
						hashMap.put(n,g);
					}
				}
			}
			while(true)
			{
				String ch;
				System.out.print("輸入學生姓名查詢成績 -1結束輸入 :");
				ch=op.next();
				if(ch.equals("-1")==true)
					break;
				else
				{
					if(hashMap.get(ch)==null)
						System.out.println("查無此資料");
					else
						System.out.println("姓名 : "+ch+"  成績 : "+hashMap.get(ch));
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("錯誤訊息:"+e);
		}
	}
}