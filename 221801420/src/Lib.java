import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class Lib {
	/*
	 * ���ܣ�ͳ���ļ��ַ���
	 * ���룺File�ļ�ָ��
	 * ��������ļ��к��е��ַ���
	 */
	 static int statisticsCharacters(File file) {
		int characterNum = 0;
		try {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file));
			BufferedReader in = new BufferedReader(read);
			String str = null;
			while ((str = in.readLine()) != null){
				for (int i = 0;i<str.length();i++) {
					int characterAscill=str.charAt(i);
					if (characterAscill >=0 && characterAscill <= 127) {
						characterNum++;
					}
				}
				characterNum++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return characterNum;
	}
}
