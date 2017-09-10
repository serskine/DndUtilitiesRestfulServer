package com.soupthatisthick.dnd.utilities.server.api.common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owner on 9/9/2017.
 */
public class PagedApiResponse<A extends Serializable> extends ApiResponse<ArrayList<A>> {

    @JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
    private List<A> results = new ArrayList<>();

    private PagingStats stats;

    public PagedApiResponse() {

    }

    public PagedApiResponse(@NotNull List<A> results, @NotNull PagingStats stats) {
        this();
        this.results = results;
        this.stats = stats;
    }

    public PagedApiResponse(@NotNull List<A> results) {
        this();
        this.results = results;
        this.stats = PagingStats.getSinglePage(results.size());
    }

    // ------------------------------- GETTERS AND SETTERS ------------------------------- //

    public PagingStats getStats() {
        return stats;
    }

    public void setStats(PagingStats stats) {
        this.stats = stats;
    }

    @Override
    public final ArrayList<A> getData() {
        return new ArrayList<>(getResults());
    }

    @Override
    public final void setData(ArrayList<A> results) {
        setResults(results);
    }


    public List<A> getResults() {
        return results;
    }

    public void setResults(List<A> results) {
        this.results = results;
    }
}


