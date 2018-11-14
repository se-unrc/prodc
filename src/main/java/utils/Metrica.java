package utils;

import com.codahale.metrics.*;
import java.util.concurrent.TimeUnit;

public class Metrica{
	
	static final MetricRegistry metrics = new MetricRegistry();
	
	public static MetricRegistry getRegistry(){
		return metrics;
	}
	
	public static void startReport() {
		  ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics)
			  .convertRatesTo(TimeUnit.SECONDS)
			  .convertDurationsTo(TimeUnit.MILLISECONDS)
			  .build();
		  reporter.start(1, TimeUnit.SECONDS);
	}

}
