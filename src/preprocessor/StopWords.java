package preprocessor;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.regex.Pattern;

public class StopWords {

	// as used by the algorithm from
	// public static String[] stopwords =
	// {"a","able","about","across","after","all","almost","also","am","among","an","and","any","are","as","at","be","because","been","but","by","can","cannot","could","dear","did","do","does","either","else","ever","every","for","from","get","got","had","has","have","he","her","hers","him","his","how","however","i","if","in","into","is","it","its","just","least","let","like","likely","may","me","might","most","must","my","neither","no","nor","not","of","off","often","on","only","or","other","our","own","rather","said","say","says","she","should","since","so","some","than","that","the","their","them","then","there","these","they","this","tis","to","too","twas","us","wants","was","we","were","what","when","where","which","while","who","whom","why","will","with","would","yet","you","your"};
	public static String[] stopwords = { "gonna", "won\'t", "don\'t", "i\'m", "a", "as", "able", "about", "above",
			"according", "accordingly", "across", "actually", "after", "afterwards", "again", "against", "aint", "all",
			"allow", "allows", "almost", "alone", "along", "already", "also", "although", "always", "am", "among",
			"amongst", "an", "and", "another", "any", "anybody", "anyhow", "anyone", "anything", "anyway", "anyways",
			"anywhere", "apart", "appear", "appreciate", "appropriate", "are", "arent", "around", "as", "aside", "ask",
			"asking", "associated", "at", "available", "away", "awfully", "be", "became", "because", "become",
			"becomes", "becoming", "been", "before", "beforehand", "behind", "being", "believe", "below", "beside",
			"besides", "best", "better", "between", "beyond", "both", "brief", "but", "by", "cmon", "cs", "came", "can",
			"cant", "cannot", "cant", "cause", "causes", "certain", "certainly", "changes", "clearly", "co", "com",
			"come", "comes", "concerning", "consequently", "consider", "considering", "contain", "containing",
			"contains", "corresponding", "could", "couldnt", "course", "currently", "definitely", "described",
			"despite", "did", "didnt", "different", "do", "does", "doesnt", "doing", "dont", "done", "down",
			"downwards", "during", "each", "edu", "eg", "eight", "either", "else", "elsewhere", "enough", "entirely",
			"especially", "et", "etc", "even", "ever", "every", "everybody", "everyone", "everything", "everywhere",
			"ex", "exactly", "example", "except", "far", "few", "ff", "fifth", "first", "five", "followed", "following",
			"follows", "for", "former", "formerly", "forth", "four", "from", "further", "furthermore", "get", "gets",
			"getting", "given", "gives", "go", "goes", "going", "gone", "got", "gotten", "greetings", "had", "hadnt",
			"happens", "hardly", "has", "hasnt", "have", "havent", "having", "he", "hes", "hello", "help", "hence",
			"her", "here", "heres", "hereafter", "hereby", "herein", "hereupon", "hers", "herself", "hi", "him",
			"himself", "his", "hither", "hopefully", "how", "howbeit", "however", "i", "id", "ill", "im", "ive", "ie",
			"if", "ignored", "immediate", "in", "inasmuch", "inc", "indeed", "indicate", "indicated", "indicates",
			"inner", "insofar", "instead", "into", "inward", "is", "isnt", "it", "itd", "itll", "its", "its", "itself",
			"just", "keep", "keeps", "kept", "know", "knows", "known", "last", "lately", "later", "latter", "latterly",
			"least", "less", "lest", "let", "lets", "like", "liked", "likely", "little", "look", "looking", "looks",
			"ltd", "mainly", "many", "may", "maybe", "me", "mean", "meanwhile", "merely", "might", "more", "moreover",
			"most", "mostly", "much", "must", "my", "myself", "name", "namely", "nd", "near", "nearly", "necessary",
			"need", "needs", "neither", "never", "nevertheless", "new", "next", "nine", "no", "nobody", "non", "none",
			"noone", "nor", "normally", "not", "nothing", "novel", "now", "nowhere", "obviously", "of", "off", "often",
			"oh", "ok", "okay", "old", "on", "once", "one", "ones", "only", "onto", "or", "other", "others",
			"otherwise", "ought", "our", "ours", "ourselves", "out", "outside", "over", "overall", "own", "particular",
			"particularly", "per", "perhaps", "placed", "please", "plus", "possible", "presumably", "probably",
			"provides", "que", "quite", "qv", "rather", "rd", "re", "really", "reasonably", "regarding", "regardless",
			"regards", "relatively", "respectively", "right", "said", "same", "saw", "say", "saying", "says", "second",
			"secondly", "see", "seeing", "seem", "seemed", "seeming", "seems", "seen", "self", "selves", "sensible",
			"sent", "serious", "seriously", "seven", "several", "shall", "she", "should", "shouldnt", "since", "six",
			"so", "some", "somebody", "somehow", "someone", "something", "sometime", "sometimes", "somewhat",
			"somewhere", "soon", "sorry", "specified", "specify", "specifying", "still", "sub", "such", "sup", "sure",
			"ts", "take", "taken", "tell", "tends", "th", "than", "thank", "thanks", "thanx", "that", "thats", "thats",
			"the", "their", "theirs", "them", "themselves", "then", "thence", "there", "theres", "thereafter",
			"thereby", "therefore", "therein", "theres", "thereupon", "these", "they", "theyd", "theyll", "theyre",
			"theyve", "think", "third", "this", "thorough", "thoroughly", "those", "though", "three", "through",
			"throughout", "thru", "thus", "to", "together", "too", "took", "toward", "towards", "tried", "tries",
			"truly", "try", "trying", "twice", "two", "un", "under", "unfortunately", "unless", "unlikely", "until",
			"unto", "up", "upon", "us", "use", "used", "useful", "uses", "using", "usually", "value", "various", "very",
			"via", "viz", "vs", "want", "wants", "was", "wasnt", "way", "we", "wed", "well", "were", "weve", "welcome",
			"well", "went", "were", "werent", "what", "whats", "whatever", "when", "whence", "whenever", "where",
			"wheres", "whereafter", "whereas", "whereby", "wherein", "whereupon", "wherever", "whether", "which",
			"while", "whither", "who", "whos", "whoever", "whole", "whom", "whose", "why", "will", "willing", "wish",
			"with", "within", "without", "wont", "wonder", "would", "would", "wouldnt", "yes", "yet", "you", "youd",
			"youll", "youre", "youve", "your", "yours", "yourself", "yourselves", "zero" };
	public static Set<String> stopWordSet = new HashSet<>(Arrays.asList(stopwords));

	public static boolean isStopWord(String word) {
		if (word.length() < 2) {
			return true;
		}
		if (word.charAt(0) >= '0' && word.charAt(0) <= '9') {
			return true; // remove numbers, "25th", etc
		}
		if (stopWordSet.contains(word)) {
			return true;
		} else {
			return false;
		}
	}

	public static String removeStopWords(String string) {
		String result = "";
		Pattern ptrn = Pattern.compile("[ .!]");
		String words[] = ptrn.split(string);
		// String[] words = string.split("\\s+");
		for (String word : words) {
			if (word.isEmpty()) {
				continue;
			}
			if (isStopWord(word)) {
				continue; // remove stopwords
			}
			result += (word + " ");
		}
		return result;
	}

}
