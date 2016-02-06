package org.rest.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler interface for Actions.
 * @author Paweł Psztyć
 *
 */
interface ActionHandler extends EventHandler {
	/**
	 * Perform the action.
	 */
	void onAction();
}
