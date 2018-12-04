import java.util.Iterator;

public class SkipGenerator<T> implements Iterable<T> {
	private Iterable<T> mSource;
	private int mSkip;

	public SkipGenerator(int n, Iterable<T> source) {
		mSource = source;
		mSkip = n;
	}

	public Iterator<T> iterator() {
		return new SkipIterator();
	}

	private class SkipIterator implements Iterator<T> {

		private Iterator<T> mIterator;

		public SkipIterator() {
			mIterator = mSource.iterator();
		}

		public boolean hasNext() {
			while (mSkip > 0) {
				mSkip--;
				if (mIterator.hasNext()) {
					mIterator.next();
				}
			}
			return mIterator.hasNext();
		}

		public T next() {
			return mIterator.next();
		}
	}

}
