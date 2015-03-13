package controller;

import java.util.List;

import cu.uci.abcd.management.db.IDatabaseManager;
import cu.uci.abos.ui.api.IViewController;

public class ManageDatabasesController implements IViewController {
    private IDatabaseManager service;

    public List<String> getDatabaseNames() {
	return service.getDatabasesList();
    }

    public void bind(IDatabaseManager service) {
	this.service = service;
    }
}
