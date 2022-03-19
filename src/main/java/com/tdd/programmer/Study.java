package com.tdd.programmer;

public class Study {

    private StudyStatus status = StudyStatus.DRAFT;

    public Study(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit 은 0 보다 커야 합니다.");
        }
        this.limit = limit;
    }

    private int limit;

    public StudyStatus getStatus() {
        return this.status;
    }

    public int getLimit() {
        return limit;
    }
}
