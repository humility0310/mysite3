package com.bit2016.mysite.action.board;

import com.bit2016.web.Action;
import com.bit2016.web.ActionFactory;

public class BoardActionFactory extends ActionFactory {
	@Override
	public Action getAction(String actionName) {

		Action action = null;

		if ("write".equals(actionName)) {
			action = new WriteAction();
		} else if ("writeform".equals(actionName)) {
			action = new WriteFormAction();
		}else if ("modifyform".equals(actionName)) {
			action = new ModifyFormAction();
		}else if ("modify".equals(actionName)) {
			action = new ModifyAction();
		} else if ("view".equals(actionName)) {
			action = new ViewAction();
		} else if ("delete".equals(actionName)) {
			action = new DeleteAction();
		} else {
			action = new BoardListAction();
		}

		return action;
	}
}
