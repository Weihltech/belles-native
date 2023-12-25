#include <jni.h>

//
// Created by Weihl on 2023/12/25.
//

extern "C"
JNIEXPORT jstring JNICALL
Java_com_well_belles_NativeBellesInfo_stringFromJNI(JNIEnv *env, jobject thiz) {
    return env ->NewStringUTF("From Native Belles-Info.cpp  C++");
}