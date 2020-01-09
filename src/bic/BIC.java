package bic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAO;
import preprocessor.PreProcessor;

public class BIC {

	public static ArrayList<String> outputList;

	public static void main(String[] args) throws IOException {
		System.out.println("enter your question");
		/// swObj = JOptionPane.showInputDialog(null, "Enter your question");
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String swObj = bfr.readLine().toString();
		System.out.println("input=" + swObj);
		enTagRec(swObj);
	}

	public static ArrayList<String> enTagRec(String swObj) throws IOException {
		outputList = new ArrayList<>();

		ArrayList<String> wordList = new ArrayList<>();
		int index[] = null; // an array to store the index of words found in database

		// perform pre-processing on the given software object and store in wordList
		wordList = new PreProcessor(swObj).process();

		// create Database Access Object
		DAO dao = null;
		try {
			dao = new DAO();
			// connect to "entagrec" database connection as "localhost"
			dao.con();
			// search database for the existence of words
			System.out.println("Searching db...");
			outputList.add("Searching db..");
			
			if (dao.search(wordList)) {
				System.out.println("Search successful");
				outputList.add("Search successful");
				// index[] stores the index of words found in database
				index = dao.getIndexArray();/////////////////////////////////////////////////////////////
			} else {
				System.out.println("No Recommendations");
				outputList.add("No Recommendations");
				System.exit(0);
			}
		} catch (SQLException ex) {
			System.out.println("Error: " + ex);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				dao.closeCon();
			} catch (SQLException ex) {
				System.out.println("Error: " + ex);
			}
		}
		System.out.println("====================================================");
		outputList.add("====================================================");

		TopicTermDistribution ttd = new TopicTermDistribution();
		ttd.setTopicTermValues(index);
		ttd.printTopicTermDistribution();

		// compute P(tags|wordList) using Bayesian Rule
		String topictermvalues[][] = ttd.getTopicTermValues();
		Tag tags[] = new Tag[7];
		tags[0] = new Tag("Java", 37146.0);
		tags[1] = new Tag("PHP", 30754.0);
		tags[2] = new Tag("C#", 35429.0);
		tags[3] = new Tag("HTML", 40596.0);
		tags[4] = new Tag("IOS", 43594.0);
		tags[5] = new Tag("XML", 18902.0);
		tags[6] = new Tag("JavaScript", 21224.0);

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < index.length; j++) {
				tags[i].prob += (Double.parseDouble(topictermvalues[i][j])) / tags[i].total;
			}
			tags[i].prob /= 7.0;
			System.out.println(tags[i].prob);
			outputList.add(Double.toString(tags[i].prob));
		}

		String recommandedTag = "";
		if (Tag.getHighestProbTag(tags).prob > 0.000000000000001) {
			System.out.println("====================================================");
			outputList.add("====================================================");
			recommandedTag = Tag.getHighestProbTag(tags).name;
			System.out.println("Recommended Tag: " + recommandedTag);
			outputList.add("Recommended Tag: " + recommandedTag);

		} else {
			System.out.println("values less than threshold");
			outputList.add("values less than threshold");
			System.exit(0);
		}
		outputList.add(recommandedTag);

		return outputList;
	}

}
