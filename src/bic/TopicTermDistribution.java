package bic;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

import edu.stanford.nlp.io.IOUtils;

public class TopicTermDistribution {

	static final int COLS = 5997;
	static final int ROWS = 7;
	String topicterm[][] = new String[ROWS][];

	public TopicTermDistribution() {

	}

	public TopicTermDistribution(String[][] str) {
		topicterm = str;
	}

	public void printTopicTermDistribution() {
		for (String x[] : topicterm) {
			for (String y : x) {
				System.out.print(y + "\t");
			}
			System.out.println("");
		}
	}

	public String getValueAt(int i, int j) {

		return topicterm[i][j];
	}

	public void setTopicTermValues() {

		try (DataInputStream rf = new DataInputStream(
				IOUtils.getInputStreamFromURLOrClasspathOrFileSystem("topic-term-distributions.csv"));
				Scanner in = new Scanner(rf);) {
			for (int i = 0; i < ROWS; i++) {
				String s = in.nextLine();
				String str[] = s.split(",");
				topicterm[i] = new String[COLS]; // create columns for given row

				for (int j = 0; j < COLS; j++) {

					topicterm[i][j] = str[j];
				}
			}
		} catch (IOException ex) {
			System.out.println("Error: " + ex);
		}
	}

	// create topic-term distribution for tags and distinct words correspoding to
	// index in index[].
	public void setTopicTermValues(int[] index) {

		try (DataInputStream rf = new DataInputStream(
				IOUtils.getInputStreamFromURLOrClasspathOrFileSystem("topic-term-distributions.csv"));
				Scanner in = new Scanner(rf);) {

			for (int i = 0; i < ROWS; i++) {
				String s = in.nextLine();
				String str[] = s.split(",");
				topicterm[i] = new String[index.length]; // create columns for given row.
				// set value in cells for index.
				// i.e.only the frequency of words that appear in swObj is extracted for each
				// tags.
				for (int j = 0, k = 0; j < index.length; j++, k++) {

					topicterm[i][j] = str[index[k] - 1];

				}

			}
		} catch (IOException ex) {
			System.out.println("Error: " + ex);
		}
	}

	public String[][] getTopicTermValues() {
		return topicterm;
	}

	public String getTopicTermValueAt(int tag, int index) {

		return topicterm[tag][index];

	}
}
