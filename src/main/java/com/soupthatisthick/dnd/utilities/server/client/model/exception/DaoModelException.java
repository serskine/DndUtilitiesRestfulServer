package com.soupthatisthick.dnd.utilities.server.client.model.exception;

import com.soupthatisthick.dnd.utilities.server.client.model.DaoModel;

public class DaoModelException extends Exception {
    DaoModel model;
    public DaoModelException(DaoModel model, String message) {
        super(message + "\n" + ((model==null) ? ("model is null") : model.json()));
        this.model = model;
    }
}
