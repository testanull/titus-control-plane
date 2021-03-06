/*
 * Copyright 2020 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.titus.master.mesos.kubeapiserver.direct;

import com.netflix.archaius.api.annotations.Configuration;
import com.netflix.archaius.api.annotations.DefaultValue;

@Configuration(prefix = "titusMaster.directKube")
public interface DirectKubeConfiguration {

    /**
     * @return the registry URL that will be merged with the image name.
     */
    @DefaultValue("")
    String getRegistryUrl();

    /**
     * @return whether or not the nested containers should be allowed.
     */
    @DefaultValue("false")
    boolean isNestedContainersEnabled();

    /**
     * @return the min that can be set on the killWaitSeconds field. The default value will be used instead if the value specified
     * is lower than the min.
     */
    @DefaultValue("10")
    int getMinKillWaitSeconds();

    /**
     * @return the max that can be set on the killWaitSeconds field. The default value will be used instead if the value specified
     * is greater than the max.
     */
    @DefaultValue("300")
    int getMaxKillWaitSeconds();

    /**
     * @return maximum amount of seconds to wait before forcefully terminating a container.
     */
    @DefaultValue("10")
    int getDefaultKillWaitSeconds();

    /**
     * @return how often to trigger a full reconciliation of nodes/pods
     */
    @DefaultValue("300000" /* 5 min */)
    long getKubeApiServerIntegratorRefreshIntervalMs();

    /**
     * @return how often to trigger a full reconciliation of available opportunistic resources
     */
    @DefaultValue("600000" /* 10 min */)
    long getKubeOpportunisticRefreshIntervalMs();

    /**
     * Thread pool size for handling Kube apiClient calls.
     */
    @DefaultValue("20")
    int getApiClientThreadPoolSize();

    @DefaultValue("5000")
    long getKubeApiClientTimeoutMs();
}
