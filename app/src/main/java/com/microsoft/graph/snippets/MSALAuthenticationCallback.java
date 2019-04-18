package com.microsoft.graph.snippets;

import com.microsoft.identity.client.AuthenticationResult;
import com.microsoft.identity.client.exception.MsalException;

interface MSALAuthenticationCallback {
    void onSuccess(AuthenticationResult authenticationResult);
    void onError(MsalException exception);
    void onError(Exception exception);
    void onCancel();
}
