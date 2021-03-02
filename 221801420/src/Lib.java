import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Lib {
    /*
     * ���ܣ�ͳ���ļ��ַ���
     * ���룺File�ļ�ָ��
     * ������ļ��к��е��ַ���
     */
    static int statisticsCharacters(File file) {
        int characterNum = 0;
        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file));
            BufferedReader in = new BufferedReader(read);
            while (true) {
                int characterAscill=in.read();
                if (characterAscill >= 0 && characterAscill <= 127) {
                    characterNum ++;
                }
                if (characterAscill == -1) break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characterNum;
    }
	 
    /*
     * ���ܣ�ͨ��������ʽ�Ե��ʽ��в���
     * ���룺File�ļ�ָ��
     * ��������ļ��к��еĵ�����
     */
    static int statisticsWords(File file) {
	     int wordNum = 0;
	     try {
	         InputStreamReader read = new InputStreamReader(new FileInputStream(file));
	         BufferedReader in = new BufferedReader(read);
	         String str = null;
	         while ((str = in.readLine()) != null){
				
	             //ͨ��������ʽ��ÿһ�е��ַ�������ƥ����ң������ڷ��������ĵ��������wordsMap
	             String ragex = "[a-zA-Z]{4,}[a-zA-Z0-9]*";
	             Pattern p = Pattern.compile(ragex);
	             Matcher m = p.matcher(str);
	             while (m.find()) {
	                 String s = m.group();
	                 wordNum++;
	             }
	         }
	     } catch (FileNotFoundException e) {
	         e.printStackTrace();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	     return wordNum;
    }
	 
    /*
     * ���ܣ�ͨ����ÿһ�е��ַ����ļ����ͳ���ļ�����Ч����
     * ���룺File�ļ�ָ��
     * ��������ļ��к��е���Ч����
     */
    static int statisticsLines(File file) {
        int lineNum = 0;
        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file));
            BufferedReader in = new BufferedReader(read);
            String str = null;
            while ((str = in.readLine()) != null){
                for (int i = 0;i<str.length();i++) {
                    if (str.charAt(i) != ' ' && str.charAt(i) !='\t') {
                        lineNum++;
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineNum;
    }
    
    /*
     * ���ܣ�ͨ����ÿ�����ʷ���treemap���ٽ�treemap����value����ɻ��ǰʮ�����ʵ�Ƶ��
     * ���룺�ļ���ָ��
     * ��������ֵ���������ɵ�List
     */
    static  List<Map.Entry<String, Integer>> wordsFrequency(File file){
        Map<String,Integer> wordsMap = new TreeMap<>();//���ʺ�Ƶ�ʵ�ӳ���
        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file));
            BufferedReader in = new BufferedReader(read);
            String str = null;
            while ((str = in.readLine()) != null){
               
                //ͨ��������ʽ��ÿһ�е��ַ�������ƥ����ң������ڷ��������ĵ��������wordsMap
                String ragex = "[a-zA-Z]{4,}[a-zA-Z0-9]*";
                Pattern p = Pattern.compile(ragex);
                Matcher m = p.matcher(str);
                while (m.find()) {
                    String s = m.group();
                    s = s.toLowerCase();
                    if (wordsMap.containsKey(s)) {
                        int num = wordsMap.get(s);
                        wordsMap.put(s, num + 1);
                    }else {
                        wordsMap.put(s, 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(wordsMap.entrySet()); 
        
        //ͨ���Ƚ���ʵ�ֱȽ�
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {  
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {  
                return o2.getValue().compareTo(o1.getValue());  
            }  
        });    
        return list;
    }
}
