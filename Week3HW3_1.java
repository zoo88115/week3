import java.io.*;
import java.util.Scanner;
import java.util.*;

class Week3HW3_1
{
	public static void main(String[] args)
	{
		HashMap hm = new HashMap();
		Scanner op= new Scanner(System.in);
		try(FileReader fr=new FileReader("test.txt"))    //Ū�ɴ���
		{
			BufferedReader br = new BufferedReader(fr);    //�NŪ�J���ɮץᵹbufferedreader,�~�వreadline
			System.out.println("�ɮ�Ū�����\!!");
			for(String line; (line = br.readLine()) != null; ) 
			{
				String []token = line.split(",| |\\.");
				hm.put(token[0],Integer.valueOf(token[1]));
			}
			fr.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("������ɮ�");
		}
		catch(final IOException e)
		{
			System.out.println("Ū�ɵo�Ϳ��~\n");
		}
		
		try{
			while(true)
			{
				System.out.print("1)��J�y�l�s�W�r�� 2)�d�ߦr�ťX�{���� 3)�����{��  : ");
				int ch;
				String s=new String();
				ch=op.nextInt();
				switch(ch)
				{
					case 1:
						s=op.nextLine();  //�^�����ؿ�ܴ���r��
						System.out.print("��J�^��y�l�G");
						s=op.nextLine();
						s=s.toLowerCase();
						System.out.println("��J�r�� : "+s+" ���\");
						String[] tok=s.split(",| |\\.|\r|\n");
						for(int ii=0;ii<tok.length;ii++)
						{
							if(tok[ii].matches("[a-z]+")==true)
							{
								if(hm.get(tok[ii])!=null)
								{
									hm.put(tok[ii],(int)hm.get(tok[ii])+1);
								}
								else
									hm.put(tok[ii],1);
							}
						}
						break;
					case 2:
						System.out.print("��J�r�šG");
						s=op.next();
						if(hm.get(s)==null)
						{
							System.out.println(s+" : �X�{���Ƭ�0");
						}
						else
							System.out.println(s+" : �X�{���Ƭ�"+hm.get(s));
						break;
					case 3:
						String writedata=new String();
						for (Object key : hm.keySet()) 
						{
							writedata+=key + " " + hm.get(key)+'\n';//�r�� �ƶq ����r��
						}
						FileWriter fw =new FileWriter("test.txt");//�g�J�ɮ�
						fw.write(writedata);
						fw.close();
						break;
					default:
						break;
				}
				if(ch==3)
					break;
			}
		}
		catch(Exception e)
		{
			System.out.println("��J���~!! ���~�T�� :"+e);
		}
	}
}