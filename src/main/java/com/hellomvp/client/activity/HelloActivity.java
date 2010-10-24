package com.hellomvp.client.activity;

import com.google.inject.Inject;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import com.hellomvp.client.place.HelloPlace;
import com.hellomvp.client.ui.HelloView;

public class HelloActivity extends AbstractActivity implements
		HelloView.Presenter {
	// Name that will be appended to "Hello,"
	private String name;
	private HelloView helloView;
    private PlaceController placeController;

    @Inject
	public HelloActivity(HelloView helloView, PlaceController placeController) {
        this.helloView = helloView;
        this.placeController = placeController;
	}

    // TODO Use AssistedInject pattern to initialize in the constructor
    public HelloActivity setPlace(HelloPlace place) {
		this.name = place.getHelloName();
        return this;
    }

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		helloView.setName(name);
		helloView.setPresenter(this);
		containerWidget.setWidget(helloView.asWidget());
	}

	/**
	 * Ask user before stopping this activity
	 */
	@Override
	public String mayStop() {
		return "Please hold on. This activity is stopping.";
	}

	/**
	 * Navigate to a new Place in the browser
	 */
	public void goTo(Place place) {
		placeController.goTo(place);
	}
}
