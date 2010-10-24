package com.hellomvp.client.activity;

import com.google.inject.Inject;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.place.shared.PlaceController;

import com.hellomvp.client.place.GoodbyePlace;
import com.hellomvp.client.ui.GoodbyeView;

public class GoodbyeActivity extends AbstractActivity {
	// Name that will be appended to "Good-bye, "
	private String name;
    private GoodbyeView goodbyeView;
    private PlaceController placeController;

    @Inject
	public GoodbyeActivity(GoodbyeView helloView, PlaceController placeController) {
        this.goodbyeView = goodbyeView;
        this.placeController = placeController;
	}

    // TODO Use AssistedInject pattern to initialize in the constructor
    public GoodbyeActivity setPlace(GoodbyePlace place) {
		this.name = place.getGoodbyeName();
        return this;
    }

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		goodbyeView.setName(name);
		containerWidget.setWidget(goodbyeView.asWidget());
	}
}
