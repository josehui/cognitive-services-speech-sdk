//
// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See LICENSE.md file in the project root for full license information.
//
package com.microsoft.cognitiveservices.speech;

/**
 * Defines the possible reasons a recognition result might be canceled.
 */
public enum CancellationReason
{
    /**
     * Indicates that an error occurred during speech recognition. Use getErrorDetails() contains detailed error response.
     */
    Error,

    /**
     * Indicates that the end of the audio stream was reached.
     */
    EndOfStream
}
