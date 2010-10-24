package com.hellomvp.client;

import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Provider;
import com.google.inject.Singleton;

// Not ready
// import com.google.gwt.inject.client.assistedinject.GinFactoryModuleBuilder;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.inject.client.AbstractGinModule;

import com.hellomvp.client.ui.GoodbyeView;
import com.hellomvp.client.ui.GoodbyeViewImpl;
import com.hellomvp.client.ui.HelloView;
import com.hellomvp.client.ui.HelloViewImpl;
import com.hellomvp.client.activity.HelloActivity;
import com.hellomvp.client.activity.GoodbyeActivity;
import com.hellomvp.client.place.HelloPlace;
import com.hellomvp.client.place.GoodbyePlace;

public class HelloMVPModule extends AbstractGinModule
{
    static class PlaceControllerProvider implements Provider<PlaceController> {
        private final EventBus eventBus;

        @Inject
        public PlaceControllerProvider(EventBus eventBus) {
            this.eventBus = eventBus;
        }

        public PlaceController get() {
            return new PlaceController(this.eventBus);
        }
    }

	@Override
    protected void configure() 
    {
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
        bind(PlaceController.class).toProvider(PlaceControllerProvider.class);

        bind(HelloView.class).to(HelloViewImpl.class);
        bind(GoodbyeView.class).to(GoodbyeViewImpl.class);

        bind(HelloActivity.class).in(Singleton.class);
        bind(GoodbyeActivity.class).in(Singleton.class);
    }
}
