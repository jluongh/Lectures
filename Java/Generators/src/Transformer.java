public interface Transformer<TIn, TOut> {
	TOut transform(TIn value);	
}
