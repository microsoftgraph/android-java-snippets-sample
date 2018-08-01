/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets.snippet;

import com.google.gson.JsonObject;
import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.core.ClientException;
import com.microsoft.graph.models.extensions.Attendee;
import com.microsoft.graph.models.generated.AttendeeType;
import com.microsoft.graph.models.generated.BodyType;
import com.microsoft.graph.models.extensions.DateTimeTimeZone;
import com.microsoft.graph.models.extensions.EmailAddress;
import com.microsoft.graph.models.extensions.Event;
import com.microsoft.graph.requests.extensions.IEventCollectionPage;
import com.microsoft.graph.models.extensions.ItemBody;
import com.microsoft.graph.models.extensions.Location;

import org.joda.time.DateTime;

import java.util.Collections;

import static com.microsoft.graph.snippets.R.array.create_event;
import static com.microsoft.graph.snippets.R.array.delete_event;
import static com.microsoft.graph.snippets.R.array.get_user_events;
import static com.microsoft.graph.snippets.R.array.update_event;

public abstract class EventsSnippets<Result> extends AbstractSnippet<Result> {

    public EventsSnippets(Integer descriptionArray) {
        super(SnippetCategory.eventsSnippetCategory, descriptionArray);
    }

    static EventsSnippets[] getEventsSnippets() {
        return new EventsSnippets[]{
                // Marker element
                new EventsSnippets(null) {
                    @Override
                    public void request(ICallback callback) {
                        //No implementation
                    }
                },
                //Snippets

                /*
                 * Get all events for the signed in user.
                 * GET https://graph.microsoft.com/{version}/me/events
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/user_list_events
                 */
                new EventsSnippets<JsonObject>(get_user_events) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        mGraphServiceClient
                                .me()
                                .events()
                                .buildRequest()
                                .get(new ICallback<IEventCollectionPage>() {
                                    @Override
                                    public void success(IEventCollectionPage iEventCollectionPage) {
                                        callback.success(iEventCollectionPage.getRawObject());
                                    }

                                    @Override
                                    public void failure(ClientException ex) {
                                        callback.failure(ex);
                                    }
                                });
                    }
                },

                /*
                 * Adds an event to the signed-in user\'s calendar.
                 * POST https://graph.microsoft.com/{version}/me/events
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/user_post_events
                 */
                new EventsSnippets<JsonObject>(create_event) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        Event event = createEventObject();

                        mGraphServiceClient
                                .me()
                                .events()
                                .buildRequest()
                                .post(event, new ICallback<Event>() {
                                    @Override
                                    public void success(Event event) {
                                        callback.success(event.getRawObject());
                                    }

                                    @Override
                                    public void failure(ClientException ex) {
                                        callback.failure(ex);
                                    }
                                });
                    }
                },

                 /*
                 * Update an event
                 * PATCH https://graph.microsoft.com/{version}/me/events/{Event.Id}
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/event_update
                 */
                new EventsSnippets<JsonObject>(update_event) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        Event event = createEventObject();

                        mGraphServiceClient
                                .me()
                                .events()
                                .buildRequest()
                                .post(event, new ICallback<Event>() {
                                    @Override
                                    public void success(Event event) {
                                        // Update the event object
                                        Event updateEvent = new Event();
                                        updateEvent.subject = "Updated event";
                                        mGraphServiceClient
                                                .me()
                                                .events()
                                                .byId(event.id)
                                                .buildRequest()
                                                .patch(updateEvent, new ICallback<Event>() {
                                                    @Override
                                                    public void success(Event event) {
                                                        callback.success(event.getRawObject());
                                                    }

                                                    @Override
                                                    public void failure(ClientException ex) {
                                                        callback.failure(ex);
                                                    }
                                                });
                                    }

                                    @Override
                                    public void failure(ClientException ex) {
                                        callback.failure(ex);
                                    }
                                });


                }

                },

                 /*
                 * Delete an event
                 * DELETE https://graph.microsoft.com/{version}/me/events/{Event.Id}
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/event_delete
                 */
                new EventsSnippets<JsonObject>(delete_event) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        Event event = createEventObject();

                        mGraphServiceClient
                                .me()
                                .events()
                                .buildRequest()
                                .post(event, new ICallback<Event>() {
                                    @Override
                                    public void success(Event event) {
                                        // Update the event object
                                        event.subject = "Updated event";

                                        mGraphServiceClient
                                                .me()
                                                .events()
                                                .byId(event.id)
                                                .buildRequest()
                                                .delete(new ICallback<Void>() {
                                                    @Override
                                                    public void success(Void aVoid) {
                                                        callback.success(null);
                                                    }

                                                    @Override
                                                    public void failure(ClientException ex) {
                                                        callback.failure(ex);
                                                    }
                                                });

                                    }

                                    @Override
                                    public void failure(ClientException ex) {
                                        callback.failure(ex);
                                    }
                                });
                    }
                }
        };
    }

    public abstract void request(ICallback<Result> callback);

    private static Event createEventObject() {
        Event event = new Event();
        event.subject = "Microsoft Graph SDK Discussion";
        // set start time to now
        DateTimeTimeZone start = new DateTimeTimeZone();
        start.dateTime = DateTime.now().toString();
        event.start = start;

        // and end in 1 hr
        DateTimeTimeZone end = new DateTimeTimeZone();
        end.dateTime = DateTime.now().plusHours(1).toString();
        event.end = end;

        // set the timezone
        start.timeZone = end.timeZone = "UTC";

        // set a location
        Location location = new Location();
        location.displayName = "Bill's Office";
        event.location = location;

        // add attendees
        Attendee attendee = new Attendee();
        attendee.type = AttendeeType.REQUIRED;
        attendee.emailAddress = new EmailAddress();
        attendee.emailAddress.address = "mara@fabrikam.com";
        event.attendees = Collections.singletonList(attendee);

        // add a msg
        ItemBody msg = new ItemBody();
        msg.content = "Let's discuss the Microsoft Graph SDK.";
        msg.contentType = BodyType.TEXT;
        event.body = msg;

        return event;
    }
}
