

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class CliMain {

	public static void main(String} args) {

		Option a = new Option("file", true, "The filename");
		a.setArgs(1);
		a.setArgName("FILENAME");
		a.setType(String.class);
		a.setRequired(true);

		Option b = new Option("foo", "Do you want to foo (optional)");

		Options opts = new Options()
				.addOption(a)
				.addOption(b);

		CommandLineParser parser = new DefaultParser();

		try {
			CommandLine commandLine = parser.parse(opts, args);
			boolean foo = commandLine.hasOption("foo");
			String filename = commandLine.getOptionValue("file");
			System.out.println("File: "+filename + " Foo: "+foo);
		} catch (ParseException e) {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("java CliMain", opts);
		}

	}

}
