/*
 * Copyright (C) 2018 Drake, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.drake.statelayout

/**
 * 缺省页的状态枚举
 * @property LOADING 加载中
 * @property EMPTY 空
 * @property ERROR 错误
 * @property CONTENT 成功
 */
enum class Status {
    LOADING, EMPTY, ERROR, CONTENT
}