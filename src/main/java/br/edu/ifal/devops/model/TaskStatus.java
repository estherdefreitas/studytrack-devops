package br.edu.ifal.devops.model;

import lombok.Getter;

@Getter
public enum TaskStatus {

    TODO(1),
    DOING(2),
    DONE(3);

    private final int code;

    TaskStatus(int code) {
        this.code = code;
    }

    public static TaskStatus fromCode(int code) {
        for (TaskStatus taskStatus : TaskStatus.values()) {
            if (taskStatus.getCode() == code) {
                return taskStatus;
            }
        }
        throw new IllegalArgumentException("No OrderStatus with code " + code + " found");
    }
}
