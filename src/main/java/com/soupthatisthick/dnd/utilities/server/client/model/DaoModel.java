package com.soupthatisthick.dnd.utilities.server.client.model;

import com.soupthatisthick.dnd.utilities.server.client.model.util.sort.Category;
import com.soupthatisthick.dnd.utilities.server.util.json.JsonUtil;

/**
 * Created by Owner on 5/31/2017.
 * Copyright of Stuart Marr Erskine, all rights reserved.
 */

public abstract class DaoModel {
    public static final String COL_THE_ROWID = "OID";
    public abstract Long getId();   // Required for comparison

    @Override
    public boolean equals(Object other)
    {
        if (other==null)
        {
            return false;
        } else if (!getClass().equals(other.getClass())) {
            return false;
        } else {
            Long myId = getId();
            Long otherId = ((DaoModel) other).getId();
            if (myId==null || otherId==null)
            {
                return super.equals(other);
            } else {
                return myId.equals(otherId);
            }
        }
    }

    /**
     * This will return the category of the dao model.
     * @return
     */
    public final Category getCategory()
    {
        return Category.parse(this);
    }

    @Override
    public String toString()
    {
        return String.format("%s{%s}", getClass().getSimpleName(), getId());
    }

    public final String json() {
        return JsonUtil.toJson(this, true);
    }
}
