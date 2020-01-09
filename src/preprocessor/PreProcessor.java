package preprocessor;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.io.File;
import java.util.ArrayList;

public class PreProcessor {
	// declare software object
	String swObj;

	public PreProcessor(String swObj) {
		this.swObj = swObj;
	}

	public ArrayList<String> process() {
		// remove stopwords
		swObj = StopWords.removeStopWords(swObj);

		// Initialize the tagger
		MaxentTagger tagger = new MaxentTagger("models/english-left3words-distsim.tagger");

		// tag the swObj
		String tagged = tagger.tagString(swObj);
		ArrayList<String> wordList = new ArrayList<>();

		String str[] = tagged.split(" ");

		for (String x : str) {
			if (x.substring(x.lastIndexOf("_") + 1).startsWith("N")) {
				wordList.add(x.split("_")[0]);
			}
		}
		return wordList;
	}
}
