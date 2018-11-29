package org.skywalking.apm.cnutcon.liveshow.projecta.trace;

import io.opentracing.Tracer;
import org.apache.skywalking.apm.toolkit.opentracing.SkywalkingTracer;

public class TracerFactory {

    private static final Tracer TRACER = new SkywalkingTracer();

    public static Tracer getTracer() {
        return TRACER;
    }
}
