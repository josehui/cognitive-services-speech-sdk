//
// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See LICENSE.md file in the project root for full license information.
//
package com.microsoft.cognitiveservices.speech.intent;

import com.microsoft.cognitiveservices.speech.CancellationReason;
import com.microsoft.cognitiveservices.speech.util.Contracts;

/**
 * Define payload of intent recognition canceled result events.
 */
public final class IntentRecognitionCanceledEventArgs extends IntentRecognitionEventArgs {

    IntentRecognitionCanceledEventArgs(com.microsoft.cognitiveservices.speech.internal.IntentRecognitionCanceledEventArgs e) {
        super(e);
        Contracts.throwIfNull(e, "e");

        this._eventArgImpl = e;

        com.microsoft.cognitiveservices.speech.internal.CancellationDetails cancellation = e.GetCancellationDetails();
        this._cancellationReason  = CancellationReason.values()[cancellation.getReason().swigValue() - 1]; // Native CancellationReason enum starts at 1!!
        this._errorDetails = cancellation.getErrorDetails();
    }

    /**
     * The reason the recognition was canceled.
     * @return Specifies the reason canceled.
     */
    public CancellationReason getReason() {
        return this._cancellationReason ;
    }

    /**
     * In case of an unsuccessful recognition, provides a details of why the occurred error.
     * This field is only filled-out if the reason canceled (@see getReason) is set to Error.
     * @return A String that represents the error details.
     */
    public String getErrorDetails() {
        return this._errorDetails;
    }

    /**
     * Returns a String that represents the speech recognition canceled event args.
     * @return A String that represents the speech recognition canceled event args.
     */
    @Override
    public String toString() {
        return "SessionId:" + this.getSessionId() +
                " ResultId:" + this.getResult().getResultId() +
                " IntentId:" + this.getResult().getIntentId() +
                " CancellationReason:" + _cancellationReason  +
                " Recognized text:<" + _errorDetails +
                ">.";
    }

    @SuppressWarnings("unused")
    private com.microsoft.cognitiveservices.speech.internal.IntentRecognitionCanceledEventArgs _eventArgImpl;
    private CancellationReason _cancellationReason ;
    private String _errorDetails;
}
