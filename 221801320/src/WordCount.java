package wordcount;

import java.io.IOException;

public class WordCount {
	public static void main(String[] args) throws IOException {
        String inputFile = "F:\\1.txt";
        String outputFile = "F:\\2.txt";
        Lib.charactersCount(inputFile);//ͳ���ַ���
        Lib.wordsCount(inputFile);//ͳ�Ƶ�����
        Lib.linesCount(inputFile);//ͳ������
        Lib.wordNum(inputFile);//
        System.out.println(Lib.output);
        Lib.writeToFile(outputFile, Lib.output);
    }
}
