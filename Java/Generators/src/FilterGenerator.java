import java.util.Iterator;
import java.util.function.Predicate;

//	private class FilterIterator implements Iterator<T> {
//		private T mNext;
//		private Iterator<T> mIterator;
//		
//		public FilterIterator() {
//			mIterator = mSource.iterator();
//			mNext = findNext();
//		}
//		
//	}
public class FilterGenerator<T> implements Iterable<T> {
	private Iterable<T> mSource;
	private Predicate<T> mPredicate;
	int i = 0;

	public FilterGenerator(Predicate<T> pred, Iterable<T> source) {
		mSource = source;
		mPredicate = pred;
	}

	public Iterator<T> iterator() {
		return new FilterIterator();
	}

	private class FilterIterator implements Iterator<T> {
		private T mNext;
		private Iterator<T> mIterator;

		public FilterIterator() {
			mIterator = mSource.iterator();
		}

		// private T findNext() {
		// while (mIterator.hasNext()) {
		// T temp = mIterator.next();
		// if (mPredicate.test(temp)) {
		// return temp;
		// }
		// }
		// return null;
		// }
		//
		// public boolean hasNext() {
		// return mNext != null;
		// }
		//
		// public T next() {
		// T temp = mNext;
		// mNext = findNext();
		// return temp;
		// }

		public boolean hasNext() {
			while (mIterator.hasNext()) {
				mNext = mIterator.next();
				if (mPredicate.test(mNext)) {
					return true;
				}
			}
			return mIterator.hasNext();
		}

		public T next() {
			return mNext;
		}
	}
}