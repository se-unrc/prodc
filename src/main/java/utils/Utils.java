package Utils;

import com.codahale.metrics.*;
import java.util.concurrent.TimeUnit;

public class Utils{

static final MetricRegistry metrics = new MetricRegistry();

public static void main(String args[]) {
    startReport();
    Meter requests = metrics.meter("requests");
    requests.mark();
    wait3Seconds();
    }

    static void startReport() {
        ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics)
        .convertRatesTo(TimeUnit.SECONDS)
        .convertDurationsTo(TimeUnit.MILLISECONDS)
        .build();
        reporter.start(1, TimeUnit.SECONDS);
    }

    static void wait3Seconds() {
        try { Thread.sleep(3*1000);}
        catch(InterruptedException e) {}
    }

}
