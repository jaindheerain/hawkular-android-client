/*
 * Copyright 2015-2017 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hawkular.client.android.util;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import org.hawkular.client.android.activity.AlertsActivity;
import org.hawkular.client.android.activity.LoginActivity;
import org.hawkular.client.android.activity.MetricActivity;
import org.hawkular.client.android.activity.MetricsActivity;
import org.hawkular.client.android.backend.model.Environment;
import org.hawkular.client.android.backend.model.Metric;
import org.hawkular.client.android.backend.model.Resource;

/**
 * Intent utilities.
 * <p/>
 * {@link org.hawkular.client.android.util.Intents.Extras} contains extra-related constants.
 * {@link org.hawkular.client.android.util.Intents.Builder} helps with building intents with right extras.
 */
public final class Intents {
    private Intents() {
    }

    public static final class Extras {
        private Extras() {
        }

        public static final String ALERT = "alert";
        public static final String ENVIRONMENT = "environment";
        public static final String RESOURCE = "resource";
        public static final String METRIC = "metric";
        public static final String HOST = "host";
        public static final String PORT = "port";
        public static final String TRIGGER = "trigger";
    }

    public static final class Requests {
        private Requests() {
        }

        public static final int AUTHORIZATION = 42;
        public static final int DEAUTHORIZATION = 24;
    }

    public static final class Builder {
        private final Context context;

        @NonNull
        public static Builder of(@NonNull Context context) {
            return new Builder(context);
        }

        private Builder(Context context) {
            this.context = context;
        }

        @NonNull
        public Intent buildAlertsIntent(@NonNull Resource resource) {
            Intent intent = new Intent(context, AlertsActivity.class);
            intent.putExtra(Extras.RESOURCE, resource);

            return intent;
        }

        @NonNull
        public Intent buildMetricIntent(@NonNull Metric metric) {
            Intent intent = new Intent(context, MetricActivity.class);
            intent.putExtra(Extras.METRIC, metric);

            return intent;
        }

        @NonNull
        public Intent buildMetricsIntent(@NonNull Environment environment, @NonNull Resource resource) {
            Intent intent = new Intent(context, MetricsActivity.class);
            intent.putExtra(Extras.ENVIRONMENT, environment);
            intent.putExtra(Extras.RESOURCE, resource);

            return intent;
        }

        @NonNull
        public Intent buildLoginIntent(@NonNull String host, @NonNull String port) {
            Intent intent = new Intent(context, LoginActivity.class);
            intent.putExtra(Extras.HOST, host);
            intent.putExtra(Extras.PORT, port);

            return intent;
        }

    }

}
