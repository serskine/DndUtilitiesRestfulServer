package com.soupthatisthick.dnd.utilities.server.client.model;

/**
 * Created by Owner on 5/11/2017.
 * Copyright of Stuart Marr Erskine, all rights reserved.
 */

public enum DieSize {
    D4(4),
    D6(6),
    D8(8),
    D10(10),
    D12(12),
    D20(20);

    public final int numFaces;

    private DieSize(int numFaces)
    {
        this.numFaces = numFaces;
    }
};
