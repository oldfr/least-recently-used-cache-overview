package com.example.least_recently_used_cache_overview.model;

import java.util.Objects;

public class StudentCacheData {

    private String dataKey;
    private String dataDetails;

    public StudentCacheData(String dataKey, String dataDetails) {
        this.dataKey = dataKey;
        this.dataDetails = dataDetails;
    }

    public String getDataKey() {
        return dataKey;
    }

    public void setDataKey(String dataKey) {
        this.dataKey = dataKey;
    }

    public String getDataDetails() {
        return dataDetails;
    }

    public void setDataDetails(String dataDetails) {
        this.dataDetails = dataDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentCacheData that = (StudentCacheData) o;
        return Objects.equals(dataKey, that.dataKey) && Objects.equals(dataDetails, that.dataDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataKey, dataDetails);
    }

    @Override
    public String toString() {
        return "StudentCacheData{" +
                "dataKey='" + dataKey + '\'' +
                ", dataDetails='" + dataDetails + '\'' +
                '}';
    }
}
