import java.io.*;
import java.util.Map;

import java.util.TreeMap;
public class WordCount {
    private static Map<String, Object> word = new TreeMap<String, Object>();
    public static void main(String[] args) throws IOException{
        // write your code here
        System.out.println("hello");
        System.out.println(countChar("C:\\Users\\Scenario\\Desktop\\test.txt"));
        System.out.println(countLine("C:\\Users\\Scenario\\Desktop\\test.txt"));
        System.out.println(countWord("C:\\Users\\Scenario\\Desktop\\test.txt"));
        countkeyword("C:\\Users\\Scenario\\Desktop\\test.txt");
    }
    public static int countChar(String filepath)throws IOException {
        BufferedReader reader=new BufferedReader(new FileReader(filepath));
        if(!reader.ready())
        {
            System.out.println("文件流无法读取");
        }
        int num=0;
        String line=null;
        while((line=reader.readLine())!=null)
        {
            num+=line.length();
        }
        reader.close();
        return num;

    }
    public static int countLine(String filepath)throws IOException {
        BufferedReader reader=new BufferedReader(new FileReader(filepath));
        if(!reader.ready())
        {
            System.out.println("文件流无法读取");
        }
        int num=0;
        String line=null;
        while((line=reader.readLine())!=null)
        {
            num+=1;
        }
        reader.close();
        return num;
    }
    public static int countWord(String filepath)throws IOException {
        BufferedReader reader=new BufferedReader(new FileReader(filepath));
        if(!reader.ready())
        {
            System.out.println("文件流无法读取");
        }
        int num=0;
        String line=null;
        while((line=reader.readLine())!=null)
        {
            String s1 = line.replaceAll("\\W", " ");
            String s2 = s1.replaceAll(" +", " ");
            String []s3=s2.split(" ");
            for(String a:s3)
            {
                if(a.length()>3&&(a.charAt(0)<'0'||a.charAt(0)>'9'))
                {
                    word.put(a,0);

                }
            }

        }
        for (String key : word.keySet()) {
            num++;
        }
        return num;
    }
    public static  void countkeyword(String filepath)throws IOException {
        int n=countWord(filepath);
        int N=10;
        BufferedReader reader=new BufferedReader(new FileReader(filepath));
        if(!reader.ready())
        {
            System.out.println("文件流无法读取");
        }
        int num=0;
        String line=null;
        while((line=reader.readLine())!=null)
        {
            String s1 = line.replaceAll("\\W", " ");
            String s2 = s1.replaceAll(" +", " ");
            String []s3=s2.split(" ");
            for(String a:s3)
            {
                if(a.length()>3&&(a.charAt(0)<'0'||a.charAt(0)>'9'))
                {
                    int number=(int)word.get(a);
                    word.put(a,number+1);

                }
            }

        }
        for(int i=0;i<=N;i++)
        {
            int max=0;
            String maxs=null;
            for (String key : word.keySet()) {
                if(max<(int)word.get(key))
                {
                    max=(int)word.get(key);
                    maxs=key;

                }
                if(max==(int)word.get(key))
                {
                    if(maxs.compareTo(key)>0)
                    {
                        max=(int)word.get(key);
                        maxs=key;
                    }
                }
            }
            System.out.println(maxs+":"+max);
            word.remove(maxs);
            n--;
            if(n<=0) break;
        }

    }

}
