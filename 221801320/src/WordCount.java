package wordcount;

import java.io.IOException;

public class WordCount {
	public static void main(String[] args) throws IOException {
        String inputFile = "F:/66/1.txt";
        String outputFile = "F:/66/2.txt";
        Count.charactersCount(inputFile);//ͳ���ַ���
        Count.wordsCount(inputFile);//ͳ�Ƶ�����
        Count.linesCount(inputFile);//ͳ������
        Count.wordNum(inputFile);//
        System.out.println(Count.output);
        FileIO.writeToFile(outputFile, Count.output);
    }
}
