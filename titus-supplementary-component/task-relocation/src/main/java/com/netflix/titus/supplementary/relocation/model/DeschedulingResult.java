package com.netflix.titus.supplementary.relocation.model;

import java.util.Objects;

import com.netflix.titus.api.agent.model.AgentInstance;
import com.netflix.titus.api.jobmanager.model.job.Task;

public class DeschedulingResult {

    private final TaskRelocationPlan taskRelocationPlan;
    private final Task task;
    private final AgentInstance agentInstance;

    public DeschedulingResult(TaskRelocationPlan taskRelocationPlan,
                              Task task,
                              AgentInstance agentInstance) {
        this.taskRelocationPlan = taskRelocationPlan;
        this.task = task;
        this.agentInstance = agentInstance;
    }

    public TaskRelocationPlan getTaskRelocationPlan() {
        return taskRelocationPlan;
    }

    public Task getTask() {
        return task;
    }

    public AgentInstance getAgentInstance() {
        return agentInstance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeschedulingResult that = (DeschedulingResult) o;
        return Objects.equals(taskRelocationPlan, that.taskRelocationPlan) &&
                Objects.equals(task, that.task) &&
                Objects.equals(agentInstance, that.agentInstance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskRelocationPlan, task, agentInstance);
    }

    @Override
    public String toString() {
        return "DeschedulingResult{" +
                "taskRelocationPlan=" + taskRelocationPlan +
                ", task=" + task +
                ", agentInstance=" + agentInstance +
                '}';
    }

    public Builder toBuilder() {
        return newBuilder().withTaskRelocationPlan(taskRelocationPlan).withTask(task).withAgentInstance(agentInstance);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private TaskRelocationPlan taskRelocationPlan;
        private Task task;
        private AgentInstance agentInstance;

        private Builder() {
        }

        public Builder withTaskRelocationPlan(TaskRelocationPlan taskRelocationPlan) {
            this.taskRelocationPlan = taskRelocationPlan;
            return this;
        }

        public Builder withTask(Task task) {
            this.task = task;
            return this;
        }

        public Builder withAgentInstance(AgentInstance agentInstance) {
            this.agentInstance = agentInstance;
            return this;
        }

        public DeschedulingResult build() {
            return new DeschedulingResult(taskRelocationPlan, task, agentInstance);
        }
    }
}