#  For more information about using CMake with Android Studio, read the
#  documentation: https://d.android.com/studio/projects/add-native-code.html.
#  For more examples on how to use CMake, see https://github.com/android/ndk-samples.

#  Sets the minimum CMake version required for this project.
cmake_minimum_required(VERSION 3.22.1)

#  Declares the project name. The project name can be accessed via ${ PROJECT_NAME},
#  Since this is the top level CMakeLists.txt, the project name is also accessible
#  with ${CMAKE_PROJECT_NAME} (both CMake variables are in-sync within the top level
#  build script scope).
project("belles")

#  Creates and names a library, sets it as either STATIC
#  or SHARED, and provides the relative paths to its source code.
#  You can define multiple libraries, and CMake builds them for you.
#  Gradle automatically packages shared libraries with your APK.
# 
#  In this top level CMakeLists.txt, ${CMAKE_PROJECT_NAME} is used to define
#  the target library name; in the sub-module's CMakeLists.txt, ${PROJECT_NAME}
#  is preferred for the same purpose.
# 
#  In order to load a library into your app from Java/Kotlin, you must call
#  System.loadLibrary() and pass the name of the library defined here;
#  for GameActivity/NativeActivity derived applications, the same library name must be
#  used in the AndroidManifest.xml file.
add_library(
        belles-normal
        SHARED
        #  List C/C++ source files with relative paths to this CMakeLists.txt.
        belles-normal.cpp
        belles-normal2.cpp)
add_library(
        belles-info
        SHARED
        #  List C/C++ source files with relative paths to this CMakeLists.txt.
        belles-info.cpp)

#  Specifies libraries CMake should link to your target library. You
#  can link libraries from various origins, such as libraries defined in this
#  build script, prebuilt third-party libraries, or Android system libraries.
target_link_libraries(
        belles-normal
        belles-info
        #  List libraries link to the target library
        android
        log)

#  设置将构建的 so 库，导出到指定目录上
set_target_properties(
        #  ./belles-native/app/src/main/cpp/libs
       PROPERTIES LIBRARY_OUTPUT_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}/libs
)


## 遍历所有需要支持的架构
#foreach(ABI IN ITEMS armeabi-v7a arm64-v8a x86 x86_64)
#    # 创建一个新的库目标
#    add_library(libnormal-${ABI} SHARED belles-normal.cpp belles-normal2.cpp)
#    # 设置库目标的输出路径
#    set_target_properties(libnormal-${ABI} PROPERTIES
#            LIBRARY_OUTPUT_DIRECTORY "${CMAKE_CURRENT_SOURCE_DIR}/libs/${ABI}")
#
#    add_library(libinfo-${ABI} SHARED belles-info.cpp)
#    set_target_properties(libinfo-${ABI} PROPERTIES
#            LIBRARY_OUTPUT_DIRECTORY "${CMAKE_CURRENT_SOURCE_DIR}/libs/${ABI}")
#endforeach()





# ------------------- 中文提示 --------------------
# 在 Android 工程中，`CMakeLists.txt` 文件是用于配置 CMake 构建系统的关键文件。以下是一些常见的配置项¹²³⁴⁵：
# 1. **cmake_minimum_required**：这个命令用于指定构建项目所需的 CMake 的最小版本。
# 
# ```cmake
# cmake_minimum_required(VERSION 3.4.1)
# ```
# 
# 2. **add_library**：这个命令用于添加一个库。您需要指定库的名称、类型（静态或动态），以及源代码文件的路径。
# 
# ```cmake
# add_library(
# #  库的名称
# native-lib
# #  库的类型
# SHARED
# #  源代码文件的路径
# src/main/cpp/native-lib.cpp
# )
# ```
# 
# 3. **find_library**：这个命令用于查找系统库，并将其路径存储为一个变量。这个变量可以在构建脚本的其他部分引用 NDK 库。
# 
# ```cmake
# find_library(
# #  路径变量的名称
# log-lib
# #  您希望 CMake 定位的 NDK 库的名称
# log
# )
# ```
# 
# 4. **target_link_libraries**：这个命令用于将目标库链接到其他库。在这个例子中，我们将 `native-lib` 链接到 `log-lib`。
# 
# ```cmake
# target_link_libraries(
# #  目标库
# native-lib
# #  链接到 NDK 中的日志库
# ${log-lib}
# )
# ```
# 
# 5. **include_directories**：这个命令用于添加头文件的路径。
# 
# ```cmake
# include_directories(src/main/cpp/include/)
# ```
# 
# 6. **set_target_properties**：这个命令用于设置目标属性，例如输出目录。
# 
# ```cmake
# set_target_properties(mylib PROPERTIES LIBRARY_OUTPUT_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}/lib)
# ```

