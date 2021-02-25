import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class WordCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lib lib = new Lib();
		System.out.println(args.length);
		if (args.length >= 2) {
			try {
				File inputFile = new File(args[0]);
				File outputFile = new File(args[1]);
				FileWriter fw = new FileWriter(outputFile);
				BufferedWriter buffWriter = new BufferedWriter(fw);
				
				//��ȡ�ַ����������
				int characterNum = lib.statisticsCharacters(inputFile);
				buffWriter.write("characters: " + characterNum);
				buffWriter.newLine();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}

