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
				System.out.print("��J�ǥͩm�W ���Z -1 -1������J:");
				n=op.next();
				g=op.nextInt();
				if(n.equals("-1")==true && g==-1)
				{
					break;
				}
				else
				{
					if(g<0 || g>100)
						System.out.println("��J���~!");
					else
					{
						hashMap.put(n,g);
					}
				}
			}
			while(true)
			{
				String ch;
				System.out.print("��J�ǥͩm�W�d�ߦ��Z -1������J :");
				ch=op.next();
				if(ch.equals("-1")==true)
					break;
				else
				{
					if(hashMap.get(ch)==null)
						System.out.println("�d�L�����");
					else
						System.out.println("�m�W : "+ch+"  ���Z : "+hashMap.get(ch));
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("���~�T��:"+e);
		}
	}
}