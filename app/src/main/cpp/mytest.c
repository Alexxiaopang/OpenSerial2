//
// Created by Alex on 2017/4/28 0028.
//
#include <jni.h>

JNIEXPORT jint JNICALL
Java_alex_openserial_OpenSerial_Ctrset(JNIEnv *env,
                                       jobject jobject1 /* this */, jboolean ison) {

if (JNI_TRUE == ison){
    return 1;

}
else
    return 0;
}

