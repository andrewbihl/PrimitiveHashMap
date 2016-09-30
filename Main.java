import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		File file;
		Integer mapSize;
		try {
			file = new File(args[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			file = new File("hawthorne.txt");
		}
		try {
			mapSize = Integer.parseInt(args[1]);
		} catch (ArrayIndexOutOfBoundsException e1) {
			mapSize = 10000;
		}
		ArrayList<String> strings = loadStringsFromFile(file);
		if (strings == null) {
			System.out.println("Failed to load in Strings.");
			return;
		}
		System.out.println("––––––––––––––––––––––––––––––––––––––––––––––––––––");
		System.out.println("Input File: " + file.getName());
		System.out.println("HashMap size: "+mapSize+"\n");
		HashMap map = new HashMap(mapSize);
		runSetTest(map, strings);
		runGetTest(map, strings);
		runDeleteTest(map, strings);
		System.out.println("––––––––––––––––––––––––––––––––––––––––––––––––––––\n");
	}

	private static ArrayList<String> loadStringsFromFile(File file) {
		ArrayList<String> loadedStrings = new ArrayList<String>();
		Scanner input;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		while (input.hasNext()) {
			loadedStrings.add(input.next());
		}
		input.close();
		return loadedStrings;
	}

	private static void runSetTest(HashMap map, ArrayList<String> strings) {
		long start = System.nanoTime();
		boolean[] successes = new boolean[strings.size() / 2];
		for (int i = 0; i < strings.size() - 1; i += 2) {
			String s1 = strings.get(i);
			String s2 = strings.get(i + 1);
			successes[i / 2] = map.set(s1, s2);
		}
		long stop = System.nanoTime();
		long timeElapsed = TimeUnit.NANOSECONDS.toMillis(stop - start);
		System.out.println("SET TEST Results:");
		System.out.println("Time elapsed: " + timeElapsed + " milliseconds..." + (stop - start) + " nanoseconds");
		System.out.println("Final load of hash map: " + map.load() + "\n");
	}

	private static void runGetTest(HashMap map, ArrayList<String> strings) {
		long start = System.nanoTime();
		String[] successes = new String[strings.size() / 2];
		for (int i = 0; i < strings.size() - 1; i += 2) {
			String s1 = strings.get(i);
			successes[i / 2] = (String) map.get(s1);
		}
		long stop = System.nanoTime();
		long timeElapsed = TimeUnit.NANOSECONDS.toMillis(stop - start);
		System.out.println("GET TEST Results:");
		System.out.println("Time elapsed: " + timeElapsed + " milliseconds..." + (stop - start) + " nanoseconds");
		System.out.println("Final load of hash map: " + map.load() + "\n");
	}

	private static void runDeleteTest(HashMap map, ArrayList<String> strings) {
		long start = System.nanoTime();
		String[] successes = new String[strings.size() / 2];
		for (int i = 0; i < strings.size() - 1; i += 2) {
			String s1 = strings.get(i);
			successes[i / 2] = (String) map.delete(s1);
		}
		long stop = System.nanoTime();
		long timeElapsed = TimeUnit.NANOSECONDS.toMillis(stop - start);
		System.out.println("DELETE TEST Results:");
		System.out.println("Time elapsed: " + timeElapsed + " milliseconds..." + (stop - start) + " nanoseconds");
		System.out.println("Final load of hash map: " + map.load());
	}

}
