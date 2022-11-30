package collector;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.function.Consumer;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CreateExecutableFileFrom {
    ExecutableFiles value();

    enum ExecutableFiles {
        INT_INTARRAY_THEN_LONGARRAY(clazz -> Collector.createAnswer(clazz,
                "whenIntAndIntArrayThenLongArray.txt")),
        INT_INTARRAY_INT_TWODINTARRAY_THEN_LONGARRAY(clazz -> Collector.createAnswer(clazz,
                "whenIntAndIntArrayAndIntAndTwoDIntArrayThenLongArray.txt")),

        INT_INTARRAY_INT_TWODINTARRAY_THEN_INTARRAY(clazz -> Collector.createAnswer(clazz,
                "whenIntAndIntArrayAndIntAndTwoDIntArrayThenIntArray.txt")),

        INT_INT_TWODINTARRAY_INT_TWODINTARRAY_THEN_LONGARRAY(clazz -> Collector.createAnswer(clazz,
                "whenIntAndIntAndTwoDIntArrayAndIntAndTwoDIntArrayThenLongArray.txt")),

        INT_INT_TWODINTARRAY_INT_TWODINTARRAY_THEN_TWODLONGARRAY(clazz -> Collector.createAnswer(clazz,
                "whenIntAndIntAndTwoDIntArrayAndIntAndTwoDIntArrayThenTwoDLongArray.txt")),

        INT_INTARRAY_TWODINTARRAY_THEN_LARRAY(clazz -> Collector.createAnswer(clazz,
                "whenIntAndIntArrayAndTwoDIntArrayThenLArray.txt")),

        INT_INTARRAY_THEN_INTARRAY(clazz -> Collector.createAnswer(clazz,
                "whenIntAndIntArrayThenIntArray.txt")),

        BUFFEREDREADER_THEN_LONGARRAY(clazz -> Collector.createAnswer(clazz,
                "whenBufferedReaderThenLongArray.txt")),

        BUFFEREDREADER_THEN_LARRAY(clazz -> Collector.createAnswer(clazz,
                "whenBufferedReaderThenLArray.txt")),
        BUFFEREDREADER_THEN_L(clazz -> Collector.createAnswer(clazz,
                "whenBufferedReaderThenL.txt"));

        final Consumer<Class<?>> consumer;

        ExecutableFiles(Consumer<Class<?>> consumer) {
           this.consumer = consumer;
        }

        public Consumer<Class<?>> getConsumer() {
            return consumer;
        }
    }
}
