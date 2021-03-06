/*******************************************************************************
 * Copyright 2012 Paweł Psztyć
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.rest.client.ui;


import java.util.ArrayList;
import java.util.Date;

import org.rest.client.event.RequestChangeEvent;
import org.rest.client.jso.ProjectObject;
import org.rest.client.jso.RequestObject;
import org.rest.client.request.FilesObject;
import org.rest.client.tutorial.TutorialFactory;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface RequestView extends IsWidget {
	/**
	 * Presenter interface
	 * @author Paweł Psztyć
	 *
	 */
	public interface Presenter {
		/**
		 * Change place
		 * @param place
		 */
		void goTo(Place place);
		/**
		 * Fire event for clear form action
		 */
		void fireClearAllEvent();
		
		void fireEncodingChangeEvent(String newEncoding);
		
		void fireMethodChangeEvent(String newMethod);
		
		void fireUrlChangeEvent(String newUrl);
		
		void fireUrlToggleEvent(boolean isNowSimpleView);
		
		void fireRequestStartActionEvent(Date startTime);
		
		void deleteCurrentEndpoint();
		
		EditProjectView getEditProjectDialog();
		void refreshCurrentDriveItem();
		void changeSavedName(String name, Callback<Boolean, Throwable> callback);
		/**
		 * Will be called when user click on URL context menu icon.
		 */
		void urlContextMenuOpenedAction();
		/**
		 * To be called when user select an action option from URL widget contect menu. 
		 * @param actionName
		 */
		void urlContextMenuActionPerformed(String actionName);
	}
	
	/**
	 * Reset request view to initial state
	 */
	void reset();
	
	/**
	 * Sets presenter for this view
	 * @param listener
	 */
	void setPresenter(Presenter listener);
	
	/**
	 * Accessors for form data
	 */
	String getUrl();
	String getMethod();
	String getHeaders();
	String getPayload();
	String getEncoding();
	ArrayList<FilesObject> getFiles();
	
	void setUrl(String url);
	void setMethod(String method);
	void setHeaders(String header);
	void setPayload(String payload);
	/**
	 * @deprecated the encoding value is deprecated and its support will be removed.
	 * @param encoding
	 */
	void setEncoding(String encoding);
	
	void setProjectData(ProjectObject project, JsArray<RequestObject> requests, int currentEndpoint);
	/**
	 * Sets the request name. Name can be from saved requests or from GDrive file name.
	 * When project is displayed the name should not appear (it is in "endpoints" input anyway).
	 * @param name
	 */
	void setRequestName(String name);
	
	/**
	 * Set up tutorial.
	 * @param factory
	 */
	void setUpTutorial(TutorialFactory factory);
	
	void handleUrlValueChangeEvent(String url);
	void handleRequestStartActionEvent(Date time);
	void handleRequestEndEvent();
	void handleRequestChangeEvent(RequestChangeEvent event);
	
	void updateProjectMetadata(ProjectObject project);
	/**
	 * Set Google Drive controls for request.
	 * It is "refresh" and "save".
	 */
	void setGDriveConstrols();

	void setUpDriveTutorial(TutorialFactory tutorialFactory);
	/**
	 * @return The request name if any.
	 */
	String getRequestName();
}
