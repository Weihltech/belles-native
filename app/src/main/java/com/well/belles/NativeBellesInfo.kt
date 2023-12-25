package com.well.belles

/**
 * @desc
 *
 * @author weihl
 * @date 2023/12/25
 */
class NativeBellesInfo {

    init {
        System.loadLibrary("belles-info")
    }

    external fun stringFromJNI():String

}