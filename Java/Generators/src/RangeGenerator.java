import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Neal
 */
public class RangeGenerator implements Iterable<Integer> {
	private int mStart, mEnd, mIncrement;

	public RangeGenerator(int start, int end, int incr) {
		mStart = start;
		mEnd = end;
		mIncrement = incr;
	}

	public Iterator<Integer> iterator() {
		return new RangeIterator();
	}

	private class RangeIterator implements Iterator<Integer> {
		private int mCurrent;

		public RangeIterator() {
			mCurrent = mStart;
		}

		public boolean hasNext() {
			return mCurrent <= mEnd;
		}

		public Integer next() {
			int temp = mCurrent;
			mCurrent += mIncrement;
			return temp;
		}
	}

}