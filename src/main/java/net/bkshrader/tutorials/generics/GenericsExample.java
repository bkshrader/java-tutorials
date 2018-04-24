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

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GenericsExample<K, V> {

    // Generic type parameters can be used as variables in object type declarations
    private final V root;

    // Generics type parameters can be used as type arguments themselves
    HashMap<K, V> map = new HashMap<>();

    // When taking input with a wildcard, such as in this constructor with a capturing wildcard, you should use upper boundaries
    public <E extends V> GenericsExample(E root) {
        this.root = root;
    }

    // When giving output with a wildcard, such as in this generic return typed method, you should use lower boundaries
    public Collection<? super V> foo() {
        return map.values();
    }

    // Generics can be nested for extreme control over the type of items passed as parameters, though it can become messy
    public <S extends List<? extends K>, T extends List<? extends V>> void addInPairs(S keys, T values) throws IllegalArgumentException {
        if (keys.size() != values.size()) throw new IllegalArgumentException("keys and values are not the same size.");
        Iterator<? extends K> keyIterator = keys.iterator();
        Iterator<? extends V> valueIterator = values.iterator();
        while (keyIterator.hasNext() && valueIterator.hasNext()) {
            map.put(keyIterator.next(), valueIterator.next());
        }
    }
}
