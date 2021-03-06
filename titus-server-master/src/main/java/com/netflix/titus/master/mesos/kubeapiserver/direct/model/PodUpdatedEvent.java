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

package com.netflix.titus.master.mesos.kubeapiserver.direct.model;

import java.util.Objects;
import java.util.Optional;

import io.kubernetes.client.models.V1Node;
import io.kubernetes.client.models.V1Pod;

public class PodUpdatedEvent extends PodEvent {

    private final V1Pod oldPod;
    private final Optional<V1Node> node;

    PodUpdatedEvent(V1Pod oldPod, V1Pod newPod, Optional<V1Node> node) {
        super(newPod);
        this.oldPod = oldPod;
        this.node = node;
    }

    public V1Pod getOldPod() {
        return oldPod;
    }

    public Optional<V1Node> getNode() {
        return node;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        PodUpdatedEvent that = (PodUpdatedEvent) o;
        return Objects.equals(oldPod, that.oldPod) &&
                Objects.equals(node, that.node);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), oldPod, node);
    }

    @Override
    public String toString() {
        return "PodUpdatedEvent{" +
                "taskId='" + taskId + '\'' +
                ", pod=" + pod +
                ", oldPod=" + oldPod +
                ", node=" + node.map(n -> n.getMetadata().getName()).orElse("<not_assigned>") +
                '}';
    }
}
