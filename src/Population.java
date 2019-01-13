import java.util.Random;

public class Population {

	private int[][] mLevels;

	public Population(int n) {
		Random r = new Random();

		mLevels = new int[n][];
		for (int i = 0; i < n; i++) {
			mLevels[i] = new int[2 * i + 1];
			for (int j = 0; j < 2 * i + 1; j++) {
				int losuLosu = r.nextInt(3) - 1;
				mLevels[i][j] = losuLosu;
			}
		}
	}

	public String toString() {
		String s = "";
		int maxLen = mLevels[mLevels.length - 1].length;
		int offset = maxLen;

		for (int i = 0; i < mLevels.length; i++) {
			for (int k = 0; k < offset; k++) {
				s += " ";
			}
			offset -= 2;

			for (int j = 0; j < mLevels[i].length; j++) {
				switch (mLevels[i][j]) {
				case -1:
					s += "l ";
					break;
				case 0:
					s += "0 ";
					break;
				case 1:
					s += "p ";
					break;
				}
			}
			s += "\n";
		}

		return s;
	}
}
