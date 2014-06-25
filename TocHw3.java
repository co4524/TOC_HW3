/******************************************************
	學號:F74006226
	姓名:蔡徳倚
	Toc_HW3
*******************************************************/
import java.io.*;
import java.net.URL;
import org.json.*;


public class TocHw3 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		int count=0,price=0,trade,add=0;
		Integer year;
		URL url=new URL(args[0]);
		BufferedReader a = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		JSONArray array=new JSONArray(new JSONTokener(a));
		//System.out.println(array);
		System.out.println(args[1]+" "+args[2]+" "+args[3]);
		for(int i=0;i<array.length();++i)
		{
			JSONObject item=array.getJSONObject(i);
			trade=item.getInt("交易年月");
			year=trade/100;
			if(args[1].equals(item.get("鄉鎮市區"))==true && args[3].equals(year.toString()) && item.get("土地區段位置或建物區門牌").toString().contains(args[2])==true)
			{
				price=item.getInt("總價元");
				System.out.println(item.get("鄉鎮市區").toString()+"	"+item.get("土地區段位置或建物區門牌").toString()+"	"+item.getInt("交易年月")+"	"+item.getInt("總價元"));
				count++;
				add=add+price;
			}
		}
		System.out.println(add/count);
	}
}