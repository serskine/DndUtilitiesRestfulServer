package com.soupthatisthick.dnd.utilities.server.api.common;

import com.soupthatisthick.dnd.utilities.server.service.common.base.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.domain.Page;

/**
 * Created by Owner on 9/9/2017.
 */
public class PagingStats extends BaseModel {

    @ApiModelProperty(required = true, notes = "requested page number")
    private int requestedPageNumber;

    @ApiModelProperty(required = true, notes = "requested page size")
    private int requestedPageSize;

    @ApiModelProperty(required = true, notes = "total number of records available")
    private int totalElements;

    @ApiModelProperty(required = true, notes = "total number of pages available")
    private int totalPages;

    @ApiModelProperty(required = true, notes = "count of records on the requested page")
    private int count;

    @ApiModelProperty(required = true, notes = "flag to indicate if this the first page")
    private boolean firstPage;

    @ApiModelProperty(required = true, notes = "flag to indicate if this is the last page")
    private boolean lastPage;


    public PagingStats() {

    }

    public PagingStats(Page page) {

    }

    /**
     * This will return paging stats that would contain all the expected elements on a single page.
     * @param numItems is the total number of elements in the collection
     * @return {@link PagingStats} where all elements are on a single page.
     */
    public static final PagingStats getSinglePage(int numItems) {
        PagingStats stats = new PagingStats();
        stats.setFirstPage(true);
        stats.setLastPage(true);
        stats.setCount(numItems);
        stats.setRequestedPageNumber(0);
        stats.setRequestedPageSize(numItems);
        stats.setTotalPages(1);
        stats.setTotalElements(numItems);
        return stats;
    }

    // ------------------------------- GETTERS AND SETTERS ------------------------------- //

    public int getRequestedPageNumber() {
        return requestedPageNumber;
    }

    public void setRequestedPageNumber(int requestedPageNumber) {
        this.requestedPageNumber = requestedPageNumber;
    }

    public int getRequestedPageSize() {
        return requestedPageSize;
    }

    public void setRequestedPageSize(int requestedPageSize) {
        this.requestedPageSize = requestedPageSize;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isFirstPage() {
        return firstPage;
    }

    public void setFirstPage(boolean firstPage) {
        this.firstPage = firstPage;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }
}
