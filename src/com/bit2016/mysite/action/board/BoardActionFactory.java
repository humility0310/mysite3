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
		} else if ("view".equals(actionName)) {
			action = new ViewAction();
		} else {
			action = new BoardListAction();
		}

		return action;
	}
}
