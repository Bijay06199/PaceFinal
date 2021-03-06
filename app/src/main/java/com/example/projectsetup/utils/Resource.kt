/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.projectsetup.utils



//data class Resource<T>(var status : Status) {
//    companion object {
//        fun <T> success(data: T?): Resource<T> {
//            return Resource(Status.Success(data))
//        }
//
//        fun <T> error(msg: String, data: T?): Resource<T> {
//            return Resource(Status.Error(data, msg))
//        }
//
//        fun <T> loading(data: T? = null): Resource<T> {
//            return Resource(Status.Loading)
//        }
//    }
//}

sealed class Resource<T> {
    class Success<T>(var data: T?) : Resource<T>()
    class Loading<T>(var data: T? = null, var refreshing: Boolean = false) : Resource<T>()
    class Error<T>(var data: T? = null, var message: String) : Resource<T>()
}

