/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets;

public class ServiceConstants {
    public static final String AUTHENTICATION_RESOURCE_ID = "https://graph.microsoft.com";
    public static final String REDIRECT_URI = "http://localhost/androidsnippets";
    // The Microsoft Graph delegated permissions that you set in the application
    // registration portal must match these scope values.
    // Update this constant with the scope (permission) values for your application:
public static final String[] SCOPES = {"openid", "Mail.ReadWrite","mail.send","User.ReadBasic.All","User.Read.All","Calendars.Read","Calendars.ReadWrite"};
        }