package com.hellomvp.client.mvp;

import com.google.inject.Inject;

import com.google.gwt.core.client.GWT;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

import com.hellomvp.client.HelloMVPInjector;
import com.hellomvp.client.place.HelloPlace;
import com.hellomvp.client.place.GoodbyePlace;
import com.hellomvp.client.activity.HelloActivity;
import com.hellomvp.client.activity.GoodbyeActivity;

public class AppActivityMapper implements ActivityMapper {

    private final HelloMVPInjector injector = GWT.create(HelloMVPInjector.class);

	public AppActivityMapper() {
		super();
	}

	public Activity getActivity(Place place) {
		if (place instanceof HelloPlace)
            return injector.getHelloActivity().setPlace((HelloPlace) place);
		else if (place instanceof GoodbyePlace)
            return injector.getGoodbyeActivity().setPlace((GoodbyePlace) place);

		return null;
	}
}
