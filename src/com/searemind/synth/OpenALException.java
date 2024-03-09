package com.searemind.synth;

import static org.lwjgl.openal.AL10.*;

class OpenALException extends RuntimeException {
    OpenALException(int errorCode) {
        super("Internal " + (errorCode == AL_INVALID_NAME ? "Invalid Name" : errorCode == AL_INVALID_ENUM ? "Invalid Enum": errorCode == AL_INVALID_VALUE
                ? "Invalid Value" : errorCode == AL_INVALID_OPERATION ? "Invalid Operation" : "Unknown") + " OpenAL Excpetion");
    }
}
