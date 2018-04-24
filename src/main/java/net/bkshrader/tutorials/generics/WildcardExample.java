/*
 * Copyright (c) 2018.
 * Copyright 2018 Bradley
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.bkshrader.tutorials.generics;

import java.util.ArrayList;

public class WildcardExample {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Number> numbers = new ArrayList<>();

        copy(integers, numbers);
    }

    private static <S extends Number, T> void copy(ArrayList<S> childlist, ArrayList<T> superlist) {
        for (Number n : childlist) {
            superlist.add((T) n);
        }
    }
}