package wordcount;

import java.io.IOException;

public class WordCount {
	public static String output = "1";
	
	public static void main(String[] args) throws IOException {
		
        String inputFile = "F:\\1.txt";
        String outputFile = "F:\\2.txt";
        Lib.charactersCount(inputFile,outputFile);//ͳ���ļ��ַ�����
        Lib.wordsCount(inputFile,outputFile);//ͳ���ļ�������
        Lib.linesCount(inputFile,outputFile);//ͳ���ļ���Ч����
        Lib.wordNum(inputFile,outputFile);//ͳ���ļ��ĵ�����

    }
}
