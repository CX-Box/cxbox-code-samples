package core.element.widget.list.rows.stream;

import org.jspecify.annotations.NonNull;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.*;
import java.util.stream.*;


public class StreamWithPagination<T> implements Stream<T> {

	private final Stream<T> streamDelegate;

	private StreamWithPagination(Stream<T> streamDelegate) {
		this.streamDelegate = streamDelegate;
	}

	public static <T> StreamWithPagination<T> of(Stream<T> stream) {
		return new StreamWithPagination<>(stream);
	}

	/**
	 * @param predicate a <a href="package-summary.html#NonInterference">non-interfering</a>,
	 *                  <a href="package-summary.html#Statelessness">stateless</a>
	 *                  predicate to apply to each element to determine if it should be included
	 * @return the new stream
	 */
	@Override
	public StreamWithPagination<T> filter(Predicate<? super T> predicate) {
		return new StreamWithPagination<>(streamDelegate.filter(predicate));
	}


	/**
	 * Returns a stream consisting of the results of applying the given
	 * function to the elements of this stream.
	 *
	 * <p>This is an <a href="package-summary.html#StreamOps">intermediate
	 * operation</a>.
	 *
	 * @param <R>    The element type of the new stream
	 * @param mapper a <a href="package-summary.html#NonInterference">non-interfering</a>,
	 *               <a href="package-summary.html#Statelessness">stateless</a>
	 *               function to apply to each element
	 * @return the new stream
	 */
	@Override
	public <R> Stream<R> map(Function<? super T, ? extends R> mapper) {
		return streamDelegate.map(mapper);
	}


	/**
	 * Returns an {@code IntStream} consisting of the results of applying the
	 * given function to the elements of this stream.
	 *
	 * <p>This is an <a href="package-summary.html#StreamOps">
	 * intermediate operation</a>.
	 *
	 * @param mapper a <a href="package-summary.html#NonInterference">non-interfering</a>,
	 *               <a href="package-summary.html#Statelessness">stateless</a>
	 *               function to apply to each element
	 * @return the new stream
	 */
	@Override
	public IntStream mapToInt(ToIntFunction<? super T> mapper) {
		return streamDelegate.mapToInt(mapper);
	}

	/**
	 * Returns a {@code LongStream} consisting of the results of applying the
	 * given function to the elements of this stream.
	 *
	 * <p>This is an <a href="package-summary.html#StreamOps">intermediate
	 * operation</a>.
	 *
	 * @param mapper a <a href="package-summary.html#NonInterference">non-interfering</a>,
	 *               <a href="package-summary.html#Statelessness">stateless</a>
	 *               function to apply to each element
	 * @return the new stream
	 */
	@Override
	public LongStream mapToLong(ToLongFunction<? super T> mapper) {
		return streamDelegate.mapToLong(mapper);
	}

