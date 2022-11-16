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
        INT_INTARRAY_THEN_LONGARRAY(Collector::whenIntIntArrayThenReturnLongArray),
        INT_INTARRAY_INT_INTARRAY_THEN_LONGARRAY(Collector::whenIntIntArrayIntIntArrayThenReturnLongArray);

        final Consumer<Class<?>> consumer;

        ExecutableFiles(Consumer<Class<?>> consumer) {
           this.consumer = consumer;
        }

        public Consumer<Class<?>> getConsumer() {
            return consumer;
        }
    }
}
