package problems_61_90;

import java.util.Scanner;

public class InstrumentTuner_89 {

	private final Scanner scan = new Scanner(System.in);
	private final String[] notes = { "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B" };
	private final double fouth_Octave_start = 440.0 / Math.pow(2, 10 / 12.0);

	public static void main(String[] args) {

		InstrumentTuner_89 pn = new InstrumentTuner_89();
		pn.result();
	}

	private void result() {
		int iter = scan.nextInt();
		while (iter-- > 0)
			System.out.print(index(scan.nextDouble()) + " ");
	}

	private String index(double frequence) {

		int i = 1;
		double startOctave, finishOctave;
		while (true) {
			if (i - 4 < 0) {
				startOctave = fouth_Octave_start / Math.pow(2, 4 - i);
				finishOctave = fouth_Octave_start / Math.pow(2, 3 - i);
			} else {
				startOctave = fouth_Octave_start * Math.pow(2, i - 4);
				finishOctave = fouth_Octave_start * Math.pow(2, i - 3);
			}

			if (frequence > startOctave && frequence < finishOctave)
				break;
			i++;
		}

		int index = 0;

		for (int j = 1; j < 12; j++) {

			double a = startOctave * Math.pow(2, j / 12.0);
			double b = startOctave * Math.pow(2, (j + 1) / 12.0);

			if (frequence > a && frequence < b) {


					if (frequence - a < b - frequence)
						index = j - 1;

					else
						index = j;
			}
		}

		return notes[index] + i;
	}

}