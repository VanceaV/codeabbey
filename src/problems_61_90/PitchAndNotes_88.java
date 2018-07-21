package problems_61_90;

import java.util.Scanner;

public class PitchAndNotes_88 {

	private final Scanner scan = new Scanner(System.in);
	private final String[] notes = { "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B" };
	private final double fouth_Octave_start = 440.0 / Math.pow(2, 10 / 12.0);

	public static void main(String[] args) {

		PitchAndNotes_88 pn = new PitchAndNotes_88();
		pn.result();
	}

	private void result() {
		int iter = scan.nextInt();
		scan.nextLine();
		while (iter-- > 0)
			System.out.print(frequencies(scan.next()) + " ");
	}

	private int frequencies(String note) {
		int octave = Integer.parseInt(note.substring(note.length() - 1));
		note = note.substring(0, note.length() - 1);

		double startOctave;
		if (octave - 4 < 0) {
			startOctave = fouth_Octave_start / Math.pow(2, 4 - octave);
		} else {
			startOctave = fouth_Octave_start * Math.pow(2, octave - 4);
		}

		int step = sptepsFromA(note);

		return (int) Math.round(startOctave * Math.pow(2, step / 12.0));
	}

	private int sptepsFromA(String note) {

		int steps = 0;
		for (int i = 0; i < 12; i++) {
			if (note.equals(notes[i])) {
				steps = i;
			}
		}
		return steps + 1;
	}
}
