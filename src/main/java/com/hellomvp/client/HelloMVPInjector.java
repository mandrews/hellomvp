package com.hellomvp.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

import com.hellomvp.client.ui.HelloView;
import com.hellomvp.client.ui.GoodbyeView;
import com.hellomvp.client.activity.HelloActivity;
import com.hellomvp.client.activity.GoodbyeActivity;

@GinModules({HelloMVPModule.class})
public interface HelloMVPInjector extends Ginjector
{
	EventBus getEventBus();
	PlaceController getPlaceController();

	HelloView getHelloView();
	GoodbyeView getGoodbyeView();

	HelloActivity getHelloActivity();
	GoodbyeActivity getGoodbyeActivity();

}
