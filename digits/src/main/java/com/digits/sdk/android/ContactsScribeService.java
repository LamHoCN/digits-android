/*
 * Copyright (C) 2015 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.digits.sdk.android;

import com.twitter.sdk.android.core.internal.scribe.EventNamespace;

class ContactsScribeService implements DigitsScribeService {
    static final String CONTACTS_COMPONENT = "contacts";

    private final DigitsScribeClient scribeClient;

    ContactsScribeService(DigitsScribeClient scribeClient) {
        if (scribeClient == null) {
            throw new NullPointerException("scribeClient must not be null");
        }
        this.scribeClient = scribeClient;
    }

    @Override
    public void impression() {
        final EventNamespace ns = DigitsScribeConstants.DIGITS_EVENT_BUILDER
                .setComponent(CONTACTS_COMPONENT)
                .setElement(DigitsScribeConstants.EMPTY_SCRIBE_ELEMENT)
                .setAction(DigitsScribeConstants.IMPRESSION_ACTION)
                .builder();
        scribeClient.scribe(ns);
    }

    @Override
    public void failure() {
        //nothing to do
    }

    @Override
    public void click(DigitsScribeConstants.Element element) {
        final EventNamespace ns = DigitsScribeConstants.DIGITS_EVENT_BUILDER
                .setComponent(CONTACTS_COMPONENT)
                .setElement(element.toString())
                .setAction(DigitsScribeConstants.CLICK_ACTION)
                .builder();
        scribeClient.scribe(ns);
    }

    @Override
    public void success() {
        //nothing to do
    }
}