	/**
	 * Returns a {@code DoubleStream} consisting of the results of applying the
	 * given function to the elements of this stream.
	 *
	 * <p>This is an <a href="package-summary.html#StreamOps">intermediate
	 * operation</a>.
	 *
	 * @param mapper a <a href="package-summary.html#NonInterference">non-interfering</a>,
	 *               <a href="package-summary.html#Statelessness">stateless</a>
	 *               function to apply to each element
	 * @return the new stream
	 */
	@Override
	public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
		return streamDelegate.mapToDouble(mapper);
	}

	/**
	 * Returns a stream consisting of the results of replacing each element of
	 * this stream with the contents of a mapped stream produced by applying
	 * the provided mapping function to each element.  Each mapped stream is
	 * {@link java.util.stream.BaseStream#close() closed} after its contents
	 * have been placed into this stream.  (If a mapped stream is {@code null}
	 * an empty stream is used, instead.)
	 *
	 * <p>This is an <a href="package-summary.html#StreamOps">intermediate
	 * operation</a>.
	 *
	 * @param <R>    The element type of the new stream
	 * @param mapper a <a href="package-summary.html#NonInterference">non-interfering</a>,
	 *               <a href="package-summary.html#Statelessness">stateless</a>
	 *               function to apply to each element which produces a stream
	 *               of new values
	 * @return the new stream
	 * @apiNote The {@code flatMap()} operation has the effect of applying a one-to-many
	 * transformation to the elements of the stream, and then flattening the
	 * resulting elements into a new stream.
	 * @see #mapMulti
	 */
	@Override
	public <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
		return StreamWithPagination.of(streamDelegate.flatMap(mapper));
	}

	/**
	 * Returns an {@code IntStream} consisting of the results of replacing each
	 * element of this stream with the contents of a mapped stream produced by
	 * applying the provided mapping function to each element.  Each mapped
	 * stream is {@link java.util.stream.BaseStream#close() closed} after its
	 * contents have been placed into this stream.  (If a mapped stream is
	 * {@code null} an empty stream is used, instead.)
	 *
	 * <p>This is an <a href="package-summary.html#StreamOps">intermediate
	 * operation</a>.
	 *
	 * @param mapper a <a href="package-summary.html#NonInterference">non-interfering</a>,
	 *               <a href="package-summary.html#Statelessness">stateless</a>
	 *               function to apply to each element which produces a stream
	 *               of new values
	 * @return the new stream
	 * @see #flatMap(Function)
	 */
	@Override
	public IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
		return streamDelegate.flatMapToInt(mapper);
	}

	/**
	 * Returns an {@code LongStream} consisting of the results of replacing each
	 * element of this stream with the contents of a mapped stream produced by
	 * applying the provided mapping function to each element.  Each mapped
	 * stream is {@link java.util.stream.BaseStream#close() closed} after its
	 * contents have been placed into this stream.  (If a mapped stream is
	 * {@code null} an empty stream is used, instead.)
	 *
	 * <p>This is an <a href="package-summary.html#StreamOps">intermediate
	 * operation</a>.
	 *
	 * @param mapper a <a href="package-summary.html#NonInterference">non-interfering</a>,
	 *               <a href="package-summary.html#Statelessness">stateless</a>
	 *               function to apply to each element which produces a stream
	 *               of new values
	 * @return the new stream
	 * @see #flatMap(Function)
	 */
	@Override
	public LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
		return streamDelegate.flatMapToLong(mapper);
	}

	/**
	 * Returns an {@code DoubleStream} consisting of the results of replacing
	 * each element of this stream with the contents of a mapped stream produced
	 * by applying the provided mapping function to each element.  Each mapped
	 * stream is {@link java.util.stream.BaseStream#close() closed} after its
	 * contents have placed been into this stream.  (If a mapped stream is
	 * {@code null} an empty stream is used, instead.)
	 *
	 * <p>This is an <a href="package-summary.html#StreamOps">intermediate
	 * operation</a>.
	 *
	 * @param mapper a <a href="package-summary.html#NonInterference">non-interfering</a>,
	 *               <a href="package-summary.html#Statelessness">stateless</a>
	 *               function to apply to each element which produces a stream
	 *               of new values
	 * @return the new stream
	 * @see #flatMap(Function)
	 */
	@Override
	public DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
		return streamDelegate.flatMapToDouble(mapper);
	}

	/**
	 * Performs an action for each element of this stream.
	 *
	 * <p>This is a <a href="package-summary.html#StreamOps">terminal
	 * operation</a>.
	 *
	 * <p>The behavior of this operation is explicitly nondeterministic.
	 * For parallel stream pipelines, this operation does <em>not</em>
	 * guarantee to respect the encounter order of the stream, as doing so
	 * would sacrifice the benefit of parallelism.  For any given element, the
	 * action may be performed at whatever time and in whatever thread the
	 * library chooses.  If the action accesses shared state, it is
	 * responsible for providing the required synchronization.
	 *
	 * @param action a <a href="package-summary.html#NonInterference">
	 *               non-interfering</a> action to perform on the elements
	 */
	@Override
	public void forEach(Consumer<? super T> action) {
		streamDelegate.forEach(action);
	}

	/**
	 * Performs an action for each element of this stream, in the encounter
	 * order of the stream if the stream has a defined encounter order.
	 *
	 * <p>This is a <a href="package-summary.html#StreamOps">terminal
	 * operation</a>.
	 *
	 * <p>This operation processes the elements one at a time, in encounter
	 * order if one exists.  Performing the action for one element
	 * <a href="../concurrent/package-summary.html#MemoryVisibility"><i>happens-before</i></a>
	 * performing the action for subsequent elements, but for any given element,
	 * the action may be performed in whatever thread the library chooses.
	 *
	 * @param action a <a href="package-summary.html#NonInterference">
	 *               non-interfering</a> action to perform on the elements
	 * @see #forEach(Consumer)
	 */
	@Override
	public void forEachOrdered(Consumer<? super T> action) {
		streamDelegate.forEachOrdered(action);
	}

	/**
	 * Returns a stream consisting of the elements of this stream, additionally
	 * performing the provided action on each element as elements are consumed
	 * from the resulting stream.
	 *
	 * <p>This is an <a href="package-summary.html#StreamOps">intermediate
	 * operation</a>.
	 *
	 * @param action a <a href="package-summary.html#NonInterference">
	 *               non-interfering</a> action to perform on the elements as
	 *               they are consumed from the stream
	 * @return the new stream
	 * @apiNote This method exists mainly to support debugging, where you want
	 * to see the elements as they flow past a certain point in a pipeline:
	 * <pre>{@code
	 *     Stream.of("one", "two", "three", "four")
	 *         .filter(e -> e.length() > 3)
	 *         .peek(e -> System.out.println("Filtered value: " + e))
	 *         .map(String::toUpperCase)
	 *         .peek(e -> System.out.println("Mapped value: " + e))
	 *         .collect(Collectors.toList());
	 * }</pre>
	 *
	 * <p>In cases where the stream implementation is able to optimize away the
	 * production of some or all the elements (such as with short-circuiting
	 * operations like {@code findFirst}, or in the example described in
	 * {@link #count}), the action will not be invoked for those elements.
	 */
	@Override
	public Stream<T> peek(Consumer<? super T> action) {
		return StreamWithPagination.of(streamDelegate.peek(action));
	}

	/**
	 * Returns whether any elements of this stream match the provided
	 * predicate.  May not evaluate the predicate on all elements if not
	 * necessary for determining the result.  If the stream is empty then
	 * {@code false} is returned and the predicate is not evaluated.
	 *
	 * <p>This is a <a href="package-summary.html#StreamOps">short-circuiting
	 * terminal operation</a>.
	 *
	 * @param predicate a <a href="package-summary.html#NonInterference">non-interfering</a>,
	 *                  <a href="package-summary.html#Statelessness">stateless</a>
	 *                  predicate to apply to elements of this stream
	 * @return {@code true} if any elements of the stream match the provided
	 * predicate, otherwise {@code false}
	 * @apiNote This method evaluates the <em>existential quantification</em> of the
	 * predicate over the elements of the stream (for some x P(x)).
	 */
	@Override
	public boolean anyMatch(Predicate<? super T> predicate) {
		return streamDelegate.anyMatch(predicate);
	}

	/**
	 * Returns whether all elements of this stream match the provided predicate.
	 * May not evaluate the predicate on all elements if not necessary for
	 * determining the result.  If the stream is empty then {@code true} is
	 * returned and the predicate is not evaluated.
	 *
	 * <p>This is a <a href="package-summary.html#StreamOps">short-circuiting
	 * terminal operation</a>.
	 *
	 * @param predicate a <a href="package-summary.html#NonInterference">non-interfering</a>,
	 *                  <a href="package-summary.html#Statelessness">stateless</a>
	 *                  predicate to apply to elements of this stream
	 * @return {@code true} if either all elements of the stream match the
	 * provided predicate or the stream is empty, otherwise {@code false}
	 * @apiNote This method evaluates the <em>universal quantification</em> of the
	 * predicate over the elements of the stream (for all x P(x)).  If the
	 * stream is empty, the quantification is said to be <em>vacuously
	 * satisfied</em> and is always {@code true} (regardless of P(x)).
	 */
	@Override
	public boolean allMatch(Predicate<? super T> predicate) {
		return streamDelegate.allMatch(predicate);
	}

	/**
	 * Returns whether no elements of this stream match the provided predicate.
	 * May not evaluate the predicate on all elements if not necessary for
	 * determining the result.  If the stream is empty then {@code true} is
	 * returned and the predicate is not evaluated.
	 *
	 * <p>This is a <a href="package-summary.html#StreamOps">short-circuiting
	 * terminal operation</a>.
	 *
	 * @param predicate a <a href="package-summary.html#NonInterference">non-interfering</a>,
	 *                  <a href="package-summary.html#Statelessness">stateless</a>
	 *                  predicate to apply to elements of this stream
	 * @return {@code true} if either no elements of the stream match the
	 * provided predicate or the stream is empty, otherwise {@code false}
	 * @apiNote This method evaluates the <em>universal quantification</em> of the
	 * negated predicate over the elements of the stream (for all x ~P(x)).  If
	 * the stream is empty, the quantification is said to be vacuously satisfied
	 * and is always {@code true}, regardless of P(x).
	 */
	@Override
	public boolean noneMatch(Predicate<? super T> predicate) {
		return streamDelegate.noneMatch(predicate);
	}

	/**
	 * Returns an {@link Optional} describing the first element of this stream,
	 * or an empty {@code Optional} if the stream is empty.  If the stream has
	 * no encounter order, then any element may be returned.
	 *
	 * <p>This is a <a href="package-summary.html#StreamOps">short-circuiting
	 * terminal operation</a>.
	 *
	 * @return an {@code Optional} describing the first element of this stream,
	 * or an empty {@code Optional} if the stream is empty
	 * @throws NullPointerException if the element selected is null
	 */
	@Override
	public @NonNull Optional<T> findFirst() {
		return streamDelegate.findFirst();
	}

	/**
	 * Returns an {@link Optional} describing some element of the stream, or an
	 * empty {@code Optional} if the stream is empty.
	 *
	 * <p>This is a <a href="package-summary.html#StreamOps">short-circuiting
	 * terminal operation</a>.
	 *
	 * <p>The behavior of this operation is explicitly nondeterministic; it is
	 * free to select any element in the stream.  This is to allow for maximal
	 * performance in parallel operations; the cost is that multiple invocations
	 * on the same source may not return the same result.  (If a stable result
	 * is desired, use {@link #findFirst()} instead.)
	 *
	 * @return an {@code Optional} describing some element of this stream, or an
	 * empty {@code Optional} if the stream is empty
	 * @throws NullPointerException if the element selected is null
	 * @see #findFirst()
	 */
	@Override
	public @NonNull Optional<T> findAny() {
		return streamDelegate.findAny();
	}

	/**
	 * Returns an iterator for the elements of this stream.
	 *
	 * <p>This is a <a href="package-summary.html#StreamOps">terminal
	 * operation</a>.
	 *
	 * @return the element iterator for this stream
	 */
	@Override
	public @NonNull Iterator<T> iterator() {
		return streamDelegate.iterator();
	}

	/**
	 * Returns a spliterator for the elements of this stream.
	 *
	 * <p>This is a <a href="package-summary.html#StreamOps">terminal
	 * operation</a>.
	 *
	 * <p>
	 * The returned spliterator should report the set of characteristics derived
	 * from the stream pipeline (namely the characteristics derived from the
	 * stream source spliterator and the intermediate operations).
	 * Implementations may report a sub-set of those characteristics.  For
	 * example, it may be too expensive to compute the entire set for some or
	 * all possible stream pipelines.
	 *
	 * @return the element spliterator for this stream
	 */
	@Override
	public @NonNull Spliterator<T> spliterator() {
		return streamDelegate.spliterator();
	}

	/**
	 * Returns the count of elements in this stream.  This is a special case of
	 * a <a href="package-summary.html#Reduction">reduction</a> and is
	 * equivalent to:
	 * <pre>{@code
	 *     return mapToLong(e -> 1L).sum();
	 * }</pre>
	 *
	 * <p>This is a <a href="package-summary.html#StreamOps">terminal operation</a>.
	 *
	 * @return the count of elements in this stream
	 * @apiNote An implementation may choose to not execute the stream pipeline (either
	 * sequentially or in parallel) if it is capable of computing the count
	 * directly from the stream source.  In such cases no source elements will
	 * be traversed and no intermediate operations will be evaluated.
	 * Behavioral parameters with side-effects, which are strongly discouraged
	 * except for harmless cases such as debugging, may be affected.  For
	 * example, consider the following stream:
	 * <pre>{@code
	 *     List<String> l = Arrays.asList("A", "B", "C", "D");
	 *     long count = l.stream().peek(System.out::println).count();
	 * }</pre>
	 * The number of elements covered by the stream source, a {@code List}, is
	 * known and the intermediate operation, {@code peek}, does not inject into
	 * or remove elements from the stream (as may be the case for
	 * {@code flatMap} or {@code filter} operations).  Thus the count is the
	 * size of the {@code List} and there is no need to execute the pipeline
	 * and, as a side-effect, print out the list elements.
	 */
	@Override
	public long count() {
		return streamDelegate.count();
	}

	/**
	 * Returns an equivalent stream that is sequential.  May return
	 * itself, either because the stream was already sequential, or because
	 * the underlying stream state was modified to be sequential.
	 *
	 * <p>This is an <a href="package-summary.html#StreamOps">intermediate
	 * operation</a>.
	 *
	 * @return a sequential stream
	 */
	@Override
	public @NonNull Stream<T> sequential() {
		return new StreamWithPagination<T>(streamDelegate.sequential());
	}

	/**
	 * Returns an equivalent stream with an additional close handler.  Close
	 * handlers are run when the {@link #close()} method
	 * is called on the stream, and are executed in the order they were
	 * added.  All close handlers are run, even if earlier close handlers throw
	 * exceptions.  If any close handler throws an exception, the first
	 * exception thrown will be relayed to the caller of {@code close()}, with
	 * any remaining exceptions added to that exception as suppressed exceptions
	 * (unless one of the remaining exceptions is the same exception as the
	 * first exception, since an exception cannot suppress itself.)  May
	 * return itself.
	 *
	 * <p>This is an <a href="package-summary.html#StreamOps">intermediate
	 * operation</a>.
	 *
	 * @param closeHandler A task to execute when the stream is closed
	 * @return a stream with a handler that is run if the stream is closed
	 */
	@Override
	public @NonNull Stream<T> onClose(@NonNull Runnable closeHandler) {
		return StreamWithPagination.of(streamDelegate.onClose(closeHandler));
	}

	/**
	 * Closes this stream, causing all close handlers for this stream pipeline
	 * to be called.
	 *
	 * @see AutoCloseable#close()
	 */
	@Override
	public void close() {
		streamDelegate.close();
	}


	// UNSAFE


	@Deprecated
	@Override
	public Stream<T> distinct() {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public Stream<T> sorted() {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public Stream<T> sorted(Comparator<? super T> comparator) {
		throw new UnsupportedOperationException();
	}


	@Deprecated
	@Override
	public Stream<T> limit(long maxSize) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public Stream<T> skip(long n) {
		throw new UnsupportedOperationException();
	}


	@Deprecated
	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public <A> A[] toArray(IntFunction<A[]> generator) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public T reduce(T identity, BinaryOperator<T> accumulator) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public @NonNull Optional<T> reduce(BinaryOperator<T> accumulator) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public <R, A> R collect(Collector<? super T, A, R> collector) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public @NonNull Optional<T> min(Comparator<? super T> comparator) {
		throw new UnsupportedOperationException();

	}

	@Deprecated
	@Override
	public @NonNull Optional<T> max(Comparator<? super T> comparator) {
		throw new UnsupportedOperationException();
	}


	@Deprecated
	@Override
	public boolean isParallel() {
		throw new UnsupportedOperationException();
	}


	@Deprecated
	@Override
	public @NonNull Stream<T> parallel() {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public @NonNull Stream<T> unordered() {
		throw new UnsupportedOperationException();
	}


}