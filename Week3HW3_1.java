import java.io.*;
import java.util.Scanner;
import java.util.*;

class Week3HW3_1
{
	public static void main(String[] args)
	{
		HashMap hm = new HashMap();
		Scanner op= new Scanner(System.in);
		try(FileReader fr=new FileReader("test.txt"))    //讀檔測試
		{
			BufferedReader br = new BufferedReader(fr);    //將讀入的檔案丟給bufferedreader,才能做readline
			System.out.println("檔案讀取成功!!");
			for(String line; (line = br.readLine()) != null; ) 
			{
				String []token = line.split(",| |\\.");
				hm.put(token[0],Integer.valueOf(token[1]));
			}
			fr.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("未找到檔案");
		}
		catch(final IOException e)
		{
			System.out.println("讀檔發生錯誤\n");
		}
		
		try{
			while(true)
			{
				System.out.print("1)輸入句子新增字符 2)查詢字符出現次數 3)結束程式  : ");
				int ch;
				String s=new String();
				ch=op.nextInt();
				switch(ch)
				{
					case 1:
						s=op.nextLine();  //擷取項目選擇換行字元
						System.out.print("輸入英文句子：");
						s=op.nextLine();
						s=s.toLowerCase();
						System.out.println("輸入字串 : "+s+" 成功");
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
						System.out.print("輸入字符：");
						s=op.next();
						if(hm.get(s)==null)
						{
							System.out.println(s+" : 出現次數為0");
						}
						else
							System.out.println(s+" : 出現次數為"+hm.get(s));
						break;
					case 3:
						String writedata=new String();
						for (Object key : hm.keySet()) 
						{
							writedata+=key + " " + hm.get(key)+'\n';//字符 數量 換行字元
						}
						FileWriter fw =new FileWriter("test.txt");//寫入檔案
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
			System.out.println("輸入錯誤!! 錯誤訊息 :"+e);
		}
	}
}