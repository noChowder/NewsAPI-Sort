package task_1;

import java.io.File;
import java.net.URL;
import java.util.logging.Logger;

public class ParserChoice {
	
	private String choice;
	private File file;
	private URL url;
	private Logger logger;
	
	/**
	 * Select parser to use. Give file or url and logger.
	 * 
	 * @param choice Parser selection (complex, simple, web).
	 * @param file File to parse. Null if using Web parser.
	 * @param url URL to parse. Null if using Complex or Simple parser.
	 * @param logger Logger for reporting errors.
	 */
	public ParserChoice(String choice, File file, URL url, Logger logger) {
		this.choice = choice;
		this.file = file;
		this.url = url;
		this.logger = logger;
	}

	/**
	 * Accepts visitor to use selected parser.
	 * 
	 * @param parserVisitor Visitor called.
	 */
	public void accept(ParserVisitor parser) {
		if(choice.isEmpty() || !choice.equalsIgnoreCase("COMPLEX") && !choice.equalsIgnoreCase("SIMPLE") && !choice.equalsIgnoreCase("WEB")) {
			System.out.println("User parser choice: \"" + choice + "\".");
			System.out.println("Please select a parser from this list: [COMPLEX, SIMPLE, WEB].");
		}
		else if(choice.equalsIgnoreCase("COMPLEX")) {
			parser.visit(new ComplexParser(file, logger, null));
		}
		else if(choice.equalsIgnoreCase("SIMPLE")) {
			parser.visit(new SimpleParser(file, logger, null));
		}
		else if(choice.equalsIgnoreCase("WEB")) {
			parser.visit(new WebParser(url, logger, null));
		}
	}
}
