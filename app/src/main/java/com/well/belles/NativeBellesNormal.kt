package com.well.belles

/**
 * @desc
 *
 * @author weihl
 * @date 2023/12/22
 */
class NativeBellesNormal {

    companion object {
        // Used to load the 'belles' library on application startup.
        init {
            System.loadLibrary("belles-normal")
        }
    }

    external fun stringFromJNI():String

}