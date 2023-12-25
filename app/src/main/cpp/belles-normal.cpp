//
// Created by Weihl on 2023/12/25.
//
#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_well_belles_NativeBellesNormal_stringFromJNI(JNIEnv *env, jobject thiz) {
    return env ->NewStringUTF("From Native Belles-Normal.cpp C++");
}