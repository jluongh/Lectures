import java.util.Iterator;
import java.util.function.Predicate;


public class TakeWhileGenerator<T> implements Iterable<T> {
	private Iterable<T> mSource;
	private Predicate<T> mPredicate;

	public TakeWhileGenerator(Predicate<T> pred, Iterable<T> source) {
		mSource = source;
		mPredicate = pred;
	}

	public Iterator<T> iterator() {
		return new TakeWhileIterator();
	}

	private class TakeWhileIterator implements Iterator<T> {
		private T mNext;
		private Iterator<T> mIterator;
		
		public TakeWhileIterator() {
			mIterator = mSource.iterator();
		}

		public boolean hasNext() {
			// Check to see if iterator has a next value
			if (mIterator.hasNext()) {
				mNext = mIterator.next();
				// Return value of testing the predicate 
				return mPredicate.test(mNext);
			}
			return false;
		}

		public T next() {
			return mNext;
		}
	}

}