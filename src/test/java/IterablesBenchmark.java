
import com.google.caliper.Benchmark;
import com.google.caliper.runner.CaliperMain;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.monitoring.runtime.instrumentation.common.com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.collect.Iterables.transform;

public class IterablesBenchmark {

    public static void main(String[] args) {
        CaliperMain.main(CollectListToList.class, args);

    }

    private static final com.google.common.base.Function<String, String> guavaIdentity = new com.google.common.base.Function<String, String>() {
        @Override
        public String apply(String s) {
            return s;
        }
    };

    private static final java.util.function.Function<String, String> streamsIdentity = new java.util.function.Function<String, String>() {
        @Override
        public String apply(String s) {
            return s;
        }
    };


    private static String[] data = new String[1000];
    static {
        Arrays.fill(data, "hello");
    }

    private static List<String> list = Arrays.asList(data);


    public static class CollectListToList {

        @Benchmark void iterate(int reps) {
            for (int i = 0; i < reps; i++) {
                ArrayList<String> result = new ArrayList<String>(list.size());
                for (String each : list) {
                    result.add(each);
                }
            }
        }

        @Benchmark void guava(int reps) {
            for (int i = 0; i < reps; i++) {
                List<String> result = Lists.newArrayList(transform(list, guavaIdentity));
            }
        }

        @Benchmark void streams(int reps) {
            for (int i = 0; i < reps; i++) {
                List<String> result = list.stream().map(streamsIdentity).collect(Collectors.toList());
            }
        }
    }

}