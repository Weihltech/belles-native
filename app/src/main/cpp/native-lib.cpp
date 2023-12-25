#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_well_belles_BellesNative_stringFromJNI(JNIEnv *env, jobject thiz) {

    std::string hello = "Belles Native from C++";
    return env->NewStringUTF(hello.c_str());
}
