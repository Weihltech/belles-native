


#### JNI NDK C++ 的开发

NDK(原生API工具集合) + 构建编译工具(CMake / ndk-build) = Android C++ Dev ;
Android 默认使用 NDK + CMake ；

----
CMake 是一个跨平台的构建系统，它可以根据不同的平台和编译器生成相应的 Makefile 或者项目文件。
CMake 可以输出各种各样的原生库，例如静态库 (.a)、动态库 (.so) 或者可执行文件 (.exe)。
CMake 还可以与 Gradle 配合使用，方便地将原生库打包到 APK 中，并在应用中调用 Java 原生接口 (JNI) 来访问原生代码。
CMake 的优点是它可以支持多种平台和编译器，而且有很多现成的模板和插件可以使用。
CMake 的缺点是它需要安装额外的工具和环境，而且可能不适合一些简单或者重复使用的原生代码。

----
ndk-build 是 Android NDK 提供的一个基于 Make 的构建系统，它专门用来构建 Android 平台上的原生库。
ndk-build 只能输出动态库 (.so)，而且只能支持 ARM、MIPS 和 x86 架构。
ndk-build 不需要安装额外的工具和环境，而且比较快速简单。
ndk-build 的优点是它专注于 Android 平台上的原生开发，而且有很多内置的函数和命令可以方便地管理原生代码。
ndk-build 的缺点是它只能支持少数几种平台和编译器，而且不能直接与 Gradle 配合使用。

----
ndk-build 是打包编译 so 库文件的编译工具；需要编写配置文件 Android.mk 、Application.mk 。
参考文献：https://developer.android.com/ndk/guides/ndk-build?hl=zh-cn

---
关于 CMake 配置文件命令、如何添加 C++ 代码、引用 NDK 
参考文献：https://developer.android.com/studio/projects/add-native-code?hl=zh-cn
详细 CMake 命令说明文档：
https://cmake.org/cmake/help/latest/manual/cmake-commands.7.html
https://cmake.org/cmake/help/latest/manual/cmake.1.html


---
NDK 是 android 提供访问原生 API 的工具集合，帮助开发者快速完成原生功能开发
原生 API 参考文献 : https://developer.android.com/ndk/guides/stable_apis?hl=zh-cn
如何添加 NDK API ？: https://developer.android.com/studio/projects/configure-cmake?hl=zh-cn#add-ndk-api

---
关于新创建 C++ 项目，如何关联到原生 app 项目中以及相关 gradle 配置的说明
参考文献：https://developer.android.com/studio/projects/gradle-external-native-builds?hl=zh-cn

---
介绍创建 NDK 项目：https://developer.android.com/codelabs/android-studio-cmake#0
参考项目-NDK ：https://github.com/android/ndk-samples 

cxx
  |-Debug  *.so ,调试用
  |-RelWithDeInfo  *.so ,优化过的，介以 debug-release 之间的库

release *.so 库，直接打包 release.apk 后，解压取出 libs 下的 so 文件


