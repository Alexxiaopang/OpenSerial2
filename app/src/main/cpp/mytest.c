//
// Created by Alex on 2017/4/28 0028.
//
#include <jni.h>

#include <android/log.h>
#include <stdio.h>
#include <sys/types.h>
#include <errno.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <termios.h>
#include <stdlib.h>
#include <signal.h>
#include <pthread.h>
#define DEV_NAME "/dev/cust_device"
#define LOG_TAG    "FlagsIntentC"

#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, DEV_NAME)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, DEV_NAME)


JNIEXPORT jint JNICALL
Java_alex_openserial_OpenSerial_Ctrset(JNIEnv *env,
                                       jobject jobject1 /* this */, jboolean ison) {


    int fd;
    fd = open(DEV_NAME, O_RDWR);
    if (-1 == fd) {

        __android_log_print(ANDROID_LOG_INFO, LOG_TAG, "================>Open device %s failed!\n", DEV_NAME);
        return -1;
    } else {
        __android_log_print(ANDROID_LOG_INFO, LOG_TAG, "================>Open device %s success!\n", DEV_NAME);
        if (JNI_TRUE == ison) {
            //__android_log_print(ANDROID_LOG_INFO, TAG, "================>Ioctl on!\n");
            ioctl(fd, 1);
        } else {
            //__android_log_print(ANDROID_LOG_INFO, TAG, "================>Ioctl off!\n");
            ioctl(fd, 0);

        }
        close(fd);
        return 1;
    }



/*if (JNI_TRUE == ison){
    return 1;

}
else
    return 0;*/
}

