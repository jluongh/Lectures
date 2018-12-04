import java.util.Iterator;

//public class MapGenerator<TIn, TOut> implements Generator<TOut> {
//   private MapFunction<TIn, TOut> mTransform;
//   private Generator<TIn> mSource;
//   
//   public MapGenerator(MapFunction<TIn, TOut> transform, Generator<TIn> source) {
//      mTransform = transform;
//      mSource = source;
//   }
//   
//   public boolean hasNext() {
//      return mSource.hasNext();
//   }
//   
//   public TOut next() {
//      return mapNext();
//   }
//   
//   private TOut mapNext() {
//      TIn  next = mSource.next();
//      TOut transformed = mTransform.transform(next);
//      System.out.println("Transformed: " + next + " to " + transformed);
//      return transformed;
//   }
//}

public class MapGenerator<TIn, TOut> implements Iterable<TOut> {
	private Transformer<TIn, TOut> mTransform;
	private Iterable<TIn> mSource;

	public MapGenerator(Transformer<TIn, TOut> transform, Iterable<TIn> source) {
		mTransform = transform;
		mSource = source;
	}

	public Iterator<TOut> iterator() {
		return new MapIterator();
	}
	
	private class MapIterator implements Iterator<TOut> {
		private Iterator<TIn> mIterator;
		
		public MapIterator() {
			mIterator = mSource.iterator();
		}

		private TOut mapNext() {
			TIn next = mIterator.next();
			TOut transformed = mTransform.transform(next);
			return transformed;
		}
		
		public boolean hasNext() {
			return mIterator.hasNext();
		}

		public TOut next() {
			return mapNext();
		}
		
		
	}
	
	

}